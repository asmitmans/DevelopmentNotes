## Git

## Introducción a Git

**Git** es un **sistema de control de versiones distribuido** que permite rastrear los 
cambios en el código fuente a lo largo del tiempo. Fue desarrollado para 
facilitar la colaboración entre desarrolladores, permitiendo llevar un registro 
de los cambios realizados en un proyecto de software.

### ¿Qué Permite Git?

* **Rastreo de Cambios:** Mantener un historial de modificaciones en archivos y 
  directorios.
* **Colaboración en Equipo:** Facilita la colaboración, ya que varios 
  desarrolladores pueden trabajar en el mismo proyecto simultáneamente.
* **Recuperación de Versiones:** Volver a versiones anteriores del proyecto si algo 
  sale mal o se desea comparar el progreso.


### Control de Versiones

El control de versiones es la práctica de gestionar y seguir cambios en archivos 
de código y otros recursos de un proyecto. Permite:

* Guardar distintas versiones del código a medida que evoluciona.
* Saber quién realizó un cambio, qué cambió, y cuándo.
* Trabajar en diferentes ramas (branches) de un proyecto de forma paralela, como 
  nuevas funcionalidades o corrección de errores.


### ¿Cuándo se debe usar Git?

* **Proyectos de Software:** Esencial para cualquier desarrollo de software, desde 
  pequeños scripts hasta grandes aplicaciones.
* **Colaboración en Equipo:** Cuando varias personas están trabajando en el mismo 
  proyecto.
* **Versionado y Backups:** Cuando se necesita hacer seguimiento de cambios, tener 
  backups del código y recuperar versiones previas.


### Formas de Uso de Git

1. **Desde la Línea de Comandos (CLI):** La forma más común y poderosa de usar Git, 
   con comandos como git init, git add, git commit, git push.
2. **Aplicaciones Gráficas (GUIs):** Herramientas visuales como GitKraken, 
   Sourcetree, y la Interfaz de GitHub permiten manejar Git con una interfaz más 
   amigable.
3. **Integración en Editores de Código:** Muchos editores modernos como VS Code, 
   Atom, y IntelliJ IDEA incluyen integración de Git para usarlo directamente 
   desde el entorno de desarrollo.

---

## Instalando y Configurando Git en Linux

### Verificando si Git Está Instalado

1. Abre la terminal.
2. Escribe el siguiente comando:
```sh
git --version
```
* Si Git está instalado, verás la versión actual de Git.
* Si no está instalado, se mostrará un mensaje de error.


### Instalando Git en Linux

1. **Actualizar el Sistema:** Es recomendable actualizar el sistema antes de 
   instalar nuevos paquetes.
```sh
sudo apt update
```

2. **Instalar Git:** Usa el gestor de paquetes (`apt` en distribuciones basadas en 
   Debian/Ubuntu).
```sh
sudo apt install git
```

3. **Verificar la Instalación:** Asegúrate de que Git se instaló correctamente.
```sh
git --version
```


### Configuración Inicial de Git

Configurar el nombre de usuario y el correo electrónico es esencial para 
identificar tus cambios en los repositorios.

1. **Configurar Nombre de Usuario:**
```sh
git config --global user.name "Tu Nombre"
```

2. **Configurar Correo Electrónico:**
```sh
git config --global user.email "tuemail@ejemplo.com"
```

3. **Verificar la Configuración:** Para ver todas las configuraciones actuales de 
   Git.
```sh
git config --list
```

---

## Uso Básico de Git

### Inicializando Git

Para empezar a usar Git en un proyecto:

1. Navega al directorio del proyecto con la terminal.
2. Ejecuta el comando:
```sh
git init
```
Esto crea un nuevo repositorio de Git en el directorio actual.


### Flujo de Trabajo de Git

El flujo de trabajo básico de Git sigue estos pasos:

1. **Working Directory (Directorio de Trabajo):** Modificar archivos en tu proyecto.

2. **Staging Area (Área de Preparación):** Añadir cambios que se quieren "guardar" 
   en un commit usando `git add`.

3. **Repository (Repositorio):** Confirmar los cambios agregados usando `git commit`, 
   creando un registro permanente en el historial del proyecto.


### Comando `git add`

El comando `git add` añade cambios al **Staging Area** (Área de Preparación).

* **Añadir un archivo específico:**
```sh
git add archivo.txt
```

* **Añadir todos los cambios del directorio actual:**
```sh
git add .
```


### Comando `git commit`

El comando `git commit` guarda los cambios añadidos al **Staging Area** en el 
historial del repositorio.

* **Comando básico para confirmar cambios:**
```sh
git commit -m "Mensaje del commit"
```
El mensaje debe describir brevemente los cambios realizados.


### Comando `git push`

El comando git push sube los commits locales a un repositorio remoto (como 
GitHub).

* **Subir cambios a la rama principal (por defecto `main`):**
```sh
git push origin main
```
Estos comandos cubren el flujo básico de trabajo en Git, permitiendo rastrear, 
guardar y compartir cambios en tu proyecto.

---

## Repositorio Local vs. Remoto

### Repositorio Local

Un **repositorio local** es el espacio en tu máquina donde se almacena el proyecto y 
el historial de Git. Trabajas en el repositorio local cuando:

* **Desarrollas y realizas cambios en el código:** Escribes y pruebas el código de 
  forma local.

* **Controlas el historial de cambios:** Usas comandos como `git add` y `git commit` 
  para rastrear y confirmar los cambios en tu máquina.

* **Prototipas o trabajas de manera aislada:** Cuando necesitas trabajar sin 
  compartir tus avances o cuando estás desconectado de internet.


### Repositorio Remoto

Un **repositorio remoto** es un repositorio alojado en un servidor (como GitHub, 
GitLab o Bitbucket) al cual varios desarrolladores pueden acceder. Trabajas en 
el repositorio remoto cuando:

* **Compartes cambios con tu equipo:** Usas `git push` para subir tus commits al 
  repositorio remoto y `git pull` para descargar los cambios realizados por otros.

* **Haces respaldo del proyecto:** Subir tu repositorio local a un servicio remoto 
  sirve como backup.

* **Colaboras y coordinas trabajo:** Utilizas ramas remotas, solicitudes de "pull 
  request", y otros mecanismos para trabajar en equipo de forma sincronizada.

---

## Subiendo una Nueva Versión: `git log`

El comando `git log` muestra el historial de commits realizados en un 
repositorio, lo que ayuda a verificar los cambios y su autor antes de subir una 
nueva versión.


### Uso Básico de `git log`

```sh
git log
```
* Muestra una lista de los **commits realizados** en el repositorio actual, 
  incluyendo:
* **Hash del commit:** Identificador único del commit.
* **Autor:** Nombre y correo del usuario que realizó el commit.
* **Fecha:** Fecha y hora en que se realizó el commit.
* **Mensaje del commit:** Descripción de los cambios realizados.


### Ejemplo de Salida de `git log`

```sql
commit 6f9c92e451e4a123456789abc12345678abcd123
Author: Nombre <correo@ejemplo.com>
Date:   Mon Sep 27 14:30:00 2023 -0400

    Mensaje del commit: Añadir función de validación
```


### Opciones Comunes

* `git log --oneline`: Muestra el historial en una sola línea por commit, con el 
  hash abreviado y el mensaje.

* `git log -n <número>`: Muestra solo los últimos `<número>` de commits.
```sh
git log -n 5
```


### Subiendo una Nueva Versión

Antes de subir una nueva versión con `git push`, se recomienda revisar el 
historial con `git log` para asegurar que todos los cambios necesarios estén 
confirmados y listos para ser subidos al repositorio remoto.

---

## Gestionando los Cambios

### `git status`

El comando `git status` muestra el estado actual del repositorio, proporcionando
información sobre los archivos y cambios no confirmados.

**Uso Básico:**
```sh
git status
```
* **Muestra:**
  * **Archivos modificados:** Cambios realizados pero aún no añadidos al área de 
  	preparación (Staging Area).
  * **Archivos en Staging Area:** Cambios listos para confirmar con git commit.
  * **Archivos sin seguimiento (Untracked):** Archivos nuevos no incluidos en Git.

Este comando es esencial para saber qué ha cambiado en tu repositorio y qué 
acciones tomar.


### `git diff`

El comando `git diff` compara los cambios realizados en el repositorio.

**Uso Básico:**
```sh
git diff
```
* Muestra las diferencias línea por línea entre el contenido de los archivos 
  modificados y la última confirmación (commit) en el repositorio.

**Opciones Comunes:**
* `git diff --staged`: Muestra las diferencias de los archivos que ya se 
  encuentran en el área de preparación (Staging Area).
```sh
git diff --staged
```


### Comparación entre `git status` y `git diff`:

* `git status`: Da una **visión general** del estado del repositorio (archivos 
  modificados, añadidos, no rastreados).

* `git diff`: Proporciona una **vista detallada** de las diferencias exactas en el 
  contenido de los archivos.

Ambos comandos son fundamentales para gestionar los cambios en Git y tomar 
decisiones antes de confirmar o subir cambios al repositorio.

---

