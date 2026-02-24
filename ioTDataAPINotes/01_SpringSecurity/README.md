# Spring Security + JWT Demo (Spring Boot 4)

Proyecto demo utilizado en IoTDataAPINotes para implementar
autenticación JWT paso a paso con Spring Security 7.

## Stack

- Spring Boot 4.0.2
- Spring Security 7
- Spring Data JPA
- H2 (memoria)
- JJWT 0.13.0
- BCryptPasswordEncoder

## Objetivo

Construir una API REST stateless con:

- Login autenticado con AuthenticationManager
- Emisión de JWT firmado (HS256)
- Validación de JWT en filtro personalizado
- Seguridad basada en SecurityFilterChain

---

## Quick Start

### 1. Ejecutar aplicación

```bash
mvn spring-boot:run
```

### 2. Login

```bash
curl -i -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"user","password":"1234"}'
```

### 3. Endpoint protegido sin token

```bash
curl -i http://localhost:8080/api/ping
```

### 4. Endpoint protegido con token

```bash
curl -i http://localhost:8080/api/ping \
  -H "Authorization: Bearer <JWT>"
```

---
