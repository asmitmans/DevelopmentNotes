# Bases de Datos Relacionales

- [Deadlock en DBMS](#deadlock-en-dbms)

---

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
  * No en 2NF: En una tabla de órdenes que tiene una clave primaria compuesta
    (OrderID, ProductID), si el ProductName depende solo de ProductID y no de la
    combinación completa de la clave primaria, se viola la 2NF.
  * En 2NF: Se elimina ProductName de la tabla de órdenes y se coloca en una
    tabla separada de productos, donde ProductID es la clave primaria.
> **Conclusión:** Todo lo que este en la tabla que no sea parte de la clave debe
> depender de la clave primaria. Por ejemplo si tengo el `id_producto` no necesito
> el `nombre_producto`.

### Tercera Forma Normal (3NF):
* **Definición**: Una tabla está en 3NF si cumple con 2NF y, además, todos los
  atributos no clave dependen directamente de la clave primaria, sin
  dependencias transitivas. Es decir, no debe haber un atributo no clave que
  dependa de otro atributo no clave.
Ejemplo:
No en 3NF: Una tabla de empleados que almacena EmployeeID, DepartmentID, y DepartmentName, donde DepartmentName depende de DepartmentID y no de EmployeeID directamente. Esto crea una dependencia transitiva.
En 3NF: Se elimina DepartmentName de la tabla de empleados y se coloca en una tabla separada de departamentos, donde DepartmentID es la clave primaria.

