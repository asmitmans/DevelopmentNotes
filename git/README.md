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




