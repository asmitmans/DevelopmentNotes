# Java

- [Java](#java)
  - [Excepción división por cero](#excepción-división-por-cero)
  - [Definir un método como `final`](#definir-un-método-como-final)
  - [Listas sin tipos](#listas-sin-tipos)
  - [Uso de `<T extends Number>`](#uso-de-t-extends-number)
  - [Acceso a atributo heredado de superclase](#acceso-a-atributo-heredado-de-superclase)
  - [Porque crear un proyecto Java usando Maven](#porque-crear-un-proyecto-java-usando-maven)
  - [Acceso a atributo heredado de superclase](#acceso-a-atributo-heredado-de-superclase-1)
  - [Porque es recomendable usar Maven para un proyecto](#porque-es-recomendable-usar-maven-para-un-proyecto)
  - [**Crear un proyecto Maven con el arquetipo Quickstart**](#crear-un-proyecto-maven-con-el-arquetipo-quickstart)
  - [ArrayList vs LinkedList](#arraylist-vs-linkedlist)
  - [Diferencias entre `forEach`, `for-each loop` y `Streams`](#diferencias-entre-foreach-for-each-loop-y-streams)
  - [**Programación Funcional en Java: Lambdas y Referencias a Métodos**](#programación-funcional-en-java-lambdas-y-referencias-a-métodos)
  - [Buenas Prácticas para Menús e Ingreso de Datos en Terminal](#buenas-prácticas-para-menús-e-ingreso-de-datos-en-terminal)

---

## Excepción división por cero
En Java, la excepción que se lanza cuando se intenta realizar una
división por cero es la `ArithmeticException`.

Por ejemplo, si intentas dividir un número entero por cero, Java
lanzará esta excepción:

```java
int result = 10 / 0;  // Esto lanzará ArithmeticException
```
El mensaje de la excepción típicamente será:

```console
Exception in thread "main" java.lang.ArithmeticException: / by zero
```

Esta excepción pertenece al paquete java.lang, por lo que no necesitas
importar ninguna clase adicional para manejarla.

----------------------------------------------------------------------

## Definir un método como `final`
En Java puedes definir un método como `final`. Cuando un método se declara como
`final`, significa que no puede ser sobrescrito (override) por ninguna subclase.
Esto es útil cuando quieres asegurarte de que el comportamiento de un método específico no se modifique en las clases derivadas.

Ejemplo:

```java
class ClaseBase {
    public final void metodoFinal() {
        System.out.println("Este método no puede ser sobrescrito.");
    }
}


class ClaseDerivada extends ClaseBase {
    // Esto causará un error de compilación porque el método es final en la clase base
    // public void metodoFinal() {
    //     System.out.println("Intentando sobrescribir el método final.");
    // }
}
```

En este ejemplo, el método `metodoFinal` está marcado como `final` en
`ClaseBase`, por lo que `ClaseDerivada` no puede sobrescribirlo. Si
intentas sobrescribirlo en la clase derivada, obtendrás un error de
compilación.

El uso de `final` en métodos es una forma de asegurar que el
comportamiento específico definido en la clase base se mantenga
intacto en todas las subclases.

----------------------------------------------------------------------

## Listas sin tipos

### Sin tipos genericos
```java
public void printList(List lista) {
    for (Object elem : lista) {
        System.out.println(elem);
    }
}
```
* Acepta cualquier lista, sin importar el tipo de sus elementos. Puedes agregar
  elementos de diferentes tipos en la misma lista.
* Pierde seguridad de tipos en tiempo de compilación, lo que puede causar
  errores en tiempo de ejecución si intentas realizar operaciones específicas en
  los elementos. Además, puede requerir conversiones (casting) para trabajar con
  tipos específicos.

### Con tipos generivos 
```java
public <T> void printList(List<T> lista) {
    for (T elem : lista) {
        System.out.println(elem);
    }
}
```
* Acepta listas de un tipo específico y mantiene la seguridad de tipos en tiempo
  de compilación. Evita la necesidad de conversiones explícitas y reduce el
  riesgo de errores.
* Garantiza que todos los elementos de la lista sean del mismo tipo, lo que
  facilita el manejo y evita errores en tiempo de ejecución.

--------------------------------------------------------------------------------

## Uso de `<T extends Number>`
Cuando en un método Java se utiliza la sintaxis **`<T extends Number>`**, se está
definiendo un **tipo genérico `T`** que está limitado a **subclases de la clase
`Number`**. Esto significa que el método solo puede aceptar tipos que sean 
subclases de **`Number`**, como **`Integer, Double, Float,`** etc.

Por ejemplo:

```java
public <T extends Number> void myMethod(T number) {
    // Aquí se pueden usar métodos de la clase Number
}
```
En este caso, **`myMethod`** puede recibir cualquier objeto que sea una instancia
de una clase que extienda **`Number`**, pero no otros tipos de objetos. Esto se
utiliza para restringir los tipos que un método genérico puede aceptar,
asegurando que solo se usen tipos compatibles.

--------------------------------------------------------------------------------

## Acceso a atributo heredado de superclase
En Java se puede acceder a un atributo heredado de una superclase desde una
subclase usando **`this.`**. siempre que el atributo no esté declarado como
**`private`**. Si el atributo es **`protected`**, **`public`**, o tiene acceso 
por defecto (si están en el mismo paquete), puedes acceder a él directamente con
**`this.`**.

Por ejemplo:

```java
class SuperClase {
    protected int atributo;
}

class SubClase extends SuperClase {
    public void metodo() {
        this.atributo = 10; // Acceso al atributo de la superclase
    }
}
```
Aquí, **`this.atributo`** en **`SubClase`** se refiere al atributo **`atributo`**
que es heredado de **`SuperClase`**.

--------------------------------------------------------------------------------

## Porque crear un proyecto Java usando Maven

Usar Maven es altamente recomendable porque:

* **Facilita la gestión de dependencias**, como JUnit.
* Permite **estructurar el proyecto de forma estándar**, facilitando su portabilidad.
* Simplifica la compilación y ejecución del proyecto, especialmente en equipos o 
  IDEs distintos.

Además, el proyecto podrá abrirse tanto en IntelliJ IDEA como en Eclipse sin 
problemas, ya que ambos soportan proyectos Maven.

--------------------------------------------------------------------------------

## Acceso a atributo heredado de superclase
En Java se puede acceder a un atributo heredado de una superclase desde una
subclase usando **`this.`**. siempre que el atributo no esté declarado como
**`private`**. Si el atributo es **`protected`**, **`public`**, o tiene acceso 
por defecto (si están en el mismo paquete), puedes acceder a él directamente con
**`this.`**.

Por ejemplo:

```java
class SuperClase {
    protected int atributo;
}

class SubClase extends SuperClase {
    public void metodo() {
        this.atributo = 10; // Acceso al atributo de la superclase
    }
}
```
Aquí, **`this.atributo`** en **`SubClase`** se refiere al atributo **`atributo`**
que es heredado de **`SuperClase`**.

--------------------------------------------------------------------------------

## Porque es recomendable usar Maven para un proyecto
Usar Maven es altamente recomendable porque:
- **Facilita la gestión de dependencias**, como JUnit.
- Permite **estructurar el proyecto de forma estándar**, facilitando su portabilidad.
- Simplifica la compilación y ejecución del proyecto, especialmente en equipos o 
  IDEs distintos.

Además, el proyecto podrá abrirse tanto en IntelliJ IDEA como en Eclipse sin 
problemas, ya que ambos soportan proyectos Maven.

--------------------------------------------------------------------------------

## **Crear un proyecto Maven con el arquetipo Quickstart**

### **¿Qué es un arquetipo en Maven?**
Un arquetipo es una plantilla predefinida para proyectos Maven que incluye una 
estructura básica de archivos y configuraciones. 
El arquetipo **"maven-archetype-quickstart"** es ideal para proyectos simples y 
educativos.

### Para IntelliJ IDEA (Community Edition)
1. **Abrir el asistente para nuevos proyectos:**
   - Ve a `File > New > Project`.
   - En el menú de la izquierda, selecciona `Maven Archetype`.

2. **Configurar el proyecto:**
   - **Name:** Escribe el nombre del proyecto (por ejemplo, `sistema-gestion-tareas`).
   - **Location:** Selecciona el directorio donde deseas guardar el proyecto.
   - **JDK:** Elige la versión adecuada (por ejemplo, OpenJDK 17 o superior).

3. **Seleccionar el arquetipo:**
   - En el campo **Archetype**, escribe directamente `quickstart`.
   - Selecciona:
     ```
     org.apache.maven.archetypes:maven-archetype-quickstart
     ```
   - Elige la versión disponible (en tu caso, `1.1`).

4. **Completar los datos del proyecto:**
   - Rellena los campos:
     - **Group ID:** `com.tuorganizacion`
     - **Artifact ID:** `sistema-gestion-tareas`
     - **Version:** `1.0-SNAPSHOT` (dejar esta versión estándar).

5. **Finalizar el asistente:**
   - Haz clic en **Create**.
   - IntelliJ generará automáticamente el proyecto con la estructura estándar y 
     descargará las dependencias necesarias.


### **Para Eclipse**
1. **Crear el proyecto:**
   - Ve a `File > New > Maven Project`.
   - Asegúrate de marcar **"Create a simple project"** si quieres una lista de arquetipos.
   - Haz clic en `Next`.

2. **Selecciona el arquetipo:**
   - En la lista, selecciona:
     ```
     org.apache.maven.archetypes:maven-archetype-quickstart
     ```
   - Si no está, haz clic en `Add Archetype` y proporciona:
     - Group ID: `org.apache.maven.archetypes`
     - Artifact ID: `maven-archetype-quickstart`
     - Version: `1.4`.
   - Haz clic en `Next`.

3. **Configura los datos del proyecto:**
   - Group ID: `com.tuorganizacion`
   - Artifact ID: `sistema-gestion-tareas`
   - Version: `1.0-SNAPSHOT`.

4. **Finaliza el asistente:**
   - Eclipse generará la estructura estándar y descargará las dependencias.


### **Estructura generada por el arquetipo Quickstart**
La estructura será:
```
sistema-gestion-tareas/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/tuorganizacion/App.java
│   └── test/
│       └── java/
│           └── com/tuorganizacion/AppTest.java
├── pom.xml
```

- **App.java**: Contendrá un método `main()` para iniciar el proyecto.
- **AppTest.java**: Ejemplo básico de prueba con JUnit.

---

### **Ventajas del arquetipo Quickstart**
1. **Plantilla lista para empezar**: Incluye las estructuras y dependencias necesarias.
2. **Prueba inicial con JUnit incluida**: Proporciona un test básico para validar la configuración.
3. **Compatible con IntelliJ y Eclipse**: Puedes compartir el proyecto sin problemas entre ambos IDEs.

--------------------------------------------------------------------------------

## ArrayList vs LinkedList

### **Características Generales**
| Aspecto                  | **ArrayList**                              | **LinkedList**                             |
|--------------------------|--------------------------------------------|-------------------------------------------|
| **Estructura Interna**   | Array dinámico                             | Nodos enlazados (doblemente enlazados)    |
| **Acceso Aleatorio**     | Muy eficiente (O(1))                       | Lento (O(n)), requiere recorrer la lista  |
| **Inserción/Eliminación**| Lenta al modificar elementos internos (O(n))| Rápida en posiciones arbitrarias (O(1))   |
| **Uso de Memoria**       | Menor (solo datos)                         | Mayor (almacena referencias adicionales)  |
| **Iteración**            | Más rápida debido a la contigüidad en memoria | Más lenta por el acceso indirecto        |


### **Casos de Uso Recomendados**
1. **Usar `ArrayList` cuando:**
   - Se requiere **acceso rápido a elementos por índice**.
   - La lista tiene operaciones de **lectura frecuente** y pocas modificaciones.
   - No hay necesidad de insertar o eliminar elementos en posiciones arbitrarias con frecuencia.

2. **Usar `LinkedList` cuando:**
   - La lista tiene **mucha inserción/eliminación en posiciones arbitrarias**.
   - El tamaño de la lista cambia constantemente y no se conoce de antemano.
   - No es necesario acceder frecuentemente a elementos por índice.


### Estado Actual
- En la mayoría de las aplicaciones modernas, **`ArrayList` es preferido** porque:
  - Es más rápido para iteraciones y acceso aleatorio, que son comunes en los sistemas actuales.
  - Las operaciones de inserción/eliminación en el medio de la lista son menos frecuentes.

- **`LinkedList` tiene usos específicos**:
  - Cuando las inserciones/eliminaciones arbitrarias son prioritarias.
  - En escenarios donde el costo de realinear elementos en un array sería muy alto.

### **Notas Finales**
1. **Rendimiento:** En términos generales, `ArrayList` es más eficiente para la 
   mayoría de los casos comunes, como colecciones grandes que se iteran o buscan 
   frecuentemente.
2. **Prácticas Profesionales:** Evalúa el patrón de uso antes de decidir. Si 
   dudas, comienza con `ArrayList` y optimiza después según las necesidades del 
   rendimiento.

--------------------------------------------------------------------------------

## Diferencias entre `forEach`, `for-each loop` y `Streams`

### **A) `for-each loop` (bucle clásico):**
```java
for (Task task : taskList) {
    if (task.getId() == id) {
        return task;
    }
}
```

- **Ventajas:**
  - Muy sencillo y directo.
  - Compatible con todas las versiones de Java.
  - Menor consumo de memoria que un `Stream` porque no crea un flujo intermedio.

- **Desventajas:**
  - Menos expresivo y funcional que las operaciones de `Stream`.
  - No tiene la fluidez de los métodos encadenados.


### **B) `stream`:**
```java
return taskList.stream()
               .filter(task -> task.getId() == id)
               .findFirst()
               .orElse(null);
```

- **Ventajas:**
  - Expresivo, conciso y funcional.
  - Encadenamiento fluido para combinar múltiples operaciones (como `filter`, `map`, etc.).
  - Puedes paralelizar con `parallelStream()` en caso de operaciones costosas (aunque no muy útil para `LinkedList`).

- **Desventajas:**
  - Puede ser menos eficiente que un bucle clásico en estructuras como `LinkedList`, ya que `Stream` no está optimizado para acceso secuencial.
  - Consume más memoria debido a la creación de un flujo intermedio.


### **C) `forEach` (método de la interfaz `Iterable`):**
```java
taskList.forEach(task -> {
    if (task.getId() == id) {
        // Lógica
    }
});
```

- **Ventajas:**
  - Similar al `for-each loop`, pero utiliza lambdas para mayor expresividad.
  - Ideal para operaciones simples como imprimir elementos.

- **Desventajas:**
  - No devuelve resultados directamente, por lo que no es tan útil para operaciones que necesitan devolver un valor (como encontrar un `Task` por ID).
  - Menos fluido que `Stream`.


### ¿Cuál es más recomendado?
La elección depende del caso de uso:

| **Escenario**                            | **Recomendación**                            |
|------------------------------------------|----------------------------------------------|
| Necesitas **simplicidad**                | Usa el `for-each loop`.                      |
| Necesitas **fluidez y funcionalidad**    | Usa `stream` (para filtrar, mapear, etc.).   |
| Solo iteras **sin devolver resultados**  | Usa el método `forEach`.                     |
| **Desempeño crítico** con `LinkedList`   | Usa el `for-each loop` (más eficiente).      |


### ¿Para `LinkedList`, cuál sería la mejor opción?
Aunque `Stream` es más moderno y expresivo, en el caso de una `LinkedList`, donde 
el acceso secuencial es la norma, **el bucle clásico `for-each loop` es más 
eficiente**, ya que evita la sobrecarga de crear flujos intermedios.

Si priorizas la **legibilidad y expresividad**, `Stream` es excelente.

--------------------------------------------------------------------------------

## **Programación Funcional en Java: Lambdas y Referencias a Métodos**

Con la llegada de **Java 8**, se introdujo el soporte para **programación funcional**, 
permitiendo trabajar con **lambdas** y pasar funciones como parámetros. Esta 
característica moderniza el lenguaje, haciéndolo más flexible y conciso, especialmente 
para el procesamiento de datos.

### **Conceptos Clave**

#### **1. Expresiones Lambda**
- **Definición:** Una lambda es una forma concisa de implementar interfaces funcionales 
  (interfaces con un único método abstracto).
- **Sintaxis:**
  ```java
  (argumentos) -> { cuerpo };
  ```

#### **2. Interfaces Funcionales**
- **Definición:** Una interfaz funcional es aquella que tiene exactamente **un método abstracto**.
- **Ejemplos comunes (en `java.util.function`):**
  - `Function<T, R>`: Toma un argumento (`T`) y devuelve un resultado (`R`).
  - `Consumer<T>`: Toma un argumento (`T`) y no devuelve nada.
  - `Supplier<T>`: No toma argumentos, pero devuelve un resultado (`T`).
  - `Predicate<T>`: Evalúa una condición sobre un argumento (`T`) y devuelve un booleano.

#### **3. Referencias a Métodos**
- **Definición:** Una referencia a método es una forma de reutilizar métodos existentes 
  como lambdas.
- **Sintaxis:**
  ```java
  ClassName::methodName
  ```

### **Ejemplo de Uso**

#### **A) Uso de Lambdas con `Function`:**
```java
import java.util.function.Function;

Function<String, Integer> stringLength = s -> s.length();
System.out.println(stringLength.apply("Hola")); // Salida: 4
```

#### **B) Referencias a Métodos:**
```java
Function<String, Integer> stringLength = String::length;
System.out.println(stringLength.apply("Hola")); // Salida: 4
```

#### **C) Streams y Programación Funcional:**
```java
List<String> nombres = Arrays.asList("Juan", "Ana", "Luis");
nombres.stream()
       .map(String::toUpperCase) // Convierte cada nombre a mayúsculas
       .forEach(System.out::println);
```


### **Ventajas**

1. **Concisión:** Reduce el código boilerplate al evitar clases anónimas para implementar 
   interfaces.
2. **Reutilización:** Permite pasar comportamientos genéricos a métodos.
3. **Flexibilidad:** Facilita operaciones como map, filter y reduce en Streams.


### **Ejemplo en un Método Genérico**
Un método genérico que procesa objetos con lambdas:
```java
import java.util.function.Function;
import java.util.List;

public static <T, R> void processList(List<T> list, Function<T, R> function) {
    for (T item : list) {
        System.out.println(function.apply(item));
    }
}

// Uso:
List<String> nombres = Arrays.asList("Juan", "Ana", "Luis");
processList(nombres, String::toUpperCase); // Salida: JUAN, ANA, LUIS
```

### **Conclusión**
La programación funcional en Java, basada en **lambdas**, **interfaces funcionales**, y 
**referencias a métodos**, permite escribir código más limpio, reutilizable y moderno. 
Su adopción es crucial para trabajar con APIs como **Streams** y mejorar la eficiencia 
en el desarrollo.

--------------------------------------------------------------------------------

## Buenas Prácticas para Menús e Ingreso de Datos en Terminal

1. **Estructura del Menú**
   - Los menús deben ser claros, simples y numerados.
   - Usa títulos y divisores para separar secciones.
   - Ofrece una opción de salida (`Salir` o `Volver al menú anterior`).
   - Muestra mensajes de error claros si el usuario ingresa una opción inválida.

   **Ejemplo básico**:
   ```
   === Menú Principal ===
   1. Crear usuario
   2. Ver reporte
   3. Salir
   Seleccione una opción: _
   ```

2. **Validación de Entrada**
   - Verifica que las entradas sean válidas (números dentro del rango de opciones).
   - Maneja excepciones (como `NumberFormatException` para entradas no numéricas).

3. **Bucles para la Navegación**
   - Usa bucles `while` para mantener al usuario dentro del menú hasta que seleccione salir.

4. **Separación de Responsabilidades**
   - Divide el código en métodos para cada opción del menú.
   - Ejemplo:
     - Método `showMenu()`: Imprime el menú.
     - Método `handleOption(int option)`: Procesa la opción seleccionada.

5. **Estilización**
   - Usa líneas o símbolos (`===`, `---`) para mejorar la legibilidad.
   - Agrega mensajes como `Presione ENTER para continuar` para pausar entre acciones.


### Librerías Opcionales
Si bien no necesitas gráficos avanzados, podrías usar estas librerías para 
facilitar el diseño del menú o mejorar su aspecto:

1. **[JLine](https://github.com/jline/jline3)**
   - Proporciona entrada/salida avanzada para terminales.
   - Permite agregar autocompletado o navegación en menús.

2. **[Lanterna](https://github.com/mabe02/lanterna)**
   - Permite crear interfaces de usuario de texto más organizadas con ventanas y menús.
   - Es opcional si deseas menús más avanzados.


### Ejemplo Básico: Menú con Validación

Aquí tienes un ejemplo de cómo implementar un menú simple y profesional en Java:

```java
import java.util.Scanner;

public class MenuApp {

    public static void main(String[] args) {
        MenuApp app = new MenuApp();
        app.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int option = -1;

        while (option != 3) {
            showMenu();
            System.out.print("Seleccione una opción: ");
            try {
                option = Integer.parseInt(scanner.nextLine());
                handleOption(option);
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
            }
        }

        System.out.println("Gracias por usar la aplicación. ¡Adiós!");
    }

    private void showMenu() {
        System.out.println("\n=== Menú Principal ===");
        System.out.println("1. Crear usuario");
        System.out.println("2. Ver reporte");
        System.out.println("3. Salir");
    }

    private void handleOption(int option) {
        switch (option) {
            case 1:
                createUser();
                break;
            case 2:
                viewReport();
                break;
            case 3:
                break; // Salir del menú
            default:
                System.out.println("Error: Opción no válida.");
        }
    }

    private void createUser() {
        System.out.println("\n[Crear Usuario]");
        System.out.print("Ingrese el nombre del usuario: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Usuario '" + name + "' creado exitosamente.");
    }

    private void viewReport() {
        System.out.println("\n[Ver Reporte]");
        System.out.println("Reporte aún no implementado.");
    }
}
```


### Buenas Prácticas en el Código
1. **Separación por Clases**:
   - Si el programa crece, divide el menú y las funcionalidades en clases:
     - Clase `MenuApp`: Controla el menú.
     - Clase `UserManager`: Gestiona usuarios.
     - Clase `ReportManager`: Maneja reportes.

2. **Mensajes Claros**:
   - Incluye confirmaciones después de cada acción (por ejemplo: `Usuario creado exitosamente`).
   - Usa colores con librerías como `JAnsi` para destacar errores o confirmaciones.

3. **Extensibilidad**:
   - Diseña el menú para que sea fácil añadir nuevas opciones sin alterar la lógica principal.

4. **Control de Excepciones**:
   - Maneja entradas inválidas sin que el programa se detenga.
   - Usa excepciones personalizadas si es necesario.

--------------------------------------------------------------------------------

