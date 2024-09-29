## Bootstrap

- [Bootstrap](#bootstrap)
- [Introducción a Bootstrap](#introducción-a-bootstrap)
- [Integrando CDN de Bootstrap](#integrando-cdn-de-bootstrap)
- [Documentación oficial de Bootstrap](#documentación-oficial-de-bootstrap)
- [Integrando Bootstrap mediante Descarga](#integrando-bootstrap-mediante-descarga)
- [Sistema de Grillas de Bootstrap](#sistema-de-grillas-de-bootstrap)


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

El sistema de grillas de Bootstrap es muy flexible, permitiendo crear layouts 
responsivos de forma rápida y sencilla.

---

