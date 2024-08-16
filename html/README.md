## HTML

- [HTML](#html)
- [Definición de HTML](#definición-de-html)
- [Estructura base de un documento HTML](#estructura-base-de-un-documento-html)
- [Generar estructura de HTML en VS Code](#generar-estructura-de-html-en-vs-code)
- [Estructura de Assets](#estructura-de-assets)
- [Etiqueta HEAD](#etiqueta-head)

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



