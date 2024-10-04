## Terminal

- [Terminal](#terminal)
- [Introducción a la Terminal](#introducción-a-la-terminal)
- [Estructura de Archivos en Sistemas Unix](#estructura-de-archivos-en-sistemas-unix)
- [Anatomía de un Comando en Unix](#anatomía-de-un-comando-en-unix)
- [Estructura General de un Comando](#estructura-general-de-un-comando)
- [Comandos Esenciales de la Terminal](#comandos-esenciales-de-la-terminal)
- [`find`: Búsqueda de Archivos y Directorios](#find-búsqueda-de-archivos-y-directorios)
- [Manejo de Archivos y Carpetas en la Terminal](#manejo-de-archivos-y-carpetas-en-la-terminal)


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

## Anatomía de un Comando en Unix

Los comandos en Unix se componen de diferentes partes que determinan su 
funcionamiento y comportamiento al ser ejecutados en la terminal. La estructura 
básica de un comando es la siguiente:

```sh
comando [opciones] [argumentos]
```


### Componentes de un Comando

1. **Comando:**
* Es la instrucción principal que indica la acción que se va a realizar.
* Ejemplos: `ls` (listar archivos), `cd` (cambiar directorio), `mkdir` (crear 
  directorio).

2. **Opciones (Flags):**
* Modifican o especifican el comportamiento del comando.
* Se representan normalmente con un guion simple `-` o doble `--`.
* Pueden combinarse para realizar varias acciones al mismo tiempo.
* Ejemplos:
  * `-l` para listar archivos con información detallada.
  * `-a` para incluir archivos ocultos.
  * `--help` para mostrar ayuda sobre el comando.

3. **Argumentos:**
* Son los objetos sobre los que el comando opera, como archivos, directorios, o 
  rutas.
* Pueden ser nombres de archivos, nombres de carpetas, o cualquier otro recurso 
  del sistema.
* Ejemplos:
  * Nombre de un archivo: ls archivo.txt.
  * Ruta a un directorio: cd /home/usuario.


### Ejemplos de Uso de Comandos
**Comando Simple:**
```sh
ls
```
Este comando muestra una lista de archivos en el directorio actual.

**Comando con Opción (Flag):**
```sh
ls -l
```
Muestra la lista de archivos con detalles (permisos, propietario, tamaño, fecha 
de modificación).

**Comando con Opción y Argumento:**
```sh
ls -a /home/usuario
```
Lista todos los archivos (incluyendo ocultos) en el directorio especificado 
`/home/usuario`.

---

## Estructura General de un Comando

Un comando puede tener múltiples opciones y argumentos al mismo tiempo, y se 
interpreta de izquierda a derecha.

**Ejemplo Completo:**
```sh
cp -r /home/usuario/docs /home/usuario/backup
```
* `cp`: Comando para copiar archivos.
* `-r`: Opción que indica que la copia debe ser recursiva (incluyendo todos los 
  subdirectorios y archivos).
* `/home/usuario/docs`: Argumento que especifica el directorio fuente.
* `/home/usuario/backup`: Argumento que especifica el directorio de destino.

---

## Comandos Esenciales de la Terminal

1. `pwd`: Muestra el **directorio de trabajo actual**.

2. `ls`: Lista los **archivos y directorios** en el directorio actual.

3. `cd`: Cambia de **directorio**.

4. `mkdir`: Crea un **nuevo directorio**.

5. `rmdir`: Elimina un **directorio vacío**.

6. `touch`: Crea un **archivo vacío** o actualiza la fecha de modificación de un 
   archivo.

7. `rm`: Elimina **archivos** o **directorios**.

8. `cp`:**Copia archivos o directorios.**

9. `mv`: **Mueve** o renombra archivos y directorios.

10. `cat`: Muestra el **contenido de un archivo**.

11. `less`: Permite **visualizar** el contenido de un archivo **página por página.**

12. `echo`: Muestra un **mensaje o texto** en la terminal.

13. `man`: Abre el **manual** de un comando para obtener más información.

14. `chmod`: Cambia los **permisos de un archivo o directorio.**

15. `chown`: Cambia el **propietario de un archivo o directorio.**

16. `find`: Busca **archivos y directorios.**

17. `grep`: Busca texto **dentro de archivos.**

18. `ps`: Muestra una lista de **procesos activos.**

19. `kill`: Finaliza un **proceso activo.**

20. `clear`: Limpia la **pantalla de la terminal.**

21. `df`: Muestra el **uso del espacio en disco.**

22. `du`: Muestra el **uso de espacio de archivos y directorios.**

23. `tar`: Agrupa (comprime o descomprime) archivos en **archivos `tar`.**

24. `wget`: Descarga archivos desde la **web.**

25. `nano` / `vim`: Editores de texto en la terminal.

26. `apt`: Gestor de paquetes en Ubuntu para **instalar, actualizar o eliminar software.**

---

## `find`: Búsqueda de Archivos y Directorios

El comando `find` se utiliza para buscar archivos y directorios dentro de un 
sistema de archivos, permitiendo búsquedas avanzadas con diferentes criterios.

### Uso Básico
```sh
find [ruta] [criterios] [acción]
```
* `[ruta]`: Especifica el directorio desde el cual se iniciará la búsqueda. Si se 
  omite, busca desde el directorio actual (`.`).

* `[criterios]`: Define las condiciones de la búsqueda, como el nombre, tipo, 
  tamaño, fecha de modificación, etc.

* `[acción]`: Opcionalmente, se puede realizar una acción sobre los resultados 
  (por ejemplo, eliminar archivos encontrados).

### Ejemplos Comunes

* **Buscar por Nombre:**
```sh
find /ruta -name "archivo.txt"
```
Busca un archivo específico llamado `archivo.txt` dentro de `/ruta`.

* **Buscar por Tipo (`f` para archivo, `d` para directorio):**
```sh
find /ruta -type f
```
Busca solo archivos (`-type f`) dentro de `/ruta`.

* **Buscar por Tamaño:**
```sh
find /ruta -size +50M
```
Busca archivos mayores a **50 MB.**

* **Buscar por Fecha de Modificación (en días):**
```sh
find /ruta -mtime -7
```
Busca archivos modificados en los últimos **7 días.**

* **Buscar todos los archivos modificados hace más de 7 días**
```sh
find /ruta -type f -mtime +7
```
* `/ruta`: Especifica el directorio donde se iniciará la búsqueda (puedes 
  reemplazarlo por . para buscar en el directorio actual).
* `-type f`: Indica que solo se deben buscar archivos (excluyendo directorios).
* `-mtime +7`: Busca archivos que hayan sido modificados hace más de 7 días.
Esto listará todos los archivos en /ruta que tienen una última fecha de modificación anterior a 7 días.

* **Ejecutar una Acción (Eliminar Archivos Encontrados):**
```sh
find /ruta -name "*.log" -delete
```
Busca y elimina todos los archivos `.log` dentro de `/ruta.`

---

## Manejo de Archivos y Carpetas en la Terminal

### Creación de Archivos
* `touch [nombre_archivo]`: Crea un archivo vacío o actualiza la fecha de 
  modificación si ya existe.
```sh
touch archivo.txt
```

### Creación de Directorios
* `mkdir [nombre_directorio]`: Crea un directorio.
```sh
mkdir nueva_carpeta
```

* `mkdir -p [ruta/del/directorio]`: Crea directorios anidados (si no existen).
```sh
mkdir -p ruta/carpeta/subcarpeta
```

### Copia de Archivos
* `cp [archivo_fuente] [archivo_destino]`: Copia un archivo a un nuevo destino.
```sh
cp archivo.txt copia_archivo.txt
```

### Copia de Directorios
* `cp -r [directorio_fuente] [directorio_destino]`: Copia un directorio y su 
  contenido de forma recursiva.
```sh
cp -r carpeta_original carpeta_copia
```

### Mover Archivos y Directorios
* `mv [fuente] [destino]`: Mueve o renombra un archivo o directorio.
```sh
mv archivo.txt nueva_ubicacion/
mv carpeta_original carpeta_renombrada
```

### Borrar Archivos
* `rm [nombre_archivo]`: Elimina un archivo.
```sh
rm archivo.txt
```

* `rm -r [nombre_directorio]`: Elimina un directorio y su contenido de forma
  recursiva.
```sh
rm -r carpeta_a_eliminar
```

---















