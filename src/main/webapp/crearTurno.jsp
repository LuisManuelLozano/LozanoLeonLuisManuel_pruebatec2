<%@page import="java.util.List"%>
<%@page import="logica.Ciudadano"%>
<%@page import="logica.Turno"%>
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
        Turno turno = (Turno) request.getAttribute("turno");
        List<Ciudadano> listaCiudadanos = (List<Ciudadano>) request.getAttribute("listaCiudadanos");
        boolean isEdit = turno != null;
        if (listaCiudadanos == null || listaCiudadanos.isEmpty()) {
            System.out.println("No hay ciudadanos disponibles en JSP");
    %>
        <p>No hay ciudadanos disponibles.</p>
    <%
        } else {
    %>
    <form action="TurnoSv" method="post">
        <input type="hidden" name="accion" value="<%= isEdit ? "editar" : "crear" %>">
        <input type="hidden" name="id" value="<%= isEdit ? turno.getId() : "" %>">
        <div class="form-group">
            <label>Ciudadano:</label>
            <select name="ciudadanoId" class="form-control" required>
                <%
                    for (Ciudadano ciudadano : listaCiudadanos) {
                        System.out.println("Ciudadano en JSP: " + ciudadano.getId() + " - " + ciudadano.getNombre() + " " + ciudadano.getApellido());
                %>
                <option value="<%= ciudadano.getId() %>" <%= isEdit && turno.getCiudadano().getId().equals(ciudadano.getId()) ? "selected" : "" %>><%= ciudadano.getNombre() %> <%= ciudadano.getApellido() %></option>
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
            <input type="date" name="fecha" class="form-control" value="<%= isEdit ? new java.text.SimpleDateFormat("yyyy-MM-dd").format(turno.getFecha()) : "" %>" required>
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
    <%
        }
    %>
    <!-- Enlace a los archivos JavaScript de Bootstrap -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>













