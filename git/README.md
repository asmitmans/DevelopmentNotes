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

## GitHub

**GitHub** es una **plataforma de alojamiento de repositorios Git** que permite 
gestionar, compartir, y colaborar en proyectos de software. Es uno de los 
servicios más populares para alojar código fuente y trabajar en equipo, además 
de ofrecer herramientas para la gestión de proyectos, control de versiones, y 
automatización.

* **Funcionalidades Principales:**
  * **Repositorios Remotos:** Permite almacenar y compartir repositorios de Git en 
    línea.
  * **Colaboración en Equipo:** Facilita la colaboración a través de pull requests, 
    revisiones de código y comentarios.
  * **Control de Versiones:** Sincroniza repositorios locales y remotos usando Git.
  * **Herramientas Adicionales:** Ofrece issues para seguimiento de errores y tareas, 
    actions para automatización, projects para gestión de tableros tipo Kanban, y 
    más.

---

## Configuración de GitHub


### 1. Crear una Cuenta:
* Ve a GitHub y regístrate para crear una cuenta gratuita.
  https://github.com/


### 2. Configurar Git para Usar GitHub:
* Configura tu nombre y correo electrónico (si no lo has hecho anteriormente):
```sh
git config --global user.name "Tu Nombre"
git config --global user.email "tuemail@ejemplo.com"
```

### 3. Generar una Clave SSH (Opcional pero Recomendado):

`#Revisar`

* Para evitar ingresar tu nombre de usuario y contraseña cada vez que 
  interactúes con un repositorio remoto, genera una clave SSH.
```sh
ssh-keygen -t ed25519 -C "tuemail@ejemplo.com"
```
* Copia la clave pública generada (`~/.ssh/id_ed25519.pub`) y agrégala a tu cuenta 
  de GitHub en **Settings > SSH and GPG keys.**

### 4. Autenticarte en GitHub con Token (Alternativa a SSH):

* Si prefieres usar HTTPS en lugar de SSH, puedes generar un Token de Acceso 
  Personal en GitHub (Settings > Developer settings > Personal access tokens).

* Usa este token cuando se te solicite la contraseña al hacer git push o git 
* pull.

### 5. Autenticarte en GitHub con Usando gh (Alternativa SSH, Token)

Forma mas sencilla de autenticarse, para subir cambios

* 1. **Instalar la CLI de GitHub (`gh`)**
  * Para instalar `gh` en sistemas Linux/Ubuntu:
```sh
sudo apt install gh
```

* 2. **Autenticación con GitHub Usando `gh`**
  * Abre la terminal y ejecuta el siguiente comando para iniciar la 
    autenticación: 
```sh
gh auth login
```
* Elige **GitHub.com** y selecciona el método de autenticación:
  * **Browser (recomendado):** Sigue el enlace generado por gh para autenticarte en 
    tu navegador.
  * Una vez autenticado, el token de acceso se configurará automáticamente.

* 3. **Configurar Git para Usar GitHub con `gh`**
* `gh` configurará automáticamente Git para que use HTTPS con el token generado 
  para todas las operaciones de Git relacionadas con GitHub.
* Esto evita que necesites ingresar tu usuario y contraseña cada vez que 
  realizas git push o git pull.

* 5. **Verificar la Configuración Global**
* Después de autenticarse, asegúrate de que `gh` ha configurado Git para manejar 
  credenciales a nivel global:
```sh
git config --global credential.helper
```
Esto debe mostrar algo como `gh auth git-credential`, indicando que `gh` está 
gestionando las credenciales de Git.

### 6. Clonar o Crear repositorio

#### Clonar un Repositorio
* **Con HTTPS:**
```sh
git clone https://github.com/usuario/repositorio.git
```
* Si `gh` gestiona las credenciales, no se te pedirá usuario y contraseña.

* **Con SSH (si configuraste `gh` para usar SSH):**
```sh
git clone git@github.com:usuario/repositorio.git
```

#### Vincular un Repositorio Local a un Repositorio Remoto
* **Agregar un repositorio remoto a un repositorio local existente:**
```sh
git remote add origin https://github.com/usuario/repositorio.git
```
* Este comando sigue siendo válido y `gh` gestionará las credenciales para las 
  operaciones posteriores (`git push`, `git pull`).

#### Crear Repositorios
* Creación Estándar en GitHub (usando el navegador):
  * Puedes crear un repositorio desde la interfaz web de GitHub y luego 
    vincularlo con tu repositorio local usando:
```sh
git remote add origin https://github.com/usuario/repositorio.git
```

---

## Subiendo y Bajando Cambios con Git

### Subiendo Cambios al Repositorio Remoto
Para subir los cambios locales al repositorio remoto, se utiliza el comando 
`git push`.

**Uso Básico:**
```sh
git push origin nombre_rama
```
* `origin`: El nombre por defecto del repositorio remoto.
* `nombre_rama`: La rama a la que quieres subir los cambios (ej: `main`, `master`).

**Ejemplo:**
```sh
git push origin main
```
Esto sube los commits de la rama local `main` al repositorio remoto.

En muchos casos puedes usar simplemente `git push` como una forma abreviada de 
`git push origin main`, pero esto depende de la configuración de tu repositorio 
y el estado actual de tu rama.

Cuando usas solo `git push`, Git intenta hacer un "push" de la rama actual al 
remoto asociado (generalmente llamado `origin`) y a la rama remota con el mismo 
nombre. Sin embargo, para que esto funcione, deben cumplirse algunas 
condiciones:

1. **Rama predeterminada configurada:** La rama local debe estar configurada para 
   hacer "push" automáticamente a una rama remota específica. Esto generalmente 
   ocurre cuando ya has hecho un "push" previo de esa rama o cuando la 
   configuración de Git (el archivo `.git/config`) define una rama de seguimiento.

2. **Remoto predeterminado:** Git debe saber a qué remoto enviar los cambios. 
   Normalmente, si solo tienes un remoto configurado (llamado `origin`), 
   `git push` lo usará por defecto.


### Bajando Cambios del Repositorio Remoto

Para traer cambios desde el repositorio remoto al repositorio local, se utiliza 
el comando `git pull`.

**Uso Básico:**
```sh
git pull origin nombre_rama
```
* `origin`: El nombre del repositorio remoto.
* `nombre_rama`: La rama de la que deseas obtener los cambios.

**Ejemplo:**
```sh
git pull origin main
```
Este comando actualiza tu rama local `main` con los cambios más recientes del 
repositorio remoto.

> **Nota:** `git pull` es una combinación de `git fetch` (descargar los cambios) 
> y `git merge` (fusionarlos en la rama actual).

---

## Git Push

El comando `git push` se utiliza para subir los cambios confirmados (commits) de 
tu repositorio local a un repositorio remoto. Este es un paso esencial para 
sincronizar tu trabajo con un repositorio alojado en un servicio como **GitHub** o 
**GitLab**.

### Cómo Funciona el `git push`

El flujo típico de `git push` consiste en:

1. Subir los commits de la rama local actual a una rama remota con el mismo
   nombre.
2. Si no especificas una rama de destino, Git asume que la rama remota será la 
   misma que la local.

**Ejemplo Básico:**
```sh
git push origin nombre_rama
```
* `origin`: Nombre del repositorio remoto.
* `nombre_rama`: La rama a la que subirás los cambios.

**Comportamiento por Defecto**
1. **Subida a una Rama Remota con el Mismo Nombre:**
   Si ejecutas `git push origin` desde una rama llamada `new_feature`, Git sube los 
   cambios a la rama remota `new_feature`.

   Esto significa que, por defecto, Git hace `push` de la rama local actual (en la 
   que estás trabajando) a la rama remota con el mismo nombre, si existe.

2. **Especificar la Rama de Destino (Rara Vez Necesario):**
   Si deseas subir los cambios de una rama local a una rama remota con un nombre 
   diferente:
```sh
git push origin rama_local:rama_destino
```

**Ejemplo:**
```sh
git push origin new_feature:main
```
Esto intenta subir los cambios de la rama `new_feature` local directamente a `main` 
en el repositorio remoto.


**Empujar Cambios Directamente a `main`**
Aunque es posible subir cambios de cualquier rama local directamente a `main`, 
esto no es una buena práctica en equipos de desarrollo. Hacer `push` directo a 
`main` puede introducir cambios no revisados y causar problemas.

En la mayoría de los casos, los equipos utilizan un flujo basado en 
**Pull Requests (PRs)** o **Merge Requests (MRs)**, donde los cambios de una rama 
(`new_feature`) son revisados y aprobados antes de ser fusionados con `main`.


### ¿Qué Son los Pull Requests (PRs)?

Un **Pull Request (PR)** es una solicitud para fusionar los cambios de una rama 
(`new_feature`) con otra (`main`). Esto permite:
* **Revisar los cambios** antes de fusionarlos.
* **Discutir los cambios** con otros colaboradores.
* **Aprobar o solicitar modificaciones** antes de que se integren en `main`.

---

## Manejo de Repositorios Remotos

Git permite administrar múltiples repositorios remotos, lo cual facilita la 
sincronización y el trabajo colaborativo.

`git remote`
El comando `git remote` se utiliza para gestionar y listar los repositorios 
remotos vinculados con tu repositorio local.

* **Listar Repositorios Remotos:**
```sh
git remote
```
Muestra una lista de los remotos asociados (por defecto suele ser `origin`).


`git remote -v`
* **Listar Detalles de los Remotos:**
```sh
git remote -v
```
Muestra la lista de repositorios remotos junto con sus direcciones URL para 
**fetch (obtener)** y **push (subir)**.


`git remote add [nombre] [dirección del repositorio]`
* **Agregar un Nuevo Repositorio Remoto:**
```sh
git remote add nombre_remoto https://github.com/usuario/repositorio.git
```
Esto añade un nuevo repositorio remoto con el **nombre especificado** (por ejemplo, 
`origin`, `upstream`) y la **URL del repositorio.**


`git remote show [nombre]`
Mostrar Información de un Remoto Específico:
```sh
git remote show nombre_remoto
```
Proporciona detalles sobre el remoto especificado, incluyendo las ramas 
rastreadas y la configuración actual de fetch y push.


### Modificar y Eliminar Repositorios Remotos

`git remote rename`
Renombrar un Repositorio Remoto:
```sh
git remote rename antiguo_nombre nuevo_nombre
```
Cambia el nombre del remoto de `antiguo_nombre` a `nuevo_nombre`.


`git remote rm`
Eliminar un Repositorio Remoto:
```sh
git remote rm nombre_remoto
```
Elimina el remoto especificado, desvinculando el repositorio local de la URL 
asociada.

---

## Trabajando con Repositorios que ya están en GitHub

### `git clone`
* **Clonar un Repositorio Remoto:**
```sh
git clone https://github.com/usuario/repositorio.git
```
* Crea una **copia local** de un repositorio remoto.
* Por defecto, clona la rama principal (generalmente llamada `main` o `master`).
* Esto permite trabajar localmente en el proyecto clonado.


### `fork`
* **Crear un Fork (Copia Propia de un Repositorio):**
  * Un **fork** es una copia de un repositorio de GitHub en tu propia cuenta.
  * Es útil para contribuir a proyectos donde no tienes permisos directos para 
    hacer cambios.
  * Una vez creado el fork, puedes clonar tu copia del repositorio y trabajar en 
    ella.

  * **Flujo Común de Forks:**
    1. Forkear el repositorio original.
    2. Clonar el fork a tu máquina local.
    3. Hacer cambios y subirlos a tu fork.
    4. Abrir un **Pull Request** al repositorio original para proponer tus cambios.

---

## Importante: Cambio de `master` a `main`

Tradicionalmente, la rama principal de un repositorio se llamaba `master`. Sin 
embargo, la comunidad ha adoptado el uso de `main` como el nombre estándar para 
la rama principal. Muchos repositorios y plataformas (como GitHub) usan `main` 
de forma predeterminada.

### Cómo Cambiar de `master` a `main`

1. **Cambiar la Rama Localmente:**
   * Si tu repositorio local todavía usa `master`, puedes renombrarlo:
```sh
git branch -m master main
```

2. **Actualizar el Remoto:**
   * Si también necesitas cambiar la rama principal en el repositorio remoto:
```sh
git push origin main
git push origin --delete master
```

3. **Actualizar la Configuración de la Rama Predeterminada en GitHub:**
   * En GitHub, ve a la configuración del repositorio y cambia la rama 
     predeterminada a `main`.

---

## Git Branch

### Conociendo las Ramas del Proyecto

Las **ramas (branches)** en Git permiten trabajar en diferentes líneas de desarrollo 
dentro de un mismo proyecto, manteniendo el código organizado. Cada rama es una 
versión paralela del proyecto que se puede modificar sin afectar otras ramas.


### `git branch`

* **Listar Ramas Disponibles:**
```sh
git branch
```
Muestra una lista de todas las ramas locales, destacando la rama activa (con un 
`*`).


### ¿Cuándo Generar una Nueva Rama?

Crear una nueva rama es útil cuando:
* **Desarrollas Nuevas Funcionalidades:** Trabajar en una nueva característica sin 
  afectar el código en la rama principal.
* **Corregir Errores (Bugs):** Crear una rama específica para arreglar un error.
* **Experimentar o Prototipar:** Probar cambios sin interferir con el desarrollo 
  principal.


### Crear y Cambiar de Ramas

1. **Crear una Nueva Rama (`git branch`):**
```sh
git branch nueva_branch
```
Esto crea una nueva rama llamada `nueva_branch` sin cambiar a ella.

2. **Cambiar de Rama (`git checkout`):**
```sh
git checkout nueva_branch
```
Cambia la rama actual a `nueva_branch`.

3. **Crear y Cambiar a una Nueva Rama (Comando Combinado):**
```sh
git checkout -b otra_branch
```
Crea una nueva rama llamada `otra_branch` y cambia a ella inmediatamente.

---

## Git Stash

`git stash` es una herramienta que permite **guardar temporalmente cambios no** 
**confirmados (commits)** en tu área de trabajo para que puedas volver a ellos más 
adelante sin necesidad de hacer un commit.


### Comandos de `git stash`

1. **Guardar Cambios con `git stash`:**
```sh
git stash
```
Esto guarda todos los cambios no confirmados (modificaciones y archivos no 
rastreados) en una especie de "pila de almacenamiento temporal" y deja el 
directorio de trabajo limpio (como en el último commit).

2. **Ver el Contenido de la Pila con `git stash list`:**
```sh
git stash list
```
Muestra una lista de los cambios guardados en la pila de stash, permitiéndote 
ver todos los conjuntos de cambios que se han guardado temporalmente.

3. **Aplicar Cambios Guardados con `git stash apply`:**
```sh
git stash apply
```
Restaura los cambios más recientes guardados en la pila, manteniéndolos en el 
stash para seguir disponibles si necesitas volver a aplicarlos.
   * Si quieres aplicar un stash específico (no el más reciente), puedes 
     referenciarlo por su identificador:
```sh
git stash apply stash@{0}
```

### Resumen del Flujo de `git stash`
1. Guardar cambios no confirmados para trabajar en algo más (con git stash).
2. Listar y verificar qué cambios hay guardados (con git stash list).
3. Restaurar los cambios guardados cuando quieras continuar trabajando en ellos 
   (con git stash apply).

`git stash` es una manera efectiva de administrar cambios temporales y mantener 
tu trabajo organizado sin la necesidad de realizar commits intermedios.

---

## Git Rebase

`git rebase` es un comando de Git que se utiliza para **reaplicar commits de una** 
**rama sobre otra**, reorganizando el historial de commits. La idea principal de 
`rebase` es tomar los cambios que están en una rama y **colocarlos al final de otra**, 
reescribiendo el historial.


### ¿Cuándo se Usa `git rebase`?

* **Mantener un Historial Lineal y Limpio:** A diferencia de `git merge`, que crea un 
  commit de fusión, `git rebase` reorganiza los commits para crear una historia 
  más limpia y fácil de leer.

* **Actualizar una Rama con Cambios de Otra Rama:** Por ejemplo, si trabajas en una 
  rama de característica (`feature`) y quieres traer los últimos cambios de `main`, 
  puedes usar `rebase` para que tus commits aparezcan después de los cambios más 
  recientes de `main`.

* **Resolver Conflictos antes de un Merge:** Preparar tus cambios para fusionarse 
  fácilmente con la rama de destino, lo que es útil al colaborar con otros 
  desarrolladores.


### Cómo Usar `git rebase`
```sh
git rebase otra_branch
```
Esto toma los commits de la **rama actual** y los reaplica sobre la rama 
`otra_branch`.

**Ejemplo de Uso:** Si estás trabajando en una rama `feature` y quieres actualizarla 
con los últimos cambios de `main`, te aseguras de estar en `feature` y luego haces:
```sh
git rebase main
```
Esto coloca los commits de `feature` sobre `main`, reorganizando el historial de 
commits para que `feature` esté al día con `main`.


### Resumen del Flujo de `rebase`:
1. **Reorganiza el Historial de Commits:** Aplica los commits de la rama actual 
   sobre otra.
2. **Mantén un Historial Limpio y Lineal:** Útil para mantener un historial más 
   fácil de seguir.
3. **Cuidado con los Conflictos:** Durante el `rebase`, pueden surgir conflictos, que 
   se deben resolver manualmente antes de continuar.

`git rebase` es una herramienta poderosa para mantener un historial de commits 
limpio, pero debe usarse con cuidado para evitar reescribir cambios que otros 
desarrolladores puedan estar utilizando.

---

## GitHub Pages

**GitHub Pages** es un servicio gratuito que permite alojar sitios web directamente 
desde un repositorio de GitHub. Es ideal para mostrar proyectos, documentación, 
blogs o sitios estáticos.


### Subiendo una Página a GitHub Pages

Puedes subir tu página a GitHub Pages directamente desde un repositorio. El 
contenido del repositorio se publica automáticamente y está disponible para 
cualquier usuario.

#### Dos Formas de Subir una Página a GitHub Pages

1. **Por Comandos (Terminal)**
   1. **Crear un Repositorio:** Si no lo tienes ya, crea un repositorio en GitHub 
      para tu sitio web.
   2. **Configurar y Subir el Proyecto Localmente:**
      * Si tu contenido está en la rama `main`, y deseas que la página se 
        despliegue desde el directorio raíz:
```sh
git add .
git commit -m "Subiendo página a GitHub Pages"
git push origin main
```
   3. **Configurar GitHub Pages:** Ve a la página del repositorio en GitHub, 
      selecciona **Settings > Pages**, elige la fuente (branch y carpeta), y guarda.


2. **Por Interfaz Gráfica de GitHub**
   1. **Crear o Seleccionar el Repositorio:** Si aún no lo tienes, crea un nuevo 
      repositorio o selecciona uno existente.

   2. **Subir Archivos Manualmente:**
      * Ve a la pestaña de **Code** del repositorio.
      * Haz clic en **Add file > Upload files** y sube los archivos de tu página 
        web.

   3. **Configurar GitHub Pages:**
      * Dirígete a **Settings > Pages**.
      * En "Source", selecciona la **branch** (generalmente `main`) y la carpeta 
        (usualmente `/root` o `/docs`).
      * Haz clic en **Save**.

Una vez configurado, GitHub procesará los archivos y la página estará disponible 
en una URL similar a `https://usuario.github.io/repositorio/`.

---
