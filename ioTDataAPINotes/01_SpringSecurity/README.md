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

Perfecto, lo tienes muy bien organizado y estás siguiendo una estructura muy profesional. Vamos a consolidarlo como guía definitiva de este capítulo. A continuación te explico **qué conservar, qué eliminar y cómo reorganizarlo**, para que quede coherente con tu enfoque teórico → implementación → extensiones.

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
  <version>0.11.5</version>
</dependency>
<dependency>
  <groupId>io.jsonwebtoken</groupId>
  <artifactId>jjwt-impl</artifactId>
  <version>0.11.5</version>
  <scope>runtime</scope>
</dependency>
<dependency>
  <groupId>io.jsonwebtoken</groupId>
  <artifactId>jjwt-jackson</artifactId>
  <version>0.11.5</version>
  <scope>runtime</scope>
</dependency>
```

---

## 2. Estructura mínima del proyecto

```
src/main/java/
└── com/example/securitydemo/
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

### 3.3. Servicio `UserDetailsService`

* Implementar método `loadUserByUsername`

### 3.4. `JwtService`

* Generar tokens con `Jwts.builder()`
* Validar tokens, extraer claims

### 3.5. `JwtFilter`

* Revisar header `Authorization`
* Validar y cargar usuario en el `SecurityContextHolder`

### 3.6. `SecurityConfig`

* Configurar seguridad sin estado (`STATELESS`)
* Permitir rutas públicas (`/auth/**`)
* Proteger otras con roles
* Inyectar el filtro antes de `UsernamePasswordAuthenticationFilter`

### 3.7. `AuthController`

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
spring.datasource.password=

# Usar Hibernate (JPA)
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Consola web de H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

Esto hará que:

* Se cree una base de datos en memoria al iniciar la app
* La consola esté accesible en `http://localhost:8080/h2-console`
* Las tablas se generen automáticamente desde tus entidades

---

## 2. Crear la entidad `Role`

En el paquete `model/`, crea un archivo `Role.java`:

```java
package com.example.springsecurityjwtdemo.model;

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
package com.example.springsecurityjwtdemo.model;

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

¿Te dejo listo ahora el capítulo 3.3 con los repositorios y datos de prueba?







