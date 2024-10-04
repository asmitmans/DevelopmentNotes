## Terminal

- [Terminal](#terminal)
- [Introducción a la Terminal](#introducción-a-la-terminal)
- [Estructura de Archivos en Sistemas Unix](#estructura-de-archivos-en-sistemas-unix)


## Introducción a la Terminal

La terminal es una interfaz de línea de comandos que permite interactuar 
directamente con el sistema operativo mediante texto. A diferencia de una 
interfaz gráfica, la terminal permite realizar tareas como navegación de 
archivos, ejecución de programas, instalación de software, y control del sistema 
de manera rápida y eficiente.

### Inicialización de la Terminal en Ubuntu

1. **Método Rápido:**
   * **Atajo de Teclado:** Presiona `Ctrl + Alt + T` para abrir la terminal 
  	 rápidamente.

2. **A través del Menú de Aplicaciones:**
* Haz clic en el icono de aplicaciones (en la esquina inferior o superior 
  izquierda).
* Busca "Terminal" en la barra de búsqueda y selecciona el resultado.

Una vez abierta, la terminal se inicia en tu directorio de usuario por defecto 
(`/home/usuario`), listo para aceptar comandos del sistema.

---

## Estructura de Archivos en Sistemas Unix

La estructura de archivos en sistemas **Unix** (y similares como Linux) es 
jerárquica, organizada como un árbol con la raíz en el directorio `/`. Aquí se 
describen los directorios más importantes y su propósito:

* **`/` (Raíz):** Es el directorio raíz de todo el sistema de archivos. Todos los 
  demás directorios están organizados dentro de él.

* `/bin`: Contiene **binarios esenciales** para el sistema y comandos básicos 
  accesibles para todos los usuarios (como `ls`, `cp`, `mv`).

* `/boot`: Contiene los **archivos necesarios para el arranque del sistema**, como el 
  kernel y los cargadores de arranque.

* `/dev`: Contiene **archivos de dispositivos** que representan hardware (discos, 
  puertos, etc.). Ejemplos: `/dev/sda` para discos duros.

* `/etc`: **Archivos de configuración** del sistema y aplicaciones. Aquí se encuentran 
  archivos de configuración global (como `/etc/passwd` para usuarios).

* `/home`: Contiene los **directorios personales de los usuarios**. Cada usuario tiene 
  su propia carpeta (por ejemplo, `/home/usuario`).

* `/lib`: Contiene las `bibliotecas esenciales` para el sistema y programas en `/bin` 
  y `/sbin`.

* `/media` y `/mnt`: Son puntos de montaje para **dispositivos externos** como discos 
  duros, memorias USB, y otros sistemas de archivos.

* `/opt`: Contiene **software opcional** o paquetes adicionales instalados manualmente 
  fuera del sistema de gestión de paquetes estándar.

* `/proc`: Es un sistema de archivos virtual que proporciona **información del** 
  **sistema y procesos** en tiempo real (como el uso de la memoria o CPU). Los 
  archivos dentro de `/proc` son generados por el kernel.

* `/root`: Es el **directorio personal del usuario** `root` (administrador del sistema). 

* `/run`: Contiene **archivos de estado y datos temporales** utilizados durante el 
  tiempo de ejecución del sistema.

* `/sbin`: Similar a `/bin`, pero contiene **comandos esenciales para la** 
  **administración del sistema** y que generalmente requieren permisos de 
  superusuario.

* `/srv`: Almacena datos para **servicios** proporcionados por el sistema (como 
  servidores web o FTP).

* `/sys`: Otro sistema de archivos virtual que **proporciona información sobre** 
  **dispositivos y controladores** del kernel. Es similar a `/proc` en su 
  funcionalidad.

* `/tmp`: Directorio para almacenar **archivos temporales** creados por programas y 
  usuarios. Estos archivos suelen ser eliminados en cada reinicio del sistema.

* `/usr`: Contiene la mayoría de los **programas y utilidades del sistema**, 
  organizados en subdirectorios:

  * `/usr/bin`: Binarios no esenciales.
  
  * `/usr/sbin`: Binarios administrativos no esenciales.
  
  * `/usr/lib`: Bibliotecas para los programas en `/usr/bin` y `/usr/sbin`.
  
  * `/usr/local`: Programas y archivos específicos del usuario local.

* `/var`: Contiene archivos que cambian constantemente, como **logs del sistema**, 
  **colas de impresión, y archivos de correo.**

---


