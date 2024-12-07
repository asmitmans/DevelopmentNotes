## Pasos para Desarrollar una API REST con Spring Boot



## 1. Creación del Proyecto
Utiliza Spring Initializr para generar un proyecto base:

1. Accede a [Spring Initializr](https://start.spring.io/).
2. Configura las opciones principales:
   - **Proyecto**: Maven/Gradle.
   - **Lenguaje**: Java.
   - **Versión de Spring Boot**: Escoge la última versión estable.
   - **Dependencias**: Incluye solo las necesarias
     - `Spring Web`: Para crear APIs REST.
     - `Spring Boot DevTools`: Para recargar automáticamente cambios en dev.
3. Descarga el archivo comprimido y extráelo.
4. Importa el proyecto en tu IDE.

**Nota:** Asegúrate de usar una versión de Java compatible con la seleccionada.


## 2. Creación de Paquetes
Organiza el proyecto en paquetes para una estructura limpia y mantenible:

1. Usa el paquete base configurado en el proyecto (por ejemplo, `com.example`).
2. Crea los siguientes paquetes estándar:
   - **`controller`**: Manejo de solicitudes HTTP.
   - **`service`**: Lógica de negocio y procesamiento de datos.
   - **`model`**: Clases para entidades o modelos de datos.
3. Opcionalmente, agrega otros paquetes según necesidades futuras:
   - **`repository`**: Interacción con bases de datos.
   - **`config`**: Configuraciones específicas.
   - **`exception`**: Manejo de excepciones.

**Nota:** Usa nombres claros y evita paquetes genéricos sin propósito claro.


## 3. Desarrollo de Clases del Modelo
Define las clases que representan los datos clave de la API:

1. Crea clases en el paquete **`model`**.
2. Usa nombres descriptivos y en inglés para cada clase. Por ejemplo:
   - **`User`**: Representa un usuario del sistema.
   - **`Product`**: Representa un producto disponible.
   - **`Order`**: Representa una solicitud o pedido.
3. Define los atributos principales de cada clase según el contexto del ejercicio.
   - Usa tipos de datos apropiados (`String`, `int`, `LocalDate`, etc.).
   - Ejemplo para `User`:
     - `id`: Identificador único (`Long` o `UUID`).
     - `name`: Nombre del usuario (`String`).
     - `email`: Correo electrónico (`String`).
4. Agrega constructores, getters y setters si es necesario.

**Nota:** En esta etapa, no necesitas incluir anotaciones como `@Entity` si no estás 
usando una base de datos. Usa únicamente atributos y métodos básicos.


## 4. Desarrollo de la Capa Service
La capa `service` maneja la lógica de negocio y las operaciones sobre los datos.

### Recomendaciones:
1. **Definir una interfaz**:
   - La interfaz especifica los métodos principales del servicio, incluyendo:
     - Qué devuelve cada método.
     - Su nombre y parámetros.
   - Ejemplo de métodos genéricos:
     - `List<Entity> findAll()`: Retorna todos los registros.
     - `Entity findById(int id)`: Busca un registro por ID.
     - `Entity create(Entity entity)`: Crea un nuevo registro.
     - `Entity update(int id, Entity entity)`: Actualiza un registro existente.
     - `void delete(int id)`: Elimina un registro por ID.

2. **Crear una clase implementadora**:
   - Usa el sufijo `Impl` para indicar que implementa la interfaz correspondiente.
   - Implementa los métodos definidos en la interfaz.

3. **Registrar la clase con `@Service`**:
   - Añade la anotación `@Service` para que Spring gestione esta clase.
   - Esto permite la inyección de dependencias en otras capas del proyecto.

4. **Simular datos o manejar repositorios**:
   - Si estás simulando datos, utiliza una lista en memoria (`ArrayList`):
     - Crea y pobla la lista con datos iniciales en el constructor o en un método
       específico de inicialización.
   - En un proyecto real, inyecta un repositorio como `JpaRepository` para 
     manejar datos desde una base de datos.

### Notas adicionales:
- Define nombres claros y específicos tanto para la interfaz como para la 
  implementadora. Ejemplo:
  - Interfaz: `EntityService` (como `ClientService`).
  - Implementadora: `EntityServiceImpl` (como `ClientServiceImpl`).
- Mantén la implementación encapsulada, sin exponer detalles de la lógica interna 
  al resto del proyecto.


## 5. Desarrollo de la Capa Controlador

### Definición
La capa de controladores (`controller`) es responsable de manejar las 
solicitudes HTTP y delegar la lógica de negocio al servicio correspondiente. 
Es el punto de entrada para las operaciones de la API REST.

---

### Recomendaciones

1. **Organización de Controladores:**
   - Ubica los controladores en el paquete `controller`.
   - Usa nombres descriptivos como `EntityController` (por ejemplo, 
     `ClientController`).

2. **Anotaciones Principales:**
   - `@RestController`: Declara la clase como un controlador REST.
   - `@RequestMapping("/path")`: Define el prefijo común para todas las 
     rutas del controlador.

3. **Definición de Métodos:**
   - Define métodos para cada operación CRUD.
   - Usa las siguientes anotaciones según el método HTTP:
     - `@GetMapping`: Para solicitudes GET.
     - `@PostMapping`: Para solicitudes POST.
     - `@PutMapping`: Para solicitudes PUT.
     - `@DeleteMapping`: Para solicitudes DELETE.

4. **Delegación al Servicio:**
   - Inyecta el servicio correspondiente usando un constructor o 
     `@Autowired`.
   - Llama a los métodos del servicio desde los métodos del controlador.

5. **Formato de Respuesta:**
   - Opcional: Usa `ResponseEntity<T>` para tener control sobre el 
     estado HTTP y la estructura de la respuesta.
   - Por simplicidad, puedes devolver directamente los datos en 
     proyectos pequeños.

### Notas Finales

1. Mantén los controladores simples y enfocados en manejar solicitudes HTTP. 
   La lógica de negocio debe estar en la capa service.

2. Opcional: Usa `ResponseEntity<T>` para mayor control y personalización de las 
   respuestas HTTP.
3. Delega el manejo de excepciones al controlador global 
   (`@RestControllerAdvice`).

---

## Resumen: Desarrollo de una API REST en Spring Boot

### Temas cubiertos
Hemos desarrollado una guía esencial para construir una API REST en Spring 
Boot, abordando los conceptos y pasos fundamentales:

1. **Creación del Proyecto:**
   - Uso de Spring Initializr para generar un proyecto base con dependencias 
     mínimas necesarias como `Spring Web` y `Spring Boot DevTools`.

2. **Estructuración del Proyecto:**
   - Organización en paquetes estándar:
     - `controller`: Manejo de solicitudes HTTP.
     - `service`: Lógica de negocio.
     - `model`: Representación de datos clave.
     - `exception`: Manejo de errores.
   - Notas sobre el uso de nombres claros y convenciones recomendadas.

3. **Capa de Modelo:**
   - Definición de clases que representan las entidades principales, con:
     - Atributos clave (como `id`, `name`, etc.).
     - Constructores, getters y setters.
   - Enfoque en simplicidad (sin anotaciones como `@Entity` en simulaciones).

4. **Capa de Servicio:**
   - Uso de interfaces para definir métodos.
   - Implementación de lógica de negocio con una clase `Impl` anotada con 
     `@Service`.
   - Simulación de datos con listas en memoria (`ArrayList`).
   - Incorporación de excepciones personalizadas en la lógica.

5. **Capa de Controlador:**
   - Implementación de controladores REST usando `@RestController`.
   - Definición de endpoints con anotaciones como `@GetMapping`, `@PostMapping`, 
     `@PutMapping`, y `@DeleteMapping`.
   - Opcional: Uso de `ResponseEntity` para control detallado sobre las 
     respuestas.

6. **Manejo de Excepciones:**
   - Creación de excepciones personalizadas (`RuntimeException`).
   - Centralización del manejo de errores con `@RestControllerAdvice` para 
     generar respuestas uniformes y claras.
   - Uso de un modelo como `ApiError` para estructurar las respuestas de error.

---

### Temas por cubrir en proyectos avanzados
En proyectos más avanzados o reales, podrías considerar los siguientes 
aspectos adicionales:

1. **Persistencia de Datos:**
   - Uso de `Spring Data JPA` para interactuar con bases de datos relacionales.
   - Configuración de entidades con anotaciones como `@Entity` y relaciones 
     (`@OneToMany`, `@ManyToOne`).

2. **Autenticación y Autorización:**
   - Implementación de seguridad con **Spring Security**.
   - Uso de JWT (JSON Web Tokens) o autenticación basada en sesiones.

3. **Validación de Datos:**
   - Validación de datos de entrada en las solicitudes HTTP usando 
     anotaciones como `@NotNull`, `@Email`, etc.
   - Uso de `@Valid` en los controladores para validar objetos automáticamente.

4. **Pruebas:**
   - Escribir pruebas unitarias para servicios con **JUnit** y **Mockito**.
   - Realizar pruebas de integración para controladores con 
     **Spring Boot Test**.

5. **Documentación de la API:**
   - Generación automática de documentación con Swagger/OpenAPI para 
     describir los endpoints y sus parámetros.

6. **Despliegue:**
   - Empaquetar la aplicación como un archivo `.jar` o `Docker image`.
   - Desplegar en plataformas como AWS, Render, o Heroku.

---
