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
- [Variable](#variable)
- [`prompt()`](#prompt)
- [`document.write()`](#documentwrite)
- [jQuery](#jquery)
- [Formas de Integrar jQuery](#formas-de-integrar-jquery)
- [Sintaxis de jQuery](#sintaxis-de-jquery)
- [Callback o Función Anónima en jQuery](#callback-o-función-anónima-en-jquery)
- [Selectores](#selectores)
- [Eventos y Funciones](#eventos-y-funciones)
- [Métodos](#métodos)


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

Los **comentarios** en JavaScript permiten agregar notas al código para que sea más 
legible, explicar lógica o desactivar fragmentos de código durante el desarrollo. 
Los comentarios no se ejecutan por el intérprete.

### Tipos de Comentarios:

* **Comentarios de Línea:** Usan `//` para comentar una sola línea.

```js
// Esto es un comentario de línea
let x = 10; // Otro comentario de línea
```

* **Comentarios de Bloque:** Usan `/* ... */` para comentar múltiples líneas.

```js
/*
  Esto es un comentario de bloque.
  Puede abarcar varias líneas.
*/
let y = 20;
```

---

## Variable

Una **variable** es un contenedor que almacena un valor que puede cambiar durante la 
ejecución del programa. Es un espacio en la memoria que guarda datos como 
números, cadenas de texto, booleanos, etc. Las variables permiten reutilizar y 
manipular datos de forma dinámica.

### Características de las variables en JavaScript:
* Pueden almacenar diferentes tipos de datos (números, strings, objetos, etc.).
* Su valor puede ser actualizado (con `let` o `var`).
* Una vez declaradas con `const`, su valor no puede cambiar.

### Sintaxis de una Variable
Para declarar una variable en JavaScript, se utilizan palabras clave como let, 
const, o var. La forma más común es let para variables que cambian de valor, y 
const para constantes.

#### Sintaxis básica:

```js
let nombreVariable = valor;
const nombreConstante = valorFijo;
```

**Ejemplos:**

```js
// Usando let para declarar una variable que puede cambiar
let edad = 25; // Declaración de una variable llamada "edad" con valor 25
edad = 30; // Actualización del valor de "edad"

// Usando const para declarar una constante
const nombre = 'Ana'; // Declaración de una constante que no puede cambiar
// nombre = 'Luis'; // Esto generaría un error, ya que "nombre" es constante
```

#### Reglas de Sintaxis:

* Los nombres de variables deben comenzar con una letra, `$`, o `_`.
* No pueden empezar con un número y no deben contener espacios.
* JavaScript es sensible a mayúsculas y minúsculas (`edad` y `Edad` son diferentes).

---

## `prompt()`

`prompt()` es una función integrada de JavaScript que muestra un cuadro de diálogo 
al usuario con un campo de entrada de texto. Es utilizada para solicitar datos o 
información directamente desde el navegador.

**Características**
* Interactividad: Pausa la ejecución del script hasta que el usuario ingresa un 
  valor y presiona "Aceptar" o "Cancelar".
* Devuelve un Valor de Texto: Retorna el valor ingresado por el usuario como un 
  string. Si el usuario presiona "Cancelar", la función devuelve `null`.
* Uso Sencillo: No requiere configuración adicional, solo un texto que indique 
  qué información se solicita.

**Sintaxis**

```js
let resultado = prompt('Escribe algo:');
```

En este ejemplo, un cuadro de diálogo aparecerá con el mensaje `"Escribe algo:"`, 
y el valor ingresado por el usuario se almacenará en la variable `resultado`.

`prompt()` es útil para obtener datos rápidamente del usuario durante la 
ejecución del programa, pero se usa menos en desarrollos modernos debido a su 
estilo de interacción que detiene el flujo natural de la aplicación. Para 
experiencias de usuario más complejas y atractivas, se prefieren formularios 
HTML y otras interfaces personalizadas.

---

## `document.write()`

`document.write()` es un método de JavaScript que permite escribir contenido 
directamente en el documento HTML desde el cual se está ejecutando el script. 
Inserta el texto o HTML especificado en la página web.

**Características**
* **Inserta Contenido Dinámicamente:** Permite añadir texto, HTML, o resultados de 
  operaciones directamente en el documento mientras se está cargando.
* **Ejecución Durante la Carga:** Si se usa después de que el documento HTML ha sido 
  completamente cargado, reemplaza todo el contenido existente de la página con 
  el nuevo contenido proporcionado.

**Sintaxis**
```js
document.write('¡Hola, mundo!');
```
Este ejemplo insertará el texto `"¡Hola, mundo!"` en la página.

**Uso y Desventajas**
* **Uso Histórico:** document.write() fue muy usado en los primeros días del 
  desarrollo web para crear contenido dinámico.
* **Desventajas en Desarrollos Modernos:** Ya no se recomienda su uso, ya que es 
  intrusivo y puede sobrescribir todo el contenido de la página si se usa después 
  de la carga inicial. Además, puede afectar el rendimiento y la experiencia del 
  usuario.

Para insertar contenido de manera dinámica y segura, se prefieren métodos 
modernos como `innerHTML` o manipulaciones más detalladas del DOM (Modelo de 
Objetos del Documento).

---

## jQuery

**jQuery** es una **librería de JavaScript rápida, pequeña, y rica en funcionalidades** 
que simplifica la manipulación del **DOM**, el manejo de **eventos**, la **animación**, y 
las **solicitudes AJAX**. Su objetivo principal es facilitar la escritura de código 
JavaScript que sea compatible con todos los navegadores.

### Características principales
* **Simplificación de la Sintaxis:** jQuery proporciona una sintaxis más sencilla y 
  corta para realizar tareas comunes como seleccionar elementos del DOM, 
  manipularlos y gestionar eventos.
* **Compatibilidad de Navegadores:** Abstrae las diferencias de implementación de 
  JavaScript entre navegadores, asegurando que el código funcione de manera 
  consistente.
* **Selección de Elementos con Selectores CSS:** jQuery permite seleccionar y 
  manipular elementos del DOM usando selectores similares a los de CSS.
* **Manipulación de Contenido y Atributos:** Facilita agregar, quitar y cambiar 
  contenido y atributos HTML de forma rápida.
* **Gestión de Eventos:** Proporciona una forma sencilla de añadir y manejar eventos 
  (clics, teclas, etc.) en los elementos de la página.
* **Animaciones y Efectos:** Ofrece métodos simples para animar elementos y crear 
  efectos como deslizamiento y desvanecimiento.
* **AJAX Simplificado:** Facilita la realización de solicitudes asíncronas para 
  cargar datos sin recargar la página completa.

### Uso Actual
Aunque jQuery sigue siendo popular y útil para ciertos proyectos, su uso ha 
disminuido con la introducción de librerías y frameworks más modernos (como 
React, Vue, Angular) que proporcionan un enfoque más avanzado y estructurado 
para el desarrollo web.

jQuery sigue siendo una herramienta poderosa para simplificar tareas de 
desarrollo web, especialmente si se busca compatibilidad y un aprendizaje rápido 
para manipular el DOM y gestionar eventos.

Para una página o sitio simple: jQuery sigue siendo útil y rápido de 
implementar. Para un sistema grande o aplicación compleja: Es recomendable usar 
un framework más avanzado como React, Vue, o Angular para tener un desarrollo 
más estructurado y escalable.

---

## Formas de Integrar jQuery

`#Revisar`

Existen dos formas principales de agregar jQuery a un proyecto: **descargando el 
archivo** o usando una **CDN** (Content Delivery Network). Ambas opciones tienen sus 
ventajas dependiendo de tus necesidades.

### 1. Descargando el Archivo
Puedes descargar el archivo de jQuery y hospedarlo localmente en tu proyecto.

#### Pasos para descargar jQuery:
1. Ve al sitio oficial de jQuery: https://jquery.com/download/.
2. Descarga la última versión de jQuery, ya sea en formato comprimido 
   (`jquery.min.js`) o sin comprimir (`jquery.js`).
3. Incluye el archivo descargado en tu proyecto.

#### Ejemplo de inclusión en HTML:

```html
<script src="path/to/jquery.min.js"></script>
```
Reemplaza `path/to/` con la ruta real donde se encuentra el archivo jQuery en tu 
proyecto.

#### Ventajas de la descarga local:
* Funciona offline, sin depender de conexión a internet.
* Control total sobre la versión utilizada.

### 2. CDN (Content Delivery Network)
Usar un CDN significa cargar jQuery desde un servidor externo, lo que suele 
mejorar la velocidad de carga y el rendimiento.

#### Incluir jQuery desde un CDN:

```html
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
```
Este ejemplo usa el CDN de Google para cargar la última versión de jQuery.

#### Ventajas de usar un CDN:
* Velocidad de carga mejorada: Si el usuario ya ha visitado un sitio que usa el 
  mismo CDN, es probable que el archivo esté en caché y la página cargue más 
  rápido.
* Reducción de carga en tu servidor: La carga del archivo se realiza desde el 
  servidor del CDN y no desde tu propio servidor.

---

## Sintaxis de jQuery
La sintaxis de jQuery es simple y se basa en el **signo `$`** seguido de una función 
que selecciona elementos y aplica acciones sobre ellos. Esto facilita la 
manipulación del DOM y la ejecución de eventos.

### Sintaxis Básica:

```js
$(selector).acción();
```

### Componentes de la Sintaxis
* **`$` (Selector de jQuery):** El símbolo `$` indica que estás utilizando jQuery. Es 
  una forma abreviada de llamar a la función principal de jQuery.

* `selector`: Es un **selector de elementos del DOM** similar a los selectores CSS 
  (`id`, `class`, `etiqueta`). Sirve para seleccionar el elemento o los elementos 
  sobre los que se quiere realizar una acción.
  * **Ejemplos de selectores:**
    * `$('p')`: Selecciona todos los elementos `<p>`.
    * `$('#miId')`: Selecciona el elemento con `id="miId"`.
    * `$('.miClase')`: Selecciona todos los elementos con `class="miClase"`.

* `.acción()`: Es un **método** que define la acción a realizar sobre los elementos 
  seleccionados (por ejemplo, ocultar, mostrar, cambiar texto).
  * **Ejemplos de acciones comunes:**
    * `.hide()`: Oculta los elementos seleccionados.
    * `.show()`: Muestra los elementos seleccionados.
    * `.css('propiedad', 'valor')`: Cambia una propiedad CSS.

### Ejemplos de Uso de la Sintaxis jQuery

**Ocultar todos los párrafos:**

```js
$('p').hide();
```


**Cambiar el texto de un elemento con id #miId:**

```js
$('#miId').text('Nuevo texto');
```


**Cambiar el color de fondo de los elementos con la clase .miClase:**

```js
$('.miClase').css('background-color', 'yellow');
```

**Esperar a que el DOM esté listo antes de ejecutar el código:**

```js
$(document).ready(function() {
  console.log('El DOM está listo');
});
```
La función `$(document).ready()` garantiza que el código se ejecute solo después 
de que la página ha terminado de cargarse.

---

## Callback o Función Anónima en jQuery

### Callback (Función Anónima)
Una **callback** es una función que se pasa como parámetro a otra función y se 
ejecuta después de que se completa una operación o evento específico. Las 
callbacks pueden ser **funciones anónimas** (sin nombre) o funciones con nombre.

En el contexto de jQuery, una **función anónima** es una **callback** comúnmente 
utilizada para ejecutar código después de que un evento ocurra, como la carga 
del DOM con `.ready()`.

### Características de una Callback (Función Anónima)
* **Ejecuta Código Después de un Evento:** Se usa para ejecutar acciones solo cuando 
  sucede algo, como la carga del DOM, clics del usuario, etc.
* **Sin Nombre (Anónima):** Muchas veces se escribe directamente como parámetro de 
  otra función, sin necesidad de asignarle un nombre.
* **Sintaxis Simple:** Define el comportamiento deseado de forma concisa.

**Ejemplo de Callback con `.ready()`**

```js
$(document).ready(function() {
  console.log('El DOM está listo');
});
```

* `function() {...}`: Esta es una **función anónima** pasada como callback.
* Propósito: Cuando el DOM esté completamente cargado, la callback se ejecuta y 
  muestra el mensaje "El DOM está listo" en la consola.

### ¿Cuándo Usar Callbacks?
* **Eventos Asíncronos:** Cuando necesitas que cierto código se ejecute después de 
  un evento asíncrono, como la carga de un documento, un temporizador 
  (`setTimeout`), o una solicitud AJAX.
* **Controlar el Flujo de Código:** Aseguran que el código se ejecute en el momento 
  adecuado, evitando errores al manipular elementos que aún no están 
  disponibles.

### Ejemplo General de una Callback:

```js
function saludar(nombre, callback) {
  console.log('Hola ' + nombre);
  callback();
}

saludar('Ana', function() {
  console.log('¡Esta es una callback!');
});
```
Aquí, la función anónima `function() {...}` se pasa como callback a `saludar`, y se
ejecuta justo después de que la función `saludar` completa su operación.

---

## Selectores

`#Revisar`

Los **selectores** en jQuery se usan para encontrar y seleccionar elementos del DOM 
con los que se desea trabajar. Funcionan de manera similar a los selectores de 
CSS, lo que hace que la sintaxis sea familiar y fácil de usar.

### Tipos de Selectores Comunes

1. **Selector por Etiqueta:** Selecciona todos los elementos de un tipo específico 
   (como <div>, <p>, <a>).
```js
$('p') // Selecciona todos los párrafos <p>
```

2. **Selector por ID:** Selecciona un elemento único con un atributo id específico.
```js
$('#miId') // Selecciona el elemento con id="miId"
```

3. **Selector por Clase:** Selecciona todos los elementos con una clase específica. 
```js
$('.miClase') // Selecciona todos los elementos con class="miClase"
```

4. **Selectores de Atributo:** Selecciona elementos basados en el valor de sus 
   atributos.
```js
$('input[type="text"]') // Selecciona todos los <input> de tipo texto
```

5. **Selector Universal (`*`):** Selecciona todos los elementos del DOM.
```js
$('*') // Selecciona todos los elementos en la página
```

### Combinando Selectores
Los selectores se pueden combinar para ser más específicos:

* **Múltiples Selectores:**
```js
$('p, .miClase') // Selecciona todos los <p> y los elementos con class="miClase"
```

* **Selectores Descendientes:**
```js
$('div p') // Selecciona todos los <p> que sean descendientes de <div>
```

* **Selectores Hijos Directos:**
```js
$('div > p') // Selecciona todos los <p> que sean hijos directos de <div>
```

### Funciones de Selección Adicionales
* **`.first()` y `.last()`:** Seleccionan el primer o último elemento de un grupo.
```js
$('p').first() // Selecciona el primer párrafo <p>
```

* **`.eq(index)`:** Selecciona el elemento en una posición específica.
```js
$('li').eq(2) // Selecciona el tercer elemento <li>
```

* Pseudo-Selectores de Estado: jQuery también admite pseudo-selectores como 
  `:visible`, `:hidden`, `:checked`.
```js
$(':checked') // Selecciona todos los elementos <input> que estén seleccionados
```

---

## Eventos y Funciones

`#Revisar`

En jQuery (y JavaScript en general), los **eventos** son acciones o sucesos que 
ocurren en la página web y pueden ser detectados para ejecutar una función. 
Estos eventos pueden ser acciones del usuario (clics, teclas presionadas, 
movimientos de ratón) o eventos del sistema (carga de página, cambios de 
tamaño).

Al usar jQuery, puedes "escuchar" estos eventos y responder con **funciones** 
(callbacks) que se ejecutan cuando el evento ocurre.

### Ejemplo de Eventos

1. **Evento de Click:**
```js
$('#miBoton').click(function() {
  alert('¡Botón clickeado!');
});
```
* Aquí, se detecta el evento `click` en un elemento con `id="miBoton"`.
* Cuando el usuario hace clic en ese elemento, se ejecuta la función que muestra 
  una alerta.

2. **Evento `mouseover` (pasar el ratón por encima):**
```js
$('.miClase').mouseover(function() {
  console.log('Mouse sobre el elemento');
});
```
* Detecta cuando el ratón pasa sobre un elemento con `class="miClase"`.

### Sintaxis de los Eventos

La sintaxis para trabajar con eventos en jQuery sigue el patrón:
```js
$(selector).evento(function() {
  // Código a ejecutar cuando ocurra el evento
});
```
* `$(selector)`: Selecciona el elemento del DOM sobre el que se quiere escuchar el 
  evento.
* `.evento`: Es el evento que se quiere detectar, como `click`, `mouseover`, `keydown`, 
  etc.
* `function() { ... }`: La función (callback) que se ejecutará cuando el evento 
  ocurra.

### Métodos de Eventos Comunes

1. `.click(function)`: Detecta cuando se hace clic en un elemento.
```js
$('#elemento').click(function() { /* ... */ });
```

2. `.dblclick(function)`: Detecta cuando se hace doble clic en un elemento.
```js
$('#elemento').dblclick(function() { /* ... */ });
```

3. `.keydown(function)`: Detecta cuando una tecla es presionada.
```js
$(document).keydown(function(event) { /* ... */ });
```

4. `.focus(function)`: Detecta cuando un campo de formulario recibe el foco.
```js
$('input').focus(function() { /* ... */ });
```

### Delegación de Eventos (Para Elementos Dinámicos)

jQuery permite usar **delegación de eventos** para manejar eventos de elementos 
añadidos dinámicamente al DOM:
```js
$(document).on('click', '.miClaseDinamica', function() {
  alert('Elemento dinámico clickeado');
});
```
* Aquí, se usa `$(document).on(...)` para delegar el evento `click` a cualquier 
  elemento con `class="miClaseDinamica"` que se agregue después de que la página 
  haya cargado.

---

## Métodos

Los **métodos** en jQuery son funciones integradas que permiten realizar operaciones 
comunes en los elementos del DOM de manera sencilla y eficiente. Estas 
operaciones incluyen aplicar efectos, manipular contenido HTML y modificar 
estilos CSS.

### 1. Métodos de Efectos

Los métodos de efectos en jQuery se utilizan para mostrar, ocultar, y animar 
elementos de la página. Los más comunes son:

* **`.show()` y `.hide()`:** Muestran u ocultan elementos.
```js
$('#elemento').hide(); // Oculta el elemento
$('#elemento').show(); // Muestra el elemento
```

* **`.toggle()`:** Alterna entre mostrar y ocultar un elemento.
```js
$('#elemento').toggle(); // Muestra u oculta dependiendo del estado actual
```

* **`.fadeIn()` y `.fadeOut()`:** Muestran y ocultan un elemento con un efecto de 
  desvanecimiento.
```js
$('#elemento').fadeIn('slow'); // Desvanece lentamente para mostrar
$('#elemento').fadeOut('fast'); // Desvanece rápidamente para ocultar
```

* **`.slideUp()` y `.slideDown()`:** Deslizan un elemento hacia arriba (para ocultar) 
  o hacia abajo (para mostrar).
```js
$('#elemento').slideUp(); // Oculta el elemento con deslizamiento hacia arriba
$('#elemento').slideDown(); // Muestra el elemento con deslizamiento hacia abajo
```

* **`.animate()`:** Permite animar propiedades CSS (números como width, height, 
  opacity).
```js
$('#elemento').animate({ width: '50%' }, 'slow'); // Cambia el ancho al 50%
```

### 2. Manipulación de HTML y CSS

jQuery facilita la manipulación del contenido HTML, atributos, y estilos CSS de 
los elementos.

#### Manipulación del Contenido HTML:

* **`.html()`:** Obtiene o establece el contenido HTML de un elemento.
```js
$('#contenedor').html('<p>Nuevo contenido</p>'); // Cambia el HTML interno
```

* **`.text()`:** Obtiene o establece solo el texto de un elemento (sin HTML).
```js
$('#contenedor').text('Nuevo texto'); // Cambia el texto interno
```

* `.append()` y `.prepend()`: Añaden contenido al final o al principio de un 
  elemento.
```js
$('#lista').append('<li>Nuevo elemento</li>'); // Añade al final de la lista
$('#lista').prepend('<li>Nuevo elemento</li>'); // Añade al principio
```

#### Manipulación de Atributos:

* **`.attr()`:** Obtiene o establece el valor de un atributo.
```js
$('#imagen').attr('src', 'nueva-imagen.jpg'); // Cambia el atributo `src` de la imagen
```

* **`.removeAttr()`**: Elimina un atributo específico.
```js
$('#link').removeAttr('href'); // Elimina el atributo `href`
```

#### Manipulación de Estilos CSS:

* **`.css()`:** Obtiene o establece propiedades CSS.
```js
$('#caja').css('background-color', 'blue'); // Cambia el color de fondo
```

* **`.addClass()` y `.removeClass()`:** Añaden o eliminan clases de CSS a un elemento.
```js
$('#caja').addClass('activo'); // Añade la clase "activo"
$('#caja').removeClass('activo'); // Elimina la clase "activo"
```

* **`.toggleClass()`:** Alterna una clase; si la clase está presente, se elimina, si 
  no, se añade.
```js
$('#caja').toggleClass('activo'); // Añade o elimina la clase "activo"
```

---

