# JWT (JSON Web Token) — Conceptos Fundamentales

Este documento explica los conceptos necesarios para entender
la implementación del JwtService y JwtAuthenticationFilter.

No contiene código.

---

# 1. ¿Qué es un JWT?

JWT (JSON Web Token) es un estándar para transmitir
información de identidad de forma compacta y segura.

Un JWT es:

- Autocontenido
- Firmado criptográficamente
- Independiente de sesión

Se envía normalmente en el header HTTP:

Authorization: Bearer <token>

---

# 2. Estructura de un JWT

Un JWT tiene tres partes separadas por puntos:

HEADER.PAYLOAD.SIGNATURE

Ejemplo conceptual:

xxxxx.yyyyy.zzzzz

## 2.1 Header

Contiene información sobre el algoritmo de firma.

Ejemplo conceptual:
{
  "alg": "HS256"
}

---

## 2.2 Payload (Claims)

Contiene información del usuario.

Ejemplo conceptual:
{
  "sub": "user",
  "iss": "SpringSecurityJWTDemo",
  "iat": 123456,
  "exp": 123999
}

Claims comunes:

- sub → Subject (usuario)
- iss → Issuer (quién emitió el token)
- iat → Issued At
- exp → Expiration

---

## 2.3 Signature

Garantiza que el token no fue modificado.

Se genera combinando:

Header + Payload + Secret Key

Si alguien altera el payload,
la firma deja de ser válida.

---

# 3. HS256 (Firma Simétrica)

HS256 es un algoritmo de firma HMAC con SHA-256.

Es simétrico, lo que significa:

- El mismo secret se usa para firmar y validar.

Ventajas:
- Simple de implementar.
- Adecuado para backend único.

Desventaja:
- Si el secret se filtra, cualquiera puede firmar tokens.

---

# 4. Secret en Base64

La clave usada para HS256 debe tener tamaño adecuado.

Por eso:

- Se genera un secret seguro.
- Se almacena como Base64 en application.properties.
- Se decodifica para construir la SecretKey.

Esto evita usar strings débiles como "123456".

---

# 5. Expiración (exp)

El token contiene una fecha de expiración.

Después de esa fecha:

- El token deja de ser válido.
- El filtro debe rechazarlo.

JWT no se "revoca" automáticamente.
La expiración es el mecanismo básico de control.

---

# 6. ¿Por qué no usamos AuthenticationProvider para JWT?

El AuthenticationProvider está diseñado para validar
credenciales (username + password).

JWT es distinto:

- El usuario ya fue autenticado previamente.
- Ahora solo se valida una firma criptográfica.

Por eso usamos un filtro personalizado:

JwtAuthenticationFilter

El filtro:

1. Extrae el token del header.
2. Valida firma y expiración.
3. Carga el usuario.
4. Coloca Authentication en el SecurityContextHolder.

No interviene AuthenticationManager.
No interviene AuthenticationProvider.

---

# 7. JWT y Arquitectura Stateless

En arquitectura stateless:

- El servidor no guarda sesión.
- El cliente debe enviar el token en cada request.
- Cada request se valida de forma independiente.

JWT permite esta arquitectura porque:

- Contiene identidad.
- Está firmado.
- No necesita consulta a base de datos para validarse
  (salvo para cargar roles actualizados).

---

# 8. Resumen Mental

Login:
Credenciales → AuthenticationManager → Generar JWT

Requests siguientes:
Authorization: Bearer <token> →
JwtFilter → Validar firma →
SecurityContextHolder →
Controller
```

---
