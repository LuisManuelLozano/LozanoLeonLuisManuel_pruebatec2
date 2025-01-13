<%@page import="logica.Ciudadano"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Ciudadano</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
    <h1 class="mb-4">Editar Ciudadano</h1>
    <a href="index.jsp" class="btn btn-secondary mb-4">Volver a Inicio</a>
    <%
        Ciudadano ciudadano = (Ciudadano) request.getAttribute("ciudadano");
        boolean isEdit = ciudadano != null;
    %>
    <form action="CiudadanoSv" method="post">
        <input type="hidden" name="accion" value="<%= isEdit ? "editar" : "crear" %>">
        <input type="hidden" name="id" value="<%= isEdit ? ciudadano.getId() : "" %>">
        <div class="form-group">
            <label>Nombre:</label>
            <input type="text" name="nombre" class="form-control" value="<%= isEdit ? ciudadano.getNombre() : "" %>" required>
        </div>
        <div class="form-group">
            <label>Apellido:</label>
            <input type="text" name="apellido" class="form-control" value="<%= isEdit ? ciudadano.getApellido() : "" %>" required>
        </div>
        <div class="form-group">
            <label>DNI:</label>
            <input type="text" name="dni" class="form-control" value="<%= isEdit ? ciudadano.getDni() : "" %>" required>
        </div>
        <div class="form-group">
            <label>Teléfono:</label>
            <input type="text" name="telefono" class="form-control" value="<%= isEdit ? ciudadano.getTelefono() : "" %>" required>
        </div>
        <button type="submit" class="btn btn-primary"><%= isEdit ? "Actualizar" : "Crear" %></button>
    </form>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>

