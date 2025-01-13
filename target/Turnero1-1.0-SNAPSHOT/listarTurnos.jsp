<%@page import="java.util.List"%>
<%@page import="logica.Turno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Listar Turnos</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
    <h1 class="mb-4">Lista de Turnos</h1>
    <a href="index.jsp" class="btn btn-secondary mb-4">Volver a Inicio</a>
    <a href="crearTurno.jsp" class="btn btn-primary mb-4">Crear Nuevo Turno</a>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>ID</th>
                <th>Número</th>
                <th>Fecha</th>
                <th>Descripción</th>
                <th>Ciudadano</th>
                <th>Estado</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Turno> listaTurnos = (List<Turno>) request.getAttribute("listaTurnos");
                if (listaTurnos != null) {
                    for (Turno turno : listaTurnos) {
            %>
            <tr>
                <td><%= turno.getId() %></td>
                <td><%= turno.getNumero() %></td>
                <td><%= turno.getFecha() %></td>
                <td><%= turno.getDescripcion() %></td>
                <td><%= turno.getCiudadano().getNombre() %> <%= turno.getCiudadano().getApellido() %></td>
                <td><%= turno.getAtendido() %></td>
                <td>
                    <a href="TurnoSv?accion=editar&id=<%= turno.getId() %>" class="btn btn-warning btn-sm">Editar</a>
                    <a href="TurnoSv?accion=eliminar&id=<%= turno.getId() %>" class="btn btn-danger btn-sm" onclick="return confirm('¿Estás seguro de que deseas eliminar este turno?');">Eliminar</a>
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




