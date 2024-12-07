## Manejo de Excepciones en Spring Boot

- [Manejo de Excepciones en Spring Boot](#manejo-de-excepciones-en-spring-boot)
- [Introducción](#introducción)
- [Paso 1: Crear excepciones personalizadas](#paso-1-crear-excepciones-personalizadas)
- [Paso 2: Crear un modelo para la respuesta de error](#paso-2-crear-un-modelo-para-la-respuesta-de-error)
- [Paso 3: Crear un controlador global para excepciones](#paso-3-crear-un-controlador-global-para-excepciones)
- [Paso 4: Usar excepciones en el servicio](#paso-4-usar-excepciones-en-el-servicio)
- [Nota final: Cómo funciona el sistema de excepciones](#nota-final-cómo-funciona-el-sistema-de-excepciones)

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
4. Lanza excepciones personalizadas desde los servicios según sea 
   necesario.

---

## Paso 1: Crear excepciones personalizadas

### Definición
Las excepciones personalizadas representan errores específicos de la lógica 
de negocio. Estas excepciones extienden `RuntimeException` para simplificar 
su manejo.

### Pasos:
1. Ubica las excepciones en un paquete dedicado (`exceptions`).
2. Extiende la clase `RuntimeException`.
3. Define un constructor que reciba un mensaje para describir el error.

### Ejemplo:
```java
package com.example.exceptions;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(String message) {
        super(message);
    }
}

```

---

## Paso 2: Crear un modelo para la respuesta de error

### Definición
El modelo de respuesta de error define la estructura que recibirán los 
clientes cuando ocurra un error en la API.

### Pasos:
1. Crea una clase en el paquete `model`.
2. Usa un nombre descriptivo como `ApiError` para evitar conflictos con 
   clases de Java (`Error`).
3. Incluye los siguientes atributos:
   - `String message`: Mensaje del error.
   - `String error`: Detalles técnicos.
   - `LocalDateTime timestamp`: Fecha y hora del error.
   - `Integer status`: Código de estado HTTP.

### Ejemplo:
```java
package com.example.model;

import java.time.LocalDateTime;

public class ApiError {
    private String message;
    private String error;
    private LocalDateTime timestamp;
    private Integer status;

    public ApiError(String message, String error, LocalDateTime timestamp, Integer status) {
        this.message = message;
        this.error = error;
        this.timestamp = timestamp;
        this.status = status;
    }
    // Getters y setters
}
```

---

## Paso 3: Crear un controlador global para excepciones

### Definición
El controlador global maneja todas las excepciones de manera centralizada.
Esto simplifica la lógica y asegura respuestas consistentes.

### Pasos:
1. Crea una clase en el paquete `exceptions` o `controllers`.
2. Anota la clase con `@RestControllerAdvice`.
3. Define métodos con `@ExceptionHandler` para manejar excepciones 
   específicas.
4. Devuelve una instancia del modelo `ApiError` como respuesta al cliente.

### Ejemplo:
```java
package com.example.exceptions;

import com.example.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ApiError> handleClientNotFound(ClientNotFoundException ex) {
        ApiError error = new ApiError(
            "Cliente no encontrado",
            ex.getMessage(),
            LocalDateTime.now(),
            HttpStatus.NOT_FOUND.value()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGeneralException(Exception ex) {
        ApiError error = new ApiError(
            "Error interno del servidor",
            ex.getMessage(),
            LocalDateTime.now(),
            HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
```

---

## Paso 4: Usar excepciones en el servicio

### Definición
La capa de servicio es responsable de la lógica de negocio. Las excepciones 
deben lanzarse desde aquí para mantener la separación de responsabilidades y 
permitir que el controlador global gestione los errores.

### Pasos:
1. Identifica los casos donde sea necesario lanzar una excepción.
2. Usa excepciones personalizadas para representar errores específicos.
3. Lanza la excepción desde el servicio con `throw`.

### Ejemplo:
```java
@Override
public Client findByRut(String rut) {
    return clients.stream()
        .filter(client -> client.getRut().equals(rut))
        .findFirst()
        .orElseThrow(() -> new ClientNotFoundException(
            String.format("El cliente con rut %s no existe", rut)
        ));
}
```

---

## Nota final: Cómo funciona el sistema de excepciones

1. **Excepciones desde el servicio:**
- La lógica de negocio lanza excepciones personalizadas, como 
  ClientNotFoundException, cuando ocurre un error.

2. **Controlador común:**
- El controlador no maneja las excepciones directamente. Se limita a delegar 
  la lógica al servicio.

3. **Controlador global:**
- Captura cualquier excepción lanzada desde el servicio o el controlador.
- Devuelve una respuesta uniforme y clara al cliente con un modelo como 
  `ApiError`.

4. **Flujo general:**
- El cliente realiza una solicitud.
- Si ocurre un error, el servicio lanza una excepción.
- El controlador global captura la excepción y responde con un mensaje bien 
  formateado.

---
