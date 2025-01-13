<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Menú Principal</title>
    <!-- Incluye Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
    <h1 class="mb-4">Menú Principal</h1>
    <form action="editarCiudadano.jsp" method="get">
        <button type="submit" class="btn btn-primary btn-block">Crear Nuevo Ciudadano</button>
    </form>
    <form action="CiudadanoSv" method="get">
        <input type="hidden" name="accion" value="listar">
        <button type="submit" class="btn btn-primary btn-block mt-2">Listar Ciudadanos</button>
    </form>
    <form action="TurnoSv" method="get">
        <input type="hidden" name="accion" value="crear">
        <button type="submit" class="btn btn-primary btn-block mt-2">Crear Turno</button>
    </form>
    <form action="TurnoSv" method="get" class="mt-3">
        <label>Buscar Turnos por Fecha:</label><br>
        <input type="date" name="fecha" class="form-control" required>
        <input type="hidden" name="accion" value="listarPorFecha">
        <button type="submit" class="btn btn-primary mt-2">Buscar</button>
    </form>
    <form action="TurnoSv" method="get" class="mt-3">
        <label>Buscar Turnos por Fecha y Estado:</label><br>
        <input type="date" name="fecha" class="form-control" required>
        <select name="estado" class="form-control mt-2">
            <option value="ATENDIDO">Atendido</option>
            <option value="EN_ESPERA">En Espera</option>
        </select>
        <input type="hidden" name="accion" value="listarPorFechaYEstado">
        <button type="submit" class="btn btn-primary mt-2">Buscar</button>
    </form>
    <!-- Incluye Bootstrap JS y dependencias -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>


