# Turnero1\n\n
Proyecto Examen: Gestión de Turnos
Descripción del Proyecto
Este proyecto es una aplicación de gestión de turnos desarrollada en Java, utilizando Java Servlets para la lógica del backend, JSP para la interacción con el usuario (frontend)
 y JPA para la persistencia de datos en la base de datos. La aplicación permite realizar operaciones CRUD (Crear, Leer, Actualizar, Borrar) sobre turnos y ciudadanos.

Estructura del Proyecto
1. Servlets
TurnoSv: Maneja las solicitudes HTTP relacionadas con los turnos, incluyendo la creación, lectura, actualización y eliminación de turnos.

CiudadanoSv: Maneja las solicitudes HTTP relacionadas con los ciudadanos, incluyendo la creación, lectura, actualización y eliminación de ciudadanos.

2. Persistencia
TurnoJpaController: Controlador JPA para operaciones CRUD de turnos.

CiudadanoJpaController: Controlador JPA para operaciones CRUD de ciudadanos.

ControladoraPersistencia: Intermediario que interactúa con los controladores JPA y maneja las operaciones de persistencia.

3. Lógica de Negocio
ControladoraLogica: Maneja la lógica de negocio interactuando con ControladoraPersistencia para gestionar turnos y ciudadanos.

Entidades:

Turno: Representa un turno en la base de datos.

Ciudadano: Representa a un ciudadano en la base de datos.

4. Frontend JSP
listarTurnos.jsp: Muestra la lista de turnos.

listarCiudadanos.jsp: Muestra la lista de ciudadanos.

crearTurno.jsp: Permite la creación de nuevos turnos.

editarCiudadano.jsp: Permite la edición de ciudadanos existentes.

index.jsp: Página de inicio y menú principal de la aplicación.

5. Configuración de Persistencia
persistence.xml: Configura el acceso a la base de datos utilizando JPA.

6. Configuración del Proyecto Maven
pom.xml: Archivo de configuración de Maven que gestiona las dependencias del proyecto.

Proyecto Examen: Gestión de Turnos
1. Descripción del Proyecto
Este proyecto es una aplicación de gestión de turnos desarrollada en Java, utilizando Java Servlets para la lógica del backend, 
JSP para la interacción con el usuario (frontend) y JPA para la persistencia de datos en la base de datos. La aplicación permite 
realizar operaciones CRUD (Crear, Leer, Actualizar, Borrar) sobre turnos y ciudadanos.

2. Estructura del Proyecto
2.1. Servlets
2.1.1. TurnoSv: Maneja las solicitudes HTTP relacionadas con los turnos, incluyendo la creación, lectura, actualización y 
eliminación de turnos.

2.1.2. CiudadanoSv: Maneja las solicitudes HTTP relacionadas con los ciudadanos, incluyendo la creación, lectura, actualización y eliminación de ciudadanos.

2.2. Persistencia
2.2.1. TurnoJpaController: Controlador JPA para operaciones CRUD de turnos.

2.2.2. CiudadanoJpaController: Controlador JPA para operaciones CRUD de ciudadanos.

2.2.3. ControladoraPersistencia: Intermediario que interactúa con los controladores JPA y maneja las operaciones de persistencia.

2.3. Lógica de Negocio
2.3.1. ControladoraLogica: Maneja la lógica de negocio interactuando con ControladoraPersistencia para gestionar turnos y ciudadanos.

2.3.2. Entidades:

2.3.2.1. Turno: Representa un turno en la base de datos.

2.3.2.2. Ciudadano: Representa a un ciudadano en la base de datos.

2.4. Frontend JSP
2.4.1. listarTurnos.jsp: Muestra la lista de turnos.

2.4.2. listarCiudadanos.jsp: Muestra la lista de ciudadanos.

2.4.3. crearTurno.jsp: Permite la creación de nuevos turnos.

2.4.4. editarCiudadano.jsp: Permite la edición de ciudadanos existentes.

2.4.5. index.jsp: Página de inicio y menú principal de la aplicación.

2.5. Configuración de Persistencia
2.5.1. persistence.xml: Configura el acceso a la base de datos utilizando JPA.

2.6. Configuración del Proyecto Maven
2.6.1. pom.xml: Archivo de configuración de Maven que gestiona las dependencias del proyecto.

3. Flujo del Programa
Inicio: El usuario accede a la página principal index.jsp, donde puede navegar a diferentes funcionalidades de la aplicación.

Gestión de Ciudadanos:

2.1. Crear Ciudadano: El usuario puede crear un nuevo ciudadano a través de editarCiudadano.jsp.

2.2. Listar Ciudadanos: El usuario puede ver la lista de ciudadanos a través de listarCiudadanos.jsp.

2.3. Editar Ciudadano: El usuario puede editar los datos de un ciudadano existente.

2.4. Eliminar Ciudadano: El usuario puede eliminar un ciudadano.

Gestión de Turnos:

3.1. Crear Turno: El usuario puede crear un nuevo turno a través de crearTurno.jsp.

3.2. Listar Turnos: El usuario puede ver la lista de turnos a través de listarTurnos.jsp.

3.3. Editar Turno: El usuario puede editar los datos de un turno existente.

3.4. Eliminar Turno: El usuario puede eliminar un turno.

3.5. Buscar Turnos por Fecha: El usuario puede buscar turnos por una fecha específica.

3.6. Buscar Turnos por Fecha y Estado: El usuario puede buscar turnos por una fecha específica y estado.

4. Manual para Usuarios
4.1. Acceso a la Aplicación
Abra su navegador web y acceda a la URL donde está desplegada la aplicación.

En la página principal, verá varias opciones para gestionar ciudadanos y turnos.

4.2. Creación de Ciudadanos
Haga clic en el botón "Crear Nuevo Ciudadano" en la página principal.

Complete el formulario con los datos del ciudadano y haga clic en "Crear".

4.3. Listado de Ciudadanos
Haga clic en el botón "Listar Ciudadanos" en la página principal.

Verá una tabla con la lista de ciudadanos registrados.

4.4. Edición y Eliminación de Ciudadanos
En la lista de ciudadanos, haga clic en "Editar" para modificar los datos de un ciudadano.

Haga clic en "Eliminar" para eliminar un ciudadano.

4.5. Creación de Turnos
Haga clic en el botón "Crear Turno" en la página principal.

Complete el formulario con los datos del turno y haga clic en "Crear".

4.6. Listado de Turnos
Haga clic en el botón "Listar Turnos" en la página principal.

Verá una tabla con la lista de turnos registrados.

4.7. Edición y Eliminación de Turnos
En la lista de turnos, haga clic en "Editar" para modificar los datos de un turno.

Haga clic en "Eliminar" para eliminar un turno.

4.8. Búsqueda de Turnos
En la página principal, puede buscar turnos por fecha y por fecha y estado, completando los formularios correspondientes y haciendo clic en "Buscar".

5. Manual para Programadores
5.1. Entendiendo el Proyecto
El proyecto se basa en una arquitectura de tres capas: Servlets para manejar las solicitudes HTTP, JSP para la interfaz de usuario y JPA para la persistencia de datos.

5.2. Adaptación del Proyecto
Para adaptar el proyecto a su propio uso o conexión a la base de datos, siga estos pasos:

5.2.1. Configuración de la Base de Datos
Modifique el archivo persistence.xml con la URL, el usuario y la contraseña de su base de datos.

xml
<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/mi_base_de_datos?serverTimeZone=UTC"/>
<property name="javax.persistence.jdbc.user" value="mi_usuario"/>
<property name="javax.persistence.jdbc.password" value="mi_contraseña"/>
5.2.2. Configuración de Maven
Asegúrese de que las dependencias necesarias están incluidas en el archivo pom.xml.

Actualice las versiones de las dependencias si es necesario.

5.2.3. Implementación de Nuevas Funcionalidades
Para añadir nuevas funcionalidades, cree nuevos Servlets y páginas JSP siguiendo el patrón existente.

Utilice la ControladoraLogica y ControladoraPersistencia para manejar la lógica de negocio y la persistencia de datos.
