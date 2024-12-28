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
1. **Crear el proyecto:**
   - Ve a `File > New > Project`.
   - Selecciona `Maven` y activa la casilla `Create from archetype`.
   - En la lista de arquetipos disponibles, busca y selecciona:
     ```
     org.apache.maven.archetypes:maven-archetype-quickstart
     ```
   - Si no aparece en la lista:
     - Haz clic en `Add Archetype`.
     - Llena los datos:
       - Group ID: `org.apache.maven.archetypes`
       - Artifact ID: `maven-archetype-quickstart`
       - Version: `1.4`
     - Haz clic en `OK`.

2. **Configura los datos del proyecto:**
   - Group ID: `com.tuorganizacion`
   - Artifact ID: `sistema-gestion-tareas`
   - Version: `1.0-SNAPSHOT`.

3. **Finaliza el asistente:**
   - IntelliJ descargará las dependencias y generará la estructura estándar.


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

---

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