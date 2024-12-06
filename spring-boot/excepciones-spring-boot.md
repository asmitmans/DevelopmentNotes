## Manejo de Excepciones en Spring Boot

- [Manejo de Excepciones en Spring Boot](#manejo-de-excepciones-en-spring-boot)
- [Introducción](#introducción)

---

## Introducción
El manejo de excepciones en Spring Boot es esencial para proporcionar 
respuestas claras y uniformes en APIs REST. Las excepciones deben: 
- Centralizarse para evitar duplicidad de lógica.
- Proporcionar mensajes útiles al cliente sin exponer detalles técnicos.
- Seguir un diseño modular y reutilizable.

**Enfoque general:**
1. Define excepciones personalizadas que extiendan `RuntimeException`.
2. Crea un modelo para las respuestas de error (por ejemplo, `ApiError`).
3. Centraliza el manejo de excepciones con `@RestControllerAdvice`.
4. Lanza excepciones personalizadas desde los controladores según sea 
   necesario.

---

