## Bootstrap

- [Bootstrap](#bootstrap)
- [Introducción a Bootstrap](#introducción-a-bootstrap)
- [Integrando CDN de Bootstrap](#integrando-cdn-de-bootstrap)


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
1. Agregar el siguiente `<link>` en el `<head>` de tu archivo HTML:

```html
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/css/bootstrap.min.css">
```
Esto asegura que todas las clases de estilos de Bootstrap estén disponibles.

### JavaScript
Bootstrap utiliza algunas funcionalidades de JavaScript para interactuar con 
componentes dinámicos como modales, tooltips, y otros. La integración de 
JavaScript desde la CDN también es sencilla.

#### Pasos esenciales:

1. Agregar el siguiente `<script>` antes del cierre del `<body>`:

```html
<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
```
Esto incluirá tanto el propio JavaScript de Bootstrap como Popper.js, necesario 
para ciertos componentes como tooltips y dropdowns.

Ambos recursos, CSS y JavaScript, son esenciales para que el framework funcione 
correctamente y se aprovechen todas sus funcionalidades.

---

