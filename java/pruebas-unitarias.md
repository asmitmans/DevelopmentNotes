## Pruebas Unitarias en Java

- [Pruebas Unitarias en Java](#pruebas-unitarias-en-java)
- [¿Qué son las pruebas unitarias?](#qué-son-las-pruebas-unitarias)
- [Elementos Clave de una Prueba Unitaria](#elementos-clave-de-una-prueba-unitaria)
- [Buenas Prácticas](#buenas-prácticas)
- [Implementación en un Proyecto Java Maven](#implementación-en-un-proyecto-java-maven)
- [Anotaciones Relevantes de JUnit 5](#anotaciones-relevantes-de-junit-5)
- [Notas Relevantes](#notas-relevantes)
- [Razonamiento detrás de los casos a probar](#razonamiento-detrás-de-los-casos-a-probar)

---

## ¿Qué son las pruebas unitarias?
Las pruebas unitarias son un tipo de prueba de software donde se verifica de 
manera aislada el funcionamiento de las unidades individuales del código, 
generalmente métodos o funciones. Su objetivo principal es asegurar que cada 
componente funcione correctamente por separado.

### ¿Para qué sirven?
1. **Detección temprana de errores:** Identifican problemas en el código antes de 
   integrarlo en el sistema.
2. **Refactorización segura:** Permiten realizar cambios al código con la confianza 
   de que las funcionalidades principales siguen funcionando.
3. **Documentación del comportamiento:** Actúan como documentación viva al mostrar 
   cómo se espera que funcionen los métodos.
4. **Facilitan el mantenimiento:** Ayudan a identificar rápidamente las causas de 
   errores futuros.

### ¿Cómo se implementan?
Las pruebas unitarias se escriben utilizando bibliotecas específicas como **JUnit** 
(para Java). Un método de prueba:
- Define un caso de prueba con datos de entrada y un resultado esperado.
- Ejecuta el método a probar.
- Compara el resultado real con el esperado.

---

## Elementos Clave de una Prueba Unitaria
1. **Framework de pruebas:** 
   - En Java, el más común es **JUnit** (actualmente JUnit 5, conocido como Jupiter).
2. **Clases de prueba:**
   - Contienen los métodos de prueba y se suelen nombrar con el sufijo `Test` 
  (e.g., `TaskManagerTest`).
3. **Asserts:**
   - Validan si el resultado real coincide con el esperado. Ejemplo:
     ```java
     Assertions.assertEquals(expected, actual);
     ```
4. **Mocks:** 
   - Simulan dependencias externas para probar métodos en aislamiento (opcional 
  en casos simples).

---

## Buenas Prácticas
1. **Un método de prueba por caso:** Cada método debe probar un escenario específico.
2. **Nombres descriptivos:** Usa nombres que indiquen claramente lo que está probando, 
   como `shouldAddTaskSuccessfully`.
3. **Independencia:** Las pruebas no deben depender unas de otras.
4. **Cobertura suficiente:** Asegúrate de probar todos los caminos posibles (inputs 
   válidos, inválidos, bordes).
5. **Revisar límites:** Por ejemplo, listas vacías, valores nulos o tamaños extremos.

---

## Implementación en un Proyecto Java Maven

1. **Configurar el entorno de pruebas:**
   Maven incluye soporte para JUnit en su estructura predeterminada. Los 
   archivos de prueba deben colocarse en:
   ```
   src/test/java
   ```
2. **Añadir dependencias:**
   En el archivo `pom.xml`, incluye la dependencia de JUnit:
   ```xml
   <dependencies>
       <dependency>
           <groupId>org.junit.jupiter</groupId>
           <artifactId>junit-jupiter</artifactId>
           <version>5.10.0</version>
           <scope>test</scope>
       </dependency>
   </dependencies>
   ```

3. **Eliminar clases de prueba generadas automáticamente:**
   Si el proyecto genera una clase como `AppTest` al crearse, elimínala o 
   refactórala según tus necesidades, ya que suele ser un ejemplo genérico.

4. **Estructura de una clase de prueba:**
   ```java
   import org.junit.jupiter.api.*;

   import static org.junit.jupiter.api.Assertions.*;

   public class TaskManagerTest {

       private TaskManager taskManager;

       @BeforeEach
       void setUp() {
           taskManager = new TaskManager(); // Inicialización
       }

       @Test
       void shouldAddTaskSuccessfully() {
           taskManager.addTask("Title", "Description", Priority.ALTA, State.PENDIENTE);
           assertEquals(1, taskManager.listTasks().size());
       }

       @Test
       void shouldNotFindNonexistentTask() {
           assertNull(taskManager.findById(999));
       }
   }
   ```

5. **Ejecutar las pruebas:**
   Ejecuta los tests usando Maven desde la línea de comandos:
   ```bash
   mvn test
   ```
   Esto buscará todas las pruebas en `src/test/java` y mostrará los resultados.

6. **Analizar resultados:**
   Maven muestra cuántas pruebas pasaron y cuántas fallaron. Si alguna falla, 
   revisa los mensajes y ajusta el código o los datos de prueba según sea 
   necesario.

--- 

## Anotaciones Relevantes de JUnit 5

- **`@BeforeEach`:** Ejecuta un método antes de cada prueba para inicializar un 
  estado limpio.  
- **`@AfterEach`:** Ejecuta un método después de cada prueba para liberar recursos 
  utilizados.  
- **`@BeforeAll`:** Ejecuta un método una vez antes de todas las pruebas para 
  configuraciones globales iniciales.  
- **`@AfterAll`:** Ejecuta un método una vez después de todas las pruebas para 
  limpiar configuraciones globales.

---

## Notas Relevantes
1. **Cobertura de pruebas:**
   Usa herramientas como **JaCoCo** para analizar qué porcentaje del código está 
   siendo probado.

2. **Integración continua:**
   Las pruebas unitarias pueden integrarse en pipelines de CI/CD para asegurar 
   calidad en cada commit.

3. **Evitar pruebas demasiado detalladas:**
   No pruebes funcionalidades de bibliotecas externas, como los métodos de 
   listas (e.g., `add` o `remove`), ya que eso es innecesario.

---

## Razonamiento detrás de los casos a probar

1. **Cubrir los casos positivos y negativos:** Garantiza que el código funcione tanto 
   en escenarios ideales como cuando recibe entradas no válidas.
2. **Casos límite:** Ayudan a validar que el sistema maneja correctamente entradas 
   extremas o inusuales, como valores nulos, listas vacías o IDs inexistentes.
3. **Comprobaciones específicas de los métodos:**
   - Métodos como `addTask` deben verificar que los datos se almacenen 
  correctamente.
   - Métodos como `editTask` y `deleteTask` requieren pruebas adicionales para 
  garantizar que las operaciones no afecten otras tareas.

---