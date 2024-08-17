## CSS

- [CSS](#css)
- [Definición de CSS](#definición-de-css)
- [Funcionalidad de CSS](#funcionalidad-de-css)
- [Formas de añadir CSS:](#formas-de-añadir-css)
- [Sintaxis de CSS:](#sintaxis-de-css)
- [Tipos de selectores en CSS:](#tipos-de-selectores-en-css)

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

### 3. CSS Inline:
* **Descripción**: CSS se aplica directamente a un elemento HTML mediante el 
  **atributo** **`style`**.
* **Ventaja**: Permite aplicar estilos rápidamente a elementos individuales.
* **Ejemplo**:
```html
<p style="color: red;">Este es un texto en rojo.</p>
```

---
## Sintaxis de CSS:
La sintaxis de CSS está compuesta por **selectores, propiedades**, y **valores** que 
determinan cómo se aplican los estilos a los elementos HTML.

### Estructura básica:
```css
selector {
    propiedad: valor;
}
```

### Componentes:
**1. Selector**: Indica a qué elementos HTML se aplicarán los estilos.
  * **Ejemplo: `h1`, `.clase`, `#id`**  

**2. Propiedad**: Define qué aspecto del elemento se va a modificar.
 * **Ejemplo: `color`, `font-size`, `margin`**

**3. Valor**: Especifica el valor que se aplicará a la propiedad.
  * **Ejemplo: `red`, `16px`, `10px`**

**4. Declaración**: Es una combinación de una propiedad y su valor, separada por un 
   `:` y finalizada con un `;`.
  * **Ejemplo: `color: red;`**

**5. Bloque de declaraciones**: Conjunto de declaraciones dentro de llaves `{}`, que 
   se aplica al selector.
  * **Ejemplo:**
```css
h1 {
    color: blue;
    font-size: 24px;
}
```

---
## Tipos de selectores en CSS:
Los selectores en CSS permiten apuntar a elementos específicos en el documento 
HTML para aplicarles estilos. Aquí están los tipos principales:

### 1. Selector de Elemento (Tag Selector):
* **Descripción**: Aplica estilos a todos los elementos de un tipo específico.
* **Sintaxis: `elemento`**
* **Ejemplo**:
```css
p {
    color: blue;
}
```
Efecto: Aplica color azul a todos los párrafos **`<p>`**.

### 2. Selector de Clase (Class Selector):
* **Descripción**: Aplica estilos a todos los elementos que comparten una clase 
  específica.
* **Sintaxis: `.nombre-clase`**
* **Ejemplo**:
```css
.destacado {
    font-weight: bold;
}
```
Efecto: Aplica negrita a todos los elementos con la clase destacado.

### 3. Selector de ID (ID Selector):
* **Descripción**: Aplica estilos a un único elemento que tiene un ID específico.
* **Sintaxis: `#id`**
* **Ejemplo**:
```css
#titulo-principal {
    text-align: center;
}
```
Efecto: Centra el texto del elemento con el ID titulo-principal.

### 4. Selector Universal (Universal Selector):
* **Descripción**: Aplica estilos a todos los elementos en la página.
* **Sintaxis: `*`**
* **Ejemplo**:
```css
* {
    margin: 0;
    padding: 0;
}
```
Efecto: Elimina el margen y el relleno de todos los elementos.

### 5. Selector de Atributo (Attribute Selector):
* **Descripción**: Aplica estilos a elementos que tienen un atributo específico o 
  cuyo atributo tiene un valor específico.
* **Sintaxis: `[atributo]` o `[atributo="valor"]`**
* **Ejemplo**:
```css
input[type="text"] {
    border: 1px solid #ccc;
}
```
Efecto: Aplica un borde a todos los campos de entrada de tipo texto.

### 6. Selectores de Descendientes (Descendant Selector):
* **Descripción**: Aplica estilos a los elementos que son descendientes de un 
  elemento específico.
* **Sintaxis: `elemento1 elemento2`**
* **Ejemplo:**
```css
div p {
    color: red;
}
```
Efecto: Aplica color rojo a todos los párrafos **`<p>`** que están dentro de un **`<div>`**.

### 7. Selector de Hijo Directo (Child Selector):
* **Descripción**: Aplica estilos a elementos que son hijos directos de un elemento 
  específico.
* **Sintaxis: `elemento1 > elemento2`**
* **Ejemplo**:
```css
ul > li {
    list-style-type: none;
}
```
Efecto: Elimina el estilo de lista solo de los elementos **`<li>`** que son hijos 
directos de un **`<ul>`**.

### 8. Selector de Hermano Adyacente (Adjacent Sibling Selector):
* **Descripción**: Aplica estilos a un elemento que es inmediatamente precedido por 
  un elemento específico.
* **Sintaxis: `elemento1 + elemento2`**
* **Ejemplo**:
```css
h1 + p {
    margin-top: 0;
}
```
Efecto: Elimina el margen superior del párrafo que sigue inmediatamente a un **`<h1>`**.

### 9. Selector de Hermano General (General Sibling Selector):
* **Descripción**: Aplica estilos a todos los elementos que son hermanos de un 
  elemento específico.
* **Sintaxis: `elemento1 ~ elemento2`**
* **Ejemplo:**
```css
h1 ~ p {
    color: gray;
}
```
Efecto: Aplica color gris a todos los párrafos que son hermanos de un **`<h1>`**.

> **Nota:** En HTML, un elemento es considerado "hermano" de otro cuando ambos 
> comparten el mismo **elemento padre**. Es decir, están al mismo nivel 
> jerárquico dentro de la estructura del documento. Por ejemplo, en el siguiente
> código, los elementos `<p>` y `<div>` son hermanos porque ambos están 
> contenidos dentro del mismo `<section>`:
>```html
><section>
>    <p>Este es un párrafo.</p>
>    <div>Este es un div.</div>
></section>
>```