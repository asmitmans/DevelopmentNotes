# Seguridad en APIs REST con Spring Security y JWT


# Parte 1: Fundamentos y arquitectura interna

## 1. Introducción

Spring Security es un framework de seguridad altamente configurable y extensible. Al integrarlo con JWT en APIs REST, reemplazamos el modelo tradicional basado en sesiones por una arquitectura sin estado (*stateless*), más escalable y adecuada para servicios modernos.

Para entender cómo personalizarlo correctamente, es importante conocer los componentes clave que actúan en el proceso de autenticación y autorización.

---

## 2. Componentes clave en el flujo de autenticación

### 2.1. `SecurityFilterChain`

Es el núcleo de la configuración de seguridad. Define cómo se interceptan las peticiones HTTP y qué filtros se aplican. Spring aplica una cadena de filtros para proteger la aplicación, y tú puedes modificarla o extenderla.

En APIs JWT, se configura para:

* Desactivar el manejo de sesión (`STATELESS`)
* Desactivar CSRF (innecesario en JWT)
* Añadir un filtro personalizado (`JwtFilter`)
* Definir qué rutas son públicas o protegidas

```java
http.csrf().disable()
    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    .authorizeHttpRequests(...)
    .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
```

---

### 2.2. `AuthenticationManager`

Es el encargado de autenticar al usuario. Recibe un `Authentication` con las credenciales (por ejemplo, `UsernamePasswordAuthenticationToken`) y lo compara con los datos de un `UserDetailsService`.

En el login con JWT, tú mismo creas este paso en el controlador de autenticación (`/auth/login`) y validas manualmente con:

```java
authenticationManager.authenticate(
    new UsernamePasswordAuthenticationToken(username, password)
);
```

---

### 2.3. `UserDetailsService`

Interfaz que define cómo obtener los datos de un usuario desde tu base de datos. Spring la usa para cargar un `UserDetails` con username, contraseña cifrada y roles.

Tú implementas esta interfaz para devolver un objeto que Spring Security pueda usar al validar credenciales o autorizar accesos.

---

### 2.4. `SecurityContextHolder`

Es el contenedor de seguridad que Spring usa para almacenar información del usuario autenticado en el contexto actual del thread. Si colocas allí un `Authentication` válido, el resto del sistema reconocerá al usuario como autenticado.

En el `JwtFilter`, una vez validado el token, se hace:

```java
SecurityContextHolder.getContext().setAuthentication(authentication);
```

Esto permite que los endpoints protegidos vean al usuario como autenticado.

---

### 2.5. Filtro personalizado (`JwtFilter`)

Este filtro se ejecuta en cada petición entrante. Sus responsabilidades son:

1. Extraer el header `Authorization: Bearer <token>`
2. Validar que el token sea correcto y no esté expirado
3. Obtener el usuario correspondiente
4. Crear un objeto `Authentication` con los datos del usuario
5. Colocarlo en el `SecurityContextHolder`

Esto reemplaza el filtro de login tradicional por una verificación automática en cada request.

---

## 3. Comparación: flujo tradicional vs JWT

| Flujo tradicional (por sesión) | Flujo JWT (stateless)                         |
| ------------------------------ | --------------------------------------------- |
| El backend crea sesión         | El backend solo entrega un token              |
| El navegador guarda una cookie | El cliente guarda el token (ej. localStorage) |
| Spring usa `HttpSession`       | Spring usa `SecurityContextHolder` sin sesión |
| El token es un identificador   | El token contiene los datos firmados          |

---

## 4. Estructura del JWT

Un JWT contiene 3 partes codificadas en Base64 y separadas por puntos:

```
header.payload.signature
```

### 4.1. Header

Contiene el tipo de token y el algoritmo usado (ej. HS256)

```json
{
  "alg": "HS256",
  "typ": "JWT"
}
```

### 4.2. Payload

Contiene los "claims", es decir, los datos del usuario y otra información:

```json
{
  "sub": "usuario1",
  "exp": 1713388727,
  "roles": ["ROLE_USER"]
}
```

### 4.3. Firma

Es la parte que asegura que el token no ha sido alterado. Se genera con la clave secreta.

```text
HMACSHA256(base64url(header) + "." + base64url(payload), clave_secreta)
```

---

## 5. Resumen del ciclo con Spring Security + JWT

1. El usuario envía sus credenciales al endpoint `/auth/login`
2. Spring las valida usando el `AuthenticationManager` y el `UserDetailsService`
3. Si son válidas, se genera un JWT firmado
4. El cliente usa ese token en todas las peticiones protegidas
5. El `JwtFilter` valida el token y establece el `Authentication` en el contexto
6. Spring permite o deniega el acceso según el rol y configuración

---

# Parte 2: Implementación práctica

## 1. Requisitos

### Dependencias (`pom.xml`)

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
  <groupId>io.jsonwebtoken</groupId>
  <artifactId>jjwt-api</artifactId>
  <version>0.13.0</version>
</dependency>
<dependency>
  <groupId>io.jsonwebtoken</groupId>
  <artifactId>jjwt-impl</artifactId>
  <version>0.13.0</version>
  <scope>runtime</scope>
</dependency>
<dependency>
  <groupId>io.jsonwebtoken</groupId>
  <artifactId>jjwt-jackson</artifactId>
  <version>0.13.0</version>
  <scope>runtime</scope>
</dependency>
```

---

## 2. Estructura mínima del proyecto

```
src/main/java/
└── com/example/springsecurityjwtdemo/
    ├── controller/
    │   └── AuthController.java
    ├── model/
    │   ├── User.java
    │   └── Role.java
    ├── repository/
    │   └── UserRepository.java
    ├── security/
    │   ├── JwtService.java
    │   ├── JwtFilter.java
    │   └── SecurityConfig.java
    ├── service/
    │   └── MyUserDetailsService.java
    └── SecurityDemoApplication.java
```

---

## 3. Pasos de implementación

### 3.1. Entidad `User`

* Campos: `id`, `username`, `password`, `roles`
* Encriptar contraseña con BCrypt

### 3.2. Entidad `Role`

* Usar convención `ROLE_USER`, `ROLE_ADMIN`, etc.

### 3.3 Ajuste inicial de Spring Security para H2 (desarrollo)

* Permitir `/h2-console/**`
* Ignorar CSRF para esa ruta
* Habilitar frames same-origin

### 3.4. Servicio `UserDetailsService`

* Implementar método `loadUserByUsername`

### 3.5. `JwtService`

* Generar tokens con `Jwts.builder()`
* Validar tokens, extraer claims

### 3.6. `JwtFilter`

* Revisar header `Authorization`
* Validar y cargar usuario en el `SecurityContextHolder`

### 3.7. `SecurityConfig`

* Configurar seguridad sin estado (`STATELESS`)
* Permitir rutas públicas (`/auth/**`)
* Proteger otras con roles
* Inyectar el filtro antes de `UsernamePasswordAuthenticationFilter`

### 3.8. `AuthController`

* POST `/auth/login`
* Verifica credenciales, genera y retorna el token

---

## 4. Validaciones recomendadas

* Usar `Postman` o `curl`
* Casos a probar:

  * Sin token → `401`
  * Con token válido → acceso correcto
  * Token expirado o mal formado → `403` o `401`

---

## 5. Extensiones posibles

* Refresh Tokens
* Lista de revocados (blacklist)
* Control de sesión con Redis
* Claims adicionales

---

## 6. Buenas prácticas de seguridad

* No subir la clave secreta a ningún repositorio
* Usar HTTPS siempre
* Establecer expiración breve del token
* Validar inputs en endpoints protegidos

---

## 7. Resultado esperado

API REST funcional con autenticación JWT, control de acceso por roles y sin uso de sesiones.

---

# Capítulo 3.1 — Crear el proyecto `SpringSecurityJWTDemo`

## 1. Ir a Spring Initializr

Abre [https://start.spring.io](https://start.spring.io) y configura así:

| Campo        | Valor                               |
| ------------ | ----------------------------------- |
| Project      | **Maven**                           |
| Language     | **Java**                            |
| Spring Boot  | **4.0.2** (última estable)          |
| Group        | `com.example`                       |
| Artifact     | `SpringSecurityJWTDemo`             |
| Name         | `SpringSecurityJWTDemo`             |
| Package name | `com.example.springsecurityjwtdemo` |
| Packaging    | `Jar`                               |
| Java         | **17** (o 21 si ya lo tienes)       |

### Dependencias

Agrega las siguientes:

* **Spring Web**
* **Spring Security**
* **Spring Data JPA**
* **H2 Database**

Haz clic en **GENERATE** y descarga el `.zip`.

---

## 2. Abrir el proyecto en IntelliJ

1. Abre IntelliJ IDEA Community
2. Ve a `File > Open`
3. Selecciona la carpeta del proyecto descomprimido `SpringSecurityJWTDemo`
4. Espera a que IntelliJ importe el proyecto (deberías ver el árbol del proyecto con `src/`, `pom.xml`, etc.)

> Si te aparece una advertencia sobre importar Maven o actualizar dependencias, acepta todo.

---

## 3. Crear estructura de paquetes

Dentro de `src/main/java/com/example/springsecurityjwtdemo`, crea los siguientes paquetes:

```
model/
repository/
service/
controller/
security/
```

Para hacerlo:

* Haz clic derecho en el paquete base (`com.example.springsecurityjwtdemo`)
* Elige `New > Package`
* Crea uno por uno: `model`, `repository`, etc.

---

Excelente, vamos entonces con el siguiente paso.

---

# Capítulo 3.2 — Configurar H2 y definir las entidades base

## 1. Configurar la base de datos H2

Abre el archivo `src/main/resources/application.properties` y reemplaza su contenido con lo siguiente:

```properties
# Configuración de H2
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=sa

# Usar Hibernate (JPA)
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Consola web de H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```
> Usuario y contraseña se definen explícitamente para simplificar el acceso a
> la consola H2 durante desarrollo.
> En entornos reales, estas credenciales no deben exponerse ni versionarse.

Esto hará que:

* Se cree una base de datos en memoria al iniciar la app
* La consola esté accesible en `http://localhost:8080/h2-console`
* Las tablas se generen automáticamente desde tus entidades


### Nota práctica: añadir `application.properties` al `.gitignore`

Se recomienda **añadir `src/main/resources/application.properties` al archivo `.gitignore`** para evitar subir claves secretas, contraseñas u otras configuraciones sensibles al repositorio.

**Excepto** en casos como este proyecto, donde:

* Se usa una base de datos en memoria (H2),
* No se exponen datos reales ni secretos.

**Para ignorarlo**, puedes hacerlo así:

```bash
echo src/main/resources/application.properties >> .gitignore
```

---

## 2. Crear la entidad `Role`

En el paquete `model/`, crea un archivo `Role.java`:

```java
package com.example.SpringSecurityJWTDemo.model;

import jakarta.persistence.*;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Ej: ROLE_USER, ROLE_ADMIN

    public Role() {}

    public Role(String name) {
        this.name = name;
    }

    // Getters y setters
    public Long getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
```

---

## 3. Crear la entidad `User`

En el mismo paquete, crea `User.java`:

```java
package com.example.SpringSecurityJWTDemo.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users") // "user" puede causar conflicto en algunas BD
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    public User() {}

    // Getters y setters

    public Long getId() { return id; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public Set<Role> getRoles() { return roles; }

    public void setRoles(Set<Role> roles) { this.roles = roles; }
}
```

---

# Capítulo 3.3 — Ajuste inicial de Spring Security para entorno de desarrollo (H2 Console)

## 1. Contexto del problema

Al añadir la dependencia `spring-boot-starter-security`, Spring Security protege
**todas las rutas HTTP por defecto**.
Esto incluye la consola web de H2 (`/h2-console`), impidiendo el acceso incluso
en entornos de desarrollo.

En este punto del proyecto:

* No existe aún autenticación real
* No existen usuarios funcionales
* No se ha implementado JWT
* El objetivo es **validar la persistencia JPA**

Por lo tanto, es necesario realizar un ajuste **temporal** de seguridad.

---

## 2. Objetivo de este paso

Permitir el acceso a la consola H2 **exclusivamente en desarrollo**, para:

* Verificar la correcta creación de tablas
* Validar las entidades y relaciones
* Comprobar que la base de datos funciona antes de continuar

Este ajuste **no representa la configuración final de seguridad**.

---

## 3. Ajuste mínimo requerido en `SecurityConfig`

Se define una configuración de seguridad que:

* Permite el acceso a `/h2-console/**`
* Mantiene el resto de rutas protegidas
* Desactiva CSRF solo para H2
* Permite el uso de frames necesarios para la consola

```java
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated()
            )
            .csrf(csrf -> csrf
                .ignoringRequestMatchers("/h2-console/**")
            )
            .headers(headers -> headers
                .frameOptions(frame -> frame.sameOrigin())
            );

        return http.build();
    }
}
```

---

## 4. Explicación de la configuración

* `requestMatchers("/h2-console/**").permitAll()`
  Permite el acceso sin autenticación a la consola H2.

* `csrf().ignoringRequestMatchers(...)`
  La consola H2 utiliza formularios internos que no son compatibles con CSRF.

* `frameOptions().sameOrigin()`
  H2 utiliza iframes para su interfaz web, lo que requiere habilitar frames del
  mismo origen.

---

## 5. Alcance y limitaciones

Este ajuste:

* Es **temporal**
* Es válido **solo para desarrollo local**
* No debe utilizarse en producción

En entornos productivos, la consola H2 normalmente se deshabilita o se protege
estrictamente.

---

## 6. Resultado esperado

Al iniciar la aplicación:

* La aplicación arranca correctamente
* Se puede acceder a `http://localhost:8080/h2-console`
* Las tablas generadas por JPA son visibles
* La persistencia queda validada

Este paso cierra la fase de configuración básica de base de datos y permite
continuar con la implementación de autenticación real.

Verificación mínima:

1. Iniciar la aplicación.
2. Abrir http://localhost:8080/h2-console
3. JDBC URL: jdbc:h2:mem:testdb
4. Usuario: sa
5. Contraseña: sa
6. Confirmar que existen las tablas generadas por JPA

---

# Capítulo 3.4 — Integración de usuarios con Spring Security (`UserDetailsService`)

## 1. Objetivo de este paso

Hasta ahora:

* La base de datos funciona
* Las entidades `User` y `Role` están definidas
* Spring Security está activo
* La aplicación exige autenticación para cualquier ruta (excepto H2)

Sin embargo, Spring Security todavía **no sabe cómo cargar usuarios desde la base de datos**.

El objetivo de este paso es:

* Integrar Spring Security con nuestra entidad `User`
* Permitir que el framework pueda autenticar contra la base de datos
* Preparar el sistema para el login real (que luego usará JWT)

---

## 2. Rol de `UserDetailsService` en Spring Security

Spring Security define la interfaz:

```java
org.springframework.security.core.userdetails.UserDetailsService
```

Esta interfaz tiene un único método:

```java
UserDetails loadUserByUsername(String username)
```

Su responsabilidad es:

* Buscar el usuario por su identificador (normalmente `username`)
* Retornar un objeto `UserDetails`
* Lanzar `UsernameNotFoundException` si no existe

Spring utiliza esta interfaz internamente cuando:

* Se ejecuta un proceso de autenticación
* Se validan credenciales
* Se construye el contexto de seguridad

---

## 3. Decisión de diseño

No se recomienda que la entidad `User` implemente directamente la interfaz `UserDetails`.

Motivos:

* Evita acoplar el modelo de dominio a Spring Security
* Mantiene separación de responsabilidades
* Facilita reutilización del modelo en otros contextos

En su lugar, se implementará un servicio que:

* Lea la entidad `User` desde la base
* La adapte al tipo `UserDetails`

---

## 4. Crear el repositorio de usuarios

Si aún no existe, crear en `repository/`:

```java
package com.example.springsecurityjwtdemo.repository;

import com.example.springsecurityjwtdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
```

Este método será utilizado por `UserDetailsService`.

---

## 5. Implementar `UserDetailsService`

Crear en el paquete `service/`:

```java
package com.example.springsecurityjwtdemo.service;

import com.example.springsecurityjwtdemo.model.User;
import com.example.springsecurityjwtdemo.repository.UserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(
                        user.getRoles()
                                .stream()
                                .map(role ->
                                        new SimpleGrantedAuthority(role.getName()))
                                .collect(Collectors.toList())
                )
                .build();
    }
}
```

---

## 6. Explicación de la adaptación

Spring Security requiere:

* Username
* Password cifrada
* Lista de `GrantedAuthority`

Los roles almacenados en la base (`ROLE_USER`, `ROLE_ADMIN`) deben convertirse en:

```java
SimpleGrantedAuthority
```

Esto permite que posteriormente puedan utilizarse anotaciones como:

```java
@PreAuthorize("hasRole('ADMIN')")
```

---

## 7. Estado del sistema después de este paso

Después de implementar `UserDetailsService`:

* Spring Security ya puede consultar la base de datos
* El framework sabe cómo obtener usuario y roles
* Aún no existe endpoint de login
* Aún no existe JWT
* No se ha configurado `PasswordEncoder`

Este paso prepara el terreno para la autenticación real que se implementará a continuación.

---

## 8. Verificación mínima

En este punto:

1. La aplicación debe iniciar sin errores.
2. No se debe producir ningún `BeanCreationException`.
3. No se espera aún que el login funcione (no está implementado).

---

Hasta aquí no estamos tocando JWT ni filtros.
Solo estamos integrando la base de datos con Spring Security.

---

Ahora haz lo siguiente:

1. Implementa exactamente esto en el proyecto.
2. Arranca la aplicación.
3. Confirma si inicia correctamente o si aparece algún error.

---

# Capítulo 3.5 — Autenticación base: `PasswordEncoder` y `AuthenticationManager`

## 1. Objetivo de este paso

En el capítulo anterior se implementó `UserDetailsService`, por lo que Spring
Security ya puede cargar usuarios desde la base de datos.

Ahora falta:

* Definir cómo se comparan contraseñas (hashing)
* Exponer un `AuthenticationManager` para autenticar credenciales

Esto permite autenticar username/password de forma estándar, lo cual será
utilizado por el endpoint de login que se implementará después.

---

## 2. `PasswordEncoder`

Spring Security no recomienda almacenar contraseñas en texto plano. Para
contraseñas, se utiliza un `PasswordEncoder`, siendo `BCryptPasswordEncoder` el
mecanismo típico soportado por Spring.

Crear el bean en tu configuración (puede estar en `SecurityConfig`):

```java
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
```

```java
@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
```

---

## 3. `AuthenticationManager`

`AuthenticationManager` es el punto de entrada del proceso de autenticación.
Recibe un `Authentication` con credenciales y retorna un `Authentication`
autenticado (o lanza una excepción si falla).

En configuraciones modernas, se obtiene desde `AuthenticationConfiguration`:

```java
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
```

```java
@Bean
public AuthenticationManager authenticationManager(
        AuthenticationConfiguration config) throws Exception {
    return config.getAuthenticationManager();
}
```

Este manager utilizará internamente:

* Tu `UserDetailsServiceImpl`
* El `PasswordEncoder` definido

si ambos están disponibles como beans.

---

## 4. Ajuste actual de `SecurityConfig` (manteniendo H2)

En este punto todavía se mantiene el ajuste para H2 Console (desarrollo).
Solo se añaden los beans descritos arriba.

Ejemplo de `SecurityConfig` consolidado hasta este paso:

```java
package com.example.SpringSecurityJWTDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated()
            )
            .csrf(csrf -> csrf
                .ignoringRequestMatchers("/h2-console/**")
            )
            .headers(headers -> headers
                .frameOptions(frame -> frame.sameOrigin())
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
```

---

## 5. Impacto en el proyecto

Después de este paso:

* Spring Security ya puede autenticar credenciales contra la base
* Existe un `PasswordEncoder` para manejar hashing correctamente
* Existe un `AuthenticationManager` usable por un controlador de login
* Aún no existe `/auth/login`
* Aún no existe JWT

Este paso deja el sistema listo para exponer el endpoint de autenticación.

---

## 6. Ajuste requerido en el cargado de usuarios (DataInitializer)

Si tu `DataInitializer` actualmente está guardando usuarios con contraseñas en
texto plano, este paso obliga a que se guarden usando el `PasswordEncoder`.
Si no lo haces, cuando autentiques, BCrypt no podrá validar correctamente.

En el siguiente capítulo se ajustará el `DataInitializer` para almacenar hashes
BCrypt (usando el bean `PasswordEncoder`).

---

## 7. Verificación mínima

1. La aplicación debe iniciar sin errores.
2. Debe existir un bean `PasswordEncoder`.
3. Debe existir un bean `AuthenticationManager`.

No se prueba login aún; solo se valida configuración.

---
Perfecto. Siguiente subcapítulo.

El paso lógico ahora es cerrar dos cosas antes de JWT:

1. Asegurar que los usuarios de prueba se guardan con password **hash BCrypt**
2. Implementar el endpoint de autenticación **POST `/auth/login`** usando
   `AuthenticationManager`

Eso deja listo el terreno para generar JWT después.

---
Tienes razón: me adelanté con “ajustar DataInitializer” como si no estuviera
listo, y en tu caso **ya está** con BCrypt. Eso está bien.

Lo que sí conviene corregir (mínimo y profesional) es **cómo lo estás usando**:

* Estás creando `new BCryptPasswordEncoder()` “a mano” dentro del initializer.
* Ya tienes un `PasswordEncoder` como bean en `SecurityConfig`.

Buenas prácticas: **reusar el bean** (`PasswordEncoder`) e inyectarlo, para que
toda la app use el mismo encoder/configuración.

Y sí: para no marearte, vuelvo al formato de antes, con secciones de código
claras y ordenadas.

---

# Capítulo 3.6 — Endpoint de login (`POST /auth/login`) con `AuthenticationManager`

## 1. Objetivo de este paso

Implementar el endpoint de autenticación que:

1. Recibe `username` y `password`
2. Autentica con `AuthenticationManager`
3. Retorna una respuesta mínima (sin JWT todavía)

Este paso valida que todo el “core” de Spring Security está funcionando con
base de datos.

---

## 2. Ajuste mínimo recomendado en `DataInitializer`

Tu `DataInitializer` ya usa BCrypt, perfecto.
Solo cambia **una cosa**: en vez de instanciar el encoder, inyecta el bean
`PasswordEncoder`.

### 2.1. Cambios

* Mueve `DataInitializer` al paquete `config/` (si quieres mantener orden).
* Inyecta `PasswordEncoder` en el `CommandLineRunner`.
* Usa `passwordEncoder.encode(...)`.

### 2.2. Versión recomendada (misma lógica, mejor infraestructura)

```java
package com.example.SpringSecurityJWTDemo.config;

import com.example.SpringSecurityJWTDemo.model.Role;
import com.example.SpringSecurityJWTDemo.model.User;
import com.example.SpringSecurityJWTDemo.repository.RoleRepository;
import com.example.SpringSecurityJWTDemo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadData(
            UserRepository userRepository,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder
    ) {
        return args -> {
            if (roleRepository.count() == 0) {
                roleRepository.save(new Role("ROLE_USER"));
                roleRepository.save(new Role("ROLE_ADMIN"));
            }

            if (userRepository.count() == 0) {
                User user = new User();
                user.setUsername("user");
                user.setPassword(passwordEncoder.encode("1234"));
                user.setRoles(Set.of(roleRepository.findByName("ROLE_USER").get()));

                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin1234"));
                admin.setRoles(Set.of(roleRepository.findByName("ROLE_ADMIN").get()));

                userRepository.save(user);
                userRepository.save(admin);
            }
        };
    }
}
```

Si no quieres tocar esto ahora, no pasa nada: **no es bloqueante**.

---

## 3. Permitir `/auth/login` en `SecurityConfig`

En tu `SecurityFilterChain`, agrega el matcher para permitir el login.

Ejemplo mínimo:

```java
.authorizeHttpRequests(auth -> auth
    .requestMatchers("/h2-console/**").permitAll()
    .requestMatchers("/auth/login").permitAll()
    .anyRequest().authenticated()
)
```

---

## 4. Crear DTOs de login

Ubicación recomendada:

```text
controller/dto/
  LoginRequest.java
  LoginResponse.java
```

### 4.1. `LoginRequest`

```java
package com.example.SpringSecurityJWTDemo.controller.dto;

public class LoginRequest {

    private String username;
    private String password;

    public LoginRequest() {}

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
```

### 4.2. `LoginResponse` (mínimo)

```java
package com.example.SpringSecurityJWTDemo.controller.dto;

public class LoginResponse {

    private String message;

    public LoginResponse() {}

    public LoginResponse(String message) {
        this.message = message;
    }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
```

---

## 5. Implementar `AuthController`

Ubicación:

```text
controller/
  AuthController.java
```

Implementación mínima usando `AuthenticationManager`:

```java
package com.example.SpringSecurityJWTDemo.controller;

import com.example.SpringSecurityJWTDemo.controller.dto.LoginRequest;
import com.example.SpringSecurityJWTDemo.controller.dto.LoginResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    public AuthController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {

        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
            )
        );

        return ResponseEntity.ok(new LoginResponse("Authenticated"));
    }
}
```

### `SecurityConfig`: permitir `/auth/login` y excluirlo de CSRF

Spring Security habilita CSRF por defecto para proteger aplicaciones basadas
en cookies y sesiones.
En una API REST stateless que usa tokens, CSRF normalmente se deshabilita
completamente o se ignora en endpoints públicos como `/auth/login`.

* Permitir acceso público a `/auth/login`
* Excluir `/auth/login` de CSRF (además de H2 console en desarrollo)

Ejemplo mínimo (manteniendo H2):

```java
http
    .authorizeHttpRequests(auth -> auth
        .requestMatchers("/h2-console/**").permitAll()
        .requestMatchers("/auth/login").permitAll()
        .anyRequest().authenticated()
    )
    .csrf(csrf -> csrf
        .ignoringRequestMatchers("/h2-console/**", "/auth/login")
    )
    .headers(headers -> headers
        .frameOptions(frame -> frame.sameOrigin())
    );
```

### Verificación mínima (curl)

```bash
curl -i -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"user","password":"1234"}'
```

Resultado esperado:

* `HTTP/1.1 200`
* Body JSON con mensaje de autenticación

---

## Capítulo 3.7 — `JwtService` (Boot 4.0.2 + Security 7 + JJWT)

La meta aquí es **tener un servicio JWT correcto y estable** antes de tocar
cualquier filtro o modo stateless.

---

## 1) Dependencias JJWT (sin “legacy jar”)

JJWT separa **API** (compile) de **impl/jackson** (runtime). Esa es la forma
recomendada por el proyecto. ([GitHub][1])

**Maven (`pom.xml`)**:

```xml
<properties>
  <jjwt.version>0.13.0</jjwt.version>
</properties>

<dependencies>
  <dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>${jjwt.version}</version>
  </dependency>

  <dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-impl</artifactId>
    <version>${jjwt.version}</version>
    <scope>runtime</scope>
  </dependency>

  <dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-jackson</artifactId>
    <version>${jjwt.version}</version>
    <scope>runtime</scope>
  </dependency>
</dependencies>
```

---

## 2) Propiedades JWT (configurable y reproducible)

Vamos a usar **HS256** (simétrico) por simplicidad del demo. El secreto debe
ser **Base64** (no string “crudo”). JJWT lo recomienda explícitamente y además
advierte que `secretString.getBytes(...)` suele ser incorrecto en criptografía.
([GitHub][1])

**`application.properties`**:

```properties
security.jwt.secret-base64=CHANGE_ME
security.jwt.ttl-seconds=3600
security.jwt.issuer=SpringSecurityJWTDemo
```

### Cómo generar un secreto correcto (una vez)

1. Ejecutar en un terminal
```bash
openssl rand -base64 32
```

2. Copiar el resultado en 
```properties
security.jwt.secret-base64=EL_RESULTADO
security.jwt.ttl-seconds=3600
security.jwt.issuer=SpringSecurityJWTDemo
```

## 3) Diseño del `JwtService` (contrato mínimo)

**Responsabilidades del servicio**:

1. Generar token firmado (con `sub`, `iat`, `exp`, opcional `iss`)
2. Extraer claims (al menos `sub`, `exp`)
3. Validar token (firma + expiración + subject)

Para *no* meter lógica de Spring Security todavía, `JwtService` debería ser
agnóstico del filtro: recibe strings y `UserDetails`.

---

## 4) Implementación usando APIs no deprecated (JJWT 0.12+ / 0.13)

JJWT documenta el flujo correcto de parseo:

* `Jwts.parser() -> verifyWith(key) -> build() -> parseSignedClaims(...)`
  ([GitHub][1])

Y también cómo construir el `SecretKey` desde Base64 con `Decoders.BASE64`.
([GitHub][1])

### 4.1 `JwtService` (interfaz)

```java
public interface JwtService {
  String generateToken(org.springframework.security.core.userdetails.UserDetails user);

  String extractUsername(String token);

  <T> T extractClaim(String token, java.util.function.Function<io.jsonwebtoken.Claims, T> resolver);

  boolean isTokenValid(String token, org.springframework.security.core.userdetails.UserDetails user);
}
```

### 4.2 `JwtServiceImpl`

```java
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Date;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtServiceImpl implements JwtService {

  private final SecretKey signingKey;
  private final long ttlSeconds;
  private final String issuer;

  public JwtServiceImpl(
      @Value("${security.jwt.secret-base64}") String secretBase64,
      @Value("${security.jwt.ttl-seconds}") long ttlSeconds,
      @Value("${security.jwt.issuer}") String issuer
  ) {
    this.signingKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretBase64));
    this.ttlSeconds = ttlSeconds;
    this.issuer = issuer;
  }

  @Override
  public String generateToken(UserDetails user) {
    Instant now = Instant.now();
    Instant exp = now.plusSeconds(ttlSeconds);

    return Jwts.builder()
        .subject(user.getUsername())
        .issuer(issuer)
        .issuedAt(Date.from(now))
        .expiration(Date.from(exp))
        .signWith(signingKey)
        .compact();
  }

  @Override
  public String extractUsername(String token) {
    return extractClaim(token, Claims::getSubject);
  }

  @Override
  public <T> T extractClaim(String token, Function<Claims, T> resolver) {
    Claims claims = Jwts.parser()
        .verifyWith(signingKey)
        .build()
        .parseSignedClaims(token)
        .getPayload();

    return resolver.apply(claims);
  }

  @Override
  public boolean isTokenValid(String token, UserDetails user) {
    try {
      String username = extractUsername(token);
      if (!user.getUsername().equals(username)) {
        return false;
      }

      Date exp = extractClaim(token, Claims::getExpiration);
      return exp != null && exp.after(new Date());

    } catch (JwtException | IllegalArgumentException ex) {
      return false;
    }
  }
}
```

**Por qué así:**

* `verifyWith(key)` + `parseSignedClaims(...)` es el flujo recomendado en JJWT
  moderno. ([GitHub][1])
* `Keys.hmacShaKeyFor(Decoders.BASE64.decode(...))` es el camino documentado
  cuando el secreto está en Base64. ([GitHub][1])

---

Gracias. Ya con tu README completo puedo revisar **3.7 como quedó en la práctica**
y escribir **3.8** con cambios de código + pruebas, **explícito**.



---

# Revisión rápida de tu doc (ajustes necesarios antes de 3.8)

## A) Hay una contradicción fuerte en JJWT

En “Requisitos / Dependencias” estás poniendo **JJWT 0.11.5**, pero en 3.7 ya
migraste a **0.13.0**. Debe quedar **una sola versión** (la nueva).
Te recomiendo **reemplazar** la sección antigua por la de 3.7.

* Mantén: `jjwt-api` (compile)
* Mantén: `jjwt-impl` y `jjwt-jackson` (runtime)
* Mantén: `<jjwt.version>0.13.0</jjwt.version>`



## B) Estructura “mínima del proyecto” está adelantada

Tu árbol lista `JwtFilter` y una configuración stateless, pero por tus reglas
todavía **no toca** filtro ni stateless. Esa parte conviene moverla más adelante
(o marcarla como “futuro”).



## C) Detalle de código en 3.7 (pequeño pero limpio)

En tu `JwtServiceImpl` importaste:

```java
import io.jsonwebtoken.io.Encoders;
```

pero **no se usa**. Bórralo para que quede prolijo.



---

# Capítulo 3.8 — Devolver JWT en `POST /auth/login` (sin filtro aún)

## 1) Objetivo

Cuando el login sea válido:

1. autenticar con `AuthenticationManager` (ya lo tienes)
2. cargar `UserDetails` con tu `UserDetailsService`
3. generar token con `JwtService`
4. responder JSON: `{ "token": "...", "type": "Bearer" }`

> Importante: **sin filtro**, el token aún no “habilita” endpoints protegidos.
> Solo lo emitimos.



---

## 2) DTOs nuevos

Crea (o ajusta) estos DTOs.

### 2.1 `LoginRequest`

Ruta sugerida:
`src/main/java/.../controller/dto/LoginRequest.java`

```java
package com.example.springsecurityjwtdemo.controller.dto;

public class LoginRequest {

    private String username;
    private String password;

    public LoginRequest() {}

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
```

### 2.2 `LoginResponse`

Ruta sugerida:
`src/main/java/.../controller/dto/LoginResponse.java`

```java
package com.example.springsecurityjwtdemo.controller.dto;

public class LoginResponse {

    private String token;
    private String type;

    public LoginResponse() {}

    public LoginResponse(String token, String type) {
        this.token = token;
        this.type = type;
    }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}
```

---

## 3) Cambios en `AuthController`

### 3.1 Inyectar dependencias

Necesitas:

* `AuthenticationManager`
* `UserDetailsService` (tu `MyUserDetailsService` ya implementa la interfaz)
* `JwtService`

### 3.2 Implementación recomendada

Archivo:
`src/main/java/.../controller/AuthController.java`

```java
package com.example.springsecurityjwtdemo.controller;

import com.example.springsecurityjwtdemo.controller.dto.LoginRequest;
import com.example.springsecurityjwtdemo.controller.dto.LoginResponse;
import com.example.springsecurityjwtdemo.security.JwtService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;

    public AuthController(
            AuthenticationManager authenticationManager,
            UserDetailsService userDetailsService,
            JwtService jwtService
    ) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        UserDetails userDetails =
                userDetailsService.loadUserByUsername(request.getUsername());

        String token = jwtService.generateToken(userDetails);

        return ResponseEntity.ok(new LoginResponse(token, "Bearer"));
    }
}
```

### Decisión técnica (por qué así)

* El token se emite **solo después** de `authenticate(...)`.
* Usamos `UserDetailsService` para generar token desde el usuario real
  (en vez de confiar en lo que venga por request).

---

## 4) `SecurityConfig`: confirmar que `/auth/login` está permitido

Tu doc ya lo tiene en 3.6:

* `permitAll()` para `/auth/login`
* CSRF ignored para `/auth/login` y `/h2-console/**`

Asegúrate que está **exactamente** así (mínimo):

```java
.authorizeHttpRequests(auth -> auth
    .requestMatchers("/h2-console/**").permitAll()
    .requestMatchers("/auth/login").permitAll()
    .anyRequest().authenticated()
)
.csrf(csrf -> csrf
    .ignoringRequestMatchers("/h2-console/**", "/auth/login")
)
```

---

## 5) Pruebas (curl) — explícitas

### 5.1 Login OK (devuelve token)

```bash
curl -i -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"user","password":"1234"}'
```

**Esperado:**

```json
{"token":"<JWT>","type":"Bearer"}
```

### 5.2 Login FAIL (password mala)

```bash
curl -i -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"user","password":"mala"}'
```

**Esperado:**

* HTTP 401 (o 403 dependiendo de tu handler actual)
* no debe devolver token

> **Nota**
> En este punto el backend **emite** JWT en el login, pero **aún no procesa**
> tokens en requests entrantes (filtro viene después).”

---

## Capítulo 3.9 — Procesar JWT en requests (JwtFilter + stateless)

En 3.8 ya **emitimos** JWT. Ahora toca que Spring Security **lo lea** desde
`Authorization: Bearer ...`, lo valide y pueble el `SecurityContextHolder`.
Spring Security usa el `SecurityContextHolder` como fuente de “quién está
autenticado”. ([Home][1])

---

### 0) Estado objetivo (al terminar 3.9)

* `/auth/login` → `permitAll` (emite token)
* `/h2-console/**` → `permitAll` (solo dev)
* Resto → requiere JWT válido
* Session = **STATELESS**
* `JwtAuthenticationFilter` en la cadena, antes del filtro de login clásico

La idea de “Bearer token” viene del estándar de Authorization header (Spring
Security Resource Server lo resuelve así por defecto). ([Home][2])

---

## 1) Crear `JwtAuthenticationFilter`

Ruta sugerida:
`src/main/java/.../security/JwtAuthenticationFilter.java`

Características clave:

* Extiende `OncePerRequestFilter`
* Lee header `Authorization`
* Si no hay `Bearer`, no hace nada y deja pasar
* Si hay token:

  * extrae `username` con `JwtService`
  * carga `UserDetails`
  * valida token
  * crea `Authentication` y la pone en `SecurityContextHolder`

> Spring Security no “impone” cómo poblar el `SecurityContextHolder`; si está
> poblado, se usa como el usuario autenticado. ([Home][1])

```java
package com.example.springsecurityjwtdemo.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    public JwtAuthenticationFilter(
            JwtService jwtService,
            UserDetailsService userDetailsService
    ) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring("Bearer ".length());

        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            String username = jwtService.extractUsername(token);
            UserDetails userDetails =
                    userDetailsService.loadUserByUsername(username);

            if (jwtService.isTokenValid(token, userDetails)) {
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );

                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );

                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}
```

Notas:

* Si el token es inválido, **no seteamos** autenticación y el request terminará
  en 401 al intentar acceder a rutas protegidas.
* No atrapamos excepciones aquí todavía; en 3.10/3.11 solemos mejorar el
  manejo de errores con `AuthenticationEntryPoint`.

---

## 2) Registrar el filtro como bean (config)

En `SecurityConfig`, crea el bean del filtro para poder inyectar deps.

```java
@Bean
public JwtAuthenticationFilter jwtAuthenticationFilter(
        JwtService jwtService,
        UserDetailsService userDetailsService
) {
    return new JwtAuthenticationFilter(jwtService, userDetailsService);
}
```

---

## 3) Configurar `SecurityFilterChain` (stateless + filter order)

### 3.1 Stateless

En Spring Security, la parte de “session management” es donde forzamos
`STATELESS` para API. ([Home][3])

```java
.sessionManagement(sm ->
    sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
)
```

### 3.2 Insertar el filtro en la cadena

Debes ponerlo **antes** de `UsernamePasswordAuthenticationFilter`:

```java
.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
```

### 3.3 H2 console (frames + CSRF)

H2 usa frames y no implementa CSRF; Spring Boot documenta que para H2 en apps
seguras debes deshabilitar CSRF en la consola y permitir frames (SAMEORIGIN).
([Home][4])

Ejemplo completo (ajusta paquetes/nombres a tu proyecto):

```java
@Bean
public SecurityFilterChain securityFilterChain(
        HttpSecurity http,
        JwtAuthenticationFilter jwtAuthenticationFilter
) throws Exception {

    http
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/h2-console/**").permitAll()
            .requestMatchers("/auth/login").permitAll()
            .anyRequest().authenticated()
        )
        .sessionManagement(sm ->
            sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        )
        .csrf(csrf -> csrf
            .ignoringRequestMatchers("/h2-console/**", "/auth/login")
        )
        .headers(headers -> headers
            .frameOptions(frame -> frame.sameOrigin())
        )
        .addFilterBefore(
            jwtAuthenticationFilter,
            UsernamePasswordAuthenticationFilter.class
        );

    return http.build();
}
```

---

## 4) Endpoint protegido de prueba (si no tienes uno)

Crea algo mínimo para verificar 200 vs 401.

Ruta sugerida:
`src/main/java/.../controller/TestController.java`

```java
package com.example.springsecurityjwtdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/api/ping")
    public String ping() {
        return "pong";
    }
}
```

---

## 5) Pruebas con curl (con HTTP codes)

### 5.1 Login OK → obtienes token (200)

```bash
curl -i -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"user","password":"1234"}'
```

Guarda el `<JWT>` del JSON.

### 5.2 Endpoint protegido sin token → 401

```bash
curl -i http://localhost:8080/api/ping
```

Esperado (mínimo):

```text
HTTP/1.1 401
```

### 5.3 Endpoint protegido con token → 200

```bash
curl -i http://localhost:8080/api/ping \
  -H "Authorization: Bearer <JWT>"
```

Esperado:

* `HTTP/1.1 200`
* body: `pong`

---

## 6) Qué NO hacemos todavía (para mantener el capítulo limpio)

* No “formateamos” el error 401 en JSON (eso viene en un capítulo de error
  handling / entry point).
* No refresh token.
* No revocación / blacklist.

---

Si me pegas tu `SecurityConfig` actual (el real, post-3.8), te lo devuelvo
exactamente con el diff mínimo (sin introducir nada extra).

[1]: https://docs.spring.io/spring-security/reference/servlet/authentication/architecture.html?utm_source=chatgpt.com "Servlet Authentication Architecture :: Spring Security"
[2]: https://docs.spring.io/spring-security/reference/servlet/oauth2/resource-server/bearer-tokens.html?utm_source=chatgpt.com "OAuth 2.0 Bearer Tokens :: Spring Security"
[3]: https://docs.spring.io/spring-security/reference/servlet/authentication/session-management.html?utm_source=chatgpt.com "Authentication Persistence and Session Management - Spring"
[4]: https://docs.spring.io/spring-boot/docs/3.2.5/reference/htmlsingle/?utm_source=chatgpt.com "Spring Boot Reference Documentation"
