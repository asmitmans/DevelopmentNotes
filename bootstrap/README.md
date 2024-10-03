## Bootstrap

- [Bootstrap](#bootstrap)
- [Introducción a Bootstrap](#introducción-a-bootstrap)
- [Integrando CDN de Bootstrap](#integrando-cdn-de-bootstrap)
- [Documentación oficial de Bootstrap](#documentación-oficial-de-bootstrap)
- [Integrando Bootstrap mediante Descarga](#integrando-bootstrap-mediante-descarga)
- [Sistema de Grillas de Bootstrap](#sistema-de-grillas-de-bootstrap)
- [Simular grid y flexbox de CSS en Bootstrap](#simular-grid-y-flexbox-de-css-en-bootstrap)
- [Mobile First](#mobile-first)
- [Mobile First en Bootstrap](#mobile-first-en-bootstrap)
- [Uso de Media Queries](#uso-de-media-queries)
- [Diseño Responsivo en Bootstrap](#diseño-responsivo-en-bootstrap)
- [Componentes de Bootstrap](#componentes-de-bootstrap)
- [Contenedores de Bootstrap](#contenedores-de-bootstrap)
- [Modificadores de Textos con Bootstrap](#modificadores-de-textos-con-bootstrap)
- [Márgenes y Paddings](#márgenes-y-paddings)
- [Background Color en Bootstrap](#background-color-en-bootstrap)
- [Componentes Avanzados de Bootstrap](#componentes-avanzados-de-bootstrap)
- [Bootstrap JS: Popover, Modal, Tooltip y Dropdown](#bootstrap-js-popover-modal-tooltip-y-dropdown)
- [Uso de `data-*` Atributos en Bootstrap](#uso-de-data--atributos-en-bootstrap)
- [Uso de data-\* atributos](#uso-de-data--atributos)
- [Carousel](#carousel)


## Introducción a Bootstrap
### Framework
Un framework es una estructura de software reutilizable que proporciona un 
conjunto de herramientas y librerías para desarrollar aplicaciones de manera más 
eficiente. Su objetivo es estandarizar el desarrollo, facilitando tareas comunes 
y proporcionando patrones predefinidos.

### Framework CSS
Un framework CSS es una colección de estilos y componentes predefinidos que 
facilitan el diseño y la creación de interfaces web. Estos frameworks 
proporcionan reglas CSS, sistemas de grid, tipografías, y componentes UI 
(botones, formularios, etc.) que ahorran tiempo y esfuerzo en el diseño 
responsivo.

### Bootstrap
Bootstrap es un framework CSS de código abierto desarrollado por Twitter. Está 
diseñado para crear rápidamente interfaces de usuario responsivas y móviles.

#### Características principales:

* **Grid System:** Un sistema de cuadrícula flexible y responsivo basado en columnas.
* **Componentes Reutilizables:** Incluye botones, navbars, modales, formularios y 
  otros elementos de interfaz.
* **Diseño Responsivo:** Permite crear diseños que se adaptan a diferentes tamaños 
  de pantalla.
* **Personalización:** Permite modificar variables Sass y componentes para adaptar 
  el estilo.
* **Compatibilidad:** Funciona con las últimas versiones de los navegadores más 
  comunes.

Bootstrap es ampliamente utilizado debido a su simplicidad, consistencia y 
amplia documentación oficial.

---

## Integrando CDN de Bootstrap

### Agregar el recurso CSS
Para usar Bootstrap de manera rápida en un proyecto, se puede integrar el CSS 
desde la CDN oficial. Esto permite cargar los estilos de Bootstrap desde 
servidores externos sin necesidad de instalar nada localmente.

#### Pasos esenciales:
1. **Agregar el siguiente** `<link>` en el `<head>` de tu archivo HTML:

```html
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/css/bootstrap.min.css">
```
Esto asegura que todas las clases de estilos de Bootstrap estén disponibles.

### JavaScript
Bootstrap utiliza algunas funcionalidades de JavaScript para interactuar con 
componentes dinámicos como modales, tooltips, y otros. La integración de 
JavaScript desde la CDN también es sencilla.

#### Pasos esenciales:

1. **Agregar el siguiente** `<script>` antes del cierre del `<body>`:

```html
<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
```
Esto incluirá tanto el propio JavaScript de Bootstrap como Popper.js, necesario 
para ciertos componentes como tooltips y dropdowns.

Ambos recursos, CSS y JavaScript, son esenciales para que el framework funcione 
correctamente y se aprovechen todas sus funcionalidades.

---

## Documentación oficial de Bootstrap

La documentación oficial de Bootstrap se encuentra en: https://getbootstrap.com/ 

Es el recurso más actualizado y detallado para aprender sobre la integración, 
componentes, utilidades y ejemplos de uso del framework.

---

## Integrando Bootstrap mediante Descarga

`#Revisar`

En lugar de usar una CDN, puedes descargar Bootstrap para tener todos sus 
archivos localmente. Esto es útil si deseas un mayor control sobre los archivos, 
trabajar offline, o personalizar el framework.

### Pasos para integrar Bootstrap mediante descarga:

1. **Descargar Bootstrap**: Ve a la página oficial de descarga de Bootstrap: 
   https://getbootstrap.com/docs/5.3/getting-started/download/.
Aquí puedes descargar la versión compilada y minificada o el código fuente 
completo.

2. **Estructura de Archivos**: Descomprime el archivo descargado. Encontrarás al 
   menos dos carpetas principales:

   * `css/`: Contiene los archivos CSS de Bootstrap.
   * `js/`: Contiene los archivos JavaScript de Bootstrap y Popper.js.

3. **Incluir el CSS**: Agrega el archivo CSS a tu proyecto añadiendo un `<link>` en el 
   `<head>` de tu archivo HTML:

   ```html
   <link rel="stylesheet" href="path/to/bootstrap/css/bootstrap.min.css">
   ```
   Asegúrate de reemplazar `path/to/bootstrap` con la ruta correcta a los 
   archivos en tu proyecto.

4. **Incluir el JavaScript**: Agrega el archivo JavaScript de Bootstrap antes del 
   cierre del `<body>`:

   ```html
   <script src="path/to/bootstrap/js/bootstrap.bundle.min.js"></script>
   ```
   Este archivo incluye tanto el JavaScript de Bootstrap como Popper.js.

Una vez integrados, puedes utilizar todas las características y componentes de 
Bootstrap en tu proyecto de manera local.

---

## Sistema de Grillas de Bootstrap

El sistema de grillas (grid system) es el componente principal de Bootstrap para 
crear layouts responsivos. Se basa en una cuadrícula de 12 columnas, y permite 
organizar el contenido fácilmente con filas y columnas que se adaptan a 
diferentes tamaños de pantalla.

### Conceptos Clave:
1. **Contenedores (`.container`, `.container-fluid`):**
   Son elementos de envoltura que alinean y centran el contenido.
   * `.container`: Tiene un ancho fijo y se ajusta automáticamente según el tamaño de pantalla.
   * `.container-fluid`: Ocupa el 100% del ancho de la pantalla.

2. **Filas (`.row`):**
   Las filas contienen columnas y aseguran que estas se alineen correctamente. Deben ser hijos directos de un contenedor.

3. **Columnas (`.col`):**
   Se utilizan para dividir el espacio dentro de una fila. Bootstrap permite 12 columnas por fila y estas pueden combinarse para ajustar su ancho (por ejemplo, `.col-6` para ocupar 6 de las 12 columnas).

### Tamaños de Pantalla (Breakpoints):
Las columnas pueden ajustarse según el tamaño de la pantalla, usando los 
siguientes prefijos:
* `.col-sm-`: Pequeñas (≥576px).
* `.col-md-`: Medianas (≥768px).
* `.col-lg-`: Grandes (≥992px).
* `.col-xl-`: Extra grandes (≥1200px).
* `.col-xxl-`: Extra extra grandes (≥1400px).

#### Ejemplo de Uso:
* **Distribución Equitativa:**
  Si quieres que todas las columnas de una fila se distribuyan equitativamente:
```html
<div class="container">
  <div class="row">
    <div class="col">Columna 1</div>
    <div class="col">Columna 2</div>
    <div class="col">Columna 3</div>
  </div>
</div>
```
* **Distribución Específica:**
  Si quieres que una columna ocupe un espacio mayor:
```html
<div class="container">
  <div class="row">
    <div class="col-8">Columna grande</div>
    <div class="col-4">Columna pequeña</div>
  </div>
</div>
```

### Ejemplo Práctico de Uso Responsivo:
El siguiente ejemplo muestra cómo una columna cambia de tamaño según el ancho de 
la pantalla:

```html
<div class="col-12 col-sm-6 col-md-4 col-lg-3">
  <img src="ruta_imagen.extension" alt="Texto alternativo" class="img-fluid">
</div>
```
En este caso:
* En pantallas muy pequeñas (por debajo de `576px`), la columna ocupará las 12 
  columnas completas.
* En pantallas pequeñas (`≥576px`), ocupará 6 columnas (la mitad del ancho).
* En pantallas medianas (`≥768px`), ocupará 4 columnas (un tercio del ancho).
* En pantallas grandes (`≥992px`), ocupará 3 columnas (un cuarto del ancho).

El uso de la clase `img-fluid` hace que la imagen sea responsiva, ajustándose al 
ancho de su contenedor sin perder proporción.

---

## Simular grid y flexbox de CSS en Bootstrap

`#Revisar`

### 1. Simular CSS Grid con Bootstrap
```html
<div class="container">
  <div class="row">
    <div class="col-6">Columna 1</div>
    <div class="col-6">Columna 2</div>
  </div>
  <div class="row">
    <div class="col-4">Columna 3</div>
    <div class="col-4">Columna 4</div>
    <div class="col-4">Columna 5</div>
  </div>
</div>
```
**Descripción:**
* La primera fila tiene dos columnas que ocupan el 50% del ancho cada una.
* La segunda fila tiene tres columnas, cada una ocupando un tercio del ancho.

### 2. Flexbox no responsiva con Bootstrap
```html
<div class="d-flex justify-content-between">
  <div>Elemento 1</div>
  <div>Elemento 2</div>
  <div>Elemento 3</div>
</div>
```
**Descripción:**
* Los elementos se distribuyen con espacio entre ellos, pero no se mueven hacia 
  abajo si no caben.

### 3. Flexbox responsiva con Bootstrap
```html
<div class="d-flex flex-wrap">
  <div class="p-2">Elemento 1</div>
  <div class="p-2">Elemento 2</div>
  <div class="p-2">Elemento 3</div>
  <div class="p-2">Elemento 4</div>
</div>
```
**Descripción:**
* La clase `flex-wrap` permite que los elementos se muevan hacia abajo 
  automáticamente si no caben en la misma línea.
* Los elementos se envuelven para ajustarse al ancho disponible.

---

## Mobile First

### ¿Qué es?
"Mobile First" es una estrategia de diseño y desarrollo web que prioriza la 
creación de experiencias optimizadas para dispositivos móviles antes de 
adaptarlas a pantallas más grandes (tabletas y ordenadores de escritorio). La 
idea es enfocarse en el contenido esencial y la usabilidad en pantallas pequeñas 
y luego escalar hacia versiones más complejas a medida que aumenta el tamaño de 
la pantalla.

### Características:
* **Prioriza el Contenido Esencial:** La información y funciones más importantes se 
  presentan de manera clara y accesible en dispositivos móviles.
* **Adaptabilidad y Escalabilidad:** El diseño se basa en expandir y agregar 
  elementos a medida que aumenta el tamaño de la pantalla, en lugar de reducir y 
  eliminar funciones de un diseño de escritorio.
* **Uso de Media Queries Min-width:** La técnica principal en CSS para "Mobile 
  First" consiste en escribir estilos base para pantallas móviles y luego usar 
  media queries con min-width para añadir estilos adicionales para pantallas más 
  grandes.
* **Rendimiento Mejorado:** Al centrarse primero en dispositivos móviles, que suelen 
  tener conexiones de red y hardware más limitados, se fomenta la creación de 
  experiencias rápidas y optimizadas.

La estrategia "Mobile First" es clave para garantizar una experiencia de usuario 
consistente y efectiva a través de múltiples dispositivos y tamaños de pantalla.

---

## Mobile First en Bootstrap
Bootstrap adopta un enfoque "Mobile First" en su diseño y desarrollo. Esto 
significa que todos los estilos base y funcionalidades están optimizados para 
dispositivos móviles, y luego se adaptan a pantallas más grandes mediante media 
queries.

### Características específicas de Mobile First en Bootstrap:
* **Estilos base para dispositivos móviles:** Todos los componentes de Bootstrap 
  están diseñados inicialmente para pantallas pequeñas. A medida que el tamaño 
  de la pantalla aumenta, se añaden reglas adicionales.

* **Media Queries de `min-width`:** Bootstrap utiliza breakpoints con `min-width` para 
  aplicar estilos adicionales según el tamaño de pantalla. Esto sigue el enfoque 
  "Mobile First", ya que los estilos se construyen de menor a mayor (de móvil a 
  escritorio). Ejemplo de breakpoints:

  * **`sm` (≥576px):** Pequeñas pantallas (tabletas).
  * **`md` (≥768px):** Pantallas medianas.
  * **`lg` (≥992px):** Pantallas grandes (desktops).
  * **`xl` (≥1200px):** Pantallas extra grandes.
  * **`xxl` (≥1400px):** Pantallas extra extra grandes.
  
* **Componentes adaptables:** Todos los componentes, como navbars, grids y tarjetas, 
  están diseñados para ser responsivos y adaptarse al tamaño de pantalla de 
  forma progresiva.

### Ejemplo de cómo se refleja Mobile First en Bootstrap:
Una columna en Bootstrap se adapta de acuerdo con el tamaño de la pantalla, 
usando breakpoints:

```html
<div class="col-12 col-sm-6 col-md-4 col-lg-3">Contenido</div>
```
**Comportamiento:**
* **Móvil (`<576px`):** La columna ocupa el ancho completo (`col-12`).
* **Pequeña (`≥576px`):** La columna ocupa la mitad del ancho (`col-sm-6`).
* **Mediana (`≥768px`):** La columna ocupa un tercio del ancho (`col-md-4`).
* **Grande (`≥992px`):** La columna ocupa un cuarto del ancho (`col-lg-3`).
 
Bootstrap facilita el diseño responsivo desde una perspectiva "Mobile First", 
asegurando que la experiencia sea fluida desde móviles hasta desktops.

---

## Uso de Media Queries

### ¿Qué es?
Las media queries son reglas de CSS que permiten aplicar estilos de manera 
condicional en función de características del dispositivo o la ventana de 
visualización (viewport), como el ancho de la pantalla, la orientación, y la 
resolución. Esto ayuda a crear diseños responsivos que se adaptan a diferentes 
tamaños y tipos de pantalla.

### Características:
* **Adaptabilidad:** Permite cambiar los estilos de una página web según el tamaño 
  de pantalla o tipo de dispositivo.

* **Condicionalidad:** Puedes aplicar estilos solo cuando se cumplen ciertas 
  condiciones (e.g., un ancho mínimo de pantalla).

* **Flexibilidad en diseño:** Permiten ajustar el layout, tipografía, y otros 
  elementos para que se vean y funcionen de manera óptima en diferentes 
  dispositivos (móviles, tabletas, desktops).

### Sintaxis Básica:
```css
@media (condition) {
  /* estilos aplicados cuando se cumple la condición */
}
```

### Ejemplos con Breakpoints Comunes:

#### 1. 576px (Pantallas pequeñas como móviles):

```css
@media (min-width: 576px) {
  .contenedor {
    background-color: lightblue;
  }
}
```
Esto aplicará un fondo azul claro cuando la pantalla tenga al menos 576px de
ancho.

#### 2. 760px (Tabletas pequeñas y móviles grandes):

```css
@media (min-width: 760px) {
  .contenedor {
    padding: 20px;
  }
}
```
Esto añade un `padding` de 20px a `.contenedor` si la pantalla es de al menos 760px 
de ancho.

#### 3. 992px (Pantallas medianas como tabletas y desktops pequeños):

```css
@media (min-width: 992px) {
  .contenedor {
    display: flex;
    flex-direction: row;
  }
}
```
Esto cambia el layout de `.contenedor` a un `flexbox` con dirección de filas en 
pantallas de al menos 992px.

#### 4. 1200px (Pantallas grandes como desktops):
```css
@media (min-width: 1200px) {
  .contenedor {
    max-width: 1200px;
    margin: auto;
  }
}
```
Aquí se limita el ancho máximo del contenedor y se centra el contenido si la 
pantalla tiene al menos 1200px de ancho.

### Orden Correcto para Media Queries
Para evitar conflictos, deben ordenarse de mayor a menor ancho (min-width), es 
decir, de pantallas grandes a pantallas pequeñas. Esto garantiza que las reglas 
más específicas para pantallas más grandes se apliquen correctamente, y luego se 
ajusten para pantallas más pequeñas.

#### Orden Recomendado (de mayor a menor ancho):
```css
/* Media query para pantallas grandes (desktops) */
@media (min-width: 1200px) {
  .contenedor {
    max-width: 1200px;
    margin: auto;
  }
}

/* Media query para pantallas medianas (tabletas y desktops pequeños) */
@media (min-width: 992px) {
  .contenedor {
    display: flex;
    flex-direction: row;
  }
}

/* Media query para tabletas pequeñas y móviles grandes */
@media (min-width: 760px) {
  .contenedor {
    padding: 20px;
  }
}

/* Media query para pantallas pequeñas (móviles) */
@media (min-width: 576px) {
  .contenedor {
    background-color: lightblue;
  }
}
```

#### ¿Por qué hacerlo así?
* **Especificidad Progresiva:** Las reglas más generales para pantallas pequeñas 
  están al final, mientras que las más específicas para pantallas grandes están 
  al principio.

* **Sobrescritura Correcta:** Los estilos para pantallas grandes se aplican primero, 
  y luego se sobrescriben si la pantalla es más pequeña, garantizando que solo 
  los estilos necesarios sean aplicados.

De esta manera, las media queries se aplican correctamente y evitas conflictos 
de estilos que puedan afectar el diseño responsivo.

---

## Diseño Responsivo en Bootstrap
Bootstrap facilita el diseño responsivo con herramientas específicas. Aquí se 
detallan algunos aspectos fundamentales para lograr un diseño responsivo 
efectivo con Bootstrap:

### 1. Usar la etiqueta `meta viewport`
La etiqueta `<meta name="viewport">` es esencial para que el diseño responsivo 
funcione correctamente. Controla cómo se ajusta la página al ancho de pantalla 
del dispositivo.

**En Bootstrap:**

```html
<meta name="viewport" content="width=device-width, initial-scale=1">
```
**Beneficio**: Esto permite que la página se adapte al ancho del dispositivo, 
asegurando que los elementos se muestren de forma correcta y escalada en 
pantallas pequeñas (móviles).

### 2. Usar Grillas
El sistema de grillas de Bootstrap (grid system) es la base para el diseño 
responsivo, basado en una cuadrícula de 12 columnas. Los breakpoints (`sm`, `md`, 
`lg`, `xl`, `xxl`) permiten ajustar la distribución de los elementos según el tamaño 
de pantalla.

**En Bootstrap:**

```html
<div class="container">
  <div class="row">
    <div class="col-sm-12 col-md-6">Columna 1</div>
    <div class="col-sm-12 col-md-6">Columna 2</div>
  </div>
</div>
```
**Beneficio:** Esto asegura que la disposición de los elementos cambie según el 
tamaño de pantalla, haciendo que el contenido sea legible y funcional.

### 3. Usar Imágenes
Las imágenes deben ser responsivas para ajustar su tamaño automáticamente al 
ancho del contenedor.

**En Bootstrap:**

```html
<img src="imagen.jpg" alt="Descripción" class="img-fluid">
```
**Beneficio:** La clase `img-fluid` hace que la imagen sea flexible y mantenga su 
proporción mientras se ajusta al tamaño del contenedor.

### 4. Considerar la Experiencia del Usuario
El diseño responsivo se enfoca en la usabilidad y la accesibilidad. Esto implica 
asegurar que los elementos interactivos (botones, menús) sean lo suficientemente 
grandes en pantallas pequeñas y que el contenido sea legible sin necesidad de 
hacer zoom.

**En Bootstrap:**
* Uso de componentes responsivos (`navbar`, `cards`).
  
* Uso de `spacing utilities` para ajustar márgenes y rellenos (`p-3`, `m-2`).

**Beneficio:** Facilita la navegación y mejora la experiencia en diferentes 
dispositivos.

> **Nota:** Las cards son responsivas en Bootstrap si utilizas clases como 
> `img-fluid` para las imágenes y usas el sistema de grillas para controlar cómo 
> se distribuyen las cards en diferentes tamaños de pantalla. Si las imágenes o 
> elementos internos tienen tamaños fijos, entonces la responsividad de las 
> cards se verá limitada.

### 5. Priorizar el Contenido de la Página Web
El diseño responsivo implica mostrar u ocultar elementos según el tamaño de 
pantalla para mejorar la experiencia del usuario.

**En Bootstrap:**

```html
<div class="d-none d-md-block">Contenido visible solo en pantallas medianas o más grandes</div>
<div class="d-block d-md-none">Contenido visible solo en pantallas pequeñas</div>
```
**Beneficio:** Permite mostrar solo el contenido relevante para cada tipo de 
dispositivo, manteniendo la interfaz limpia y fácil de usar.

---

## Componentes de Bootstrap

`#Revisar`

Bootstrap proporciona una variedad de componentes predefinidos que permiten 
crear interfaces web de manera rápida y fácil. A continuación, se detallan 
algunos de los componentes más utilizados junto con ejemplos de uso.

> **Dato importante**:
> * Los componentes de Bootstrap están compuestos de clases que colaboran para 
>   que el componente se muestre de la manera que se expone en la documentación.
> * Cuando quieras modificar o personalizar los estilos de un componente, es 
>   importante identificar las clases involucradas y utilizar el inspector de 
>   elementos para detallar las propiedades de CSS aplicadas.

### Navbar
La **Navbar** es un componente de navegación flexible que se adapta a diferentes 
tamaños de pantalla.

#### Uso básico de Navbar:
```html
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="#">Inicio</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Enlace</a>
      </li>
    </ul>
  </div>
</nav>
```

#### Características:
* La clase `navbar-expand-lg` permite que la navbar se colapse en pantallas 
  pequeñas.
* `navbar-light` y `bg-light` aplican estilos claros al texto y fondo.

### Button
Los **botones** son componentes básicos que se pueden personalizar con diferentes 
clases.

#### Uso básico de Button:
```html
<button type="button" class="btn btn-primary">Botón Primario</button>
<button type="button" class="btn btn-secondary">Botón Secundario</button>
```

#### Características:
* La clase `btn` es la base de todos los botones.
* La clase `btn-primary` define el estilo del botón, en este caso un botón con 
  color azul por defecto. Otros estilos disponibles son `btn-secondary`, 
  `btn-success`, `btn-danger`, etc.


### Accordion
El **Accordion** es un componente de Bootstrap para mostrar y ocultar contenido de 
forma colapsable.

#### Uso básico de Accordion:
```html
<div class="accordion" id="accordionExample">
  <div class="accordion-item">
    <h2 class="accordion-header" id="headingOne">
      <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne">
        Sección 1
      </button>
    </h2>
    <div id="collapseOne" class="accordion-collapse collapse show" data-bs-parent="#accordionExample">
      <div class="accordion-body">
        Contenido de la sección 1.
      </div>
    </div>
  </div>
</div>
```

#### Características:
* `accordion` crea un contenedor para el componente.
* `accordion-button` define el botón que muestra u oculta el contenido.
* `accordion-collapse` controla la visibilidad del contenido.


---

## Contenedores de Bootstrap

Los **contenedores** en Bootstrap son los elementos principales para alinear y 
centrar el contenido en la página, y sirven como base para el diseño responsivo.

### `Container`

#### Características:
* **Centro y Alineación:** Los contenedores proporcionan un ancho máximo y centran 
  el contenido horizontalmente en la página.

* **Tipos de Contenedores:**
  * **`.container:`** Tiene un ancho fijo y cambia según el tamaño de pantalla (sm, 
    md, lg, xl, xxl).
  * **`.container-fluid:`** Ocupa el 100% del ancho de la pantalla independientemente 
    del tamaño del viewport.

---

## Modificadores de Textos con Bootstrap
Bootstrap incluye una serie de utilidades para estilizar y alinear textos, así 
como para aplicar márgenes y rellenos (padding). Aquí se resumen sus principales 
características.

### 1. Color
Bootstrap proporciona clases para cambiar el color del texto rápidamente.

* **Ejemplos de clases de color de texto:**
  * `.text-primary`: Azul (color primario).
  * `.text-secondary`: Gris oscuro.
  * `.text-success`: Verde.
  * `.text-danger`: Rojo.
  * `.text-warning`: Amarillo.
  * `.text-info`: Cian.
  * `.text-light`: Gris claro.
  * `.text-dark`: Gris oscuro.
  * `.text-white`: Blanco.
  * `.text-muted`: Gris más claro, para texto secundario.

### 2. Alineamiento del Texto
Utiliza clases para alinear el texto de diferentes formas.

* **Clases de alineación:**
  * `.text-start`: Alinea a la izquierda.
  * `.text-center`: Centra el texto.
  * `.text-end`: Alinea a la derecha.

### 3. Tamaño del Texto
Puedes ajustar el tamaño del texto con clases específicas.

* **Clases para cambiar el tamaño del texto:**
  * `.fs-1` a `.fs-6`: Cambian el tamaño de la fuente desde `fs-1` (más grande) a 
    `fs-6` (más pequeño).

### 4. Display
Para cambiar la propiedad de visualización de un texto (títulos grandes, 
encabezados), puedes usar las clases de display.

* **Clases de display:**
  * `.display-1` a `.display-6`: Aumentan el tamaño del texto progresivamente 
    (siendo `display-1` el más grande).

---

## Márgenes y Paddings
Bootstrap incluye utilidades para agregar márgenes (`m-`) y rellenos (`p-`). La 
sintaxis es flexible y te permite especificar de manera detallada el espacio a 
aplicar.

### Sintaxis General
`{propiedad}-{lado}-{tamaño}`

* **Propiedad:**
  * `m`: Margen.
  * `p`: Padding (relleno).

* **Lado:**
  * `t`: Top (arriba).
  * `b`: Bottom (abajo).
  * `s`: Start (left o `left` en idiomas LTR, `right` en RTL).
  * `e`: End (right o `right` en LTR, `left` en RTL).
  * `x`: Horizontal (left y right).
  * `y`: Vertical (top y bottom).
  * **Sin especificar lado:** Aplica a todos los lados.

* **Tamaño:**
* `0`: Elimina el margen o padding.
* `1` a `5`: Niveles progresivos de espacio (de pequeño a grande).
* `auto`: Ajusta automáticamente el margen.

### Ejemplos de uso:
* `.m-3`: Margen en todos los lados con tamaño 3.
* `.p-t-2`: Padding solo en la parte superior con tamaño 2.
* `.mx-auto`: Margen automático a los lados horizontales (usado para centrar elementos).
* `.mb-0`: Sin margen en la parte inferior.

---
## Background Color en Bootstrap

Puedes cambiar el fondo de un elemento con clases de colores predefinidos.

### Clases de background color:
* `.bg-primary`: Azul (color primario).
* `.bg-secondary`: Gris oscuro.
* `.bg-success`: Verde.
* `.bg-danger`: Rojo.
* `.bg-warning`: Amarillo.
* `.bg-info`: Cian.
* `.bg-light`: Gris claro.
* `.bg-dark`: Gris oscuro.
* `.bg-white`: Blanco.

**Ejemplo:**
```html
<div class="bg-primary text-white p-3">Fondo azul con texto blanco</div>
```

---

## Componentes Avanzados de Bootstrap
Bootstrap ofrece componentes avanzados que facilitan el diseño de interfaces más 
complejas y atractivas. Aquí se detallan algunos de los componentes más útiles y 
sus características.

### 1. Card
Las cards son contenedores flexibles que permiten organizar contenido y se componen de varios elementos opcionales como títulos, textos, imágenes, y botones.

#### Ejemplo de una Card Básica:

```html
<div class="card" style="width: 18rem;">
  <img src="imagen.jpg" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">Título de la card</h5>
    <p class="card-text">Texto de ejemplo dentro de la card.</p>
    <a href="#" class="btn btn-primary">Ir a algún lugar</a>
  </div>
</div>
```

#### Características:
* `.card`: Crea la estructura básica de la card.
* `.card-img-top`: Añade una imagen en la parte superior.
* `.card-body`: Contenedor del contenido principal de la card (título, texto, etc.).


### 2. Formulario
Bootstrap facilita la creación de formularios con componentes predefinidos para 
inputs, botones, y validación de datos.

#### Input Definidos para Formularios HTML:
* **Clases principales:**
  * `.form-control`: Para campos de texto, selects y textareas.
  * `.form-check`: Para checkbox y radio buttons.

* **Ejemplo de formulario básico:**
```html
<form>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Correo electrónico</label>
    <input type="email" class="form-control" id="exampleInputEmail1">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Contraseña</label>
    <input type="password" class="form-control" id="exampleInputPassword1">
  </div>
  <button type="submit" class="btn btn-primary">Enviar</button>
</form>
```


### 3. Carrusel
El carrusel es un componente que permite mostrar una serie de elementos 
(imágenes o contenido) de forma deslizable.

#### Ejemplo básico de Carrusel:
```html
<div id="carouselExample" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="imagen1.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="imagen2.jpg" class="d-block w-100" alt="...">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
    <span class="carousel-control-next-icon"></span>
  </button>
</div>
```

#### Características:
* `.carousel`: Contenedor principal del carrusel.
* `.carousel-inner`: Contenedor para las diapositivas del carrusel.
* `.carousel-item`: Cada diapositiva individual.


### 4. Alerta
Las alertas se usan para mostrar mensajes importantes de una manera visual.

#### Ejemplo básico de una Alerta:
```html
<div class="alert alert-warning" role="alert">
  Este es un mensaje de alerta de advertencia.
</div>
```

#### Clases principales:
* `.alert-primary`, `.alert-secondary`, `.alert-success`, `.alert-danger`, 
  `.alert-warning`, `.alert-info`, `.alert-light`, `.alert-dark`: Cambian el color y el 
estilo de la alerta.


Las alertas también pueden ser desmontables con un botón de cierre:

```html
<div class="alert alert-success alert-dismissible fade show" role="alert">
  Esta alerta puede cerrarse.
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>
```

---

## Bootstrap JS: Popover, Modal, Tooltip y Dropdown

`#Revisar`

Bootstrap JS ofrece componentes interactivos que mejoran la usabilidad de una 
página. Estos componentes añaden información adicional, ventanas emergentes, y 
menús desplegables de forma elegante y fácil de implementar.

### 1. Popover

El **popover** es un cuadro de información flotante similar a un tooltip, pero más 
robusto ya que puede incluir contenido HTML y más información.

### Cómo usar un Popover:

1. Incluye `data-bs-toggle="popover"` en el elemento objetivo.
2. Inicializa con JavaScript.

**Ejemplo:**
```html
<button type="button" class="btn btn-secondary" data-bs-toggle="popover" data-bs-content="Más información aquí">
  Haz clic para popover
</button>

<script>
  var popoverTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="popover"]'));
  var popoverList = popoverTriggerList.map(function (popoverTriggerEl) {
    return new bootstrap.Popover(popoverTriggerEl);
  });
</script>
```

### 2. Modal

El modal es una ventana emergente que se muestra sobre el contenido principal de 
la página, deshabilitando la interacción con el resto del contenido hasta que el 
modal se cierra.

### Cómo usar un Modal:

1. Crea la estructura HTML con `.modal`.
2. Abre el modal con un botón con `data-bs-toggle="modal"`.

**Ejemplo:**
```html
<!-- Botón que activa el modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#miModal">
  Abrir Modal
</button>

<!-- Estructura del Modal -->
<div class="modal fade" id="miModal" tabindex="-1" aria-labelledby="miModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="miModalLabel">Título del Modal</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Cerrar"></button>
      </div>
      <div class="modal-body">
        Contenido del Modal...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
        <button type="button" class="btn btn-primary">Guardar Cambios</button>
      </div>
    </div>
  </div>
</div>
```

### 3. Tooltip

El **tooltip** es una pequeña etiqueta flotante que muestra información breve al 
pasar el ratón o enfocar un elemento. Es similar al popover, pero más simple y 
solo soporta texto.

#### Cómo usar un Tooltip:

1. Añade `data-bs-toggle="tooltip"` al elemento objetivo.
2. Inicializa con JavaScript.

**Ejemplo:**
```html
<button type="button" class="btn btn-secondary" data-bs-toggle="tooltip" data-bs-placement="top" title="Información del botón">
  Pasa el ratón por aquí
</button>

<script>
  var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'));
  var tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
    return new bootstrap.Tooltip(tooltipTriggerEl);
  });
</script>
```

### 4. Dropdown

El **dropdown** es un componente para crear menús desplegables, que muestran una 
lista de opciones al hacer clic en un botón.

**Cómo usar un Dropdown:**

1. Añade `data-bs-toggle="dropdown"` a un botón.
2. Crea la lista con `.dropdown-menu`.

**Ejemplo:**
```html
<!-- Botón que activa el dropdown -->
<div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
    Menú desplegable
  </button>
  <!-- Lista del dropdown -->
  <ul class="dropdown-menu">
    <li><a class="dropdown-item" href="#">Acción 1</a></li>
    <li><a class="dropdown-item" href="#">Acción 2</a></li>
    <li><a class="dropdown-item" href="#">Otra acción</a></li>
  </ul>
</div>
```


### Inicialización con JavaScript

Para inicializar estos componentes, usa el archivo bootstrap.bundle.js, que 
incluye las funcionalidades de Bootstrap JS y Popper.js (necesario para 
popovers, tooltips y dropdowns).

---

## Uso de `data-*` Atributos en Bootstrap

### ¿Qué son los `data-*` Atributos?

Los **`data-*` atributos** son atributos personalizados permitidos por el 
estándar **HTML5** que permiten añadir información adicional a elementos HTML. 
Estos atributos pueden ser usados para extender el HTML de manera flexible y 
segura sin interferir con el funcionamiento estándar del elemento.

Bootstrap utiliza estos atributos como **`data-bs-*`** para activar y configurar 
componentes interactivos (como **modals**, **dropdowns**, y **tooltips**) sin 
necesidad de escribir código JavaScript explícito.

### ¿Por Qué Existen los `data-*` Atributos?

- **Extendibilidad del HTML:** HTML5 permite añadir atributos personalizados que 
  sigan el formato `data-*`. Esto da flexibilidad para almacenar datos adicionales 
  directamente en el HTML sin alterar la semántica de los elementos.

- **Compatibilidad con HTML Estándar:** Todos los navegadores modernos reconocen 
  los `data-*` atributos y los ignoran si no están siendo utilizados, lo que evita 
  errores y problemas de compatibilidad.

### Uso de `data-*` Atributos con Bootstrap

Bootstrap aprovecha los `data-*` atributos para hacer la inicialización de sus 
componentes interactivos de manera declarativa y simple. Por ejemplo, un botón 
para abrir un modal se puede definir solo con HTML de esta manera:

```html
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#miModal">
  Abrir Modal
</button>
```
En este caso:
* `data-bs-toggle="modal"`: Indica que este elemento activa un modal.
* `data-bs-target="#miModal`": Apunta al id del modal que se abrirá.
Gracias a estos atributos, Bootstrap no requiere que escribas JavaScript 
adicional para inicializar el componente.

### Cómo Usar y Acceder a los data-* Atributos

Los `data-*` atributos pueden ser usados en cualquier elemento HTML para almacenar 
información personalizada. Estos datos pueden ser accedidos y manipulados 
fácilmente con JavaScript a través de la propiedad .dataset.

**Ejemplo:**
`html`
<div data-user-id="12345" data-role="admin">
  Información del usuario
</div>
```

**Acceso con JavaScript:**
```js
const div = document.querySelector('div');
console.log(div.dataset.userId); // "12345"
console.log(div.dataset.role); // "admin"
```

---

## Uso de data-* atributos

El uso de **`data-*` atributos** es bastante común en el desarrollo con **JavaScript** 
**estándar** o **jQuery**, incluso fuera del contexto de frameworks como Bootstrap. Son 
utilizados para almacenar y asociar datos directamente con elementos del DOM de 
forma sencilla y semántica.


### Razones para Usar `data-*` Atributos

1. **Asociar Datos a Elementos del DOM:**
* Los `data-*` atributos permiten añadir información específica a los elementos 
  HTML de una forma que es fácil de acceder con JavaScript.

* Es una alternativa más limpia y semántica que sobrecargar clases (`class`) o 
  identificadores (`id`) para almacenar información adicional.

2. **Facilitar la Interacción JS-DOM:**
* Ayudan a conectar la lógica de JavaScript con el DOM al hacer que los datos 
  estén disponibles de forma declarativa.

* Permiten que ciertos datos permanezcan en el DOM y sean independientes de la 
  lógica de la aplicación (evitando mantener los datos solo en variables de JS).


### Ejemplos Comunes de Uso

**Ejemplo 1: Lista de Productos con data-* Atributos**
```html
<ul>
  <li data-product-id="101" data-category="electronics">Producto 1</li>
  <li data-product-id="102" data-category="books">Producto 2</li>
  <li data-product-id="103" data-category="clothing">Producto 3</li>
</ul>
```
En este caso, cada `<li>` contiene información adicional sobre el producto (como 
`product-id` y `category`) que puede ser utilizada por JavaScript para cualquier 
funcionalidad (por ejemplo, filtrado, selección).

**Ejemplo 2: Asociar Datos a un Botón**
```html
<button data-action="eliminar" data-item-id="456">
  Eliminar
</button>
```
En este caso, el botón tiene atributos `data-*` que indican la acción y el 
identificador del elemento a eliminar. Esto puede ser útil para manejar la 
lógica de eventos.

**Acceso con JavaScript:**

```js
const boton = document.querySelector('button');
console.log(boton.dataset.action); // "eliminar"
console.log(boton.dataset.itemId); // "456"
```

### Ventajas del Uso de `data-*` Atributos

* **Semántica y Claridad:** Los `data-*` atributos proporcionan una forma limpia de 
  añadir datos a elementos HTML sin afectar la estructura o estilo.

* **Accesibilidad con JavaScript:** Acceder y modificar datos con la propiedad 
  `.dataset` es simple y directo.

* **Evita Sobrecargar Clases/IDs:** Usar clases o IDs para almacenar datos 
  adicionales puede hacer que el código sea difícil de mantener y leer. Los 
  `data-*` atributos son una alternativa más semántica.


### ¿Cuándo Usar `data-*` Atributos?

1. **Para Almacenar Información Ligera:** Si necesitas asociar datos pequeños y 
   estáticos (como identificadores, estados, etc.) con elementos del DOM.

2. **Para Interacción JS-DOM Declarativa:** Cuando desees hacer tu lógica de 
   JavaScript más declarativa, como en el caso de eventos o elementos dinámicos.


### ¿Cuándo No Usarlos?

* **Datos Complejos o Grandes:** Si necesitas manejar datos grandes o complejos (por 
  ejemplo, objetos o arrays), es preferible usar variables de JavaScript u otros 
  mecanismos de almacenamiento (como `localStorage` o `sessionStorage`).

* **Datos Sensibles:** Los `data-*` atributos son visibles en el HTML y accesibles 
  para cualquier persona que inspeccione el DOM, por lo que no deben usarse para 
  datos sensibles o privados.

---

## Carousel

El carousel de Bootstrap es un componente que permite crear carruseles o sliders 
para mostrar una serie de elementos como imágenes, texto o contenido multimedia 
de forma deslizante. Es una manera efectiva de presentar contenido en un espacio 
compacto con transiciones animadas.


### Características del Carousel

* **Deslizable y Controlable:** Puedes navegar a través de los elementos de forma 
  automática o manual.

* **Responsivo:** Adapta su tamaño a diferentes pantallas.

* **Controles y Paginación:** Incluye controles para navegar y elementos indicadores 
  que muestran el progreso.


### Cómo Usar el Carousel

El carousel se define con una estructura HTML específica y se controla mediante 
los atributos de Bootstrap.

**Ejemplo de Código HTML para un Carousel:**
```html
<!-- Incluye los archivos CSS y JS de Bootstrap -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>

<!-- Carousel Container -->
<div id="miCarousel" class="carousel slide" data-bs-ride="carousel">
  
  <!-- Indicadores (Opcionales) -->
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#miCarousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#miCarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#miCarousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>

  <!-- Elementos del Carousel -->
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="imagen1.jpg" class="d-block w-100" alt="Imagen 1">
    </div>
    <div class="carousel-item">
      <img src="imagen2.jpg" class="d-block w-100" alt="Imagen 2">
    </div>
    <div class="carousel-item">
      <img src="imagen3.jpg" class="d-block w-100" alt="Imagen 3">
    </div>
  </div>

  <!-- Controles de Navegación -->
  <button class="carousel-control-prev" type="button" data-bs-target="#miCarousel" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Anterior</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#miCarousel" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Siguiente</span>
  </button>
</div>
```

**Explicación de la Estructura**

* **Contenedor Principal del Carousel (`.carousel.slide`):**
  * `id="miCarousel"`: Identificador único del carousel.
  * `data-bs-ride="carousel"`: Activa el funcionamiento automático del carousel.

* **Indicadores (`.carousel-indicators`):**
  * Son botones de navegación que indican la cantidad de elementos y la posición 
    actual del carousel.
  * Usan `data-bs-slide-to` para moverse a un slide específico.

* **Elementos (`.carousel-inner` y `.carousel-item`):**
  * `.carousel-inner`: Contenedor de todos los elementos (slides) del carousel.
  * `.carousel-item`: Cada elemento individual del carousel. La primera debe tener 
    la clase `.active` para que se muestre inicialmente.
  * Dentro de cada `.carousel-item`, puedes incluir imágenes, texto u otros elementos.

* **Controles de Navegación (`.carousel-control-prev` y `.carousel-control-next`):**
  * Permiten navegar manualmente hacia el slide anterior (`prev`) o siguiente (`next`).
  * Usan `data-bs-target` para indicar a cuál carousel pertenecen.


### Personalización del Carousel

* **Automático vs. Manual:**
  * Si quieres que el carousel funcione automáticamente, mantén 
    `data-bs-ride="carousel"`.
  * Si prefieres controlarlo manualmente, elimina el atributo `data-bs-ride`.

* **Intervalo de Deslizamiento:**
  * Puedes cambiar la velocidad con la que se mueve el carousel con el atributo 
    `data-bs-interval`.
```html
<div id="miCarousel" class="carousel slide" data-bs-ride="carousel" data-bs-interval="3000">
```
Esto hará que los slides cambien cada **3000 ms (3 segundos)**.

* **Controles de Transición y Efectos:**
  * Bootstrap usa transiciones suaves por defecto (`slide`), pero puedes añadir 
    más estilos o efectos personalizados usando clases adicionales o CSS.

---
