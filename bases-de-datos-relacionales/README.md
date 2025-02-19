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
- [¿Qué es una Transacción en Bases de Datos?](#qué-es-una-transacción-en-bases-de-datos)
- [Comandos de Transacciones en SQL](#comandos-de-transacciones-en-sql)
- [Modo Autocommit en SQL](#modo-autocommit-en-sql)
- [Buenas Prácticas en la Gestión de Bases de Datos Relacionales](#buenas-prácticas-en-la-gestión-de-bases-de-datos-relacionales)
- [Lenguaje de Definición de Datos (DDL) en SQL](#lenguaje-de-definición-de-datos-ddl-en-sql)
- [Borrar Tablas Referenciadas en SQL](#borrar-tablas-referenciadas-en-sql)
- [Modelo Entidad-Relación (ER)](#modelo-entidad-relación-er)
- [Modelo Conceptual de Entidad-Relación](#modelo-conceptual-de-entidad-relación)
- [Carfinalidad](#carfinalidad)
- [Entidades Fuertes y Entidades Débiles](#entidades-fuertes-y-entidades-débiles)
- [Diferencias Fundamentales entre el Modelo Relacional y el Modelo Conceptual](#diferencias-fundamentales-entre-el-modelo-relacional-y-el-modelo-conceptual)
- [Modelo Lógico](#modelo-lógico)
- [Modelo Físico](#modelo-físico)
- [Normalización y Desnormalización](#normalización-y-desnormalización)


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

- Ejemplo con restricciones y valor por defecto
```sql
CREATE TABLE productos (
	id SERIAL PRIMARY KEY,
	codigo_producto VARCHAR(25) NOT NULL,
	precio_unitario INT NOT NULL,
	stock INT DEFAULT 0 NOT NULL
);
```

- Ejemplo con tipo de dato de fecha
```sql
CREATE TABLE ordenes_compra (
	id SERIAL PRIMARY KEY,
	emision DATE NOT NULL,
	entrega DATE NOT NULL,
	solicitada DATE NOT NULL
);
```

- Ejemplo restricción de foreign key
```sql
CREATE TABLE detalle (
	id SERIAL PRIMARY KEY,
	codigo_producto VARCHAR(25) NOT NULL,
	cantidad INT DEFAULT 0 NOT NULL,
	total_detalle INT DEFAULT 0 NOT NULL,
	orden_id INT NOT NULL,
	CONSTRAINT fk_orden FOREIGN KEY (orden_id) REFERENCES ordenes_compra(id)
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

#### 2. Prevención de Errores:
Ayuda a evitar la introducción de datos inválidos o huérfanos. Por ejemplo, si 
se elimina un cliente de la tabla de clientes, la integridad referencial evitaría 
que existan pedidos que referencien a ese cliente inexistente, evitando así datos 
inconsistentes o "huérfanos".

#### 3. Mantenimiento de Relaciones Lógicas:
Asegura que las relaciones entre las tablas se mantengan correctas y lógicas a lo 
largo del tiempo. Esto es crucial en aplicaciones donde las tablas están 
fuertemente interrelacionadas, como en sistemas de gestión de inventarios o 
sistemas de facturación.

#### 4. Facilita la Mantenibilidad:
Una base de datos con integridad referencial es más fácil de mantener y auditar. 
Las reglas de integridad referencial permiten a los administradores y 
desarrolladores confiar en que las relaciones entre datos son correctas, lo que 
simplifica las actualizaciones, eliminaciones y otras operaciones de mantenimiento.

#### 5. Optimización de Consultas:
Las bases de datos relacionales pueden optimizar consultas de manera más efectiva 
cuando se asegura la integridad referencial, ya que el sistema puede hacer 
suposiciones seguras sobre las relaciones entre tablas, mejorando el rendimiento. 

--------------------------------------------------------------------------------

## ¿Qué es una Transacción en Bases de Datos?
### Definición:
Una **transacción** en una base de datos es una secuencia de una o más operaciones 
(como **`INSERT`, `UPDATE`, `DELETE`**) que se ejecutan como una unidad indivisible de 
trabajo. Esto significa que todas las operaciones dentro de una transacción se 
completan exitosamente, o ninguna de ellas se aplica, garantizando que la base 
de datos permanezca en un estado consistente.

### Propiedades ACID de una Transacción
Las transacciones en bases de datos relacionales se adhieren a las propiedades 
**ACID**:

#### 1. Atomicidad (Atomicity):
Garantiza que todas las operaciones dentro de una transacción se completen o 
ninguna lo haga. Si alguna parte de la transacción falla, se realiza un **rollback** 
(reversión) de todas las operaciones.

#### 2. Consistencia (Consistency):
Asegura que una transacción lleve a la base de datos de un estado válido a otro 
estado válido, manteniendo las reglas de integridad y las restricciones definidas.

#### 3. Aislamiento (Isolation):
Asegura que las transacciones concurrentes no interfieran entre sí. Cada 
transacción se ejecuta en un entorno aislado, como si fuera la única operación 
en la base de datos.

#### 4. Durabilidad (Durability):
Asegura que una vez que una transacción se ha completado y se ha confirmado 
(committed), los cambios realizados persisten en la base de datos, incluso si 
ocurre una falla del sistema.

### ¿Por qué Son Importantes las Transacciones?
#### 1. Consistencia de los Datos:
Las transacciones aseguran que las operaciones complejas sobre la base de datos, 
como transferencias de fondos entre cuentas, se completen sin dejar los datos en 
un estado inconsistente.

#### 2. Recuperación ante Fallos:
En caso de que ocurra un fallo durante una transacción, los cambios realizados 
pueden revertirse, lo que ayuda a mantener la integridad de los datos.

#### 3. Manejo de Operaciones Complejas:
Las transacciones permiten agrupar múltiples operaciones de manipulación de datos 
en una sola unidad de trabajo. Esto es crucial en situaciones donde las 
operaciones interdependientes deben completarse todas juntas o no realizarse en 
absoluto.

#### 4. Concurrencia Controlada:
En entornos donde múltiples usuarios acceden y modifican la base de datos 
simultáneamente, las transacciones ayudan a controlar el acceso concurrente, 
evitando condiciones de carrera y garantizando que cada transacción vea un 
estado consistente de la base de datos.

#### 5. Facilidad de Desarrollo:
Para los desarrolladores, las transacciones simplifican la lógica de las 
aplicaciones al asegurar que las secuencias de operaciones complejas se manejen 
de manera robusta y segura.

--------------------------------------------------------------------------------

## Comandos de Transacciones en SQL
En SQL, los comandos de transacciones permiten controlar cómo se agrupan y 
ejecutan las operaciones de manipulación de datos (DML) para garantizar que se 
respeten las propiedades ACID (Atomicidad, Consistencia, Aislamiento, 
Durabilidad). 

| **Comando**             | **Descripción**                                                                                                                                                    |
|-------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **`BEGIN`**             | Inicia una nueva transacción. Todas las operaciones subsecuentes se agrupan en una transacción hasta que se ejecute `COMMIT` o `ROLLBACK`.                          |
| **`COMMIT`**            | Confirma todos los cambios realizados en la transacción actual, haciendo que sean permanentes en la base de datos. Después de un `COMMIT`, la transacción se cierra. |
| **`ROLLBACK`**          | Revierte todos los cambios realizados en la transacción actual desde el último `BEGIN`, devolviendo la base de datos al estado anterior al inicio de la transacción. |
| **`SAVEPOINT`**         | Crea un punto de guardado dentro de una transacción que se puede utilizar para deshacer una parte de la transacción sin afectar al resto.                           |
| **`RELEASE SAVEPOINT`** | Elimina un punto de guardado previamente definido.                                                                                                                 |
| **`ROLLBACK TO SAVEPOINT`** | Revierte las operaciones hasta el `SAVEPOINT` especificado, pero no termina la transacción. Las operaciones antes del `SAVEPOINT` se mantienen.               |

### Ejemplos de Uso:
#### 1. Iniciar y Confirmar una Transacción:
```sql
BEGIN;
INSERT INTO cuentas (cliente_id, balance) VALUES (1, 1000);
UPDATE cuentas SET balance = balance - 100 WHERE cliente_id = 1;
COMMIT;
```
* **Descripción**: Se inicia una transacción, se realizan las operaciones de 
  inserción y actualización, y finalmente, se confirma la transacción con 
  **`COMMIT`**, haciendo permanentes los cambios.

#### 2. Revertir una Transacción:
```sql
BEGIN;
INSERT INTO cuentas (cliente_id, balance) VALUES (2, 2000);
DELETE FROM cuentas WHERE cliente_id = 2;
ROLLBACK;
```
* **Descripción**: Se inicia una transacción, se realizan las operaciones de 
  inserción y eliminación, pero luego se ejecuta un **`ROLLBACK`**, revirtiendo todos 
  los cambios realizados en la transacción.

#### 3. Uso de SAVEPOINT:
```sql
BEGIN;
INSERT INTO cuentas (cliente_id, balance) VALUES (3, 3000);
SAVEPOINT sp1;
UPDATE cuentas SET balance = balance - 500 WHERE cliente_id = 3;
ROLLBACK TO SAVEPOINT sp1;
COMMIT;
```
* **Descripción**: Se inicia una transacción, se inserta un registro, se crea un 
  **`SAVEPOINT`**, se realiza una actualización, y luego se revierte solo la operación 
  después del **`SAVEPOINT`**. Finalmente, se confirma la transacción.

--------------------------------------------------------------------------------

## Modo Autocommit en SQL
**¿Qué es el Modo Autocommit?**
Autocommit es un modo en las bases de datos SQL donde cada instrucción DML 
(Data Manipulation Language), como INSERT, UPDATE, DELETE, o SELECT, se trata 
automáticamente como una transacción independiente que se confirma 
automáticamente al completarse. Es decir, cada comando ejecutado se confirma de 
inmediato sin necesidad de un comando COMMIT explícito.

### Características del Modo Autocommit:
#### 1. Confirmación Automática:
En el modo autocommit, cada operación se confirma inmediatamente después de su 
ejecución. No es necesario iniciar una transacción explícita con **`BEGIN`** ni 
finalizarla con **`COMMIT`**.

#### 2. Desactivación del Autocommit:
Puedes desactivar el modo autocommit si deseas ejecutar varias operaciones como 
parte de una única transacción. En muchos sistemas de bases de datos, esto se 
hace iniciando una transacción explícita con **`BEGIN`** o un comando equivalente.

#### 3. Reversión Manual No Disponible:
Debido a que cada operación se confirma inmediatamente, no se puede usar 
**`ROLLBACK`** para revertir los cambios a menos que desactives el modo autocommit 
y trabajes dentro de una transacción explícita.

### Cómo Funciona en PostgreSQL:
* **Activado por Defecto**: En PostgreSQL, el modo autocommit está activado por 
  defecto. Esto significa que cada instrucción SQL se ejecuta como una 
  transacción propia y se confirma automáticamente.

* **Desactivar el Autocommit**:
  * Para ejecutar varias instrucciones dentro de una única transacción, puedes 
    desactivar el autocommit utilizando el siguiente enfoque:
```sql
BEGIN;  -- Inicia una transacción
INSERT INTO tabla (columna) VALUES ('valor1');
UPDATE tabla SET columna = 'valor2' WHERE id = 1;
COMMIT;  -- Confirma la transacción
```
  * Aquí, **`BEGIN`** inicia una transacción y **`COMMIT`** la confirma. Durante este tiempo, 
    el autocommit está efectivamente desactivado.

### Ventajas y Desventajas:
* **Ventajas**:
  * **Simplicidad**: Para operaciones simples y transacciones que consisten en una 
    sola instrucción, el autocommit facilita la codificación y reduce la 
    posibilidad de olvidarse de confirmar una transacción.

* **Desventajas**:
  * **Control Limitado**: En operaciones complejas que requieren múltiples 
    instrucciones, el modo autocommit puede ser problemático porque no permite 
    revertir las operaciones fácilmente si ocurre un error en medio de la 
    secuencia.
  * **Riesgo de Inconsistencia**: Si se producen errores lógicos entre las 
    operaciones, no se puede deshacer una parte de las operaciones realizadas 
    antes de detectar el problema.

--------------------------------------------------------------------------------

## Buenas Prácticas en la Gestión de Bases de Datos Relacionales
En la gestión de bases de datos relacionales, es fundamental seguir buenas 
prácticas que aseguren la integridad de los datos, la fiabilidad del sistema, y 
la capacidad de recuperación ante incidentes.

### 1. Utilizar Claves PRIMARY KEY y FOREIGN KEY para Garantizar la Integridad Referencial:
Las claves primarias (**`PRIMARY KEY`**) aseguran la unicidad y la identificación de 
cada fila en una tabla, mientras que las claves foráneas (**`FOREIGN KEY`**) 
establecen y refuerzan las relaciones entre tablas. El uso de estas claves es 
esencial para mantener la integridad referencial, garantizando que las relaciones 
entre los datos sean correctas y consistentes.

### 2. Definir Reglas de Negocio y Restricciones de Integridad en la Base de Datos:
Es importante que las reglas de negocio, como las restricciones de integridad 
(**`NOT NULL`, `UNIQUE`, `CHECK`**), se implementen a nivel de base de datos para evitar 
la entrada de datos inválidos o inconsistentes. Esto asegura que los datos 
siempre cumplan con las expectativas y los requerimientos del sistema.

### 3. Realizar Pruebas Exhaustivas de las Operaciones que Modifican Datos:
Antes de implementar operaciones que modifican datos (como **`INSERT`, `UPDATE`**, 
**`DELETE`**), es crucial realizar pruebas exhaustivas para verificar que las 
operaciones se comportan como se espera y no introducen errores o inconsistencias 
en los datos. Esto incluye pruebas de escenarios límite, pruebas de integridad 
referencial y validaciones de negocio.

### 4. Implementar un Plan de Recuperación ante Desastres para Proteger la Base de Datos contra Fallos del Sistema:
Un plan de recuperación ante desastres es fundamental para garantizar que la 
base de datos pueda ser restaurada en caso de fallos del sistema, como pérdida 
de datos, corrupción de archivos o fallos de hardware. Esto incluye respaldos 
regulares, procedimientos de restauración, y pruebas periódicas del plan de 
recuperación.

### 5. Optimizar el Rendimiento mediante el Uso Adecuado de Índices:
El uso de índices en las tablas puede mejorar significativamente el rendimiento 
de las consultas, especialmente en bases de datos grandes. Sin embargo, es 
importante diseñar los índices cuidadosamente para evitar impactos negativos en 
las operaciones de escritura (**`INSERT`, `UPDATE`, `DELETE`**). Además, se debe 
realizar un mantenimiento regular de los índices, como la reconstrucción de 
índices fragmentados.

--------------------------------------------------------------------------------

## Lenguaje de Definición de Datos (DDL) en SQL
El **Lenguaje de Definición de Datos (DDL)** es un subconjunto del lenguaje SQL que 
se utiliza para definir, modificar y eliminar la estructura de los objetos en 
una base de datos. Estos objetos incluyen tablas, índices, esquemas, vistas, 
entre otros.

### Principales Comandos DDL:
#### 1. `CREATE`:
* **Función**: Crea nuevos objetos en la base de datos, como tablas, índices, 
  vistas, esquemas, etc.
* **Ejemplo**:
```sql
CREATE TABLE empleados (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    edad INT,
    departamento VARCHAR(50)
);
```
* **Descripción**: Este comando crea una nueva tabla llamada empleados con las 
  columnas especificadas.

#### 2. `ALTER`:
* **Función**: Modifica la estructura de un objeto existente en la base de datos.
* **Ejemplo**:
```sql
ALTER TABLE empleados ADD COLUMN salario DECIMAL(10, 2);
```
* **Descripción**: Este comando añade una nueva columna llamada salario a la tabla 
  empleados.

#### 3. `DROP`:
* **Función**: Elimina un objeto de la base de datos, como una tabla, vista, índice, 
  etc.
* **Ejemplo**:
```sql
DROP TABLE empleados;
```
* **Descripción**: Este comando elimina la tabla empleados y todos los datos 
  contenidos en ella.

#### 4. `TRUNCATE`:
* **Función**: Elimina rápidamente todos los registros de una tabla, reseteando 
  cualquier contador de identificadores automáticos, pero manteniendo la 
  estructura de la tabla.
* **Ejemplo**:
```sql
TRUNCATE TABLE empleados;
```
* **Descripción**: Este comando elimina todos los registros de la tabla empleados, 
  pero la tabla en sí permanece en la base de datos.

### Características Clave del DDL:
* **Transacciones Implícitas**:
Las operaciones DDL suelen ser transacciones implícitas, lo que significa que se 
confirman automáticamente cuando se ejecutan y no pueden ser revertidas mediante 
un **`ROLLBACK`**.

* **Cambios Permanentes**:
Los comandos DDL realizan cambios permanentes en la estructura de la base de 
datos. Una vez que un comando DDL se ejecuta con éxito, los cambios son 
inmediatamente visibles para todos los usuarios y no pueden deshacerse sin 
ejecutar comandos adicionales.

--------------------------------------------------------------------------------

## Borrar Tablas Referenciadas en SQL
En una base de datos relacional, cuando una tabla tiene una clave foránea 
**(`FOREIGN KEY`)** que referencia a otra tabla, no puedes eliminar (borrar) la 
tabla referenciada directamente si existen relaciones activas, a menos que tomes 
medidas adicionales. Esto es para garantizar la integridad referencial.

### Opciones para Borrar Tablas Referenciadas:
#### 1. Eliminar las Restricciones de Clave Foránea (`FOREIGN KEY`) Antes de Borrar la Tabla:
Puedes eliminar primero las restricciones de clave foránea que hacen referencia 
a la tabla que deseas borrar, y luego eliminar la tabla.
* **Pasos**:
  **1. Eliminar la Clave Foránea**:
```sql
ALTER TABLE tabla_hija DROP CONSTRAINT fk_nombre_de_la_restricción;
```
  **2. Borrar la Tabla Referenciada**:
```sql
DROP TABLE tabla_referenciada;
```

#### 2. Utilizar `CASCADE` para Eliminar la Tabla Referenciada:
En PostgreSQL y otros sistemas de bases de datos, puedes usar la opción **`CASCADE`** 
cuando eliminas una tabla. Esto eliminará automáticamente todas las claves 
foráneas que hacen referencia a la tabla y la propia tabla.
* **Comando**:
```sql
DROP TABLE tabla_referenciada CASCADE;
```
* **Descripción**: Este comando eliminará la tabla tabla_referenciada y 
  automáticamente eliminará todas las referencias a ella en otras tablas.

#### 3. Eliminar Manualmente las Filas Dependientes Antes de Borrar la Tabla:
Si no deseas utilizar **`CASCADE`**, puedes eliminar manualmente las filas 
dependientes en las tablas que referencian la tabla que deseas borrar.
* **Pasos**:
  **1. Eliminar las Filas Dependientes**:
```sql
DELETE FROM tabla_hija WHERE referencia = valor_referenciado;
```
  **2. Borrar la Tabla Referenciada**:
```sql
DROP TABLE tabla_referenciada;
```

### Consideraciones:
* **Integridad Referencial**:
La integridad referencial es clave para mantener datos consistentes. Borrar una 
tabla referenciada sin tener cuidado puede llevar a inconsistencias y errores 
lógicos en tu base de datos.

* **Precaución con `CASCADE`**:
Usar **`CASCADE`** es poderoso, pero también peligroso si no se utiliza 
correctamente. Puede borrar más datos de los que inicialmente se pretendía, por 
lo que debe utilizarse con precaución.

--------------------------------------------------------------------------------

## Modelo Entidad-Relación (ER)
El **Modelo Entidad-Relación (ER)** es un marco conceptual utilizado para 
representar y diseñar la estructura de una base de datos. Este modelo visualiza 
los datos en términos de entidades, atributos y relaciones, lo que facilita la 
planificación y la implementación de una base de datos relacional.

### Componentes Principales:
#### 1. Entidades:
  * **Definición**: Una entidad representa un objeto o concepto del mundo real que 
    tiene una existencia independiente. Cada entidad se convierte en una tabla 
    en la base de datos.
  * **Ejemplo**: **`Cliente`, `Producto`, `Pedido`**.

#### 2. Atributos:
  * **Definición**: Los atributos son las propiedades o características de una 
    entidad. Cada atributo se convierte en una columna en la tabla 
    correspondiente.
  * **Ejemplo**: Para la entidad **`Cliente`**, los atributos podrían ser `Nombre`,
    **`Apellido`**, **`Correo Electrónico`**.

#### 3. Relaciones:
  * **Definición**: Las relaciones describen cómo se asocian dos o más entidades. 
    Estas relaciones se convierten en claves foráneas (**`FOREIGN KEY`**) en las 
    tablas de la base de datos.
  * **Tipos de Relaciones**:
    * **Uno a Uno (1:1)**: Una entidad se asocia con una y solo una entidad de otra 
      tabla.
    * **Uno a Muchos (1)**: Una entidad se asocia con muchas entidades de otra tabla. 
    * **Muchos a Muchos (N)**: Muchas entidades se asocian con muchas entidades de 
      otra tabla, usualmente representadas con una **tabla intermedia**.
* **Ejemplo**: Un Cliente puede realizar muchos Pedidos (relación 1).

### Diagramas ER:
* **Definición**: Los diagramas ER son representaciones gráficas del modelo 
  Entidad-Relación. Utilizan rectángulos para entidades, óvalos para atributos y 
  rombos para relaciones.
* **Propósito**: Facilitan la comprensión y comunicación del diseño de la base de 
  datos antes de su implementación.

### Proceso de Diseño con el Modelo ER:
1. **Identificación de Entidades y Atributos**: Se determinan las entidades y sus 
   atributos relevantes.
2. **Establecimiento de Relaciones**: Se identifican cómo se relacionan las 
   entidades entre sí.
3. **Creación del Diagrama ER**: Se dibuja el diagrama para visualizar la estructura 
   de la base de datos.
4. **Conversión a Tablas**: Se transforma el modelo ER en un esquema relacional, con 
   tablas, claves primarias y claves foráneas.

--------------------------------------------------------------------------------

## Modelo Conceptual de Entidad-Relación
El **Modelo Conceptual de Entidad-Relación (ER)** es una representación abstracta y 
de alto nivel de la estructura de una base de datos. Se utiliza en las primeras 
etapas del diseño de bases de datos para definir de manera clara y comprensible 
las entidades, sus atributos y las relaciones entre ellas, sin entrar en 
detalles técnicos de implementación.

### Componentes Principales del Modelo Conceptual ER:
#### 1. Entidades:
  * **Definición**: Representan objetos o conceptos del mundo real que tienen 
    relevancia en el sistema que se está modelando.
  * **Ejemplo**: **`Cliente`, `Producto`, `Empleado`**.

#### 2. Atributos:
* **Definición**: Son las propiedades o características que describen a una entidad.
* **Ejemplo**: **`Cliente`** podría tener atributos como **`Nombre`, `Dirección`, `Teléfono`**.

#### 3. Relaciones:
  * **Definición**: Describen cómo se conectan o interactúan las entidades entre sí.
  * **Tipos**:
    * **Uno a Uno (1:1)**: Un empleado tiene un solo puesto, y un puesto es ocupado 
      por un solo empleado.
    * **Uno a Muchos (1)**: Un cliente puede realizar varios pedidos, pero cada 
      pedido es realizado por un solo cliente.
    * **Muchos a Muchos (N)**: Un estudiante puede inscribirse en varios cursos, y 
      un curso puede tener varios estudiantes.

#### 4. Cardinalidad:
* **Definición**: Indica el número de instancias de una entidad que pueden estar 
  asociadas con una instancia de otra entidad.
* **Ejemplo**: Un departamento (entidad **`Departamento`**) puede tener varios empleados 
  (entidad **`Empleado`**), pero un empleado solo puede pertenecer a un departamento.

### Propósito del Modelo Conceptual ER:
* **Claridad y Comunicación**: Proporciona una visión clara y compartida de los 
  datos que el sistema manejará, facilitando la comunicación entre analistas, 
  diseñadores y otros stakeholders.
* **Independencia de la Implementación**: Este modelo es independiente de cualquier 
  sistema de gestión de bases de datos específico o detalles técnicos, 
  permitiendo un enfoque centrado en los requisitos del negocio.
* **Base para el Diseño Lógico**: El modelo conceptual ER se utiliza como punto de 
  partida para desarrollar el modelo lógico, donde se definen las tablas, las 
  claves primarias y foráneas, y otros aspectos técnicos.

### Diagramas ER en el Modelo Conceptual:
* **Representación Gráfica**: Se utilizan diagramas ER para representar visualmente 
  el modelo conceptual, con entidades representadas por rectángulos, atributos 
  por óvalos y relaciones por rombos.
* **Ejemplo Simple**: Una entidad **`Cliente`** relacionada con la entidad **`Pedido`** 
  mediante una relación de "hace" (uno a muchos), donde **`Cliente`** tiene atributos 
  como **`Nombre`** y **`Teléfono`**, y **`Pedido`** tiene atributos como **`Fecha`** y **`Monto`**.

--------------------------------------------------------------------------------

## Carfinalidad
La **cardinalidad** en el Modelo Entidad-Relación define el número de instancias 
de una entidad que pueden asociarse con una instancia de otra entidad. Los tipos 
principales son: **1:1** (una instancia de una entidad se asocia con una 
instancia de otra), **1** (una instancia de una entidad se asocia con muchas de 
otra), y **N** (muchas instancias de una entidad se asocian con muchas de otra).
La cardinalidad es clave para diseñar y mantener la integridad de las relaciones 
en una base de datos.

--------------------------------------------------------------------------------

## Entidades Fuertes y Entidades Débiles
### Entidades Fuertes**:
* **Definición**: Son entidades que tienen una clave primaria propia, es decir, un 
  atributo o conjunto de atributos que las identifica de manera única sin 
  depender de otras entidades.
* **Ejemplo**: **`Cliente`** con una **`id_cliente`** como clave primaria.

### Entidades Débiles:
* **Definición**: Son entidades que no tienen una clave primaria propia y dependen 
  de una entidad fuerte para ser identificadas. Necesitan una clave foránea y un 
  atributo adicional para formar su clave primaria compuesta.
* **Ejemplo**: **`FacturaDetalle`** que depende de **`Factura`** (entidad fuerte) y utiliza 
  **`id_factura`** junto con un número de línea para ser identificada.
  
Las entidades débiles se relacionan con entidades fuertes a través de una 
relación de dependencia, y su existencia está ligada a la entidad fuerte.

--------------------------------------------------------------------------------

## Diferencias Fundamentales entre el Modelo Relacional y el Modelo Conceptual
### 1. Nivel de Abstracción:
* **Modelo Conceptual**: Alto nivel, abstracto, centrado en representar entidades, 
  atributos y relaciones del mundo real.
* **Modelo Relacional**: Más técnico, enfocado en cómo se implementarán los datos en 
  tablas, filas y columnas.

### 2. Componentes:
* **Modelo Conceptual**: Utiliza entidades, atributos y relaciones.
* **Modelo Relacional**: Utiliza tablas, columnas y claves (primarias y foráneas).

### 3. Propósito:
* **Modelo Conceptual**: Capturar y organizar los requisitos de datos de manera 
  independiente de la tecnología.
* **Modelo Relacional**: Implementar y manejar la estructura física de los datos en 
  una base de datos.

### 4. Uso:
* **Modelo Conceptual**: Para la planificación y diseño inicial, comunicando ideas a 
  nivel de negocio.
* **Modelo Relacional**: Para la creación y operación efectiva de la base de datos.

--------------------------------------------------------------------------------

## Modelo Lógico
El **Modelo Lógico** es una representación más detallada del modelo conceptual, 
enfocada en la estructura de los datos que se utilizará para implementar la base 
de datos en un sistema específico. Se encarga de definir cómo se organizan los 
datos en términos de tablas, columnas, y relaciones entre ellas, pero aún sin 
considerar detalles físicos o específicos del software de base de datos.

### Características Clave:
#### 1. Tablas:
* Cada entidad del modelo conceptual se traduce en una tabla en el modelo lógico.
* Las relaciones entre entidades se representan como claves foráneas.

#### 2. Columnas:
* Los atributos de las entidades se convierten en columnas dentro de las tablas.
* Se definen tipos de datos para cada columna.

#### 3. Relaciones:
* Las relaciones entre tablas se especifican mediante claves foráneas.
* Se identifican las cardinalidades y las restricciones de integridad.

#### 4. Normalización:
* El modelo lógico aplica principios de normalización para minimizar la 
  redundancia y evitar problemas de inconsistencia.

### Diferencias con el Modelo Conceptual:
* **Nivel de Detalle**: El modelo lógico es más detallado que el conceptual, 
  especificando tipos de datos y relaciones en un formato más estructurado.
* **Enfoque**: Mientras que el modelo conceptual es más abstracto, el modelo lógico 
  se enfoca en cómo se implementarán los datos en una base de datos específica, 
  pero sin aún entrar en detalles físicos como índices o particiones.

### Propósito:
* **Transición**: Sirve como un puente entre el modelo conceptual y el modelo 
  físico, proporcionando una base sólida para la implementación de la base de 
  datos.
* **Consistencia y Eficiencia**: Ayuda a diseñar la base de datos de manera que sea 
  consistente y eficiente en términos de almacenamiento y consulta de datos.

--------------------------------------------------------------------------------

## Modelo Físico
El **Modelo Físico** es la representación final y más detallada del diseño de una 
base de datos, especificando cómo se almacenarán y recuperarán los datos en un 
sistema de gestión de bases de datos (DBMS) específico. Este modelo considera 
aspectos de rendimiento, almacenamiento, y seguridad, y es directamente 
implementable en el sistema de base de datos.

### Características Clave:
#### 1. Tablas y Estructura de Almacenamiento:
* Se definen las tablas con todos los detalles específicos del DBMS, como tipos 
  de datos precisos (ej., **`INT`, `VARCHAR(255)`**), tamaños de campos, y restricciones 
  de integridad.
* Se decide la estructura de almacenamiento, como la distribución de datos en 
  disco, índices, particiones, y espacios de tablas.

#### 2. Índices:
* Se crean índices para mejorar el rendimiento de las consultas, especificando 
  las columnas que se indexarán y el tipo de índice (ej., B-Tree, Hash).

#### 3. Claves Primarias y Foráneas:
* Se implementan las claves primarias y foráneas con las restricciones 
  específicas para garantizar la integridad referencial en el entorno físico.

#### 4. Particionamiento y Almacenamiento:
* Se diseñan particiones para manejar grandes volúmenes de datos, optimizando el 
  rendimiento y la gestión del espacio.
* Se determinan las configuraciones de almacenamiento físico, como la compresión 
  y distribución de datos.

#### 5. Consideraciones de Seguridad:
* Se definen permisos y políticas de acceso, asegurando que solo los usuarios 
  autorizados puedan acceder o modificar ciertos datos.
* Se establecen medidas de seguridad como encriptación de datos en reposo y en 
  tránsito.

#### 6. Optimización de Rendimiento:
* Se implementan estrategias de optimización de consultas, tuning de índices, y 
  ajuste de parámetros del DBMS para mejorar el rendimiento.

### Diferencias con el Modelo Lógico:
* **Nivel de Detalle**: El modelo físico es más detallado que el lógico, 
  considerando todos los aspectos técnicos específicos del DBMS, como el 
  almacenamiento en disco y los índices.
* **Enfoque en el Rendimiento**: Mientras que el modelo lógico se enfoca en la 
  estructura de datos, el modelo físico se centra en cómo esa estructura se 
  implementará para optimizar el rendimiento y la eficiencia.

### Propósito:
* **Implementación**: El modelo físico es la base para la implementación real de la 
  base de datos en un sistema de gestión de bases de datos específico.
* **Optimización y Seguridad**: Garantiza que la base de datos no solo funcione 
  correctamente, sino que también sea segura y eficiente en el manejo de datos.

--------------------------------------------------------------------------------

## Normalización y Desnormalización

### Normalización
* **Definición**: La normalización es el proceso de organizar los datos en una base 
  de datos para minimizar la redundancia y evitar problemas de inconsistencia. 
  Se logra mediante la aplicación de varias formas normales, cada una de las 
  cuales impone una regla para asegurar la integridad de los datos.
* **Objetivo**: Garantizar que los datos se almacenen de manera eficiente y 
  consistente, evitando duplicaciones y asegurando que cada dato se almacene 
  solo una vez.

### Desnormalización
* **Definición**: La desnormalización es el proceso de combinar tablas normalizadas 
  para mejorar el rendimiento de las consultas, a menudo introduciendo 
  redundancia intencionalmente.
* **Objetivo**: Optimizar el rendimiento de las consultas y reducir la complejidad 
  en la recuperación de datos, especialmente en sistemas donde las operaciones 
  de lectura son más frecuentes que las de escritura.

### Diferencias Clave:
* **Normalización**: Reduce la redundancia y mejora la integridad de los datos, pero 
  puede hacer que las consultas sean más complejas y lentas debido a la necesidad 
  de realizar JOINs entre múltiples tablas.
* **Desnormalización**: Mejora el rendimiento de las consultas al reducir la 
  necesidad de JOINs, pero puede aumentar la redundancia y el riesgo de 
  inconsistencias.

### Cuándo Usar Cada Enfoque:
* **Normalización**: Es ideal en sistemas donde la integridad de los datos es 
  crítica y las operaciones de escritura y actualización son comunes.
* **Desnormalización**: Es útil en sistemas donde se prioriza el rendimiento de las 
  consultas de lectura, como en sistemas de análisis de datos o en aplicaciones 
  con alta carga de consultas.

--------------------------------------------------------------------------------
