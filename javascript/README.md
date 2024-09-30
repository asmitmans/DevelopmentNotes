## Javascript

- [Javascript](#javascript)
- [¿Qué es JavaScript?](#qué-es-javascript)
- [Agregando JavaScript (JS)](#agregando-javascript-js)
- [`console.log`](#consolelog)
- [Declaraciones y Sintaxis en JavaScript](#declaraciones-y-sintaxis-en-javascript)
- [Operadores](#operadores)
- [Expresiones](#expresiones)
- [Palabras Claves](#palabras-claves)
- [Comentarios](#comentarios)


## ¿Qué es JavaScript?

JavaScript es un lenguaje de programación de alto nivel y dinámico que se 
utiliza principalmente en el desarrollo web. Es uno de los tres pilares 
fundamentales para construir aplicaciones web, junto con HTML (estructura) y CSS 
(estilo).

### Características principales:

* **Lenguaje de Scripting:** JavaScript se ejecuta en el navegador del cliente, 
  permitiendo interactuar y modificar el contenido de la página web en tiempo 
  real.
* **Orientado a Objetos:** Aunque no es un lenguaje de programación estrictamente 
  orientado a objetos, permite la creación y uso de objetos, métodos y herencia 
  prototípica.
* **Interactividad y Dinamismo:** Permite agregar interactividad a una página web 
  (formularios dinámicos, sliders, menús desplegables, validación de datos).
* **Uso Extendido:** Además de su uso en el front-end (navegador), JavaScript 
  también puede utilizarse en el back-end con plataformas como Node.js.

JavaScript es fundamental para el desarrollo web moderno, permitiendo la 
creación de experiencias de usuario dinámicas e interactivas.

---

## Agregando JavaScript (JS)

En el desarrollo web, hay varias formas de agregar JavaScript a una página web 
para mejorar su interactividad y funcionalidad. Aquí se presentan las tres 
formas más comunes:

### 1. Inspector de Elementos

El Inspector de Elementos de un navegador permite probar y depurar código 
JavaScript directamente en la consola.

**Uso:**

* Abre la consola de tu navegador (generalmente con `F12` o `Ctrl + Shift + I`).
* Ve a la pestaña "Console".
* Puedes escribir y ejecutar código JavaScript directamente para probar 
  funciones, manipular el DOM y ver resultados en tiempo real.

**Ventaja**: Permite realizar pruebas rápidas sin modificar los archivos fuente.


### 2. Desde el Mismo Archivo HTML

Puedes incluir código JavaScript directamente dentro de un archivo HTML usando 
la etiqueta `<script>`.

**Ejemplo:**

```html
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Ejemplo con JS</title>
</head>
<body>
  <h1>Hola, mundo</h1>
  <script>
    console.log('Este es un mensaje desde el script dentro del HTML');
    alert('Hola desde JavaScript');
  </script>
</body>
</html>
```

**Características:**

* La etiqueta `<script>` se puede colocar en el `<head>` o al final del `<body>`.
* Si se coloca al final del `<body>`, se asegura que el DOM se haya cargado 
  completamente antes de ejecutar el script.


### 3. Desde un Archivo JS Externo

Es posible vincular un archivo JavaScript externo para mantener el código 
separado del HTML, lo que facilita su mantenimiento y reutilización.

**Ejemplo de HTML con JS Externo:**

```html
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Ejemplo con JS Externo</title>
</head>
<body>
  <h1>Hola, mundo</h1>
  <script src="script.js"></script>
</body>
</html>
```

**Contenido del Archivo `script.js`:**

```js
console.log('Este es un mensaje desde un archivo JS externo');
alert('Hola desde archivo JS');
```

**Características:**

* La etiqueta `<script src="archivo.js">` debe contener el atributo src que apunta 
  a la ubicación del archivo JavaScript.
* Es recomendable ubicar el `<script>` al final del `<body>` para mejorar la carga 
  de la página.

---

## `console.log`

`console.log` es una función de JavaScript que permite imprimir mensajes, 
variables, y otros datos en la **consola del navegador** o en la **terminal** (cuando se 
usa con Node.js). Es una herramienta esencial para depurar y verificar el 
funcionamiento de tu código.

**Características:**

* **Imprimir Datos**: Muestra texto, variables, objetos, y otros tipos de datos.
* **Depuración Rápida**: Permite entender el flujo de ejecución de tu programa y 
  verificar el valor de las variables en diferentes momentos.
* **Uso Sencillo**: Su sintaxis es simple y directa.

**Ejemplo Básico:**

```js
console.log('Hola, mundo'); // Imprime: Hola, mundo
```

**Imprimir Variables:**

```js
let nombre = 'Juan';
console.log(nombre); // Imprime: Juan
```

**Imprimir Objetos:**

```js
let persona = { nombre: 'Ana', edad: 25 };
console.log(persona); // Imprime el objeto completo: { nombre: 'Ana', edad: 25 }
```

**Debugging Efectivo**: Usar console.log en diferentes puntos de tu código te ayuda 
a rastrear errores, revisar la lógica de tu programa y entender cómo cambian los 
valores durante la ejecución.

Es una práctica común incluir console.log durante el desarrollo y eliminarlo o 
comentarlo antes de la implementación final en producción.

---

## Declaraciones y Sintaxis en JavaScript

JavaScript se basa en declaraciones y su correcta sintaxis para realizar 
acciones en el programa.

### 1. Declaraciones de JavaScript
Una **declaración** en JavaScript es una instrucción que se ejecuta para realizar 
una acción. Puede ser una declaración de variables, funciones, bucles, 
condiciones, etc. Cada declaración generalmente termina con un punto y coma (`;`).

### Ejemplos de declaraciones:

```js
let nombre = 'Juan'; // Declaración de una variable
function saludar() { // Declaración de una función
  console.log('Hola');
}
```

### 2. Sintaxis
La sintaxis de JavaScript es el conjunto de reglas que define cómo escribir 
correctamente el código. Cada declaración debe seguir estas reglas para 
funcionar correctamente.

#### Características de la sintaxis de JavaScript:
* **Sensibilidad a Mayúsculas y Minúsculas:** JavaScript distingue entre `Nombre` y 
  `nombre`.
* **Uso de Punto y Coma (`;`):** Se recomienda usar el punto y coma para finalizar las 
  declaraciones, aunque JavaScript lo agrega automáticamente en la mayoría de 
  los casos.
* **Bloques de Código:** Los bloques de código están delimitados por llaves `{}`.

#### Ejemplo de sintaxis correcta:

```js
if (true) {
  console.log('Esto se ejecuta');
}
```


### 3. Valor en JavaScript
El concepto de "valor" en JavaScript se refiere a cualquier dato que se puede 
manipular en el lenguaje (números, strings, objetos, etc.).

#### Literales
Un **literal** es un valor fijo que se escribe directamente en el código. Son datos 
que no cambian durante la ejecución del programa.

**Ejemplos de literales:**

```js
10            // Literal numérico
'Hola'        // Literal de cadena (string)
true          // Literal booleano
```

#### Variables
Las **variables** son contenedores para almacenar valores que pueden cambiar durante 
la ejecución del programa. Se declaran con palabras clave como let, const, y var.

**Ejemplo de variable:**

```js
let edad = 25;         // Variable que almacena un número
const nombre = 'Ana';  // Variable constante que almacena un string
```

Las variables permiten manipular datos de manera dinámica y flexible dentro del 
programa.

---

## Operadores

JavaScript utiliza **operadores** y **expresiones** para realizar cálculos, 
comparaciones, asignaciones y otras operaciones.

### 1. Operadores
Los **operadores** son símbolos que realizan operaciones sobre valores (operandos). 
Se clasifican en varios tipos:

* **Operadores Aritméticos:** Realizan operaciones matemáticas.
  * `+` (suma), `-` (resta), `*` (multiplicación), `/` (división), `%` (módulo)
  * **Ejemplo:** `5 + 3` resulta en `8`.

* **Operadores de Asignación:** Asignan valores a variables.
  * `=` (asigna), `+=` (asigna y suma), `-=` (asigna y resta)
  * **Ejemplo:** `x = 10` asigna el valor `10` a `x`.

* **Operadores de Comparación:** Comparan dos valores y devuelven un resultado 
  booleano (`true` o `false`).
  * `==` (igual), `===` (estrictamente igual), `!=` (diferente), 
    `!==` (estrictamente diferente), `>` (mayor que), `<` (menor que)
  * Ejemplo: `5 === '5'` devuelve `false` (comparación estricta).

* **Operadores Lógicos:** Realizan operaciones lógicas sobre valores booleanos.
  * `&&` (AND), `||` (OR), `!` (NOT)
  * **Ejemplo:** `(5 > 3)` && `(2 < 4)` devuelve true.

* **Operadores de Incremento/Decremento:** Modifican el valor de una variable en 1.
  * `++` (incrementa), `--` (decrementa)
  * Ejemplo: `x++` aumenta el valor de `x` en 1.
  
* **Operadores de Concatenación (para strings):** Usados para unir cadenas de texto.
  * `+` (concatena cadenas)
  * **Ejemplo:** `'Hola' + ' Mundo'` resulta en `'Hola Mundo'`.

---

## Expresiones

Una **expresión** es una combinación de valores, variables y operadores que se 
evalúan para producir un valor.

### Tipos de expresiones:

* **Expresiones Aritméticas:** Realizan operaciones matemáticas.

```js
10 + 5 // Resulta en 15
```

* **Expresiones de Asignación:** Asignan el resultado de una operación a una 
  variable.

```js
let resultado = 5 * 3; // `resultado` ahora es 15
```

* **Expresiones Lógicas:** Evalúan condiciones y devuelven un valor booleano (`true` o 
  `false`).

```js
(10 > 5) && (5 < 8) // Resulta en `true`
```

* **Expresiones de Concatenación:** Unen cadenas de texto.

```js
let saludo = 'Hola' + ' ' + 'Mundo'; // `saludo` es 'Hola Mundo'
```

Las expresiones son piezas fundamentales del código que pueden combinarse y 
usarse en declaraciones de control, asignaciones y cálculos dentro de un 
programa. Los operadores actúan sobre estas expresiones para darles sentido y 
manipular los datos correctamente.

---

## Palabras Claves

Las **palabras claves** (keywords) son reservadas por el lenguaje y tienen un 
significado específico en JavaScript. Estas no pueden utilizarse como nombres de 
variables, funciones, o identificadores.

### Algunas palabras claves comunes:

* **Declaración de Variables y Constantes:**
  * `let`: Declara una variable de bloque.
  * `const`: Declara una constante, cuyo valor no puede cambiar.
  * `var`: Declara una variable (no recomendado por problemas de alcance).

* **Control de Flujo:**
* if, else: Para condicionales.
* switch, case: Para condicionales con múltiples casos.
* for, while, do: Para bucles.

* **Funciones:**
* `function`: Declara una función.
* `return`: Devuelve un valor desde una función.

* **Manipulación de Objetos y Clases:**
* `class`: Declara una clase.
* `extends`: Define la herencia de clases.
* `this`: Hace referencia al contexto actual del objeto.
* `new`: Crea una instancia de un objeto.

* **Otros:**
* `try`, `catch`, `finally`: Manejo de excepciones.
* `import`, `export`: Para importar y exportar módulos en ES6.

---

## Comentarios
Los comentarios en JavaScript permiten agregar notas al código para que sea más legible, explicar lógica o desactivar fragmentos de código durante el desarrollo. Los comentarios no se ejecutan por el intérprete.

Tipos de Comentarios:

Comentarios de Línea: Usan // para comentar una sola línea.

js
Copiar código
// Esto es un comentario de línea
let x = 10; // Otro comentario de línea
Comentarios de Bloque: Usan /* ... */ para comentar múltiples líneas.

js
Copiar código
/*
  Esto es un comentario de bloque.
  Puede abarcar varias líneas.
*/
let y = 20;
Los comentarios son útiles para documentar el código y hacer que sea más fácil de entender para ti y otros desarrolladores. Sin embargo, deben usarse con moderación para evitar saturar el código.
