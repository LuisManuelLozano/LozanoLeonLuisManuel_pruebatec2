<%@page import="java.util.List"%>
<%@page import="logica.Ciudadano"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Listar Ciudadanos</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
    <h1 class="mb-4">Lista de Ciudadanos</h1>
    <a href="index.jsp" class="btn btn-secondary mb-4">Volver a Inicio</a>
    <a href="crearCiudadano.jsp" class="btn btn-primary mb-4">Crear Ciudadano</a>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>DNI</th>
                <th>Teléfono</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Ciudadano> listaCiudadanos = (List<Ciudadano>) request.getAttribute("listaCiudadanos");
                if (listaCiudadanos != null) {
                    for (Ciudadano ciudadano : listaCiudadanos) {
            %>
            <tr>
                <td><%= ciudadano.getId() %></td>
                <td><%= ciudadano.getNombre() %></td>
                <td><%= ciudadano.getApellido() %></td>
                <td><%= ciudadano.getDni() %></td>
                <td><%= ciudadano.getTelefono() %></td>
                <td>
                    <a href="CiudadanoSv?accion=editar&id=<%= ciudadano.getId() %>" class="btn btn-warning btn-sm">Editar</a>
                    <a href="CiudadanoSv?accion=eliminar&id=<%= ciudadano.getId() %>" class="btn btn-danger btn-sm" onclick="return confirm('¿Estás seguro de que deseas eliminar este ciudadano?');">Eliminar</a>
                </td>
            </tr>
            <%
                    }
                }
            %>
        </tbody>
    </table>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>



