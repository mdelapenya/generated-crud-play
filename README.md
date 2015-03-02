# Generación de código de mantenimiento de bases de datos

- Alumno: Manuel de la Peña Peña (53.430.012-T)
- Asignatura: Generación Automática de Código

## Enunciado de la práctica

"Construir un generador que dado un fichero con la definición estática de una base de datos cree una aplicación de manipulación: alta-baja-modificación automáticamente utilizando los recursos gráficos que se desee y utilizando código SQL embebido".

## Solución general propuesta

Para satisfacer los requisitos de la práctica, se realizará una aplicación web que gestione las tareas CRUD (consultas, altas, bajas y modificaciones) de una base de datos (BB.DD.).

## Stack tecnológico

El primer paso ha sido generar una aplicación web que se ejecutara con un servidor de aplicaciones embebido, en lugar de tener que instalar un servidor de aplicaciones en el que desplegar la aplicación.

Este punto facilitará la ejecución de la aplicación por parte del personal docente, que no tendrá que instalar la aplicación en ningún servidor, sino simplemente ejecutarla y abrir un navegador apuntando al puerto del servidor embebido.

Respecto al almacenamiento persistente se ha optado por utilizar una BB.DD. que no utilice un servidor de BB.DD, por la misma razón de facilidad de uso, accediendo por tanto a un simple fichero en el disco. En este caso utilizaremos **H2** (http://www.h2database.com/), el cual será accedido mediante JDBC.

La capa de persistencia será realizada por **"Ebeans ORM"** (http://www.avaje.org/). Ebean es una herramienta Java ORM (Object Relational Mapping) open source con licencia LGPL. Utiliza anotaciones JPA (@entity, @OneToMany ...) para el mapeo de las entidades.

El framework de desarrollo **"Play! Framework"** posibilita todas estas características, pues es capaz de iniciar de manera automática un servidor web embebido (Netty), y por defecto proporciona las dependencias de la BB.DD. H2 y del ORM Ebeans.

En cuanto a la generación propiamente dicha de código, se ha escogido **Freemarker** (http://freemarker.org) como motor de plantillas, debido a la potencia que ofrece, así como su fácil integración con proyectos basados en el lenguaje Java.

Para definir un look&feel consistente entre todas las pantallas, se ha elegido **Twitter Bootstrap** v.3.2.3 (http://getbootstrap.com/) como framework HTML, CSS. que requiere a su vez para la parte Javascript, de **jQuery** v1.11.2 (http://jquery.com).

## Arquitectura de la aplicación

La aplicación sigue el modelo MVC (Model-View-Controller), para el cual "Play! Framework" define tres elementos, claramente identificados en la estructura de la aplicación:

- model -> representa las entidades de la BB.DD.
- view -> capa de presentación de la aplicación, definidas mediante plantillas SCALA.
- controller -> la representación del controlador se realiza mediante el enrutado de las peticiones HTTP a diferentes URL, que una vez solicitadas ejecutarán una clase en concreto. En particular, será necesario definir unas rutas (routes), que se enlazarán con unas clases Java que extiendan de Controller. Por convenio, estas clases se denominarán XYZApplication.

## Esquema de trabajo

El primer paso ha consistido en desarrollar una aplicación CRUD muy básica, permitiendo altas, bajas, consultas y modificaciones de un modelo muy sencillo.

A partir de este modelo, y sus correspondientes elementos de aplicación (vistas, controladores y persistencia), se definirán unas plantillas en Freemarker responsables de generar el código para todas las capas en las que el modelo es necesario, así como todos los elementos principales de la aplicación que necesiten ser generados.

## Generación de código

La generación propiamente dicha vendrá definida en los siguientes pasos:

* Parseo del fichero SQL de entrada.
* Representación conceptual de las tablas de la BB.DD. definidas en el fichero de entrada en un conjunto de objetos.
* Utilización de un motor de plantillas para interpolar el conjunto de objetos anterior sobre las plantillas definidas previamente.
* Generación de los ficheros.

Como se menciona en la descripción del stack tecnológico, el motor de generación de plantillas escogido es Freemarker. Éste utiliza ficheros .ftl (Freemarker template) para definir cada plantilla, en la que se definirá la estructura de cada fichero a generar.

Sobre este fichero se podrán crear "interpolaciones", o elementos de la plantilla que podrán ser sobrescritos dinámicamente dentro del motor de plantillas. Esta sobrescritura se realizará en base a una definición del modelo para generar un output, en este caso código fuente.

Cada vez que se quiera modificar el comportamiento de la aplicación se realizarán los siguientes pasos:
- Modificar las plantillas necesarias
- Recompilar el proyecto
- Utilizar la aplicación para subir un fichero SQL, que automáticamente regenerará la aplicación (el framework Play! compilará el código autogenerado en cuanto lo detecte).

### Ficheros generados

#### routes
Fichero que representa el mapping de las rutas de la aplicación, esto es, las URLs válidas que la aplicación acepta del navegador para cada modelo, para enrutarlas al controlador adecuado. Su plantilla será [codegenerator/templates/routes.ftl](../tree/master/app/codegenerator/templates/routes.ftl)

Se generarán 4 routes por entidad del modelo:

- Visualizar un modelo existente: **GET /models/:id controllers.ModelApplication.get(id: Long)**
- Ir a la página de creación de un modelo: **GET /model/add controllers.ModelApplication.addModel**
- Ir a la página donde se muestran todos registros de un modelo concreto: **GET /models controllers.ModelApplication.all**
- Editar un modelo (add/update/delete): **POST /model/submit controllers.ModelApplication.submit()**

#### ModelApplication.java
Fichero que representa el controlador relacionado con la entidad 'Model', en el que se definirán los métodos que serán invocados tras procesar las routes. Su plantilla será [codegeneration/templates/application.ftl](../master/app/codegeneration/templates/application.ftl)

#### ModelFormData.java
Fichero que representa el POJO (Plain Old Java Object) relacionado con la entidad 'Model', que almacenará todos los campos como String y recibirá los valores directamente de los formularios de la aplicación. Será el elemento de intercambio de información entre la capa View y la capa de persistencia. Su plantilla será [codegeneration/templates/formData.ftl](../master/app/codegeneration/templates/formData.ftl)

#### Model.java
Fichero que representa a la entidad 'Model', en el que cada campo de BB.DD. será un atributo de la clase. Se generarán a su vez los métodos getters y setters para los atributos, así como métodos de utilidad que generarán un ModelFormData a partir de un Model, y viceversa. Su plantilla será [codegeneration/templates/model.ftl](../master/app/codegeneration/templates/model.ftl)

#### listmodels.scala.html
Fichero que representa una lista en formato de tabla con todas las entidades en la BB.DD., permitiendo mediante un enlace el acceso a las pantallas destinadas para cada modelo. Por otro lado, un botón de "Home" aparecerá en la cabecera, permitiendo volver al inicio de la aplicación (subida del fichero SQL que permite regenerar la aplicación). Su plantilla será [codegeneration/templates/listmodels.scala.html.ftl](../master/app/codegeneration/templates/listmodels.scala.html.ftl)

#### model.scala.html
Fichero que representa la pantalla de visualización de datos de una entidad concreta, identificada por su clave primaria. En ella se podrán crear entidades del tipo concreto, o además se podrán modificar los valores de los campos del modelo concreto seleccionado. Por otro lado, aparecerán en la cabecera botones de "Borrar" (en modo edición únicamente) y "Volver al Modelo". Su plantilla será [codegeneration/templates/model.scala.html.ftl](../master/app/codegeneration/templates/model.scala.html.ftl)

#### models.scala.html
Fichero que representa el listado de entidades de un modelo concreto. En este listado, en el que cada fila corresponderá con una entidad, se mostrarán en cada fila todos los campos del modelo con el valor concreto para cada entidad, en formato nube de tags. Además, el campo clave de cada entidad estará identificado en otro color y añadirá un enlace a la pantalla de visualización/edición del modelo. Por otro lado, aparecerán en la cabecera botones de "Crear nuevo" y "Volver al listado de Modelos". Su plantilla será [codegeneration/templates/models.scala.html.ftl](../master/app/codegeneration/templates/models.scala.html.ftl)

## Fichero SQL de entrada

### Precondiciones

#### Sentencias SQL válidas
Por simplicidad, el fichero no debe contener la sentencia CREATE DATABASE, sino que debe contener únicamente sentencias CREATE TABLE (...).

#### Sintáxis
Cada línea del fichero deber contener una única sentencia, de modo que el fichero SQL sea multi-línea.

Además, la sintáxis SQL del fichero debe corresponder con el de la BB.DD. escogida, que es H2.

#### Claves primarias
Otra dato a tener en cuenta son las claves primarias. Por simplicidad, todas las tablas del script deben tener una sola clave primaria, evitando las tablas de relación con varias 'Foreign Keys'. De esta manera, la capa de persistencia manejará las actualizaciones de una manera mucho más simple, manteniendo los propósitos de la práctica.

Por tanto, del fichero fuente original se han eliminado todas las inserciones de datos, la creación de índices, y las tablas cuya 'Primary Key' estuviera formada por varios campos.

Además, por el mismo criterio de simplicidad, no se soportan tablas cuyo campo 'primaryKey' no sea del tipo 'long'. Por este motivo, se han eliminado del esquema original las tablas con clave primaria de tipo 'String'.

#### Tipos de datos
Todos los tipos de dato SQL son válidos, a excepción del campo BLOB/CLOB, que por sencillez no han sido implementados. Por ello, las tablas que contengan algún campo de ese tipo serán procesadas igualmente, pero sin esos campos.

#### Ejemplo de fichero SQL
En el código fuente de la aplicación se define un script SQL de ejemplo, en el directorio 'test'. Este fichero ha sido descargado del proyecto OpenSource Liferay Portal (http://www.liferay.com), y puede ser descargado de dos sitios:
- https://raw.githubusercontent.com/mdelapenya/generated-crud-play/master/public/sql/tables-hypersonic.sql
- Directamente de la aplicación, del directorio http://localhost:9000/assets/sql/tables-hypersonic.sql

## Ejecución de la aplicación

### Requisitos previos

#### Versión de Java
Para poder ejecutar la aplicación, Java 7 debe estar instalado en la máquina de ejecución. Para el desarrollo, compilación y pruebas de la aplicación se ha utilizado la versión del JDK v1.7.0.60.

#### Base de datos
No es necesario instalar ningún gestor de base de datos, ya que en el diseño inicial se ha contemplado el utilizar una BBDD embebida, como es H2.

#### Servidor web
Del mismo modo, la aplicación no necesita de la instalación de un servidor de aplicaciones, puesto que la aplicación utiliza un servidor embebido.

### Ejecución
La aplicación se encuentra empaquetada en el fichero ZIP generatedcrud-1.0-SNAPSHOT.

Una vez extraída, en el directorio 'bin' existen dos scripts ejecutables: "generatedcrud.bat" y "generatedcrud", uno para cada plataforma: Windows o Unix (Linux/Mac). Ejecutando estos scripts se inicia la aplicación. Por defecto, correrá en el puerto 9000, por lo que apuntando un navegador (Chrome, Firefox, IExplorer, Opera...) a http://localhost:9000 aparecerá la pantalla inicial de la aplicación.

## Descripción de las pantallas

### Inicio
En esta pantalla se solicita al usuario que suba a la aplicación un fichero SQL para generar su modelo de datos. Para acceder a ella se utilizará la URL por defecto: http://localhost:9000

### Listado de modelos
Ver Ficheros generados > listmodels.scala.html. Para acceder a ella se utilizará la URL: http://localhost:9000/showModels

### Listado de entidades de un modelo
Ver Ficheros generados > models.scala.html. Para acceder a ella se utilizará la URL: http://localhost:9000/NOMBRE_MODELO + s (P.e. http://localhost:9000/customgroups)

### Entidad de un modelo
Ver Ficheros generados > model.scala.html. Para acceder a ella se utilizará la URL: http://localhost:9000/NOMBRE_MODELO + s/:id (P.e. http://localhost:9000/customgroups/1)

## Licencia

This project, "Generated CRUD Play!", is free software ("Licensed Software"); you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; including but not limited to, the implied warranty of MERCHANTABILITY, NONINFRINGEMENT, or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA


