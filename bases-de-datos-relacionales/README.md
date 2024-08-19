## Bases de Datos Relacionales

- [Bases de Datos Relacionales](#bases-de-datos-relacionales)
- [Deadlock en DBMS](#deadlock-en-dbms)
- [Implementaciones Comunes:](#implementaciones-comunes)
- [Formas Normales en Bases de Datos](#formas-normales-en-bases-de-datos)
- [ANALYZE](#analyze)
- [Vista Materializada](#vista-materializada)
- [Crear índice en tabla](#crear-índice-en-tabla)
- [Crear restricción de unicidad](#crear-restricción-de-unicidad)
- [SQL](#sql)
- [Insensibilidad a las Mayúsculas en SQL](#insensibilidad-a-las-mayúsculas-en-sql)
- [Motor de Bases de Datos](#motor-de-bases-de-datos)
- [Primary Key (Clave Primaria)](#primary-key-clave-primaria)
- [Foreign Key (Clave Foránea)](#foreign-key-clave-foránea)
- [PostgreSQL](#postgresql)
- [SELECT en SQL](#select-en-sql)
- [WHERE en SQL](#where-en-sql)
- [LIMIT en SQL](#limit-en-sql)
- [ORDER BY en SQL](#order-by-en-sql)
- [Creación y Conexión a una BD en PostgreSQL utilizando psql en Ubuntu](#creación-y-conexión-a-una-bd-en-postgresql-utilizando-psql-en-ubuntu)
- [Crear Base de Datos en PostgreSQL](#crear-base-de-datos-en-postgresql)
- [Conectarse a Base de Datos en PostgreSQL](#conectarse-a-base-de-datos-en-postgresql)
- [Crear Tabla en PostgreSQL](#crear-tabla-en-postgresql)
- [Insertar Registros en Tabla en PostgreSQL](#insertar-registros-en-tabla-en-postgresql)
- [Borrar una Base de Datos en PostgreSQL](#borrar-una-base-de-datos-en-postgresql)
- [Listar las Bases de Datos en PostgreSQL](#listar-las-bases-de-datos-en-postgresql)
- [Añadir una Columna a una Tabla en PostgreSQL](#añadir-una-columna-a-una-tabla-en-postgresql)
- [Eliminar una Columna de una Tabla en PostgreSQL](#eliminar-una-columna-de-una-tabla-en-postgresql)
- [Listar Todas las Tablas en PostgreSQL](#listar-todas-las-tablas-en-postgresql)
- [Describir una Tabla en PostgreSQL](#describir-una-tabla-en-postgresql)
- [Borrar Todos los Datos de una Tabla en PostgreSQL](#borrar-todos-los-datos-de-una-tabla-en-postgresql)
- [Borrar Algunos Datos de una Tabla en PostgreSQL](#borrar-algunos-datos-de-una-tabla-en-postgresql)
- [Insertar Varios Registros a una Tabla en PostgreSQL](#insertar-varios-registros-a-una-tabla-en-postgresql)
- [Función LEFT en PostgreSQL](#función-left-en-postgresql)


--------------------------------------------------------------------------------

## Deadlock en DBMS

Un deadlock en el contexto de bases de datos ocurre cuando dos o más
transacciones se bloquean mutuamente porque cada una espera que la otra libere
un recurso que necesita para continuar. Ninguna de las transacciones puede
proceder, lo que resulta en un bloqueo indefinido hasta que se tome una acción
para resolverlo.

### Prevención de Deadlocks:
Para prevenir deadlocks en bases de datos, se pueden implementar las siguientes
estrategias:
1. **Ordenamiento de Recursos**: Asegurar que todas las transacciones adquieran
   los recursos en un orden predefinido. Esto minimiza la posibilidad de ciclos
   de espera.
2. **Tiempo de Espera**: Configurar un tiempo máximo de espera (timeout) para
   que una transacción espere por un recurso. Si se excede este tiempo, la
   transacción se aborta, liberando los recursos y evitando el deadlock.
3. **Evitar Retener Recursos**: Minimizar la duración durante la cual una
   transacción mantiene los recursos bloqueados, liberándolos lo antes posible.

### Resolución de Deadlocks:
Si ocurre un deadlock, se pueden aplicar las siguientes técnicas para resolverlo:
1. **Detección y Recuperación**: Implementar mecanismos que detecten ciclos de
   espera entre transacciones. Una vez detectado un deadlock, se puede abortar
   una o más transacciones involucradas para liberar los recursos.

2. **Rollback de Transacciones**: Una vez identificado un deadlock, se
   selecciona una transacción como "víctima" y se revierte (rollback) para
   liberar los recursos y permitir que otras transacciones avancen.

## Implementaciones Comunes:
1. **Algoritmos de Detección de Deadlocks**: Muchos sistemas de gestión de bases
   de datos (RDBMS) incluyen algoritmos para detectar deadlocks basados en
   gráficos de espera.

2. **Políticas de Tiempo de Espera**: Los RDBMS también pueden implementar
   políticas de tiempo de espera y abortar transacciones si el tiempo de espera
   es demasiado largo.

--------------------------------------------------------------------------------

## Formas Normales en Bases de Datos

Estas formas normales se aplican para eliminar redundancias y mejorar la
integridad de los datos en las bases de datos relacionales.

### 1. Primera Forma Normal (1NF):
* **Definición**: Una tabla está en 1NF si todos los valores de sus columnas son
  atómicos, es decir, cada columna contiene un único valor por fila, y no hay
  listas o conjuntos en una sola celda.
* **Ejemplo**:
  * **No en 1NF**: Una tabla que almacena los teléfonos de los empleados con
    múltiples números en una sola celda, como "123-456, 789-012".
  * **En 1NF**: Cada número de teléfono está en su propia fila, con el ID del
    empleado repetido si tienen más de un número.
> **Conclusión:** Debe haber solo un valor por celda.


### Segunda Forma Normal (2NF):
* **Definición**: Una tabla está en 2NF si cumple con 1NF y, además, todos los
  atributos no clave dependen completamente de la clave primaria. No debe haber
  dependencias parciales, donde un atributo dependa solo de parte de una clave
  primaria compuesta.
* **Ejemplo**:
  * **No en 2NF**: En una tabla de órdenes que tiene una clave primaria compuesta
    (OrderID, ProductID), si el ProductName depende solo de ProductID y no de la
    combinación completa de la clave primaria, se viola la 2NF.
  * **En 2NF**: Se elimina ProductName de la tabla de órdenes y se coloca en una
    tabla separada de productos, donde ProductID es la clave primaria.
> **Conclusión:** Todo lo que este en la tabla que no sea parte de la clave debe
> depender de la clave primaria completa(si es compuesta). Por ejemplo si tengo
> el `id_producto` no necesito el `nombre_producto`.

### Tercera Forma Normal (3NF):
* **Definición**: Una tabla está en 3NF si cumple con 2NF y, además, todos los
  atributos no clave dependen directamente de la clave primaria, sin
  dependencias transitivas. Es decir, no debe haber un atributo no clave que
  dependa de otro atributo no clave.
* **Ejemplo**:
  * **No en 3NF**: Una tabla de empleados que almacena EmployeeID, DepartmentID,
    y DepartmentName, donde DepartmentName depende de DepartmentID y no de 
    EmployeeID directamente. Esto crea una dependencia transitiva.
  * **En 3NF**: Se elimina DepartmentName de la tabla de empleados y se coloca
    en una tabla separada de departamentos, donde DepartmentID es la clave
    primaria.
> **Conclusión:** Todo lo que esté en la tabla debe depender únicamente de la 
> clave primaria.

--------------------------------------------------------------------------------

## ANALYZE

**[PostgreSQL]**

El comando **`ANALYZE`** es parte de **PostgreSQL** (aunque otros sistemas de gestión
de bases de datos también tienen comandos similares).

### Función de ANALYZE:
**`ANALYZE`** se utiliza para recopilar estadísticas sobre el contenido de las
tablas en una base de datos. Estas estadísticas son esenciales para el optimizador
de consultas, que las usa para generar planes de ejecución eficientes.

### Detalles:
* **Mejora el rendimiento**: Al recopilar estadísticas sobre la distribución de los
  datos en las columnas, **`ANALYZE`** permite que el optimizador de consultas
  seleccione los mejores índices y estrategias de acceso.
* **Ejecución automática**: En PostgreSQL, **`ANALYZE`** se puede ejecutar
  manualmente o configurarse para que se ejecute automáticamente en intervalos
  regulares.

### Ejemplo de uso:
```sql
ANALYZE my_table;
```
Esto actualizará las estadísticas de la tabla **`my_table`**, mejorando el rendimiento
de futuras consultas sobre esa tabla.
> **Conclusión:** **`ANALYZE`** actualiza las estadísticas de la tabla para hacer las
> consultas más eficientes.

--------------------------------------------------------------------------------

## Vista Materializada

Una **vista materializada** en el contexto de bases de datos relacionales es una
copia física de los datos que resulta de una consulta SQL, almacenada en una tabla.
A diferencia de una vista normal, que es simplemente una consulta almacenada que
se ejecuta cada vez que es llamada, una vista materializada guarda el resultado
de la consulta en el momento en que se crea o se actualiza.

### Características principales:
* **Persistencia de datos**: Almacena los datos físicamente en la base de datos,
  lo que permite un acceso más rápido a los resultados de la consulta.
* **Actualización periódica**: Puede ser configurada para actualizarse automáticamente
  en intervalos regulares o manualmente, para reflejar los cambios en los datos
  subyacentes.
* **Mejora de rendimiento**: Es útil para mejorar el rendimiento de consultas
  complejas o costosas que no necesitan ser recalculadas cada vez que se consultan.

### Ejemplo de uso:
Imagina una consulta que junta datos de varias tablas y realiza cálculos
complejos. Si esta consulta se ejecuta con frecuencia, podrías crear una vista
materializada para almacenar el resultado de esa consulta y así reducir el
tiempo de procesamiento en futuras solicitudes.
> **Conclusión:** Es como una vista normal que es solo una consulta almacenada, 
> pero ademas almacena el resultado de la consulta en una tabla. 

--------------------------------------------------------------------------------

## Crear índice en tabla

**[PostgreSQL]**

Para crear un índice en una tabla en PostgreSQL, se utiliza el comando **`CREATE INDEX`**.

```sql
CREATE INDEX index_name ON table_name (column_name);
```

### Ventaja:
* **Mejora el rendimiento de las consultas**: Los índices aceleran las consultas
  SELECT al permitir un acceso más rápido a los datos, especialmente en tablas
  grandes.

### Desventaja:
* **Costo de almacenamiento y escritura**: Los índices ocupan espacio adicional en
  el disco y pueden ralentizar las operaciones de inserción, actualización y
  eliminación, ya que el índice debe mantenerse actualizado.

### Caso de uso:
* **Consultas frecuentes en una columna**: Crear un índice es útil cuando una columna
  se usa frecuentemente en condiciones WHERE, JOIN, o en ordenamientos (ORDER BY).
  Por ejemplo, crear un índice en una columna **`email`** en una tabla de usuarios
  si las búsquedas por correo electrónico son comunes.

Este enfoque permite un acceso más rápido y eficiente a los datos, pero debe
usarse con cuidado, considerando el impacto en las operaciones de escritura y el
almacenamiento.

En PostgreSQL (y en la mayoría de los sistemas de bases de datos relacionales),
las claves primarias **(Primary Keys)** son automáticamente índices.

--------------------------------------------------------------------------------

## Crear restricción de unicidad

**[PostgreSQL]**

### Crear restricción de unicidad al crear la tabla:
```sql
CREATE TABLE nombre_tabla (
    columna1 tipo_dato,
    columna2 tipo_dato,
    columna3 tipo_dato,
    CONSTRAINT nombre_restriccion UNIQUE (columna2, columna3)
);
```

Otro forma
```sql
CREATE TABLE nombre_tabla (
    columna1 tipo_dato UNIQUE,
    columna2 tipo_dato,
    columna3 tipo_dato
);
```
Esto asegura que **`columna1`** no tendrá valores duplicados.

### Añadir restricción de unicidad a una tabla existente:
```sql
ALTER TABLE nombre_tabla 
ADD CONSTRAINT nombre_restriccion UNIQUE (columna);
```

--------------------------------------------------------------------------------

## SQL
SQL (Structured Query Language) es el lenguaje estándar para gestionar y 
manipular bases de datos relacionales. Permite realizar operaciones como 
consulta, inserción, actualización, y eliminación de datos, así como la creación 
y modificación de estructuras de bases de datos. SQL es fundamental para 
interactuar con bases de datos relacionales, asegurando la organización y el 
control eficiente de la información almacenada.

--------------------------------------------------------------------------------

## Insensibilidad a las Mayúsculas en SQL
SQL es insensible a las mayúsculas, lo que significa que el lenguaje no 
distingue entre letras mayúsculas y minúsculas en las palabras clave, nombres de 
tablas, columnas, y otras entidades. Esto permite escribir comandos SQL en 
mayúsculas, minúsculas o una combinación de ambas sin afectar su funcionamiento.

### Ejemplo:
Las siguientes sentencias SQL son equivalentes:
```sql
SELECT * FROM usuarios;
select * from usuarios;
SeLeCt * fRoM usuarios;
```

### Buenas Prácticas en el Uso de Mayúsculas y Minúsculas en SQL
Usar mayúsculas para las palabras clave SQL y minúsculas para nombres de tablas 
y columnas es una práctica profesional que mejora la legibilidad y coherencia del 
código. La consistencia en el estilo es clave para un código SQL más limpio y 
fácil de mantener.

#### Nombres de Más de una Palabra en SQL
Para nombres de más de una palabra en SQL, el uso de **snake case** (**`first_name`**, 
**`user_profiles`**) es la práctica más común y recomendada, proporcionando claridad
y uniformidad en la estructura de la base de datos.

--------------------------------------------------------------------------------

### RDBMS (Relational Database Management System)
Un **RDBMS** (Sistema de Gestión de Bases de Datos Relacionales) es un software 
que permite crear, gestionar y manipular bases de datos relacionales. En un RDBMS, 
los datos se organizan en tablas que están interrelacionadas mediante claves 
primarias y claves foráneas.

### Características Relevantes:
* **Estructura Tabular**: Los datos se almacenan en tablas que consisten en filas 
  (registros) y columnas (atributos).
* **Integridad Relacional**: Mantiene la consistencia y precisión de los datos 
  mediante restricciones como claves primarias, claves foráneas, y restricciones 
  de integridad.
* **Lenguaje SQL**: La mayoría de los RDBMS utilizan SQL como lenguaje estándar para 
  interactuar con las bases de datos.

--------------------------------------------------------------------------------

## Motor de Bases de Datos
Un **motor de bases de datos** es el componente software fundamental de un sistema 
de gestión de bases de datos (DBMS) que se encarga de realizar las operaciones 
esenciales de creación, lectura, actualización, y eliminación de datos (CRUD). 
El motor gestiona el acceso a los datos, la ejecución de consultas, y el manejo 
de la integridad y seguridad de los datos.

### Características:
* **Procesamiento de Consultas**: Interpreta y ejecuta las consultas SQL enviadas por 
  los usuarios.
* **Gestión de Transacciones**: Asegura la atomicidad, consistencia, aislamiento y 
  durabilidad (ACID) de las operaciones realizadas en la base de datos.
* **Optimización**: Utiliza técnicas de optimización para mejorar la eficiencia y el 
  rendimiento de las consultas.
* **Manejo de Concurrencia**: Administra el acceso simultáneo a los datos por 
  múltiples usuarios o procesos.

--------------------------------------------------------------------------------

## Primary Key (Clave Primaria)
Una **Primary Key** es un atributo o un conjunto de atributos en una tabla de una 
base de datos relacional que se utiliza para identificar de manera única cada 
registro (fila) en esa tabla. La clave primaria garantiza que no haya dos filas 
con el mismo valor o combinación de valores en las columnas designadas como clave 
primaria.

### Características:
* **Unicidad**: Cada valor en la columna o columnas de la clave primaria debe ser 
  único dentro de la tabla.
* **No Nulos**: Los valores en la clave primaria no pueden ser nulos (**`NULL`**).
* **Identificación Única**: Proporciona un identificador único para cada registro, lo 
  que es fundamental para establecer relaciones entre tablas.

--------------------------------------------------------------------------------

## Foreign Key (Clave Foránea)
Una **Foreign Key** es un atributo o un conjunto de atributos en una tabla de una 
base de datos relacional que establece y refuerza una relación entre dos tablas. 
La clave foránea en una tabla hace referencia a la clave primaria en otra tabla, 
creando un vínculo entre las filas de ambas tablas.

### Características:
* **Referencialidad**: La clave foránea crea una relación entre dos tablas al 
  referenciar la clave primaria de otra tabla.
* **Integridad Referencial**: Asegura que los valores de la clave foránea correspondan 
  a valores existentes en la clave primaria de la tabla referenciada, evitando la 
  creación de registros huérfanos o inconsistentes.
* **Múltiples Relaciones**: Una tabla puede contener múltiples claves foráneas, cada 
  una estableciendo una relación con diferentes tablas.

--------------------------------------------------------------------------------

## PostgreSQL
**PostgreSQL** es un sistema de gestión de bases de datos relacional y objeto-relacional 
de código abierto, conocido por su robustez, extensibilidad y conformidad con el 
estándar SQL. PostgreSQL es altamente respetado por su capacidad para manejar 
grandes volúmenes de datos y por ofrecer características avanzadas que son 
comparables a las de sistemas de bases de datos comerciales.

### Características:
* **Conformidad con SQL**: PostgreSQL es compatible con el estándar SQL, lo que 
  asegura que las consultas y comandos SQL sigan las normas establecidas.
* **Extensibilidad**: Permite a los usuarios crear sus propios tipos de datos, 
  operadores, y funciones personalizadas.
* **Soporte para Transacciones ACID**: Asegura la atomicidad, consistencia, 
  aislamiento, y durabilidad de las transacciones.
* **Alta Concurrencia**: Utiliza un sistema avanzado de control de concurrencia 
  multiversión (MVCC), permitiendo un manejo eficiente de múltiples operaciones 
  simultáneas.
* **Integridad de Datos**: Ofrece características avanzadas como claves foráneas, 
  disparadores, vistas, y restricciones de integridad para asegurar la precisión 
  y coherencia de los datos.

--------------------------------------------------------------------------------

## SELECT en SQL
El comando **`SELECT`** en SQL se utiliza para recuperar datos de una o más tablas 
de una base de datos. Es el comando más básico y fundamental para realizar 
consultas, permitiendo especificar las columnas que se desean obtener y las 
condiciones para filtrar los resultados.

### Sintaxis Básica:
```sql
SELECT columna1, columna2 FROM nombre_tabla WHERE condicion;
```

### Características Relevantes:
* **Proyección**: Permite seleccionar columnas específicas en lugar de todas las 
  columnas de la tabla.
* **Filtrado**: Puede combinarse con la cláusula **`WHERE`** para filtrar los resultados 
  basados en condiciones.
* **Alias**: Soporta alias para renombrar columnas temporalmente en el resultado.

### Ejemplo:
```sql
SELECT nombre, edad FROM usuarios WHERE edad > 18;
```
--------------------------------------------------------------------------------

## WHERE en SQL
La cláusula **`WHERE`** en SQL se utiliza para filtrar los registros que se 
devuelven en una consulta, actualización o eliminación. Esta cláusula permite 
especificar una condición que debe cumplirse para que las filas sean incluidas 
en el resultado de la operación.

### Sintaxis Básica:
```sql
SELECT columna1, columna2 FROM nombre_tabla WHERE condicion;
```

### Características:
* **Filtrado de Filas**: Solo las filas que cumplen la condición especificada en 
  **`WHERE`** serán procesadas.
* **Operadores**: Puede utilizarse con operadores como **`=`, `!=`, `<`, `>`, `LIKE`, `IN`,** 
  **`BETWEEN`**, entre otros, para crear condiciones más complejas.
* **Combinación con AND/OR**: Se pueden combinar múltiples condiciones usando **`AND`** y 
  **`OR`** para afinar el filtro.

### Ejemplo:
```sql
SELECT nombre, edad FROM usuarios WHERE edad > 18 AND ciudad = 'Madrid';
```

--------------------------------------------------------------------------------

## LIMIT en SQL
La cláusula **`LIMIT`** en SQL se utiliza para restringir el número de filas que 
se devuelven en el resultado de una consulta. Es especialmente útil cuando se 
necesita obtener solo una parte de los datos, como las primeras N filas.

### Sintaxis Básica:
```sql
SELECT columna1, columna2 FROM nombre_tabla LIMIT numero_filas;
```

### Características:
* **Restricción de Resultados**: Limita el número de filas devueltas por la consulta.
* **Ordenación Combinada**: A menudo se utiliza junto con ORDER BY para seleccionar 
  las primeras filas ordenadas según un criterio específico.
* **Compatibilidad**: El comportamiento y la sintaxis pueden variar ligeramente entre 
  diferentes sistemas de gestión de bases de datos, pero la funcionalidad básica 
  es similar.

### Ejemplo:
```sql
SELECT nombre, edad FROM usuarios ORDER BY edad DESC LIMIT 10;
```
* **Descripción**: Esta consulta selecciona los 10 usuarios más viejos de la tabla 
  usuarios.

--------------------------------------------------------------------------------

## ORDER BY en SQL
La cláusula **`ORDER BY`** en SQL se utiliza para ordenar los resultados de una 
consulta según uno o más criterios, ya sea en orden ascendente o descendente. Es 
una herramienta clave para organizar los datos de manera significativa antes de 
presentarlos.

### Sintaxis Básica:
```sql
SELECT columna1, columna2 FROM nombre_tabla ORDER BY columna1 [ASC | DESC];
```

### Características:
* **Orden Ascendente/Descendente**: De forma predeterminada, los resultados se 
  ordenan en orden ascendente (**`ASC`**), pero se puede especificar un orden 
  descendente (**`DESC`**).
* **Múltiples Columnas**: Se puede ordenar por más de una columna, lo que permite 
  ordenar jerárquicamente.
* **Compatibilidad con `LIMIT`**: Comúnmente se utiliza junto con **`LIMIT`** para obtener 
  un subconjunto ordenado de los resultados.

### Ejemplo:
```sql
SELECT nombre, edad FROM usuarios ORDER BY edad DESC, nombre ASC;
```
* Descripción: Esta consulta ordena los usuarios primero por edad en orden descendente, y en caso de empate, por nombre en orden ascendente.

--------------------------------------------------------------------------------

## Creación y Conexión a una BD en PostgreSQL utilizando psql en Ubuntu
**PostgreSQL** en Ubuntu se gestiona a través del terminal usando el cliente psql. 

### 1. Acceder a psql:
* Abre una terminal en Ubuntu y accede al cliente psql:
```bash
sudo -u postgres psql
```
* **Descripción**: Este comando inicia **`psql`** como el usuario **`postgres`**, que es el 
  superusuario predeterminado de PostgreSQL.

### 2. Crear una Base de Datos:
* Utiliza el siguiente comando para crear una nueva base de datos:
```sql
CREATE DATABASE nombre_base_datos;
```

### 3. Conectar a la Base de Datos:
* Una vez creada la base de datos, puedes conectarte a ella usando el comando:
```sql
\c nombre_base_datos;
```

--------------------------------------------------------------------------------

## Crear Base de Datos en PostgreSQL
```sql
CREATE DATABASE mi_base_de_datos;
```

--------------------------------------------------------------------------------

## Conectarse a Base de Datos en PostgreSQL
```sql
\c mi_base_de_datos;
```

--------------------------------------------------------------------------------

## Crear Tabla en PostgreSQL
```sql
CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100),
    edad INT
);
```

--------------------------------------------------------------------------------

## Insertar Registros en Tabla en PostgreSQL
```sql
INSERT INTO usuarios (nombre, edad) VALUES ('Juan', 25);
```

--------------------------------------------------------------------------------

## Borrar una Base de Datos en PostgreSQL
```sql
DROP DATABASE mi_base_de_datos;
```

--------------------------------------------------------------------------------

## Listar las Bases de Datos en PostgreSQL
```sql
\l
```

--------------------------------------------------------------------------------

## Añadir una Columna a una Tabla en PostgreSQL
```sql
ALTER TABLE usuarios ADD COLUMN email VARCHAR(255);
```

--------------------------------------------------------------------------------

## Eliminar una Columna de una Tabla en PostgreSQL
```sql
ALTER TABLE usuarios DROP COLUMN email;
```

--------------------------------------------------------------------------------

## Listar Todas las Tablas en PostgreSQL
```sql
\dt
```

--------------------------------------------------------------------------------

## Describir una Tabla en PostgreSQL
```sql
\d usuarios
```

--------------------------------------------------------------------------------

## Borrar Todos los Datos de una Tabla en PostgreSQL
```sql
DELETE FROM usuarios;
```

--------------------------------------------------------------------------------

## Borrar Algunos Datos de una Tabla en PostgreSQL
```sql
DELETE FROM usuarios WHERE edad < 18;
```

--------------------------------------------------------------------------------

## Insertar Varios Registros a una Tabla en PostgreSQL
```sql
INSERT INTO usuarios (nombre, edad) VALUES 
('Ana', 30),
('Carlos', 22),
('Beatriz', 28);
```

--------------------------------------------------------------------------------

## Función LEFT en PostgreSQL
Extrae un número determinado de caracteres desde el inicio de una cadena.
```sql
SELECT LEFT(nombre, 3) FROM usuarios;
```
Si nombre es 'Carlos', el resultado será 'Car'.

--------------------------------------------------------------------------------


--------------------------------------------------------------------------------