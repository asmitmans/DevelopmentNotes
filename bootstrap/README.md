## CSS

- [CSS](#css)
- [Definición de CSS](#definición-de-css)
- [Funcionalidad de CSS](#funcionalidad-de-css)
- [Formas de añadir CSS:](#formas-de-añadir-css)
- [Sintaxis de CSS:](#sintaxis-de-css)
- [Tipos de selectores en CSS:](#tipos-de-selectores-en-css)
- [Jerarquía en CSS:](#jerarquía-en-css)
- [Color en CSS:](#color-en-css)
- [Texto en CSS:](#texto-en-css)
- [Fondo en CSS:](#fondo-en-css)
- [Unidades de Medida Absoluta en CSS:](#unidades-de-medida-absoluta-en-css)
- [Unidades Relativas en CSS:](#unidades-relativas-en-css)
- [Modelos de Caja en CSS:](#modelos-de-caja-en-css)
- [Restablecimiento de Propiedades por Defecto en CSS:](#restablecimiento-de-propiedades-por-defecto-en-css)
- [Propiedad `display` en CSS:](#propiedad-display-en-css)
- [CSS Web Safe Fonts:](#css-web-safe-fonts)
- [Propiedad `position` en CSS:](#propiedad-position-en-css)
- [Personalizar SVG en CSS](#personalizar-svg-en-css)

---

## Definición de CSS
**CSS (Cascading Style Sheets)**** es un lenguaje de hojas de estilo utilizado 
para definir y controlar la presentación visual de documentos HTML o XML. 
CSS se encarga de especificar cómo los elementos de una página web deben 
mostrarse en términos de diseño, incluyendo aspectos como colores, fuentes, 
disposición, espaciado, y más.

**Definición:**
CSS es el estándar utilizado para aplicar estilos a los elementos HTML, 
permitiendo separar la estructura del contenido (HTML) de su presentación, y 
ofreciendo la capacidad de mantener y modificar el diseño de una página web de 
manera eficiente y centralizada.

---
## Funcionalidad de CSS
La funcionalidad de CSS radica en su capacidad para definir y gestionar la 
presentación visual de documentos web, principalmente aquellos escritos en HTML.
A continuación, se detallan las principales funcionalidades de CSS:

**1. Control del Diseño Visual:**
* CSS permite ajustar cómo se muestran los elementos en una página web, 
  controlando aspectos como colores, fuentes, tamaños, márgenes, bordes, y mucho 
  más.
* Ejemplo: Definir el color del texto, el estilo de las fuentes, o el espaciado 
  entre párrafos.

**2. Separación de Contenido y Presentación:**
* CSS separa la estructura del contenido (HTML) de su presentación, lo que 
  facilita el mantenimiento y la actualización del diseño sin alterar el HTML.
* Ejemplo: Modificar un archivo CSS afectará el estilo de todas las páginas que 
  lo utilicen, sin necesidad de tocar el contenido HTML.

**3. Responsive Design:**
* CSS permite que las páginas web se adapten a diferentes dispositivos y tamaños 
  de pantalla utilizando técnicas como **`media queries`**.
* Ejemplo: Crear un diseño que funcione tanto en dispositivos móviles como en 
  pantallas de escritorio.

**4. Reutilización y Consistencia:**
* Los estilos CSS pueden definirse una vez y aplicarse a múltiples elementos o 
  páginas, lo que asegura un diseño coherente en todo el sitio web.
* Ejemplo: Definir una clase CSS para botones y aplicarla a todos los botones 
  del sitio para mantener un estilo uniforme.

**5. Cascada y Especificidad:**
* CSS utiliza un modelo de cascada que permite que los estilos se apliquen en un 
  orden jerárquico. Esto significa que los estilos más específicos pueden 
  sobrescribir los estilos más generales.
* Ejemplo: Un estilo inline (definido directamente en un elemento HTML) puede 
  sobrescribir un estilo definido en una hoja de estilo externa.

**6. Animaciones y Transiciones:**
* CSS puede manejar animaciones y transiciones para agregar interactividad y 
  dinamismo a los elementos de la página.
* Ejemplo: Crear efectos de transición suave cuando un usuario pasa el ratón 
  sobre un botón.

---
## Formas de añadir CSS:
Existen tres formas principales de añadir CSS a un documento HTML:

### 1. CSS Externo:
* **Descripción**: CSS se coloca en un archivo separado con extensión **`.css`**, y se 
  enlaza al documento HTML mediante la etiqueta **`<link>`** en el **`<head>`**.
* **Ventaja**: Facilita la reutilización y mantenimiento, ya que un solo archivo CSS 
  puede ser utilizado por múltiples páginas.
* **Ejemplo**:
```html
<link rel="stylesheet" href="styles.css">
```

### 2. CSS Interno:
* **Descripción**: CSS se escribe dentro de una etiqueta **`<style>`** en el **`<head>`** del documento HTML.
* **Ventaja**: Útil para aplicar estilos específicos a una única página.
* **Ejemplo**:
```html
<style>
  body {
	  background-color: lightblue;
  }
</style>
```