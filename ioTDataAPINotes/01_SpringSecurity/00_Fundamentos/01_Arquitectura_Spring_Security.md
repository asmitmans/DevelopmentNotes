# Arquitectura Interna de Spring Security (Resumen Conceptual)

Este documento resume los conceptos necesarios para entender
la implementación práctica del capítulo 3.x.

No contiene código. Solo explica el modelo mental del sistema.

---

# 1. Visión General

Spring Security funciona como una cadena de filtros HTTP.

Cada request pasa primero por la SecurityFilterChain
antes de llegar a cualquier Controller.

Diagrama simplificado:

```plaintext
                        ┌──────────────────────────┐
Request ──────────────► │     SecurityFilterChain  │
                        └─────────────┬────────────┘
                                      │
                                      ▼
                        ┌──────────────────────────┐
                        │  JwtAuthenticationFilter │
                        └─────────────┬────────────┘
                                      │
                 (si hay token válido)│
                                      ▼
                        ┌────────────────────────────┐
                        │  SecurityContextHolder     │
                        │  (contiene Authentication) │
                        └─────────────┬──────────────┘
                                      │
                                      ▼
                                 Controller
```

Nada llega al controller sin pasar por esta cadena.

---

# 2. SecurityContextHolder

Es el contenedor donde Spring guarda la identidad autenticada.

Internamente utiliza un mecanismo por hilo (ThreadLocal),
por lo que cada request tiene su propio contexto aislado.

Si el SecurityContextHolder contiene una Authentication válida,
Spring considera al usuario autenticado.

Si está vacío → el request no está autenticado.

---

# 3. Authentication

Authentication representa la identidad autenticada.

Contiene:

* Principal (normalmente UserDetails)
* Authorities (roles/permisos)
* Estado de autenticación (authenticated = true/false)

En nuestro flujo JWT:

El JwtAuthenticationFilter crea un
UsernamePasswordAuthenticationToken autenticado
y lo coloca en el SecurityContextHolder.

---

# 4. Flujo de Login (Username + Password)

El login utiliza credenciales tradicionales.

Diagrama conceptual:

Login Request (username/password)
│
▼
AuthenticationManager
│
▼
AuthenticationProvider
│
▼
UserDetailsService
│
▼
PasswordEncoder

```

Si las credenciales son correctas:

- Se devuelve una Authentication válida.
- Se genera el JWT.
- No se crea sesión (modo stateless).

Si son incorrectas:

- Se lanza AuthenticationException.

---

# 5. AuthenticationManager

Es el punto de entrada para autenticación por credenciales.

No valida directamente usuario y contraseña.
Delegará esa responsabilidad a un AuthenticationProvider.

En una API JWT stateless:

AuthenticationManager se usa únicamente en el login.

Después de emitir el token, ya no participa más.

---

# 6. AuthenticationProvider (Concepto Clave)

AuthenticationProvider es el componente que realmente
sabe cómo validar un tipo específico de autenticación.

Responsabilidades:

1. Recibir un Authentication sin validar.
2. Extraer credenciales.
3. Consultar UserDetailsService.
4. Comparar password con PasswordEncoder.
5. Devolver Authentication autenticada o lanzar excepción.

Spring puede tener múltiples AuthenticationProvider
para distintos mecanismos (LDAP, JWT, OAuth, etc.).

En nuestro caso se utiliza el proveedor estándar
DaoAuthenticationProvider.

---

# 7. Flujo JWT (Requests posteriores)

Una vez autenticado y con token emitido:

Request con header Authorization: Bearer <token>
               │
               ▼
       JwtAuthenticationFilter
               │
               ▼
     Validación de firma y expiración
               │
               ▼
  SecurityContextHolder.setAuthentication(...)
               │
               ▼
           Controller

En este flujo:

- No se usa AuthenticationManager.
- No se usa sesión HTTP.
- Cada request es independiente.

---

# 8. Stateless vs Stateful

Stateful:
- Usa sesión HTTP (JSESSIONID).
- El servidor guarda estado.

Stateless:
- No se guarda sesión.
- Cada request debe traer su autenticación.
- Se usa SessionCreationPolicy.STATELESS.

Nuestra API es completamente stateless.

---

# 9. 401 vs 403

401 → No autenticado.
403 → Autenticado pero sin permisos suficientes.

Dependiendo del AuthenticationEntryPoint configurado,
Spring puede devolver 403 incluso cuando falta autenticación.

En APIs REST es común forzar 401 cuando el token es inválido o ausente.
```

---
