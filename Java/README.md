# Java


- [Excepción división por cero](#excepción-división-por-cero)
- [Definir un método como `final`](#definir-un-método-como-final)
- [Listas sin tipos](#listas-sin-tipos)


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

----------------------------------------------------------------------