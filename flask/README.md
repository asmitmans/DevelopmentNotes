## Flask

- [Flask](#flask)
- [Definición de HTML](#definición-de-html)
- [Spring Security](#spring-security)
- [Pasos para Desarrollar una API REST con Spring Boot](#pasos-para-desarrollar-una-api-rest-con-spring-boot)
- [Manejo de Excepciones en Spring Boot](#manejo-de-excepciones-en-spring-boot)
- [Crear Proyecto SpringBoot + MongoDB](#crear-proyecto-springboot--mongodb)

---

## ¿Qué es Flask?

Flask es un microframework de desarrollo web para Python que permite crear 
aplicaciones web de manera sencilla y rápida. Se denomina "micro" porque mantiene 
un núcleo simple pero extensible, sin imponer dependencias o estructuras 
específicas, lo que brinda a los desarrolladores la flexibilidad de elegir las 
herramientas y bibliotecas que mejor se adapten a sus necesidades. Flask se basa 
en Werkzeug, un conjunto de utilidades para aplicaciones WSGI, y en Jinja2, un 
motor de plantillas para Python.

**Ventajas de Flask:**

- **Simplicidad y Flexibilidad:** Proporciona las herramientas esenciales para desarrollar 
  aplicaciones web, permitiendo a los desarrolladores agregar funcionalidades 
  según sea necesario.

- **Extensibilidad:** Cuenta con una amplia gama de extensiones que facilitan la integración 
  de diversas funcionalidades, como autenticación, manejo de formularios y 
  conexión a bases de datos.

- **Comunidad Activa:** Flask tiene una comunidad robusta que contribuye con extensiones, 
  documentación y soporte, lo que facilita el aprendizaje y la resolución de 
  problemas.

---

## ORM en Flask: SQLAlchemy

En el desarrollo de aplicaciones web, es común interactuar con bases de datos 
relacionales. Para simplificar esta interacción, se utilizan ORM 
(Object-Relational Mappers), que permiten a los desarrolladores manipular bases 
de datos utilizando paradigmas de programación orientada a objetos.

En el ecosistema de Flask, la extensión más popular para este propósito es 
**Flask-SQLAlchemy**, que integra SQLAlchemy con Flask. SQLAlchemy es un ORM 
para Python que ofrece una abstracción de alto nivel para la manipulación de 
bases de datos, permitiendo a los desarrolladores trabajar con bases de datos 
utilizando clases y objetos en lugar de escribir consultas SQL directamente.

**Ventajas de usar Flask-SQLAlchemy:**

- **Abstracción Simplificada:** Facilita la definición de modelos de datos como clases 
  Python, mapeando automáticamente estas clases a tablas en la base de datos.

- **Consultas Flexibles:** Permite construir y ejecutar consultas de manera programática 
  utilizando métodos de Python, manteniendo el código limpio y mantenible.

- **Gestión de Sesiones:** Maneja automáticamente las sesiones de la base de datos, 
  facilitando la ejecución de transacciones y el manejo de conexiones.

---

## Guía Práctica: Implementación de una API REST con Flask

A continuación, se presenta una guía paso a paso para crear una API REST 
utilizando Flask y Flask-SQLAlchemy.

### 1. Instalación de Flask y Extensiones Necesarias

Primero, es recomendable crear un entorno virtual para aislar las dependencias 
del proyecto:

```bash
python -m venv venv
source venv/bin/activate  # En Windows, usa `venv\Scripts\activate`
```

Luego, instala Flask y Flask-SQLAlchemy utilizando pip:

```bash
pip install Flask Flask-SQLAlchemy
```

### 2. Configuración de la Aplicación Flask

Crea un archivo llamado `app.py` y configura la aplicación Flask junto con la 
base de datos:

```python
from flask import Flask
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///test.db'  # URL de la base de datos
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False

db = SQLAlchemy(app)
```

### 3. Definición de Modelos de Datos

Define los modelos de datos que representarán las tablas en la base de datos:

```python
class SensorData(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    temperature = db.Column(db.Float, nullable=False)
    humidity = db.Column(db.Float, nullable=False)
    timestamp = db.Column(db.DateTime, default=db.func.current_timestamp(), nullable=False)
```

### 4. Creación de la Base de Datos

Antes de ejecutar la aplicación, crea la base de datos y las tablas 
correspondientes:

```python
with app.app_context():
    db.create_all()
```

### 5. Implementación de Rutas de la API

Define las rutas de la API para manejar las operaciones CRUD (Crear, Leer, 
Actualizar, Eliminar):

```python
from flask import request, jsonify

@app.route('/data', methods=['POST'])
def add_data():
    data = request.get_json()
    new_entry = SensorData(temperature=data['temperature'], humidity=data['humidity'])
    db.session.add(new_entry)
    db.session.commit()
    return jsonify({'message': 'Data added successfully'}), 201

@app.route('/data', methods=['GET'])
def get_data():
    data = SensorData.query.all()
    result = [
        {
            'id': entry.id,
            'temperature': entry.temperature,
            'humidity': entry.humidity,
            'timestamp': entry.timestamp
        } for entry in data
    ]
    return jsonify(result), 200
```

### 6. Ejecución de la Aplicación

Finalmente, ejecuta la aplicación:

```python
if __name__ == '__main__':
    app.run(debug=True)
```

Con estos pasos, has creado una API REST básica utilizando Flask y 
Flask-SQLAlchemy. Esta estructura puede ampliarse y adaptarse según las 
necesidades específicas del proyecto.

Para obtener más detalles y acceder al código completo, puedes visitar el 
repositorio del proyecto en 
[nodoESP32WifiTestAPI](https://github.com/asmitmans/nodoESP32WifiTestAPI).

**Referencias:**

- [Flask Official Documentation](https://flask.palletsprojects.com/)
- [Flask-SQLAlchemy](https://flask-sqlalchemy.palletsprojects.com/en/2.x/)

---

## ¿Se puede crear una API funcional con persistencia solo con modelo y controlador, sin repositorio?

Sí, se puede. En Flask, el modelo de datos (`db.Model`) puede interactuar directamente 
con la base de datos sin necesidad de una capa de repositorio explícita. SQLAlchemy 
ya proporciona métodos para manipular la base de datos, como `query.all()`, `add()`, 
`commit()`, `delete()`, etc.

**¿Cuándo sí se recomienda un repositorio?**
- Cuando se busca separar la lógica de acceso a datos del controlador (buenas 
  prácticas en aplicaciones más grandes).
- Si la API crece y se requiere abstracción para facilitar cambios futuros en la 
  persistencia.
- Para facilitar pruebas unitarias, evitando que los controladores dependan 
  directamente del ORM.


En Flask, se puede implementar un repositorio creando una capa de servicio o un 
archivo separado, por ejemplo:

```python
class SensorDataRepository:
	@staticmethod
	def add_sensor_data(data):
		db.session.add(data)
		db.session.commit()

	@staticmethod
	def get_all_sensor_data():
		return SensorData.query.all()
```

Luego, el controlador llamaría a este repositorio en lugar de interactuar 
directamente con el modelo.

---

## **Ejemplo de cómo se usa `db` en la app**

```python
from flask import Flask
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)
app.config["SQLALCHEMY_DATABASE_URI"] = "sqlite:///test.db"
db = SQLAlchemy(app)  # Se inicializa el objeto único `db`

class SensorData(db.Model):  # La tabla "sensor_data" en la base de datos
    id = db.Column(db.Integer, primary_key=True)
    temperature = db.Column(db.Float, nullable=False)
    humidity = db.Column(db.Float, nullable=False)

# Crear la base de datos
with app.app_context():
    db.create_all()  # Crea las tablas si no existen
```

- `db.Model` es equivalente a `@Entity` en Spring Boot.
- `class SensorData(db.Model)` **hereda** de `db.Model`, no lo recibe como argumento.
- `db = SQLAlchemy()` es un objeto global único en la app, maneja la conexión con la BD.
- `db.create_all()` genera las tablas definidas en los modelos.

---
