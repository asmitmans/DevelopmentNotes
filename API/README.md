# API RESTful

## Índice
1. [HATEOAS](#HATEOAS)

## HATEOAS

HATEOAS (Hypermedia As The Engine Of Application State) es un concepto
fundamental en el diseño de APIs RESTful. Es parte del conjunto de 
restricciones que definen un servicio como RESTful, de acuerdo con el estilo
arquitectónico propuesto por Roy Fielding en su tesis doctoral.

### ¿Qué es HATEOAS?
HATEOAS es una técnica que asegura que las interacciones con una API
se realicen de manera más dinámica y auto-descriptiva. Según este
principio, un cliente de la API no necesita conocer previamente la
estructura exacta de la API, porque el servidor proporcionará toda la
información necesaria para navegar y utilizar la API en las respuestas
que envía.

### ¿Cómo funciona?
Cuando un cliente hace una solicitud a un endpoint de la API, la
respuesta no solo contiene los datos solicitados, sino también enlaces
(links) a otros recursos relacionados y a posibles acciones
adicionales que el cliente puede realizar. Estos enlaces permiten al
cliente descubrir dinámicamente la funcionalidad disponible sin
necesidad de tener conocimiento previo de la API.

**Ejemplo:**
Supongamos que tienes una API RESTful para gestionar un catálogo de
libros. Una solicitud GET a un recurso específico de un libro podría
devolver algo como esto:

```json
{
  "id": 123,
  "title": "Spring in Action",
  "author": "Craig Walls",
  "price": 29.99,
  "links": [
    {
      "rel": "self",
      "href": "/books/123"
    },
    {
      "rel": "all-books",
      "href": "/books"
    },
    {
      "rel": "purchase",
      "href": "/books/123/purchase"
    },
    {
      "rel": "author-info",
      "href": "/authors/craig-walls"
    }
  ]
}
```
    
En este ejemplo:

* "self": Es un enlace a sí mismo, es decir, a los detalles de este
  libro específico.
* "all-books": Proporciona un enlace a la lista completa de libros.
* "purchase": Un enlace que permite realizar una compra de este libro.
* "author-info": Un enlace a la información sobre el autor del libro.

### Beneficios de HATEOAS:
1. Descubrimiento Dinámico: Los clientes pueden navegar la API sin
   necesidad de documentación adicional, ya que los enlaces
   proporcionan todas las rutas y acciones disponibles.
   
2. Desacoplamiento: Los clientes están menos acoplados a la
   estructura de la API, ya que no dependen de conocer todas las URLs
   con antelación.
   
3. Evolución de la API: Permite que la API evolucione sin romper a los
   clientes existentes, siempre que se mantengan los enlaces
   proporcionados.

### Desafíos:
* Implementación: HATEOAS puede ser más complejo de implementar y
  mantener que una API tradicional.
* Adopción: No todas las aplicaciones o servicios requieren HATEOAS, y
  en algunos casos, su adopción puede ser innecesaria.

HATEOAS es un concepto potente que promueve el diseño de APIs más
robustas, autodescriptivas y flexibles.


HATEOAS es una herramienta más en el diseño de APIs RESTful, pero no
es un requisito obligatorio ni siempre la mejor opción. Su utilidad
depende mucho del contexto y del tipo de API que estás construyendo.
Si consideras que en tu caso particular la API es sencilla, las rutas
son bien conocidas y estables, y los clientes están bien definidos,
puede que HATEOAS no aporte mucho valor. Es importante considerar el
contexto y las necesidades específicas de tu aplicación antes de
decidir si implementar HATEOAS o no.

----------------------------------------------------------------------