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