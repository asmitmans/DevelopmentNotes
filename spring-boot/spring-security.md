## Spring Security

- [Spring Security](#spring-security)
- [¿Qué es Spring Security y para qué sirve?](#qué-es-spring-security-y-para-qué-sirve)
- [Pasos para implementar Spring Security](#pasos-para-implementar-spring-security)
- [Configuración estándar y personalizable de Spring Security](#configuración-estándar-y-personalizable-de-spring-security)
- [Relación entre JWT y Spring Security](#relación-entre-jwt-y-spring-security)
- [Tablas de usuarios y roles en Spring Security](#tablas-de-usuarios-y-roles-en-spring-security)
- [Configuración de usuarios y roles con JPA en Spring Security](#configuración-de-usuarios-y-roles-con-jpa-en-spring-security)
- [Implementación de Spring Security](#implementación-de-spring-security)
- [Implementación de Spring Security con JWT](#implementación-de-spring-security-con-jwt)


---

## ¿Qué es Spring Security y para qué sirve?

**Spring Security** es un framework dentro del ecosistema de **Spring** que 
proporciona una solución integral para gestionar la **autenticación** y 
**autorización** en aplicaciones. Su principal objetivo es proteger las 
aplicaciones Java, asegurando que solo los usuarios correctos puedan acceder a 
las funcionalidades definidas.

Algunas de sus características clave incluyen:
- **Autenticación**: Verifica la identidad de los usuarios, permitiendo la 
  integración con diversas fuentes de datos (bases de datos, LDAP, JWT, OAuth2).
- **Autorización**: Define qué recursos o rutas pueden ser accedidos por cada 
  usuario, basado en roles o permisos.
- **Protección contra ataques**: Spring Security protege las aplicaciones contra 
  ataques comunes como **CSRF**, **XSS**, y **session fixation**.
- **Flexibilidad**: Se adapta tanto a aplicaciones web con formularios como a 
  APIs RESTful.

La última versión de Spring Security elimina la necesidad de usar el 
**WebSecurityConfigurerAdapter**, simplificando la configuración y adoptando un 
enfoque más moderno con anotaciones y beans personalizados.

---

## Pasos para implementar Spring Security

1. **Añadir dependencias en el `pom.xml`**:
   El primer paso es incluir la dependencia de **Spring Security** en el archivo 
   `pom.xml` de tu proyecto:

   ```xml
   <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-security</artifactId>
   </dependency>
   ```
Esto integrará Spring Security en tu proyecto, proporcionando funcionalidades de 
seguridad predeterminadas.

2. **Configurar una clase de seguridad**: Luego, debes crear una clase de 
   configuración de seguridad anotada con `@Configuration` y `@EnableWebSecurity`.
   Aquí puedes definir cómo Spring Security manejará la autenticación y 
   autorización:
  
  ```java:
  @Configuration
  @EnableWebSecurity
  public class SecurityConfig {

      @Bean
      public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
          http
              .authorizeHttpRequests(authz -> authz
                  .anyRequest().authenticated())
              .formLogin(form -> form
                  .loginPage("/login")
                  .permitAll())
              .logout(logout -> logout
                  .permitAll());
          return http.build();
      }
  }
  ```

3. **Personalizar la autenticación y autorización**: En esta clase, puedes 
   configurar qué rutas requieren autenticación, qué tipo de autenticación usar 
   (como formularios o tokens), y personalizar las páginas de inicio de sesión y 
   error.

4. **Gestión de usuarios y roles**: Puedes usar una base de datos, un servicio 
   externo, o un servicio de usuario personalizado para manejar la carga de 
   usuarios y sus roles.

5. **Opcional: Proteger APIs REST con JWT o OAuth2**: Si tu aplicación es una API, 
   puedes integrar **JWT (JSON Web Tokens)** o **OAuth2** para manejar la autenticación 
   sin estado (stateless).

---

## Configuración estándar y personalizable de Spring Security

La configuración de **Spring Security** es bastante **estándar** en la mayoría de 
los proyectos. Spring proporciona una estructura predeterminada para manejar la 
autenticación y autorización, pero permite la **personalización** según las 
necesidades de cada aplicación.

1. **Estructura básica estándar**:
   - **Autenticación y autorización**: La mayoría de los proyectos siguen un 
     patrón similar donde las rutas protegidas requieren autenticación, y se 
     define cómo se gestionan los roles y permisos.
   - **Formularios de login**: Spring Security, por defecto, proporciona un 
     formulario de login estándar que puede ser personalizado si se desea.
   - **Protección contra CSRF**: La protección **CSRF (Cross-Site Request Forgery)** 
     está habilitada por defecto para aplicaciones web.

2. **Personalización según las necesidades**:
   - **Rutas protegidas**: Puedes personalizar qué rutas son accesibles sin 
     autenticación (como páginas públicas) y cuáles requieren autenticación, 
     usando `.authorizeHttpRequests()`.
   - **Formularios personalizados**: Si no deseas usar el formulario 
     predeterminado, puedes crear tu propia página de inicio de sesión con 
     `formLogin().loginPage("/mi-login")`.
   - **Tipos de autenticación**: Spring Security permite cambiar entre diferentes 
     tipos de autenticación, como **formularios**, **JWT (tokens)** o **OAuth2**, 
     lo que da flexibilidad según el tipo de aplicación (web o API).
   - **Gestión de usuarios**: Se puede personalizar cómo se cargan los usuarios 
     (desde una base de datos, un servicio externo, o directamente en memoria).

En resumen, la configuración de seguridad sigue un patrón base, pero puede 
ajustarse para cubrir los requerimientos específicos de cada proyecto.

---

## Relación entre JWT y Spring Security

**JWT** es simplemente un formato de token que se usa para autenticar usuarios 
en aplicaciones sin necesidad de sesiones (stateless). Por sí solo, JWT no 
proporciona un sistema completo de seguridad. Sin embargo, cuando usas JWT en 
una API, necesitas configurar ciertas capas de seguridad:

1. **Filtros de seguridad**: Configuran el mecanismo que valida el token JWT en 
   cada solicitud.
2. **Carga de usuarios y roles**: Una vez validado el JWT, se verifica la 
   autorización del usuario según los roles incluidos en el token.

**Spring Security**, por otro lado, es un framework de seguridad completo que 
gestiona toda la seguridad de una aplicación: desde la protección de rutas hasta 
la autenticación y autorización. En resumen, **JWT** es un tipo de credencial, 
mientras que **Spring Security** es el sistema que define y controla todo el 
acceso a los recursos de una aplicación.

**Complementarios**: **JWT** se puede usar dentro de **Spring Security** para 
gestionar la autenticación en APIs. Mientras que Spring Security maneja la 
protección de rutas y roles, **JWT** permite a los usuarios autenticarse sin 
necesidad de sesiones, transmitiendo un token en cada petición.

---

## Tablas de usuarios y roles en Spring Security

Cuando implementas **Spring Security** con autenticación basada en bases de datos, 
necesitas definir tablas para almacenar los **usuarios** y **roles**. Estas tablas 
deben tener la información que Spring Security requiere para cargar y verificar 
los usuarios y sus permisos.

1. **Tabla de usuarios** (`users`):
   Debe contener al menos:
   - **username**: El nombre de usuario único que identificará a cada usuario.
   - **password**: La contraseña, que debe estar encriptada (usualmente con **BCrypt**).
   - **enabled**: Un campo booleano que indica si el usuario está habilitado o no.

   Ejemplo de tabla `users`:
   ```sql
   CREATE TABLE users (
       username VARCHAR(50) NOT NULL PRIMARY KEY,
       password VARCHAR(100) NOT NULL,
       enabled BOOLEAN NOT NULL
   );
   ```

2. **Tabla de roles o authorities (`authorities` o `roles`)**: Esta tabla debe asignar 
   roles o permisos a los usuarios. Se recomienda usar una relación de uno a 
   muchos, donde un usuario puede tener varios roles.

   Ejemplo de tabla `authorities`:
   ```sql
   CREATE TABLE authorities (
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES users(username)
   );
   ```

### Relación entre tablas:
* **users**: Almacena los detalles del usuario (nombre de usuario, contraseña 
  encriptada, estado habilitado).
* **authorities/roles**: Almacena los roles o permisos asociados a cada usuario.

Spring Security usará estas tablas para autenticar a los usuarios y verificar si 
tienen los permisos adecuados para acceder a ciertos recursos.

Este formato te permitirá estructurar y comprender las tablas necesarias para 
manejar la autenticación y autorización usando Spring Security.

---

## Configuración de usuarios y roles con JPA en Spring Security

1. **Entidades JPA**:
   - **User**: Define la entidad `User` con los campos `username`, `password`, 
     `enabled`, y la relación con los roles.
   - **Role**: Define la entidad `Role` que mapea los roles de los usuarios.

1. **Repositorios JPA**:
   - **UserRepository**: Interactúa con la tabla de usuarios.
   - **RoleRepository**: Interactúa con la tabla de roles.

2. **Servicio `UserDetailsServiceImpl`**:
   - Este servicio carga los detalles del usuario y sus roles desde la base de 
     datos utilizando los repositorios de JPA.

1. **Configuración de Spring Security**:
   - Configura Spring Security para usar el `UserDetailsService` personalizado y 
     manejar la autenticación de usuarios desde la base de datos.

1. **PasswordEncoder**:
   - Se recomienda usar **BCryptPasswordEncoder** para encriptar las contraseñas 
     en la base de datos.

---

## Implementación de Spring Security

1. **Dependencias**:
   - Añadir las dependencias necesarias en el archivo `pom.xml`, principalmente 
    `spring-boot-starter-security`.

2. **Entidades JPA (Usuarios y Roles)**:
   - Crear las entidades `User` y `Role` que se mapearán a las tablas de usuarios 
     y roles en la base de datos.

3. **Tablas de usuarios y roles**:
   - Definir tablas en la base de datos para almacenar la información de los 
     usuarios y sus roles.

4. **Repositorios JPA**:
   - Crear repositorios para manejar las entidades `User` y `Role` (`UserRepository`, 
     `RoleRepository`).

5. **Servicio `UserDetailsServiceImpl`**:
   - Implementar un servicio personalizado (`UserDetailsServiceImpl`) para cargar 
     los usuarios y roles desde la base de datos.

6. **PasswordEncoder**:
   - Configurar un codificador de contraseñas, como **BCryptPasswordEncoder**, 
     para encriptar las contraseñas.

7. **Configuración de seguridad (`SecurityConfig.java`)**:
   - Definir la configuración de seguridad en una clase con `@EnableWebSecurity` 
     y `SecurityFilterChain` para gestionar la autenticación, autorización y 
     rutas protegidas.

8. **Formularios de login y logout**:
   - Personalizar las páginas de inicio de sesión y cierre de sesión, si es 
     necesario.
 
---

## Implementación de Spring Security con JWT

1. **Dependencias adicionales**:
   - Añadir dependencias para **JWT** en el archivo `pom.xml`. Estas dependencias 
     permitirán generar y validar los tokens JWT.

2. **Generación y validación de JWT**:
   - Implementar un servicio para generar tokens JWT una vez que el usuario ha 
     sido autenticado. Este token se devolverá al cliente.
   - Implementar la validación del token JWT para asegurarse de que las 
     peticiones autenticadas contienen un token válido.

3. **Filtros de autenticación y autorización con JWT**:
   - Configurar un filtro personalizado que se encargue de interceptar cada 
     solicitud HTTP. Este filtro se encargará de extraer el token JWT del 
     encabezado de la petición y validarlo.
   
4. **Autenticación sin estado (stateless)**:
   - Desactivar el manejo de sesiones en la configuración de **Spring Security**, 
     ya que con JWT la autenticación es sin estado. Esto implica configurar la 
     política de gestión de sesiones como **STATELESS**.

5. **Autenticación de usuarios con JWT**:
   - Spring Security utilizará el token JWT en lugar de las sesiones 
     tradicionales para autenticar a los usuarios en cada solicitud, verificando 
     los permisos y roles incluidos en el token.

6. **Configuración de seguridad (`SecurityConfig.java`)**:
   - Ajustar la clase de configuración de seguridad para integrar el filtro JWT 
     y asegurar que las rutas están protegidas según los roles definidos en el 
     token.

7. **Roles y permisos con JWT**:
   - Extraer los roles o permisos del token JWT y utilizarlos para autorizar el 
     acceso a rutas específicas dentro de la aplicación.

8. **Autenticación con JWT en APIs REST**:
   - Este enfoque es ideal para **APIs RESTful**, donde el cliente y el servidor 
     están desacoplados, y el token se envía en cada solicitud, sin necesidad de 
     mantener una sesión en el servidor.

---

### ¿Pueden convivir autenticación con estado (stateful) y sin estado (stateless) en Spring Security?

**Sí**, es posible combinar autenticación con estado y sin estado en una misma 
aplicación utilizando **Spring Security**:

1. **Autenticación con estado (stateful)**:
   - Las aplicaciones web tradicionales pueden usar sesiones en el servidor para 
     mantener la autenticación del usuario a lo largo de las distintas páginas 
     de la aplicación.
   - Esto es útil en aplicaciones donde los usuarios necesitan interactuar 
     repetidamente con el servidor.

2. **Autenticación sin estado (stateless) con JWT**:
   - Las APIs RESTful generalmente utilizan **JWT** para autenticar a los 
     usuarios en cada solicitud sin la necesidad de mantener sesiones en el 
     servidor.
   - Cada solicitud incluye un **token JWT** que se valida en el servidor.

### Convivencia en una aplicación:
- **Spring Security** permite configurar rutas que utilizan autenticación **stateful** 
  (para la web app) y otras que usan **stateless** (para la API REST con JWT).
- Esto se logra configurando diferentes reglas en **SecurityFilterChain** o en 
  los ajustes de seguridad para diferentes tipos de rutas.

En resumen, una misma aplicación puede manejar tanto autenticación con estado 
(web app con sesiones) como autenticación sin estado (API REST con JWT).

---



