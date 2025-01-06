## Algoritmos de Búsqueda Fundamentales

- [Algoritmos de Búsqueda Fundamentales](#algoritmos-de-búsqueda-fundamentales)
- [1. Búsqueda Lineal](#1-búsqueda-lineal)
- [2. Búsqueda Binaria](#2-búsqueda-binaria)
- [3. Algoritmo de Knuth-Morris-Pratt (KMP)](#3-algoritmo-de-knuth-morris-pratt-kmp)
- [4. Algoritmo de Boyer-Moore](#4-algoritmo-de-boyer-moore)
- [5. Índices Invertidos](#5-índices-invertidos)
- [Cuando usar cada uno](#cuando-usar-cada-uno)

--------------------------------------------------------------------------------

Los algoritmos de búsqueda son esenciales para manejar datos de manera eficiente 
en cualquier sistema. Aquí están los más fundamentales, con explicaciones 
concisas y detalles clave:

## 1. Búsqueda Lineal
- **Descripción:** Recorre una lista elemento por elemento y compara cada uno con el objetivo.
- **Complejidad:** O(n) (lineal).
- **Aplicación:** 
  - Útil para listas pequeñas o no ordenadas.
  - Funciona con cualquier tipo de dato.
- **Detalles clave:**
  - Es el algoritmo más básico pero el menos eficiente para listas grandes.
  - Fácil de implementar y entender.

--------------------------------------------------------------------------------

## 2. Búsqueda Binaria
- **Descripción:** Divide repetidamente la lista ordenada en mitades hasta encontrar el 
  elemento o determinar que no está.
- **Complejidad:** O(log n) (logarítmica).
- **Aplicación:** 
  - Exclusivo para listas previamente ordenadas.
  - Muy eficiente para datos numéricos o cadenas con orden predefinido.
- **Detalles clave:**
  - Requiere preprocesamiento (ordenar la lista).
  - No es aplicable a listas dinámicas o no ordenadas.

--------------------------------------------------------------------------------

## 3. Algoritmo de Knuth-Morris-Pratt (KMP)
- **Descripción:** Optimiza la búsqueda de patrones en cadenas utilizando prefijos y 
  sufijos para evitar comparaciones redundantes.
- **Complejidad:** O(n + m), donde `n` es la longitud del texto y `m` la del patrón.
- **Aplicación:** 
  - Ideal para encontrar substrings dentro de cadenas largas.
  - Muy eficiente en comparación con una búsqueda lineal en texto.
- **Detalles clave:**
  - Requiere construir una tabla auxiliar de prefijos (`LPS`) antes de buscar.

--------------------------------------------------------------------------------

## 4. Algoritmo de Boyer-Moore
- **Descripción:** Realiza saltos en el texto al buscar patrones, usando dos reglas clave: 
  la regla del mal carácter y la del sufijo bueno.
- **Complejidad:** O(n/m) en promedio, donde `m` es el tamaño del patrón.
- **Aplicación:** 
  - Más eficiente que KMP para patrones grandes en textos extensos.
- **Detalles clave:**
  - Menos intuitivo que KMP pero más rápido en la mayoría de los casos.

--------------------------------------------------------------------------------

## 5. Índices Invertidos
- **Descripción:** Estructura que asocia palabras clave con los documentos o registros que
  las contienen.
- **Complejidad:** 
  - Construcción: O(n * m), donde `n` es el número de documentos y `m` el promedio de 
    palabras.
  - Búsqueda: O(p + r), donde `p` es el número de palabras buscadas y `r` el número de 
    resultados.
- **Aplicación:** 
  - Motores de búsqueda y bases de datos textuales.
- **Detalles clave:**
  - Muy eficiente para búsquedas repetidas o en grandes volúmenes de texto.
  - Consume más memoria debido a la estructura adicional.

### Explicación del Índice Invertido
1. **Concepto:**
   - Es un **diccionario** que asocia palabras clave con los **objetos** que contienen 
  esas palabras en alguno de sus campos (título, descripción, etc.).

2. **Proceso de construcción:**
   - Recorremos la lista de objetos (en este caso, tareas).
   - Dividimos los textos de cada objeto (título y descripción) en palabras.
   - Para cada palabra, la añadimos como clave al índice y asociamos el objeto que la 
  contiene.

3. **Búsqueda:**
   - Dividimos la consulta en palabras clave.
   - Para cada palabra, consultamos en el índice los objetos relacionados.
   - Combinamos los resultados para devolver los objetos correspondientes.


### **Pseudocódigo Genérico del Índice Invertido**

#### **Construcción del Índice Invertido**
```plaintext
1. Crear un mapa vacío `invertedIndex`
2. Para cada objeto en la lista:
   a. Obtener los campos relevantes para la búsqueda (pueden ser varios).
   b. Combinar los campos relevantes en un solo texto.
   c. Dividir el texto en palabras clave.
   d. Para cada palabra clave:
      - Normalizar la palabra (e.g., convertir a minúsculas).
      - Si la palabra no existe en `invertedIndex`, añadirla con una lista vacía.
      - Agregar el objeto a la lista asociada a la palabra en `invertedIndex`.
```

#### **Búsqueda en el Índice**
```plaintext
1. Dividir el término de búsqueda en palabras clave.
2. Crear un conjunto vacío `resultados` para almacenar los objetos encontrados.
3. Para cada palabra clave en la consulta:
   a. Si la palabra está en `invertedIndex`:
      - Agregar todos los objetos asociados a esa palabra al conjunto `resultados`.
4. Devolver `resultados` como una lista.
```


### **Implementación Genérica en Java**

#### **Método Genérico para Construir el Índice**
```java
public void buildIndex(Function<Task, String> fieldExtractor) {
    invertedIndex.clear();

    for (Task task : taskList) {
        
        String combinedText = fieldExtractor.apply(task);

        String[] words = combinedText.split("\\s+");

        for (String word : words) { 
            word = word.toLowerCase();
            
            invertedIndex.computeIfAbsent(word, k -> new LinkedList<>()).add(task);
        }
    }
}
```

**Detalles clave:**
- **`Function<Task, String>`:** Permite personalizar la combinación de campos 
  relevantes para cada caso, sin limitarse a "título" y "descripción".
- **Uso del índice genérico:** Este enfoque se adapta a cualquier tipo de objeto y 
  conjunto de campos.


#### **Búsqueda Genérica en el Índice**
```java
public List<Task> searchTasks(String query) {
    Set<Task> resultSet = new HashSet<>(); 

    String[] words = query.toLowerCase().split("\\s+");
    for (String word : words) { 
        List<Task> tasks = invertedIndex.get(word);
        if (tasks != null) {
            resultSet.addAll(tasks);
        }
    }

    return new LinkedList<>(resultSet);
}
```

#### **Cómo Usarlo en Diferentes Escenarios**

**Caso 1: Usar Título y Descripción**
```java
manager.buildIndex(task -> task.getTitle() + " " + task.getDescription());
```

**Caso 2: Usar Solo Título**
```java
manager.buildIndex(Task::getTitle);
```

**Caso 3: Usar Campos Personalizados**
Si el objeto tiene campos como "etiquetas" o "categorías":
```java
manager.buildIndex(task -> task.getTags() + " " + task.getCategory());
```

#### **Ventajas del Enfoque Genérico**
1. **Reutilizable:** Puedes adaptarlo a cualquier tipo de objeto o conjunto de campos 
   relevantes para búsqueda.
2. **Escalable:** Permite extender la lógica sin modificar la estructura del índice.
3. **Profesional:** Se basa en conceptos de programación funcional (`Function`) y sigue 
   principios de abstracción y encapsulación.


--------------------------------------------------------------------------------

## Cuando usar cada uno
1. **Búsqueda Lineal:**
   - Siempre debes conocerla como base y para listas pequeñas.
2. **Búsqueda Binaria:**
   - Fundamental para listas ordenadas.
3. **KMP o Boyer-Moore:**
   - Indispensables para procesar texto o encontrar patrones.
4. **Índice Invertido:**
   - Imprescindible en sistemas que manejan grandes volúmenes de texto o búsquedas complejas.

--------------------------------------------------------------------------------