<%@page import="java.util.List"%>
<%@page import="logica.Ciudadano"%>
<%@page import="logica.Turno"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Crear Turno</title>
    <!-- Enlace a Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
    <h1 class="mb-4">Crear Turno</h1>
    <a href="index.jsp" class="btn btn-secondary mb-4">Volver a Inicio</a>
    <%
        // Obtiene la lista de ciudadanos y el turno desde los atributos de la solicitud
        List<Ciudadano> listaCiudadanos = (List<Ciudadano>) request.getAttribute("listaCiudadanos");
        Turno turno = (Turno) request.getAttribute("turno");
        boolean isEdit = turno != null;
    %>
    <form action="TurnoSv" method="post">
        <!-- Campo oculto para la acción (crear o editar) -->
        <input type="hidden" name="accion" value="<%= isEdit ? "editar" : "crear" %>">
        <!-- Campo oculto para el ID del turno (solo para edición) -->
        <input type="hidden" name="id" value="<%= isEdit ? turno.getId() : "" %>">
        <div class="form-group">
            <label>Ciudadano:</label>
            <select name="ciudadanoId" class="form-control" required>
                <%
                    for (Ciudadano ciudadano : listaCiudadanos) {
                        boolean selected = isEdit && turno.getCiudadano().getId().equals(ciudadano.getId());
                %>
                <option value="<%= ciudadano.getId() %>" <%= selected ? "selected" : "" %>><%= ciudadano.getNombre() %> <%= ciudadano.getApellido() %></option>
                <%
                    }
                %>
            </select>
        </div>
        <div class="form-group">
            <label>Número:</label>
            <input type="text" name="numero" class="form-control" value="<%= isEdit ? turno.getNumero() : "" %>" required>
        </div>
        <div class="form-group">
            <label>Fecha:</label>
            <input type="date" name="fecha" class="form-control" value="<%= isEdit ? new SimpleDateFormat("yyyy-MM-dd").format(turno.getFecha()) : "" %>" required>
        </div>
        <div class="form-group">
            <label>Descripción:</label>
            <input type="text" name="descripcion" class="form-control" value="<%= isEdit ? turno.getDescripcion() : "" %>" required>
        </div>
        <div class="form-group">
            <label>Atendido:</label>
            <select name="atendido" class="form-control">
                <option value="ATENDIDO" <%= isEdit && turno.getAtendido() == Turno.Atendido.ATENDIDO ? "selected" : "" %>>Atendido</option>
                <option value="EN_ESPERA" <%= isEdit && turno.getAtendido() == Turno.Atendido.EN_ESPERA ? "selected" : "" %>>En Espera</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary"><%= isEdit ? "Actualizar" : "Crear" %></button>
    </form>
    <!-- Enlace a los archivos JavaScript de Bootstrap -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>













