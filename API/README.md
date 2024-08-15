# API RESTful

- [HATEOAS](#HATEOAS)
- [Header HTTP](#header-http)
- [`Authorization` HTTP Header](#authorization-http-header)
- [Cookies](#cookies)


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

## Header HTTP

La principal función del **header** en una solicitud o respuesta HTTP es
proporcionar **metadatos** sobre la comunicación entre el cliente (por ejemplo,
un navegador web o una aplicación) y el servidor. Estos metadatos incluyen
información crucial para el correcto procesamiento de la solicitud o respuesta.
Los headers pueden especificar una amplia variedad de detalles, tales como:

1. **Autenticación y Autorización**: Headers como `Authorization` permiten que 
   el cliente envíe credenciales al servidor para acceder a recursos protegidos.

2. **Control de Cache**: Headers como `Cache-Control`, `Expires`, y `ETag`
   indican si y cómo el contenido debe ser almacenado en caché por el cliente o
   intermediarios.

3. **Tipo de Contenido**: Headers como `Content-Type` indican el tipo de los
   datos que se están enviando o recibiendo, por ejemplo, `application/json`
   para JSON, `text/html` para HTML, etc.

4. **Lenguaje**: Headers como `Accept-Language` indican las preferencias de
   idioma del cliente para el contenido que se va a recibir.

5. **Seguridad**: Headers como `Strict-Transport-Security` ayudan a reforzar la
   seguridad de la comunicación, como forzar el uso de HTTPS.

6. **Detalles de la Conexión**: Headers como `Connection` pueden controlar si la
   conexión debe ser cerrada o mantenida abierta después de completar la
   solicitud.

7. **Control de Transferencia**: Headers como `Transfer-Encoding` y 
   `Content-Length` indican cómo se está transmitiendo el cuerpo del mensaje,
   especialmente para manejar respuestas grandes.

En resumen, los headers en HTTP son esenciales para la correcta interpretación y
manipulación de las solicitudes y respuestas, asegurando que tanto el cliente
como el servidor puedan comunicarse de manera efectiva y segura.

----------------------------------------------------------------------

## `Authorization` HTTP Header

El header `Authorization` en HTTP se usa para enviar credenciales del cliente al
servidor para autenticar la solicitud. Puede usar diferentes esquemas de
autenticación, como:

* **Basic**: Envía nombre de usuario y contraseña codificados en Base64.
* **Bearer**: Envía un token, como un JWT, para autenticar al usuario.

Ejemplo de uso con Bearer:

```http
Authorization: Bearer <token>
```
Este header es clave para la autenticación en APIs y recursos protegidos.

----------------------------------------------------------------------

## Cookies

La función principal de las **cookies** es almacenar pequeños fragmentos de datos
en el navegador del usuario para ser utilizados por el servidor en futuras
interacciones. Esto permite:

1. **Mantener sesiones**: Guardar información sobre la sesión del usuario, como
   identificadores de sesión, para que el usuario no tenga que volver a
   autenticarse en cada solicitud.  

2. **Recordar preferencias**: Almacenar configuraciones personalizadas, como
   idioma o temas visuales, para mejorar la experiencia del usuario en futuras
   visitas.   

3. **Rastrear actividad**: Realizar un seguimiento de la actividad del usuario
   en el sitio web para análisis o personalización de contenido.   

Las cookies son fundamentales para mantener el estado en la comunicación HTTP,
que es inherentemente sin estado (stateless).


Las cookies son un **mecanismo para mantener información entre solicitudes 
HTTP.** Dado que HTTP es un protocolo sin estado, las cookies permiten que el 
servidor "recuerde" información sobre el cliente entre distintas solicitudes, 
como la sesión de usuario, preferencias, o datos de seguimiento. Esto es 
esencial para proporcionar una experiencia continua y personalizada en 
aplicaciones web.

----------------------------------------------------------------------