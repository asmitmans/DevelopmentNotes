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
> código, los elementos **`<p>`** y **`<div>`** son hermanos porque ambos están 
> contenidos dentro del mismo **`<section>`**:
>```html
><section>
>    <p>Este es un párrafo.</p>
>    <div>Este es un div.</div>
></section>
>```

---
## Jerarquía en CSS:
La jerarquía en CSS se refiere a las reglas que determinan qué estilos se aplican
a un elemento cuando hay múltiples reglas potencialmente en conflicto. Las dos 
reglas principales que gobiernan esta jerarquía son:

### 1. Especificidad:
* **Descripción**: La especificidad determina qué tan "específica" es una regla CSS.
  Las reglas más específicas tienen prioridad sobre las menos específicas.
* **Cálculo de especificidad**:
  * Selectores **inline (`style="..."`)** tienen la mayor especificidad.
  * Selectores de **ID (`#id`)** tienen mayor especificidad que selectores de clase 
    **(`.clase`)**, pseudo-clases, o selectores de atributo.
  * Selectores de **clase**, pseudo-clases, y selectores de atributo son más 
    específicos que los selectores de elemento **(`p`, `div`)**.
* **Ejemplo**:
```css
p { color: blue; }          /* Especificidad baja */
.important { color: red; }  /* Especificidad media */
#unique { color: green; }   /* Especificidad alta */
```

### 2. Orden de aparición (cascada):
* **Descripción**: Si dos reglas tienen la misma especificidad, la última regla en el 
  código tiene prioridad. Esto se refiere al concepto de la "cascada" en CSS.
* **Ejemplo**:
```css
p { color: blue; }
p { color: red; }  /* Este estilo se aplicará porque aparece después */
```

### Excepción: `!important`
* **Descripción**: La declaración **`!important`** puede sobreescribir la jerarquía natural 
  basada en especificidad y orden de aparición, forzando una regla a tener la 
  máxima prioridad.
* **Ejemplo**:
```css
p { color: blue !important; }
#unique { color: green; }  /* El color azul se aplicará a pesar de la especificidad del ID */
```

---
## Color en CSS:
El manejo del color es una parte fundamental del diseño en CSS, ya que permite 
definir los colores de texto, fondo, bordes y otros elementos visuales en una 
página web.

### Formatos de color en CSS:
#### 1. Nombres de colores (Color Names):
   * **Descripción**: CSS soporta un conjunto de nombres predefinidos para colores 
     comunes como **`red`, `blue`, `green`**, etc.
   * **Ejemplo**:
```css
p {
    color: red;
}
```

#### 2. Hexadecimal (Hex Color):
* **Descripción**: Utiliza una combinación de seis dígitos hexadecimales para 
  representar el color. Los primeros dos dígitos representan el rojo, los 
  siguientes dos el verde, y los últimos dos el azul.
* **Sintaxis**: `#RRGGBB`
* Ejemplo:
```css
p {
    color: #ff0000; /* Rojo */
}
```

#### 3. RGB (Red, Green, Blue):
* **Descripción**: Define el color mediante los valores de los canales rojo, verde y
  azul. Los valores pueden ir de 0 a 255.
* **Sintaxis: `rgb(RED, GREEN, BLUE)`**
* **Ejemplo**:
```css
p {
    color: rgb(255, 0, 0); /* Rojo */
}
```

#### 4. RGBA (Red, Green, Blue, Alpha):
* **Descripción**: Similar a rgb, pero incluye un cuarto valor (alpha) para definir 
  la opacidad del color. El valor de alpha va de 0 (transparente) a 1 (opaco).
* **Sintaxis: `rgba(RED, GREEN, BLUE, ALPHA)`**
* **Ejemplo**:
```css
p {
    color: rgba(255, 0, 0, 0.5); /* Rojo semi-transparente */
}
```

#### 5. HSL (Hue, Saturation, Lightness):
* **Descripción**: Define el color mediante matiz (hue), saturación y luminosidad. 
  El matiz es un ángulo en el círculo de colores (0-360), mientras que la 
  saturación y luminosidad son porcentajes.
* **Sintaxis: `hsl(HUE, SATURATION%, LIGHTNESS%)`**
* **Ejemplo**:
```css
p {
    color: hsl(0, 100%, 50%); /* Rojo */
}
```

#### 6. HSLA (Hue, Saturation, Lightness, Alpha):
* **Descripción**: Similar a hsl, pero incluye el valor alpha para definir la opacidad.
* **Sintaxis: `hsla(HUE, SATURATION%, LIGHTNESS%, ALPHA)`**
* **Ejemplo**:
```css
p {
    color: hsla(0, 100%, 50%, 0.5); /* Rojo semi-transparente */
}
```

### Aplicaciones comunes:
* **Color del texto**: Utilizado con la propiedad color.
* **Color de fondo**: Utilizado con la propiedad background-color.
* **Color de bordes**: Utilizado con propiedades como border-color.

### Ejemplo completo:
```css
body {
    background-color: #f0f0f0; /* Fondo gris claro */
}

h1 {
    color: hsl(200, 100%, 50%); /* Azul brillante */
}

p {
    color: rgba(0, 0, 0, 0.7); /* Negro con 70% de opacidad */
    background-color: #ffffcc; /* Fondo amarillo claro */
}
```

---
## Texto en CSS:
CSS ofrece una variedad de propiedades para controlar el estilo, tamaño, 
alineación y otros aspectos del texto en una página web.

### 1. Tipografía (Typography):
* **Propiedad principal**: `font-family`
* **Descripción**: Define la fuente utilizada para el texto.
* **Ejemplo**:
```css
p {
    font-family: "Arial", sans-serif;
}
```
* **Dato extra**: Es común definir una pila de fuentes como respaldo, en caso de que 
  la fuente principal no esté disponible.

#### font-family en CSS
En CSS, **`font-family`** se refiere a una familia de fuentes que puede incluir varios 
estilos o variaciones de una fuente. Por ejemplo, la familia de fuentes "Arial" 
incluye variaciones como "Arial Bold", "Arial Italic", etc. Al especificar una 
familia de fuentes, CSS intentará usar esa fuente y sus variaciones en el texto.

#### Comillas en valores de fuentes
* **Comillas para nombres con espacios**: Los nombres de fuentes que contienen 
  espacios deben ir entre comillas. "Arial" no tiene espacios, pero sigue siendo 
  una buena práctica usar comillas para los nombres de fuentes, ya que algunos 
  navegadores podrían requerirlo si el nombre contiene caracteres especiales o 
  empieza con un número.
* **Familias genéricas sin comillas**: **`sans-serif`** es una **familia genérica**, no una 
  fuente específica. Las familias genéricas en CSS son **`serif`, `sans-serif`,** 
  **`monospace`, `cursive`**, y **`fantasy`**. No requieren comillas porque no se refieren a 
  una fuente específica, sino a un tipo general de diseño tipográfico. El 
  navegador selecciona una fuente predeterminada que coincida con ese estilo 
  genérico si no puede usar las fuentes anteriores en la lista.

Es una **práctica recomendada** en CSS incluir tanto una fuente específica (deseada) 
como una familia genérica como respaldo, como en **`font-family: "Arial", sans-serif;`**. 
Esto asegura que, si por alguna razón la fuente deseada no está disponible en el 
dispositivo del usuario, el navegador pueda utilizar una fuente de la familia 
genérica.

### 2. Tamaño del texto (Font Size):
* **Propiedad principal: `font-size`**
* **Descripción**: Controla el tamaño del texto. Puede especificarse en varias 
  unidades como **`px`, `em`, `rem`, `%`**, etc.
* **Ejemplo**:
```css
h1 {
    font-size: 36px;
}
p {
    font-size: 16px;
}
```
* **Dato extra**: Usar unidades relativas como em o rem facilita la creación de un 
  diseño responsivo.

### 3. Estilo de la fuente (Font Style):
* **Propiedad principal: `font-style`**
* **Descripción**: Controla el estilo de la fuente, como normal, cursiva o itálica.
* **Ejemplo**:
```css
em {
    font-style: italic;
}
```
* **Dato extra**: Es común aplicar **`font-style`: `italic`** a citas o énfasis.

### 4. Peso de la fuente (Font Weight):
* **Propiedad principal: `font-weight`**
* **Descripción**: Controla el grosor del texto, variando desde valores como **`normal`**, 
  **`bold`**, hasta números que van de **`100`** a **`900`**.
* **Ejemplo**:
```css
strong {
    font-weight: bold;
}
```
* **Dato extra**: Los valores numéricos permiten mayor precisión en el grosor de la 
  fuente.

### 5. Alineación del texto (Text Alignment):
* **Propiedad principal: `text-align`**
* **Descripción**: Define cómo se alinea el texto dentro de su contenedor. Los 
  valores comunes son **`left`, `right`, `center`**, y **`justify`**.
* **Ejemplo**:
```css
p {
    text-align: justify;
}
h1 {
    text-align: center;
}
```

### 6. Decoración del texto (Text Decoration):
* **Propiedad principal: `text-decoration`**
* **Descripción**: Controla la decoración del texto, como subrayado, línea 
  sobrepuesta, o tachado.
* **Ejemplo**:
```css
a {
    text-decoration: underline;
}
del {
    text-decoration: line-through;
}
```

### 7. Transformación del texto (Text Transform):
* **Propiedad principal: `text-transform`**
* **Descripción**: Controla la capitalización del texto, con valores como **`uppercase`**, 
  **`lowercase`**, y **`capitalize`**.
* **Ejemplo**:
```css
h2 {
    text-transform: uppercase;
}
```

### 8. Espaciado entre letras (Letter Spacing):
* **Propiedad principal: `letter-spacing`**
* **Descripción**: Ajusta el espacio entre caracteres de un texto.
* **Ejemplo**:
```css
h1 {
    letter-spacing: 2px;
}
```

### 9. Altura de línea (Line Height):
* **Propiedad principal: `line-height`**
* **Descripción**: Define la altura de una línea de texto, afectando el espaciado 
  vertical entre líneas.
* **Ejemplo**:
```css
p {
    line-height: 1.5;
}
```

## Fondo en CSS:
CSS proporciona una serie de propiedades para controlar el fondo de los elementos 
en una página web. Estas propiedades permiten definir colores de fondo, imágenes, 
y cómo estos se comportan en relación con el contenido del elemento.

### Propiedades principales:
#### 1. `background-color`:
* **Descripción**: Define el color de fondo de un elemento.
* **Ejemplo**:
```css
body {
    background-color: #f0f0f0; /* Gris claro */
}
```

#### 2. `background-image`:
* **Descripción**: Establece una imagen como fondo de un elemento.
* **Ejemplo**:
```css
div {
    background-image: url('imagen.jpg');
}
```
* **Dato extra**: Se puede usar con imágenes repetitivas o como fondo decorativo.

#### 3. `background-repeat`:
* **Descripción**: Controla cómo se repite la imagen de fondo.
* **Valores comunes: `repeat`, `no-repeat`, `repeat-x`, `repeat-y`.**
* **Ejemplo**:
```css
div {
    background-image: url('imagen.jpg');
    background-repeat: no-repeat;
}
```

#### 4. `background-position`:
* **Descripción**: Define la posición inicial de la imagen de fondo.
* **Valores comunes: `top`, `bottom`, `left`, `right`, `center`**.
* **Ejemplo**:
```css
div {
    background-image: url('imagen.jpg');
    background-position: center center;
}
```

#### 5. `background-size`:
* **Descripción**: Controla el tamaño de la imagen de fondo.
* **Valores comunes: `auto`, `cover`, `contain`.**
* **Ejemplo**:
```css
div {
    background-image: url('imagen.jpg');
    background-size: cover;
}
```

#### 6. `background-attachment`:
* **Descripción**: Define si la imagen de fondo se desplaza con el contenido o 
  permanece fija.
* **Valores comunes: `scroll`, `fixed`, `local`.**
* **Ejemplo**:
```css
div {
    background-image: url('imagen.jpg');
    background-attachment: fixed;
}
```

#### 7. `background-clip`:
* **Descripción**: Especifica el área del fondo en la que se aplica el color de
  fondo o la imagen.
* **Valores comunes: `border-box`, `padding-box`, `content-box`.**
* **Ejemplo**:
```css
div {
    background-color: lightblue;
    background-clip: padding-box;
}
```

#### 8. `background-origin:`
* **Descripción**: Establece el punto de referencia para la posición del fondo.
* **Valores comunes: `padding-box`, `border-box`, `content-box`.**
* **Ejemplo**:
```css
div {
    background-image: url('imagen.jpg');
    background-origin: content-box;
}
```

### Propiedad abreviada background:
* **Descripción**: Permite definir todas las propiedades del fondo en una sola línea.
* **Ejemplo**:
```css
div {
    background: url('imagen.jpg') no-repeat center center / cover fixed;
}
```

### Ejemplo completo:
```css
body {
    background-color: #f0f0f0; /* Fondo gris claro */
}

div {
    background-image: url('imagen.jpg');
    background-repeat: no-repeat;
    background-position: center;
    background-size: cover;
    background-attachment: fixed;
}
```

---
## Unidades de Medida Absoluta en CSS:
Las unidades de medida absolutas en CSS se refieren a unidades que tienen un 
tamaño fijo, independiente del entorno de visualización, como el dispositivo o 
la pantalla. Estas unidades son especialmente útiles cuando se necesita un 
control preciso y consistente del tamaño, independientemente de las 
configuraciones del usuario o del dispositivo.

### Principales Unidades de Medida Absoluta:
#### 1. `px` (píxeles):
* **Descripción**: Un píxel es la unidad más básica de medida en pantallas. En la 
  mayoría de los casos, 1px equivale a un píxel físico en la pantalla.
* **Uso común**: Ancho de bordes, tamaño de fuentes, márgenes y rellenos.
* **Ejemplo**:
```css
p {
    font-size: 16px;
}
```

#### 2. `cm` (centímetros):
* **Descripción**: Un centímetro es una unidad de medida basada en el sistema métrico.
* **Uso común**: Más utilizada en impresión o en situaciones donde se necesita medir 
  en términos físicos.
* **Ejemplo**:
```css
div {
    width: 10cm;
}
```

#### 3. `mm` (milímetros):
* **Descripción**: Un milímetro es 1/10 de un centímetro. Como los centímetros, los 
  milímetros se utilizan principalmente para medios impresos.
* **Uso común**: Precisión en impresiones o diseños específicos.
* **Ejemplo**:
```css
div {
    width: 50mm;
}
```

#### 4. `in` (pulgadas):
* **Descripción**: Una pulgada es equivalente a 2.54 centímetros. Es otra unidad de 
  medida basada en el sistema imperial.
* **Uso común**: Principalmente en impresión, donde las dimensiones físicas son 
  importantes.
* **Ejemplo**:
```css
div {
    width: 2in;
}
```

#### 5. `pt` (puntos):
* **Descripción**: Un punto es igual a 1/72 de una pulgada. Esta unidad se usa 
  comúnmente en tipografía.
* **Uso común**: Principalmente en la definición del tamaño de fuentes para impresión.
* **Ejemplo**:
```css
p {
    font-size: 12pt;
}
```

#### 6. `pc` (picas):
* **Descripción**: Una pica equivale a 12 puntos, o 1/6 de pulgada. Es otra unidad 
  tipográfica.
* **Uso común**: Tipografía en diseño gráfico y editorial.
* **Ejemplo**:
```css
div {
    width: 3pc;
}
```

### Comparación y Uso:
* **Pantallas vs. Impresión**: Las unidades como **`px`** se utilizan principalmente en 
  pantallas, mientras que **`cm`, `mm`, `in`, `pt`**, y **`pc`** son más comunes en 
  medios impresos donde se requiere una medida física exacta.
* **Consistencia**: Las unidades absolutas aseguran que el tamaño se mantenga 
  constante sin importar el dispositivo o la configuración del usuario, lo que 
  puede ser útil en ciertos contextos, aunque a menudo es preferible utilizar 
  unidades relativas para lograr un diseño responsivo.

---
## Unidades Relativas en CSS:
Las unidades relativas en CSS son aquellas que se definen en relación con otra 
medida, ya sea el tamaño del contenedor, la raíz del documento, o la 
configuración del navegador. Estas unidades permiten crear diseños más flexibles 
y adaptables.

### Principales Unidades Relativas:
#### 1. `em`:
* **Descripción**: Relativa al tamaño de la fuente del elemento padre.
* **Ejemplo**:
```css
p {
    font-size: 2em; /* 2 veces el tamaño de la fuente del padre */
}
```

#### 2. `rem`
* **Descripción**: Relativa al tamaño de la fuente de la raíz del documento 
  (normalmente **`<html>`**).
* **Ejemplo**:
```css
p {
    font-size: 1.5rem; /* 1.5 veces el tamaño de la fuente raíz */
}
```

#### 3. `%` (Porcentaje)
* **Descripción**: Relativa al tamaño del contenedor padre, comúnmente utilizada para 
  el ancho y alto.
* **Ejemplo**:
```css
div {
    width: 50%; /* 50% del ancho del contenedor padre */
}
```
> **Nota:** En la mayoría de los casos, cuando utilizas un porcentaje en CSS, 
> estás especificando un tamaño relativo al contenedor padre del elemento, lo 
> que hace que el diseño sea flexible y se adapte a diferentes tamaños de 
> contenedores.

#### 4. `vh` (Viewport Height):
* **Descripción**: Relativa al 1% de la altura de la ventana gráfica (viewport).
* **Ejemplo**:
```css
div {
    height: 50vh; /* 50% de la altura de la ventana gráfica */
}
```

#### 5. `vw` (Viewport Width):
* **Descripción**: Relativa al 1% del ancho de la ventana gráfica (viewport).
* **Ejemplo**:
```css
div {
    width: 80vw; /* 80% del ancho de la ventana gráfica */
}
```

#### 6. `vmin` y `vmax`:
* **Descripción**:
* **`vmin`**: Relativa al 1% de la dimensión más pequeña del viewport (altura o ancho).
* **`vmax`**: Relativa al 1% de la dimensión más grande del viewport.
* **Ejemplo**:
```css
div {
    width: 50vmin; /* 50% de la dimensión más pequeña del viewport */
}
```
**`vmin`** y **`vmax`** permiten establecer tamaños relativos en función de cuántas 
veces el 1% del ancho o alto del viewport, dependiendo de cuál sea más pequeño o 
más grande, respectivamente.

---
## Modelos de Caja en CSS:
El modelo de caja es un concepto fundamental en CSS que describe cómo se 
estructuran y se comportan los elementos en una página web. Cada elemento en CSS 
es una "caja" que contiene el contenido, el relleno, el borde y el margen.

### Diagrama
<img src="./box-model.svg" alt="Modelo de Caja CSS" width="300" height="300">

### Componentes del Modelo de Caja:
#### 1. Contenido (Content):
* **Descripción**: Es el área donde se muestra el contenido del elemento, como texto, 
  imágenes, etc.
* **Propiedades relevantes: `width`, `height`.**
* **Ejemplo**:
```css
div {
    width: 200px;
    height: 100px;
}
```

#### 2. Relleno (Padding):
* **Descripción**: Espacio entre el contenido y el borde del elemento. El relleno 
  aumenta el tamaño total de la caja.
* **Propiedades relevantes: `padding`, `padding-top`, `padding-right`, `padding-bottom`,** 
* **`padding-left`**.
* **Ejemplo**:
```css
div {
    padding: 20px;
}
```

#### 3. Borde (Border):
* **Descripción**: Línea que rodea el contenido y el relleno. Puede tener grosor, 
  estilo y color.
* **Propiedades relevantes: `border`, `border-width`, `border-style`, `border-color`.**
* **Ejemplo**:
```css
div {
    border: 2px solid black;
}
```

#### 4. Margen (Margin):
* **Descripción**: Espacio fuera del borde, separa el elemento de otros elementos 
  adyacentes.
* **Propiedades relevantes: `margin`, `margin-top`, `margin-right`, `margin-bottom`,**
* **`margin-left.`**
* **Ejemplo**:
```css
div {
    margin: 15px;
}
```

### Modelo de Caja Estándar (Content-Box):
* **Descripción**: En el modelo de caja estándar, las propiedades **`width`** y **`height`** 
  solo aplican al área del contenido. El relleno y el borde se suman al tamaño 
  total de la caja.
* **Ejemplo**:
```css
div {
    width: 200px;
    padding: 20px;
    border: 5px solid black;
}
```
* **Tamaño total**:
  * **Ancho total: `200px (contenido) + 20px (relleno) x 2 + 5px (borde) x 2 = 250px`**
  * **Alto total: `100px (contenido) + 20px (relleno) x 2 + 5px (borde) x 2 = 150px`**

### Modelo de Caja Alternativo (Border-Box):
* **Descripción**: En el modelo **`border-box`**, las propiedades **`width`** y **`height`**
  incluyen el contenido, el relleno y el borde, lo que simplifica el cálculo del 
  tamaño total de la caja.
* **Ejemplo**:
```css
div {
    box-sizing: border-box;
    width: 200px;
    padding: 20px;
    border: 5px solid black;
}
```
* **Tamaño total**:
  * **Ancho total** = 200px
  * **Alto total** = 100px

### Ejemplo Visual Completo:
```css
div {
    width: 200px;
    height: 100px;
    padding: 20px;
    border: 5px solid black;
    margin: 15px;
    box-sizing: border-box; /* Usa border-box para simplificar el tamaño total */
}
```

---
## Restablecimiento de Propiedades por Defecto en CSS:
El restablecimiento de propiedades por defecto en CSS se refiere a la práctica 
de eliminar o normalizar los márgenes, rellenos, y otros estilos predeterminados 
que los navegadores aplican a los elementos HTML. Esto se suele hacer para 
asegurar un comportamiento consistente en todos los navegadores, ya que cada uno 
tiene su propia configuración por defecto.

### Ejemplo Común de Restablecimiento:
```css
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}
```
* **`*`**: Es el selector universal, que aplica las reglas a todos los elementos de 
  la página.
* **`margin: 0`; y `padding: 0;`**: Elimina todos los márgenes y rellenos predeterminados.
* **`box-sizing: border-box;`**: Cambia el modelo de caja para incluir el padding y el 
  borde dentro del ancho y alto declarados.

### Uso de `* { margin: 0; padding: 0; }:`
Es una práctica que puede ser útil en ciertos contextos, pero no es la más óptima 
para todos los casos debido a posibles problemas de rendimiento.
### Práctica Profesional Recomendada: 
Utilizar **`Normalize.css`** o un archivo de CSS Reset adecuado para manejar las 
inconsistencias entre navegadores es una mejor práctica, más alineada con las 
necesidades de desarrollo moderno.

---
## Propiedad `display` en CSS:
La propiedad `display` en CSS es una de las más fundamentales, ya que controla cómo 
se muestran y organizan los elementos en la página web. Define el modelo de caja 
utilizado por un elemento y cómo interactúa con otros elementos a su alrededor.

### Valores Comunes de `display`:
#### 1. `display: block;`:
* **Descripción**: El elemento se comporta como un bloque, ocupando todo el ancho 
  disponible de su contenedor. Comienza en una nueva línea y otros elementos 
  también comienzan en nuevas líneas.
* **Ejemplo**:
```css
div {
    display: block;
}
```
* **Aplicación típica**: Elementos como **`<div>`, `<p>`, `<h1>`**.

#### 2. `display: inline;`:
* **Descripción**: El elemento se comporta como un contenido en línea, ocupando solo 
  el espacio necesario y permitiendo que otros elementos se sitúen a su lado en 
  la misma línea.
* **Ejemplo**:
```css
span {
    display: inline;
}
```
* **Aplicación típica**: Elementos como **`<span>`, `<a>`, `<strong>`**.

#### 3. `display: inline-block;`:
* **Descripción**: Combina las características de **`inline`** y **`block`**. El elemento se 
  comporta como un contenido en línea, pero se puede dar dimensiones (ancho, alto) 
  como un bloque.
* **Ejemplo**:
```css
img {
    display: inline-block;
}
```
* **Aplicación típica**: Botones, imágenes, menús horizontales.

#### 4.`display: none;`:
* **Descripción**: El elemento no se muestra en la página y no ocupa espacio en el 
  layout.
* **Ejemplo**:
```css
.oculto {
    display: none;
}
```
* **Aplicación típica**: Ocultar temporalmente contenido o elementos interactivos.

#### 5. `display: flex;`:
* **Descripción**: Convierte el contenedor en un contenedor flexible (flexbox), lo 
  que facilita la alineación y distribución de los elementos hijos en direcciones 
  horizontal o vertical.
* **Ejemplo**:
```css
.contenedor {
    display: flex;
}
```
* **Aplicación típica**: Layouts modernos y dinámicos que requieren alineación y 
  distribución sofisticadas.

#### 6. `display: grid;`:
* **Descripción**: Convierte el contenedor en un contenedor de cuadrícula (grid), 
  permitiendo la alineación y distribución de los elementos hijos en filas y 
  columnas.
* **Ejemplo**:
```css
.contenedor {
    display: grid;
}
```
* **Aplicación típica**: Layouts complejos que requieren control preciso sobre filas 
  y columnas.

#### 4. `display: inline-flex;` y `display: inline-grid;`:
* **Descripción**: Versiones en línea de flex y grid, permitiendo que el contenedor 
  ocupe solo el espacio necesario mientras mantiene las propiedades de flexbox o 
  grid.
* **Ejemplo**:
```css
.item {
    display: inline-flex;
}
```

---








