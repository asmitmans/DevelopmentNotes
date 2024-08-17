## HTML

- [HTML](#html)
- [Definición de HTML](#definición-de-html)
- [Estructura base de un documento HTML](#estructura-base-de-un-documento-html)
- [Generar estructura de HTML en VS Code](#generar-estructura-de-html-en-vs-code)
- [Estructura de Assets](#estructura-de-assets)
- [Etiqueta HEAD](#etiqueta-head)
- [Etiqueta BODY](#etiqueta-body)
- [Etiqueta `<p>` (Párrafo):](#etiqueta-p-párrafo)
- [Etiquetas `<h1>`, `<h2>`, `<h3>`, etc. (Encabezados):](#etiquetas-h1-h2-h3-etc-encabezados)
- [Etiqueta `<img>` (Imagen):](#etiqueta-img-imagen)
- [Etiqueta `<a>` (Enlace):](#etiqueta-a-enlace)
- [Etiqueta `<ul>` y `<ol>` (Listas):](#etiqueta-ul-y-ol-listas)
- [Imagen con enlace (`<a>` con `<img>`)](#imagen-con-enlace-a-con-img)
- [Menu de navegación `<nav>` con `<ul>`, `<li>`, y `<a>`](#menu-de-navegación-nav-con-ul-li-y-a)
- [Etiqueta `<div>` (División o contenedor):](#etiqueta-div-división-o-contenedor)
- [Etiquetas semánticas en HTML5:](#etiquetas-semánticas-en-html5)

---

## Definición de HTML
HTML (HyperText Markup Language) es el lenguaje de marcado estándar utilizado
para crear y estructurar el contenido en la web. Define la estructura básica de
una página web mediante etiquetas, permitiendo la inclusión de texto, imágenes,
enlaces, formularios y otros elementos multimedia. HTML es la base sobre la que
se construyen todas las páginas web, y trabaja en conjunto con CSS y JavaScript
para crear experiencias web interactivas y visualmente atractivas.

---

## Estructura base de un documento HTML
La estructura base de un documento HTML sigue una estructura jerárquica simple,
que define el esqueleto básico necesario para cualquier página web. 

```html
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Título de la Página</title>
</head>
<body>
    <!-- Contenido de la página -->
</body>
</html>
```
### Desglose de la estructura:
* **`<!DOCTYPE html>`**: Declara el tipo de documento y asegura la compatibilidad
  con HTML5.
* **`<html lang="es">`**: La etiqueta raíz que contiene todo el contenido del
  documento; **`lang="es"`** define el idioma del contenido.
* **`<head>`**: Contiene metadatos sobre el documento, como el conjunto de
  caracteres (**`<meta charset="UTF-8">`**), el título de la página (**`<title>`**),
  y otras configuraciones como la etiqueta de viewport para la compatibilidad
  con dispositivos móviles.
* **`<body>`**: Contiene todo el contenido visible de la página web, como texto,
  imágenes, enlaces, y más. 


---

## Generar estructura de HTML en VS Code
Para crear una estructura básica de HTML automáticamente en Visual Studio Code,
sigue estos pasos:
1. **Crear un nuevo archivo HTML:**
   - Abre Visual Studio Code.
   - Crea un nuevo archivo con la extensión .html.
2. **Utilizar Emmet para generar la estructura:**
   - Dentro del archivo HTML, escribe `!` (signo de exclamación).
   - Presiona **`Enter`** o **`Tab`**.
3. **Resultado:**
   - Esto generará automáticamente la estructura básica de un documento HTML5.

**Nota:**
Esta funcionalidad es proporcionada por **Emmet**, que está integrado en Visual 
Studio Code y permite acelerar la escritura de código HTML y CSS.

Código generado:
```html
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
</head>
<body>
	
</body>
</html>
```

---

## Estructura de Assets
En el desarrollo web de una página estática basada en assets, la estructura de
directorios suele seguir un patrón organizado para facilitar el mantenimiento, 
escalabilidad y claridad del proyecto.

A continuación se presenta una estructura de carpetas recomendada:

```plaintext
/
├── index.html            # Archivo HTML principal
├── assets/               # Directorio principal para todos los assets
│   ├── css/              # Archivos CSS
│   │   └── styles.css    # Hoja de estilos principal
│   ├── js/               # Archivos JavaScript
│   │   └── main.js       # Script principal
│   ├── images/           # Imágenes utilizadas en la página
│   │   └── logo.png      # Ejemplo de imagen
│   ├── fonts/            # Fuentes personalizadas
│   │   └── custom-font
```

---

## Etiqueta HEAD
### Definición:
La etiqueta **`<head>`** en HTML es una sección del documento que contiene metadatos
y otros elementos que no son visibles directamente en la página web, pero que
son esenciales para la configuración, el rendimiento y la optimización de la 
página.

### Función:
* **Metadatos:** La etiqueta **`<head>`** alberga metadatos sobre la página, como
  el título, la codificación de caracteres, enlaces a archivos CSS, scripts, y
  meta-etiquetas para SEO.
* **Referencias externas:** Incluye enlaces a hojas de estilo, fuentes, y scripts
  externos.
* **Optimización:** Facilita la optimización para motores de búsqueda y redes
  sociales mediante meta-etiquetas.

### Características:
* **No visible:** El contenido dentro de **`<head>`** no se muestra en la página,
  pero es crucial para el correcto funcionamiento y visualización de la misma.
* **Posicionamiento:** Debe estar presente antes de la etiqueta **`<body>`**.
* **Contenido típico:** Título de la página (**`<title>`**), enlaces a hojas de estilo
* (**`<link>`**), scripts (**`<script>`**), metaetiquetas (**`<meta>`**), entre otros.

### Ejemplo en código:
```html
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Descripción de la página para SEO">
    <title>Mi Página Web</title>
    <link rel="stylesheet" href="assets/css/styles.css">
    <link rel="icon" href="assets/images/favicon.ico">
    <script src="assets/js/main.js" defer></script>
</head>
<body>
    <!-- Contenido de la página -->
</body>
</html>

```
### Otros datos importantes:
* **SEO y redes sociales:** Metaetiquetas como **`<meta name="description">`** y Open Graph
  (**`<meta property="og:title">`**) mejoran la visibilidad de la página en motores
  de búsqueda y redes sociales.
* **Compatibilidad y rendimiento:** Incluir meta viewport para la adaptación en dispositivos
  móviles y usar el atributo **`defer`** en **`<script>`** para cargar scripts sin 
  bloquear el renderizado.

---

## Etiqueta BODY
### Definición:
La etiqueta **`<body>`** en HTML es la sección del documento que contiene todo el
contenido visible de la página web, incluyendo texto, imágenes, enlaces,
formularios, y cualquier otro elemento que el usuario puede ver e interactuar.

### Función:
* **Contenedor del contenido:** La etiqueta **`<body>`** alberga todo el contenido visual
  y los elementos interactivos que se muestran en el navegador.
* **Interacción**: Es la parte de la página que los usuarios ven y con la que pueden
  interactuar.

### Características:
* **Visible:** Todo lo que se coloca dentro de **`<body>`** se renderiza en la página web.
* **Única por documento:** Solo puede haber una etiqueta **`<body>`** por documento HTML.
* **Carga del contenido:** El contenido dentro de **`<body>`** se carga después de que el
  navegador procesa las etiquetas y metadatos en **`<head>`**.

### Ejemplo en código:
```html
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mi Página Web</title>
</head>
<body>
    <h1>Bienvenido a mi página web</h1>
    <p>Este es un párrafo de ejemplo dentro del cuerpo de la página.</p>
</body>
</html>
```
### Otros datos importantes:
* **Scripts y estilos:** Aunque es posible incluir scripts y estilos dentro de 
  **`<body>`**, generalmente se recomienda mantenerlos en el **`<head>`** o en archivos
  externos para una mejor organización y rendimiento.
* **Eventos de carga:** El contenido dentro de **`<body>`** se carga después de los
  elementos en **`<head>`**, y se pueden utilizar eventos como **`onload`** para ejecutar
  scripts una vez que el cuerpo de la página esté completamente cargado.

---
## Etiqueta `<p>` (Párrafo):
* **Estructura: `<p>Texto del párrafo</p>`**
* **Ejemplo:**
```html
<p>Este es un párrafo de texto.</p>
```
* **Dato extra:** Los párrafos añaden un margen por defecto antes y después del 
contenido.

---
## Etiquetas `<h1>`, `<h2>`, `<h3>`, etc. (Encabezados):
* **Estructura: `<h1>Texto del encabezado</h1>`, `<h2>Texto del encabezado</h2>`, ...,**
  **`<h6>Texto del encabezado</h6>`**
* **Ejemplo:**
```html
<h1>Encabezado principal</h1>
<h2>Subtítulo o sección</h2>
<h3>Subsección</h3>
```
- **Dato extra**: Los encabezados **`<h1>`** a **`<h6>`** representan niveles jerárquicos de
importancia, siendo **`<h1>`** el más importante (usualmente el título principal de la
página) y **`<h6>`** el menos importante. Estos encabezados también juegan un papel
crucial en la accesibilidad y el SEO, ayudando a estructurar el contenido de
manera lógica.

---
## Etiqueta `<img>` (Imagen):
- **Estructura: `<img src="ruta-imagen" alt="Descripción">`**
- **Ejemplo:**
```html
<img src="imagen.jpg" alt="Descripción de la imagen">
```
- **Dato extra**: El atributo alt es importante para la accesibilidad y para SEO.

---
## Etiqueta `<a>` (Enlace):
- **Estructura: `<a href="URL">Texto del enlace</a>`**
- **Ejemplo:**
```html
<a href="https://example.com">Visita nuestro sitio</a>
```
- **Dato extra:** El atributo **`target="_blank"`** se puede usar para abrir el enlace en
una nueva pestaña.

---
## Etiqueta `<ul>` y `<ol>` (Listas):
- **Estructura**: 
  - **Listas no ordenadas: `<ul><li>Elemento 1</li><li>Elemento 2</li></ul>`**
  - **Listas ordenadas: `<ol><li>Elemento 1</li><li>Elemento 2</li></ol>`**
- **Ejemplo**:
```html
<ul>
  <li>Elemento no ordenado 1</li>
  <li>Elemento no ordenado 2</li>
</ul>

<ol>
  <li>Elemento ordenado 1</li>
  <li>Elemento ordenado 2</li>
</ol>
```
- **Dato extra:** Las listas **`<ul>`** se utilizan para elementos sin un orden específico,
mientras que las listas **`<ol>`** son para elementos que tienen un orden o secuencia.
Se pueden anidar listas dentro de listas para crear estructuras más complejas.

---
## Imagen con enlace (`<a>` con `<img>`)
- **Estructura:**
```html
<a href="URL">
  <img src="ruta-imagen" alt="Descripción de la imagen">
</a>
```
- **Ejemplo:**
```html
<a href="https://example.com">
  <img src="imagen.jpg" alt="Visita nuestro sitio">
</a>
```
- **Dato extra**: Esta combinación permite que una imagen funcione como un enlace. Es
útil para crear botones visuales o enlaces gráficos en una página web. Asegúrate
de incluir un buen alt en la imagen para accesibilidad y SEO.

---

## Menu de navegación `<nav>` con `<ul>`, `<li>`, y `<a>`
- **Ejemplo:**
```html
<nav>
  <ul>
    <li><a href="inicio.html">Inicio</a></li>
    <li><a href="sobre.html">Sobre Nosotros</a></li>
    <li><a href="contacto.html">Contacto</a></li>
  </ul>
</nav>
```
- **Dato extra**: El elemento **`<nav>`** se usa para envolver el bloque de navegación, 
mejorando la semántica y accesibilidad del HTML. Dentro, **`<ul>`** crea una lista no
ordenada de enlaces, y cada enlace está contenido en un **`<li>`** (elemento de lista).
Esto es una práctica común para estructurar menús de navegación en sitios web.

---
## Etiqueta `<div>` (División o contenedor):
* **Estructura: `<div>Contenido aquí</div>`**
* **Ejemplo:**
```html
<div class="contenedor">
    <h2>Título de la sección</h2>
    <p>Este es un párrafo dentro de un contenedor div.</p>
</div>
```
* **Dato extra**: La etiqueta **`<div>`** es un contenedor genérico que se usa para 
  agrupar elementos y aplicarles estilos o scripts. No tiene un significado 
  semántico propio, por lo que es ideal para organizar el layout de una página 
  sin añadir ninguna semántica adicional. Es muy común en el diseño web, 
  especialmente en combinación con CSS y JavaScript.

---
## Etiquetas semánticas en HTML5:
Las etiquetas semánticas en HTML5 son aquellas que describen claramente su 
propósito y el tipo de contenido que contienen, mejorando la accesibilidad, SEO, 
y la comprensión del código tanto para los desarrolladores como para los 
navegadores.

### Principales etiquetas semánticas:
- **`<header>`**: Define un encabezado para un documento o sección.
- **`<nav>`**: Indica un conjunto de enlaces de navegación.
- **`<section>`**: Representa una sección genérica de un documento, generalmente con un 
  encabezado.
- **`<article>`**: Denota un contenido independiente y autocontenido, como un artículo 
  de blog o una noticia.
- **`<aside>`**: Contiene contenido relacionado indirectamente con el contenido principal, 
  como una barra lateral o un bloque de anuncios.
- **`<footer>`**: Define el pie de página para un documento o sección.
- **`<main>`**: Representa el contenido principal del documento, excluyendo cabeceras, 
  barras laterales, y pie de página.
- **`<figure>`** y **`<figcaption>`**: Usado para agrupar contenido como imágenes, gráficos, 
  o tablas con una leyenda.

### Ventajas de usar etiquetas semánticas:
- **Accesibilidad**: Mejora la accesibilidad, permitiendo que los lectores de pantalla 
  interpreten mejor la estructura del documento.
- **SEO**: Los motores de búsqueda pueden entender mejor la estructura y relevancia 
  del contenido, mejorando el posicionamiento.
- **Mantenimiento**: Facilita la lectura y mantenimiento del código al proporcionar 
  una estructura más clara y significativa.

### Ejemplo:
```html
<article>
    <header>
        <h1>Título del Artículo</h1>
        <p>Fecha: 15 de agosto de 2024</p>
    </header>
    <section>
        <p>Contenido principal del artículo...</p>
    </section>
    <footer>
        <p>Autor: John Doe</p>
    </footer>
</article>
```

Las etiquetas semánticas son una parte esencial de las mejores prácticas en HTML5, 
contribuyendo a la creación de documentos web más claros, accesibles y bien 
estructurados.

### Diagrama
<img src="./semantic_tags.svg">

---












