# Cosas que No se Dejan al Enviar a Producción

En este documento se enumeran los elementos y configuraciones que deben ser 
evitados o eliminados al preparar una aplicación para su despliegue en 
producción. Esto asegura un entorno seguro, eficiente y profesional.

## 1. **Código y Dependencias de Desarrollo**
- **Comentarios innecesarios**: Elimina comentarios redundantes, código comentado 
  o bloques no utilizados.
- **Dependencias de desarrollo**: Verifica que las dependencias en `pom.xml` o 
  archivos equivalentes solo incluyan librerías necesarias para producción.

## 2. **Configuraciones de Depuración y Logs**
- **Mensajes de depuración**: Desactiva o elimina `System.out.println()`, `console.log()`, 
  y logs de depuración.
- **Nivel de logging**: Configura el nivel de logs en `ERROR` o `WARN`. Evita `DEBUG` o 
  `TRACE` en producción.

## 3. **Credenciales y Claves**
- **Credenciales en código**: No dejes claves API, tokens o credenciales sensibles 
  embebidas en el código. Usa variables de entorno o servicios seguros para 
  gestionarlas.

## 4. **Archivos y Configuraciones Temporales**
- **Archivos de prueba**: Elimina datos o configuraciones temporales, como archivos 
  de configuración usados solo para desarrollo o pruebas.
- **Configuraciones de ejemplo**: Verifica que los archivos de configuración (por ejemplo, 
  `application.properties`) contengan valores reales y apropiados para producción.

## 5. **Pruebas y Mocks**
- **Mocks y stubs**: Remueve código de pruebas o servicios simulados que no deben 
  ejecutarse en producción.
- **Archivos de prueba unitarios**: Asegúrate de no incluirlos en el paquete de 
  despliegue.

## 6. **Dependencias No Utilizadas**
- Ejecuta herramientas como `mvn dependency:analyze` para identificar y eliminar 
  dependencias no utilizadas o redundantes.

## 7. **Seguridad**
- **Endpoints de prueba**: Elimina rutas o endpoints creados para depuración.
- **Exposición de información**: Evita mostrar detalles del sistema, excepciones 
  completas o estructuras de datos sensibles en las respuestas de la API.

## 8. **Configuración de Entorno**
- **Variables locales**: Asegúrate de que las configuraciones locales no sobreescriban 
  las configuraciones de producción.
- **Configuraciones estandarizadas**: Usa herramientas como `Docker`, `Kubernetes` o 
  `Ansible` para asegurar la consistencia entre entornos.

## 9. **Pruebas Finales**
- **Revisar las pruebas unitarias**: Todas las pruebas deben pasar antes de realizar 
  el despliegue.
- **Validación manual**: Verifica manualmente las funcionalidades críticas antes de 
  subir a producción.

---