# Bases de Datos Relacionales

- [Deadlock en DBMS](#deadlock-en-dbms)
- [Formas Normales en Bases de Datos](#formas-normales-en-bases-de-datos)
- [PostgreSQL: ANALYZE](#postgresql-analyze)
- [Vista Materializada](#vista-materializada)
- [Crear índice en tabla](#crear-índice-en-tabla)
- [Crear restricción de unicidad](#crear-restricción-de-unicidad)


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

## PostgreSQL: ANALYZE

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