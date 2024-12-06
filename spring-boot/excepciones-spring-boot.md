## Manejo de Excepciones en Spring Boot

- [Manejo de Excepciones en Spring Boot](#manejo-de-excepciones-en-spring-boot)
- [Introducción](#introducción)
- [Paso 1: Crear excepciones personalizadas](#paso-1-crear-excepciones-personalizadas)
- [Paso 2: Crear un modelo para la respuesta de error](#paso-2-crear-un-modelo-para-la-respuesta-de-error)
- [Paso 3: Crear un controlador global para excepciones](#paso-3-crear-un-controlador-global-para-excepciones)
- [Paso 4: Lanza excepciones desde los controladores](#paso-4-lanza-excepciones-desde-los-controladores)
- [Pasos:](#pasos-3)

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

## Paso 4: Lanza excepciones desde los controladores

### Definición
Los controladores deben lanzar excepciones personalizadas cuando ocurran 
errores en la lógica de negocio, delegando el manejo al controlador global. 

## Pasos:
1. Usa servicios para realizar la lógica de negocio.
2. Lanza excepciones personalizadas cuando sea necesario.
3. Deja que el controlador global maneje la respuesta al cliente.

### Ejemplo:
```java
@GetMapping("/clients/{rut}")
public ResponseEntity<Client> findByRut(@PathVariable String rut) {
    Client client = clientService.findByRut(rut);
    if (client == null) {
        throw new ClientNotFoundException(String.format("El cliente con rut %s no existe", rut));
    }
    return ResponseEntity.ok(client);
}
```

---
