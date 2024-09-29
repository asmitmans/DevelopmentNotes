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

