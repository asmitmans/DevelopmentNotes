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
- [Función `LEFT` en PostgreSQL](#función-left-en-postgresql)
- [Función `COALESCE` en PostgreSQL](#función-coalesce-en-postgresql)
- [Función `LOWER` en PostgreSQL](#función-lower-en-postgresql)
- [Función `UPPER` en PostgreSQL](#función-upper-en-postgresql)
- [Función `LENGTH` en PostgreSQL](#función-length-en-postgresql)
- [Función de Agregación `SUM()` en PostgreSQL](#función-de-agregación-sum-en-postgresql)
- [Función de Agregación `AVG()` en PostgreSQL](#función-de-agregación-avg-en-postgresql)
- [Función de Agregación `COUNT()` en PostgreSQL](#función-de-agregación-count-en-postgresql)
- [Función de Agregación `MAX()` en PostgreSQL](#función-de-agregación-max-en-postgresql)
- [Función de Agregación `MIN()` en PostgreSQL](#función-de-agregación-min-en-postgresql)
- [GROUP BY en PostgreSQL](#group-by-en-postgresql)
- [Modelo de Datos en Bases de Datos Relacionales](#modelo-de-datos-en-bases-de-datos-relacionales)
- [Modelo de Datos Físico en Bases de Datos Relacionales](#modelo-de-datos-físico-en-bases-de-datos-relacionales)
- [Queries Anidadas o Subconsultas en PostgreSQL](#queries-anidadas-o-subconsultas-en-postgresql)
- [Operaciones de Unión entre Tablas en PostgreSQL](#operaciones-de-unión-entre-tablas-en-postgresql)
- [INNER JOIN](#inner-join)
- [LEFT OUTER JOIN (LEFT JOIN)](#left-outer-join-left-join)
- [RIGHT OUTER JOIN (RIGHT JOIN)](#right-outer-join-right-join)
- [FULL OUTER JOIN](#full-outer-join)
- [HAVING en SQL](#having-en-sql)
- [Data Manipulation Language (DML) en SQL](#data-manipulation-language-dml-en-sql)
- [Uso de IN en SQL](#uso-de-in-en-sql)
- [Uso de `DELETE` sin condicion](#uso-de-delete-sin-condicion)
- [Uso de `UPDATE` sin condicion](#uso-de-update-sin-condicion)
- [Tipos de Datos en PostgreSQL](#tipos-de-datos-en-postgresql)
- [Tipos de Datos Numéricos en PostgreSQL con Rangos de Valores](#tipos-de-datos-numéricos-en-postgresql-con-rangos-de-valores)
- [Restricciones en SQL](#restricciones-en-sql)
- [SERIAL en PostgreSQL](#serial-en-postgresql)
- [Importancia de la Integridad Referencial en las Tablas](#importancia-de-la-integridad-referencial-en-las-tablas)


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

### Cómo Crear una Primary Key
1. #### Al crear la tabla:
* Puedes definir la clave primaria directamente al crear la tabla.
* **Ejemplo**:
```sql
CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100),
    email VARCHAR(255)
);
```
2. #### Al añadir la columna:
* Si la columna ya existe y deseas convertirla en una clave primaria, puedes 
  hacerlo con **`ALTER TABLE`**.
* **Ejemplo**:
```sql
ALTER TABLE usuarios ADD PRIMARY KEY (id);
```

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

### Cómo Crear una Foreign Key
1. #### Al crear la tabla:
* Puedes definir la clave foránea directamente al crear la tabla.
* **Ejemplo**:
```sql
CREATE TABLE pedidos (
    id SERIAL PRIMARY KEY,
    id_usuario INT REFERENCES usuarios(id),
    fecha DATE
);
```

2. #### Al añadir la columna:
* Si la columna ya existe y deseas convertirla en una clave foránea, puedes 
  hacerlo con **`ALTER TABLE`**.
* **Ejemplo**:
```sql
ALTER TABLE pedidos ADD CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES usuarios(id);
```

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

## Función `LEFT` en PostgreSQL
Extrae un número determinado de caracteres desde el inicio de una cadena.
```sql
SELECT LEFT(nombre, 3) FROM usuarios;
```
Si nombre es 'Carlos', el resultado será 'Car'.

--------------------------------------------------------------------------------

## Función `COALESCE` en PostgreSQL
Devuelve el primer valor no nulo de la lista de expresiones proporcionadas.
```sql
SELECT COALESCE(email, 'sin_email@example.com') FROM usuarios;
```
Si **`email`** es **`NULL`**, el resultado será **`'sin_email@example.com'`**.

--------------------------------------------------------------------------------

## Función `LOWER` en PostgreSQL
Convierte todos los caracteres de una cadena a minúsculas.
```sql
SELECT LOWER(nombre) FROM usuarios;
```
Si `nombre` es `'Carlos'`, el resultado será `'carlos'`.

--------------------------------------------------------------------------------

## Función `UPPER` en PostgreSQL
Convierte todos los caracteres de una cadena a mayúsculas.
```sql
SELECT UPPER(nombre) FROM usuarios;
```
Si nombre es 'Carlos', el resultado será 'CARLOS'.

--------------------------------------------------------------------------------

## Función `LENGTH` en PostgreSQL
Devuelve la longitud de una cadena en número de caracteres.
```sql
SELECT LENGTH(nombre) FROM usuarios;
```
Si nombre es 'Carlos', el resultado será 6.

--------------------------------------------------------------------------------

## Función de Agregación `SUM()` en PostgreSQL
Calcula la suma total de los valores en una columna numérica. Se puede usar sin 
**`GROUP BY`** para sumar todos los valores, o con **`GROUP BY`** para sumar valores 
dentro de grupos específicos.
```sql
SELECT SUM(edad) FROM usuarios;
```
Si las edades son 25, 30, y 35, el resultado será 90.

--------------------------------------------------------------------------------

## Función de Agregación `AVG()` en PostgreSQL
Calcula el promedio (media aritmética) de los valores en una columna numérica. 
Se puede usar sin **`GROUP BY`** para promediar todos los valores, o con **`GROUP BY`** para 
promediar valores dentro de grupos específicos.
```sql
SELECT AVG(edad) FROM usuarios;
```
Si las edades son 25, 30, y 35, el resultado será 30.

--------------------------------------------------------------------------------

## Función de Agregación `COUNT()` en PostgreSQL
* **`COUNT(*)`** cuenta todas las filas, incluidas las que tienen valores nulos en 
  cualquier campo.
* **`COUNT(campo)`** cuenta solo las filas donde el campo especificado no es nulo.

```sql
SELECT COUNT(*) FROM usuarios;
```
Si hay 10 registros en la tabla **`usuarios`**, el resultado será **`10`**.

```sql
SELECT COUNT(email) FROM usuarios;
```
Si hay 10 registros en la tabla usuarios y 7 de ellos tienen un valor no nulo en
la columna email, el resultado será 7.

--------------------------------------------------------------------------------

## Función de Agregación `MAX()` en PostgreSQL
Devuelve el valor máximo en una columna numérica o de fecha. Se puede usar sin 
**`GROUP BY`** para obtener el valor máximo de toda la tabla, o con **`GROUP BY`** para 
obtener el valor máximo dentro de cada grupo específico.
```sql
SELECT MAX(edad) FROM usuarios;
```
Si las edades en la tabla son 25, 30, y 35, el resultado será 35.

--------------------------------------------------------------------------------

## Función de Agregación `MIN()` en PostgreSQL
Devuelve el valor mínimo en una columna numérica o de fecha. Se puede usar sin 
**`GROUP BY`** para obtener el valor mínimo de toda la tabla, o con **`GROUP BY`** para
obtener el valor mínimo dentro de cada grupo específico.
```sql
SELECT MIN(edad) FROM usuarios;
```
Si las edades en la tabla son 25, 30, y 35, el resultado será 25.

--------------------------------------------------------------------------------

## GROUP BY en PostgreSQL
**`GROUP BY`** es una cláusula en SQL que se utiliza para agrupar filas que tienen 
los mismos valores en columnas especificadas en grupos. Esta agrupación permite 
aplicar funciones de agregación (como **`SUM`, `AVG`, `COUNT`, `MAX`, `MIN`**) a cada 
grupo de datos.

### Uso
**`GROUP BY`** se utiliza después de la cláusula **`WHERE`** y antes de la cláusula 
**`ORDER BY`** (si se utiliza). Los campos especificados en **`GROUP BY`** determinan cómo 
se agrupan las filas en el resultado.

### Ejemplo: Precio más alto por categoría mostrando la categoría

Supongamos que tenemos una tabla **`productos`** con las columnas **`categoria`, `nombre`**, y 
**`precio`**. Queremos encontrar el precio más alto por categoría.
```sql
SELECT categoria, MAX(precio) 
FROM productos 
GROUP BY categoria;
```
* **Explicación**:
  * **`SELECT categoria, MAX(precio)`**: Selecciona la categoría y el precio máximo 
    dentro de esa categoría.
  * **`GROUP BY categoria`**: Agrupa los registros por la columna categoria, asegurando 
    que cada grupo contenga registros con la misma categoría.

* **Regla Importante**: Solo puedes incluir en el **`SELECT`** las columnas que 
  están en la cláusula **`GROUP BY`** o las que están dentro de una función de 
  agregación. Esto asegura que el resultado sea coherente y no haya ambigüedad 
  en los datos mostrados.
  
--------------------------------------------------------------------------------
  
## Modelo de Datos en Bases de Datos Relacionales
Un **modelo de datos** es una representación abstracta que define cómo se organizan, 
almacenan, y manipulan los datos en una base de datos relacional. Este modelo 
establece las estructuras de datos (tablas, columnas) y las relaciones entre 
ellas.

### Componentes Clave:
**1. Entidades (Tablas)**: Representan objetos o conceptos del mundo real, como 
  "Usuarios" o "Productos".
**2. Atributos (Columnas)**: Describen propiedades o características de las 
  entidades, como "nombre", "edad" o "precio".
**3. Relaciones**: Definen cómo las entidades están conectadas entre sí, 
  utilizando claves primarias y foráneas.
**4. Restricciones**: Reglas que aseguran la integridad y validez de los datos, 
  como `UNIQUE`, `NOT NULL`, y `FOREIGN KEY`.

### Ejemplo de un Modelo de Datos:
* **Tabla Usuarios**:
  * id_usuario (Primary Key)
  * nombre
  * email
  
* **Tabla Pedidos**:
  * id_pedido (Primary Key)
  * fecha
  * id_usuario (Foreign Key que refiere a Usuarios)

**Relación**:
* Un **usuario** puede tener muchos pedidos, lo que define una relación uno a muchos 
  entre las tablas Usuarios y Pedidos.
  
--------------------------------------------------------------------------------
  
## Modelo de Datos Físico en Bases de Datos Relacionales
El modelo de datos físico es una representación detallada de cómo los datos se 
almacenan y se organizan en un sistema de gestión de bases de datos (DBMS) a 
nivel físico. Este modelo se enfoca en la implementación real de la base de datos 
en hardware, incluyendo detalles como estructuras de almacenamiento, índices, y 
particionamiento.

### Componentes Clave:
1. **Tablas y Columnas**: Definición específica de las tablas, tipos de datos de las 
   columnas, y restricciones a nivel de base de datos.
3. **Índices**: Estructuras que mejoran la velocidad de las consultas al permitir 
   acceso rápido a los datos.
4. **Particionamiento**: Dividir grandes tablas en partes más pequeñas para mejorar 
   el rendimiento y la gestión.
5. **Espacios de Almacenamiento**: Definición de los discos o volúmenes donde se 
   almacenarán los datos.
6. **Optimización del Rendimiento**: Uso de técnicas como la desnormalización para 
   mejorar la eficiencia de las consultas.

### Ejemplo de un Modelo de Datos Físico:
* **Tabla Usuarios**:
  * **`id_usuario`** (INTEGER, PRIMARY KEY, almacenado en un índice de tipo B-tree)
  * **`nombre`** (VARCHAR(100))
  * **`email`** (VARCHAR(255), INDEX para búsquedas rápidas)

* **Índices**:
  * Índice **`idx_email`** en la columna email para acelerar las consultas que buscan 
    usuarios por su dirección de correo electrónico.

--------------------------------------------------------------------------------

## Queries Anidadas o Subconsultas en PostgreSQL
Una subconsulta o query anidada es una consulta dentro de otra consulta (consulta 
exterior). La subconsulta se ejecuta primero, y su resultado se utiliza en la 
consulta exterior para realizar cálculos o filtros adicionales.

#### Consulta Exterior y Consulta Interior:
* **Consulta Exterior**: Es la consulta principal que recibe los resultados de la 
  subconsulta.
* **Consulta Interior**: Es la subconsulta que se ejecuta dentro de la consulta 
  exterior para proporcionar datos adicionales.

### Ejemplo: Obtener las Ventas Promedio por Vendedor
Supongamos que tienes una tabla ventas con las columnas empleado_id y monto, y 
deseas calcular el promedio de ventas por vendedor utilizando una subconsulta.

#### Objetivo:
1. **Calcular la suma total de ventas por vendedor**.
2. **Calcular el promedio de esas sumas para obtener el promedio de ventas por** 
   **vendedor**.

```sql
SELECT AVG(ventas_por_vendedor) AS promedio_ventas_por_vendedor
FROM (
    SELECT empleado_id, SUM(monto) AS ventas_por_vendedor
    FROM ventas
    GROUP BY empleado_id
) AS subconsulta;
```
  
--------------------------------------------------------------------------------

## Operaciones de Unión entre Tablas en PostgreSQL
Las operaciones de unión (joins) se utilizan en SQL para combinar filas de dos o 
más tablas basándose en una columna relacionada entre ellas.

--------------------------------------------------------------------------------

## INNER JOIN
* **Descripción**: Combina filas de dos tablas donde las columnas relacionadas tienen 
  valores coincidentes en ambas tablas. Solo se devuelven las filas que tienen 
  coincidencias en ambas tablas.

* **Ejemplo**:

```sql
SELECT a.nombre, b.pedido
FROM clientes a
INNER JOIN pedidos b ON a.cliente_id = b.cliente_id;
```
* **Resultado**: Devuelve solo los clientes que tienen pedidos.

--------------------------------------------------------------------------------

## LEFT OUTER JOIN (LEFT JOIN)
* **Descripción**: Devuelve todas las filas de la tabla de la izquierda (la primera tabla mencionada), y las filas coincidentes de la tabla de la derecha. Si no hay 
coincidencias, las columnas de la tabla derecha se completan con **`NULL`**.

* **Ejemplo**:
```sql
SELECT a.nombre, b.pedido
FROM clientes a
LEFT JOIN pedidos b ON a.cliente_id = b.cliente_id;
```
* **Resultado**: Devuelve todos los clientes, incluso aquellos que no tienen pedidos 
  (con **`NULL`** en las columnas del pedido).
  
--------------------------------------------------------------------------------

## RIGHT OUTER JOIN (RIGHT JOIN)
* **Descripción**: Devuelve todas las filas de la tabla de la derecha (la segunda 
  tabla mencionada), y las filas coincidentes de la tabla de la izquierda. Si no 
  hay coincidencias, las columnas de la tabla izquierda se completan con **`NULL`**.

* **Ejemplo**:

```sql
SELECT a.nombre, b.pedido
FROM clientes a
RIGHT JOIN pedidos b ON a.cliente_id = b.cliente_id;
```
* **Resultado**: Devuelve todos los pedidos, incluso aquellos que no están asociados 
  con ningún cliente (con **`NULL`** en las columnas del cliente).

--------------------------------------------------------------------------------

## FULL OUTER JOIN
* **Descripción**: Devuelve todas las filas cuando hay coincidencia en una de las 
  tablas. Si no hay coincidencias, las filas se completan con **`NULL`** en las 
  columnas de la tabla que no coincide.

* **Ejemplo**:

```sql
SELECT a.nombre, b.pedido
FROM clientes a
FULL OUTER JOIN pedidos b ON a.cliente_id = b.cliente_id;
```
* **Resultado**: Devuelve todos los clientes y todos los pedidos, incluyendo aquellos 
  que no tienen coincidencias en la otra tabla (con **`NULL`** en las columnas donde no 
  hay coincidencia).

--------------------------------------------------------------------------------

## HAVING en SQL
La cláusula HAVING en SQL se utiliza para filtrar resultados después de que se 
hayan aplicado funciones de agregación (como SUM, AVG, COUNT, etc.). HAVING es 
similar a WHERE, pero se usa en conjunto con GROUP BY para filtrar los grupos de 
resultados generados por la consulta.

### WHERE vs HAVING
#### WHERE**:
* Se utiliza para filtrar filas individuales antes de aplicar cualquier función 
  de agregación.
* No puede utilizarse para filtrar resultados basados en agregaciones.
* **Ejemplo**:
```sql
SELECT empleado_id, SUM(monto) 
FROM ventas 
WHERE monto > 100 
GROUP BY empleado_id;
```
* Aquí, **`WHERE`** filtra las filas individuales donde monto es mayor que 100 antes 
  de realizar la agregación.

#### HAVING:
* Se utiliza para filtrar los resultados después de que se hayan aplicado las 
  funciones de agregación y los grupos hayan sido formados.
* Se utiliza principalmente para filtrar grupos de datos.
* **Ejemplo**:
```sql
SELECT empleado_id, SUM(monto) 
FROM ventas 
GROUP BY empleado_id 
HAVING SUM(monto) > 1000;
```
* Aquí, **`HAVING`** filtra los grupos para incluir solo aquellos cuyo total 
  (SUM(monto)) es mayor que 1000.  
  
--------------------------------------------------------------------------------

## Data Manipulation Language (DML) en SQL
**Data Manipulation Language (DML)** es un subconjunto de SQL que incluye los 
comandos utilizados para manipular y gestionar los datos en una base de datos 
relacional. Estos comandos permiten insertar, actualizar, eliminar y consultar 
datos almacenados en las tablas.

### Principales Comandos DML:
1. #### INSERT:
* **Función**: Se utiliza para insertar nuevos registros en una tabla.
* **Ejemplo**:
```sql
INSERT INTO empleados (nombre, edad, departamento) VALUES ('Juan', 30, 'Ventas');
```

2. #### UPDATE:
* **Función**: Se utiliza para modificar los datos existentes en una tabla.
* **Ejemplo**:
```sql
UPDATE empleados SET edad = 31 WHERE nombre = 'Juan';
```
Otro ejemplo
```sql
UPDATE empleados SET departamento = 'Marketing' WHERE departamento = 'Ventas' 
AND edad > 25;
```

3. #### DELETE:
* **Función**: Se utiliza para eliminar registros de una tabla.
* **Ejemplo**:
```sql
DELETE FROM empleados WHERE nombre = 'Juan';
```

4. #### SELECT:
* **Función**: Se utiliza para consultar y recuperar datos de una tabla.
* **Ejemplo**:
```sql
SELECT nombre, edad FROM empleados WHERE departamento = 'Ventas';
```
### Características Relevantes:
* **Transacciones**: Las operaciones DML generalmente se realizan dentro de 
  transacciones para garantizar la integridad de los datos. Esto significa que 
  los cambios pueden ser confirmados (**`COMMIT`**) o revertidos (**`ROLLBACK`**).
* **Manipulación de Datos**: DML se enfoca exclusivamente en la manipulación de los 
  datos existentes en la base de datos, a diferencia del Data Definition 
  Language (DDL), que se usa para definir la estructura de la base de datos.
  
--------------------------------------------------------------------------------

## Uso de IN en SQL
La cláusula **`IN`** en SQL se utiliza para especificar múltiples valores en una 
condición **`WHERE`**. Es una forma concisa de verificar si un valor de una columna 
coincide con alguno de los valores dentro de una lista o subconsulta.

### Sintaxis Básica:
```sql
SELECT columna1, columna2 
FROM nombre_tabla 
WHERE columna IN (valor1, valor2, valor3, ...);
```

### Ejemplo con Lista de Valores:
```sql
SELECT nombre, departamento 
FROM empleados 
WHERE departamento IN ('Ventas', 'Marketing', 'IT');
```
* **Explicación**: Este comando selecciona todos los empleados cuyos departamentos 
  sean "Ventas", "Marketing" o "IT".

### Ejemplo con Subconsulta:
```sql
SELECT nombre, departamento 
FROM empleados 
WHERE departamento IN (SELECT departamento FROM departamentos 
WHERE ubicacion = 'Madrid');
```
* **Explicación**: Este comando selecciona todos los empleados cuyos departamentos 
  coinciden con los departamentos ubicados en "Madrid" según la tabla 
  **`departamentos`**.

### Ventajas de IN:
* **Simplicidad**: Permite evitar el uso de múltiples condiciones OR.
* **Legibilidad**: Hace que las consultas sean más legibles y fáciles de entender 
  cuando se comparan varios valores.

--------------------------------------------------------------------------------

## Uso de `DELETE` sin condicion
Si intentas borrar un registro en una tabla SQL sin especificar un campo 
identificador (o cualquier condición en la cláusula **`WHERE`**), el comando de 
eliminación podría eliminar todos los registros de la tabla.

### Ejemplo:
Supongamos que tienes la tabla **`empleados`**, y ejecutas el siguiente comando sin 
una condición **`WHERE`**:
```sql
DELETE FROM empleados;
```
**Consecuencia**:
* ***Sin `WHERE`**: Este comando eliminaría todos los registros de la tabla empleados, 
  dejando la tabla vacía.

--------------------------------------------------------------------------------

## Uso de `UPDATE` sin condicion
Si se ejecuta un comando **`UPDATE`** sin incluir una cláusula **`WHERE`**, se actualizarán 
todos los registros de la tabla.

### Ejemplo:
Supongamos que tienes la tabla **`empleados`**, y ejecutas el siguiente comando sin 
una condición **`WHERE`**:
```sql
UPDATE empleados 
SET departamento = 'Marketing';
```
**Consecuencia**:
* **Sin `WHERE`**: Este comando cambiaría el valor del campo departamento a "Marketing" 
  para todos los registros en la tabla **`empleados`**, independientemente de su valor 
  original.

--------------------------------------------------------------------------------

## Tipos de Datos en PostgreSQL
PostgreSQL soporta una amplia variedad de tipos de datos que se pueden utilizar 
para definir las columnas de una tabla. A continuación se presenta una lista de 
los tipos de datos más comunes:

1. ### Tipos Numéricos
* **`INTEGER (INT)`**: Entero de 4 bytes.
* **`SMALLINT`**: Entero pequeño de 2 bytes.
* **`BIGINT`**: Entero grande de 8 bytes.
* **`SERIAL`**: Entero autoincremental de 4 bytes.
* **`BIGSERIAL`**: Entero autoincremental de 8 bytes.
* **`DECIMAL / NUMERIC`**: Número exacto con precisión y escala definidas.
* **`REAL`**: Número de punto flotante de 4 bytes.
* **`DOUBLE PRECISION`**: Número de punto flotante de 8 bytes.

2. ### Tipos de Cadenas de Texto
* **`VARCHAR(n)`**: Cadena de texto de longitud variable con un límite de **`n`** caracteres.
* **`CHAR(n)`**: Cadena de texto de longitud fija de **`n`** caracteres.
* **`TEXT`**: Cadena de texto de longitud variable sin límite específico.

3. ### Tipos de Fecha y Hora
* **`DATE`**: Fecha (año, mes, día).
* **`TIME [WITHOUT TIME ZONE]`**: Hora del día (sin información de zona horaria).
* **`TIMESTAMP [WITHOUT TIME ZONE]`**: Marca de tiempo (fecha y hora sin zona horaria).
* **`TIMESTAMP WITH TIME ZONE`**: Marca de tiempo con zona horaria.
* **`INTERVAL`**: Intervalo de tiempo (diferencia entre dos tiempos).

4. ### Tipos Booleanos
* **`BOOLEAN`**: Valor lógico que puede ser **`TRUE`, `FALSE` o `NULL`**.

5. ### Tipos Monetarios
* **`MONEY`**: Valor monetario con símbolo de moneda.

6. ### Tipos de Datos Binarios
* **`BYTEA`**: Datos binarios (byte array).

7. ### Tipos Geográficos
* **`POINT`**: Un punto en un plano de 2D.
* **`LINE`**: Línea infinita en un plano de 2D.
* **`LSEG`**: Segmento de línea en un plano de 2D.
* **`BOX`**: Rectángulo en un plano de 2D.
* **`PATH`**: Camino geométrico en un plano de 2D.
* **`POLYGON`**: Polígono en un plano de 2D.
* **`CIRCLE`**: Círculo en un plano de 2D.

8. ### Tipos de Datos JSON
* **`JSON`**: Datos en formato JSON, sin verificación de la estructura.
* **`JSONB`**: Datos en formato JSON almacenados en formato binario con 
  verificación de la estructura.

9. ### Tipos de Datos de Matriz
* **`<tipo_de_dato>[]`**: Matriz de cualquier tipo de datos base (ej. **`INTEGER[]`**, 
  **`TEXT[]`**).

1.  ### Otros Tipos de Datos
* **`UUID`**: Identificador único universal.
* **`XML`**: Datos en formato XML.
* **`ARRAY`**: Matriz de elementos de un tipo de datos.
* **`CIDR`, `INET`, `MACADDR`**: Para almacenar direcciones de red, IP, y direcciones MAC.

--------------------------------------------------------------------------------

## Tipos de Datos Numéricos en PostgreSQL con Rangos de Valores

| **Tipo de Dato**        | **Descripción**                                | **Rango de Valores**                                           | **Precisión**                 |
|-------------------------|------------------------------------------------|----------------------------------------------------------------|-------------------------------|
| `INTEGER` (`INT`)       | Entero de 4 bytes                              | -2,147,483,648 a 2,147,483,647                                 | N/A                           |
| `SMALLINT`              | Entero pequeño de 2 bytes                      | -32,768 a 32,767                                               | N/A                           |
| `BIGINT`                | Entero grande de 8 bytes                       | -9,223,372,036,854,775,808 a 9,223,372,036,854,775,807         | N/A                           |
| `SERIAL`                | Entero autoincremental de 4 bytes              | 1 a 2,147,483,647                                              | N/A                           |
| `BIGSERIAL`             | Entero autoincremental de 8 bytes              | 1 a 9,223,372,036,854,775,807                                  | N/A                           |
| `DECIMAL` / `NUMERIC`   | Número exacto con precisión y escala definidas | Ajustable según la precisión especificada                      | Definida por el usuario       |
| `REAL`                  | Número de punto flotante de 4 bytes            | Aproximadamente de -3.4 * 10^38 a 3.4 * 10^38                  | 6 decimales significativos    |
| `DOUBLE PRECISION`      | Número de punto flotante de 8 bytes            | Aproximadamente de -1.7 * 10^308 a 1.7 * 10^308                | 15 decimales significativos   |

--------------------------------------------------------------------------------

## Restricciones en SQL
Las restricciones en SQL son reglas que se aplican a las columnas de una tabla 
para asegurar la integridad de los datos.

1. ### NOT NULL:
* **Función**: Evita que se inserten valores **`NULL`** en la columna.
* **Uso**: Se aplica cuando un campo debe tener siempre un valor. 
  Por ejemplo, una columna nombre no debe estar vacía.

2. ### UNIQUE:
* **Función**: Asegura que todos los valores en una columna sean distintos.
* **Uso**: Utilizado en campos como **`email`** o **`username`** donde no se 
  permiten duplicados.

3. ### PRIMARY KEY:
* **Función**: Combina **`NOT NULL`** y **`UNIQUE`** en una columna o conjunto de columnas para 
  identificar de manera única cada fila de la tabla.
* **Uso**: Se utiliza comúnmente en la columna id de una tabla para asegurar que 
  cada registro tenga un identificador único.

4. ### FOREIGN KEY:
* **Función**: Enlaza dos tablas y asegura que el valor en la columna de la clave 
  foránea coincida con un valor en la columna de la clave primaria de otra tabla.
* **Uso**: Establece relaciones entre tablas, como vincular **`cliente_id`** en una tabla 
  de pedidos a **`id`** en una tabla de clientes.

--------------------------------------------------------------------------------

## SERIAL en PostgreSQL
**`SERIAL`** es un tipo de dato especial en PostgreSQL utilizado para crear columnas 
con valores enteros autoincrementales. Es una forma abreviada de definir una 
columna que automáticamente genera un valor único e incremental para cada nueva 
fila insertada en la tabla.

### Características:
* **Rango de Valores**:
  * **`SERIAL`** es equivalente a **`INTEGER`** con un rango de valores de 1 a 2,147,483,647.
* **Automatización**:
  * PostgreSQL crea automáticamente una secuencia y la asocia con la columna SERIAL.
* **Uso Común**:
  * Se utiliza principalmente para crear claves primarias.

### Sintaxis:
```sql
CREATE TABLE ejemplo (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100)
);
```
**Explicación**:
* **`id SERIAL PRIMARY KEY`**: Define la columna **`id`** como un **`SERIAL`**, lo que 
  significa que PostgreSQL asignará automáticamente un valor único e incremental 
  a esta columna para cada nueva fila. También se define como clave primaria 
  (**`PRIMARY KEY`**), lo que asegura que cada valor en la columna id sea único y 
  no nulo.

### Equivalente Explicado:
Definir una columna como **`SERIAL`** es equivalente a:
```sql
id INTEGER NOT NULL DEFAULT nextval('nombre_de_la_secuencia') PRIMARY KEY;
```
Aquí, PostgreSQL:
1. Crea una secuencia automática.
2. Establece el valor predeterminado de la columna como el siguiente valor en la 
   secuencia.
3. Asigna automáticamente valores incrementales a medida que se insertan nuevas 
   filas.

--------------------------------------------------------------------------------

## Importancia de la Integridad Referencial en las Tablas
### ¿Qué es la Integridad Referencial?
La **integridad referencial** es un concepto clave en bases de datos relacionales 
que asegura que las relaciones entre tablas permanezcan consistentes. Se logra 
mediante el uso de claves foráneas (**`FOREIGN KEY`**), que vinculan una columna 
en una tabla con una clave primaria en otra tabla.

### Razones por las que es Importante la Integridad Referencial:
#### 1. Consistencia de Datos:
Garantiza que los datos en la base de datos estén siempre en un estado coherente. 
Por ejemplo, si una tabla de pedidos hace referencia a una tabla de clientes, la 
integridad referencial asegura que no puedas crear un pedido para un cliente que 
no existe en la base de datos.

2. #### Prevención de Errores:
Ayuda a evitar la introducción de datos inválidos o huérfanos. Por ejemplo, si 
se elimina un cliente de la tabla de clientes, la integridad referencial evitaría 
que existan pedidos que referencien a ese cliente inexistente, evitando así datos 
inconsistentes o "huérfanos".

3. #### Mantenimiento de Relaciones Lógicas:
Asegura que las relaciones entre las tablas se mantengan correctas y lógicas a lo 
largo del tiempo. Esto es crucial en aplicaciones donde las tablas están 
fuertemente interrelacionadas, como en sistemas de gestión de inventarios o 
sistemas de facturación.

4. #### Facilita la Mantenibilidad:
Una base de datos con integridad referencial es más fácil de mantener y auditar. 
Las reglas de integridad referencial permiten a los administradores y 
desarrolladores confiar en que las relaciones entre datos son correctas, lo que 
simplifica las actualizaciones, eliminaciones y otras operaciones de mantenimiento.

5. #### Optimización de Consultas:
Las bases de datos relacionales pueden optimizar consultas de manera más efectiva 
cuando se asegura la integridad referencial, ya que el sistema puede hacer 
suposiciones seguras sobre las relaciones entre tablas, mejorando el rendimiento. 

--------------------------------------------------------------------------------































