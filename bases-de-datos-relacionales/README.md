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

