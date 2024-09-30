## Javascript

- [Javascript](#javascript)
- [¿Qué es JavaScript?](#qué-es-javascript)
- [Agregando JavaScript (JS)](#agregando-javascript-js)


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

