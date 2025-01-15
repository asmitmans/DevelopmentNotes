## Crear Proyecto SpringBoot + MongoDB

- [Crear Proyecto SpringBoot + MongoDB](#crear-proyecto-springboot--mongodb)
- [Paso 1: Crear un nuevo proyecto de Spring Boot](#paso-1-crear-un-nuevo-proyecto-de-spring-boot)
- [Paso 2: Configurar `application.properties`](#paso-2-configurar-applicationproperties)
- [Paso 3: Crear la entidad `Customer`](#paso-3-crear-la-entidad-customer)
- [Paso 4: Crear el repositorio](#paso-4-crear-el-repositorio)
- [Paso 5: Crear el controlador](#paso-5-crear-el-controlador)
- [Paso 6: Ejecutar y probar](#paso-6-ejecutar-y-probar)
- [Paso 7: Validar el almacenamiento en MongoDB](#paso-7-validar-el-almacenamiento-en-mongodb)


## Paso 1: Crear un nuevo proyecto de Spring Boot
1. Abre **Spring Tool Suite (STS)** y crea un nuevo proyecto **Spring Boot**.
2. En **Spring Initializr**, incluye las siguientes dependencias:
   - **Spring Web**
   - **Spring Data MongoDB**
   - **Lombok**


## Paso 2: Configurar `application.properties`
Dado que usaremos MongoDB corriendo con valores por defecto, añade esta 
configuración mínima en el archivo `src/main/resources/application.properties`:

```properties
spring.application.name=mongoDB
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=testdb
```

> Cambia `testdb` por el nombre de la base de datos que desees usar. Si no 
> existe, se creará automáticamente.


## Paso 3: Crear la entidad `Customer`
Crea una clase llamada `Customer` en el paquete `model`. Usaremos **Lombok** para 
simplificar el código:

```java
package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "customers")
public class Customer {
	
	@Id
	private String id;
	private String name;
	private String lastName;
	private String email;
	
}
```


## Paso 4: Crear el repositorio
Crea una interfaz `CustomerRepository` en el paquete `repository`. Extiende 
`MongoRepository` para habilitar operaciones básicas:

```java
package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    // Las operaciones básicas (save, findAll, deleteById, etc.) ya están disponibles
}
```


## Paso 5: Crear el controlador
Crea una clase `CustomerController` en el paquete `controller` para manejar las 
solicitudes HTTP:

```java
package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    // GET: Obtener todos los clientes
    @GetMapping("")
    public ResponseEntity<List<Customer>> findAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerRepository.findAll());
    }

    // POST: Crear un nuevo cliente
    @PostMapping("")
    public ResponseEntity<Customer> insert(@RequestBody Customer customer) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(customerRepository.insert(customer));
    }
}
```


## Paso 6: Ejecutar y probar
1. Inicia el proyecto desde STS.
2. Verifica que no haya errores en la consola.
3. Usa herramientas como **Postman** o **curl** para probar los endpoints:
   - **GET** `http://localhost:8080/customers`:
     ```bash
     curl -X GET http://localhost:8080/customers
     ```
   - **POST** `http://localhost:8080/customers`:
     ```bash
     curl -X POST http://localhost:8080/customers \
     -H "Content-Type: application/json" \
     -d '{"name": "John", "lastName": "Doe", "email": "john.doe@example.com"}'
     ```


## Paso 7: Validar el almacenamiento en MongoDB
1. Abre **mongosh** en tu terminal.
2. Cambia a la base de datos usada (`use testdb`).
3. Verifica los datos en la colección:
   ```bash
   db.customers.find().pretty()
   ```

---