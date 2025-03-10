package servlets;

import logica.ControladoraLogica;
import logica.Ciudadano;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "CiudadanoSv", urlPatterns = {"/CiudadanoSv"})
public class CiudadanoSv extends HttpServlet {

    // Instancia de la controladora l�gica
    ControladoraLogica controlLogica = new ControladoraLogica();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        try {
            if ("listar".equals(accion)) {
                // Listar todos los ciudadanos
                List<Ciudadano> listaCiudadanos = controlLogica.traerCiudadanos();
                request.setAttribute("listaCiudadanos", listaCiudadanos);
                request.getRequestDispatcher("listarCiudadanos.jsp").forward(request, response);
            } else if ("crear".equals(accion)) {
                // L�gica para redirigir al formulario de creaci�n de ciudadano
                request.getRequestDispatcher("crearCiudadano.jsp").forward(request, response);
            } else if ("editar".equals(accion)) {
                // Redirigir al formulario de edici�n con datos del ciudadano pre-rellenados
                Long id = Long.parseLong(request.getParameter("id"));
                Optional<Ciudadano> ciudadanoOpt = controlLogica.traerCiudadano(id);
                if (ciudadanoOpt.isPresent()) {
                    request.setAttribute("ciudadano", ciudadanoOpt.get());
                    request.getRequestDispatcher("editarCiudadano.jsp").forward(request, response);
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Ciudadano no encontrado");
                }
            } else if ("eliminar".equals(accion)) {
                // Eliminar un ciudadano y redirigir a la lista de ciudadanos
                Long id = Long.parseLong(request.getParameter("id"));
                controlLogica.eliminarCiudadano(id);
                response.sendRedirect("CiudadanoSv?accion=listar");
            } else {
                // Par�metro de acci�n no v�lido
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Acci�n no reconocida");
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inv�lido");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error interno del servidor");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        try {
            if ("crear".equals(accion)) {
                // Crear un nuevo ciudadano
                String nombre = Optional.ofNullable(request.getParameter("nombre")).orElse("");
                String apellido = Optional.ofNullable(request.getParameter("apellido")).orElse("");
                String dni = Optional.ofNullable(request.getParameter("dni")).orElse("");
                String telefono = Optional.ofNullable(request.getParameter("telefono")).orElse("");

                if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty() || telefono.isEmpty()) {
                    throw new IllegalArgumentException("Todos los campos son obligatorios.");
                }

                Ciudadano nuevoCiudadano = new Ciudadano();
                nuevoCiudadano.setNombre(nombre);
                nuevoCiudadano.setApellido(apellido);
                nuevoCiudadano.setDni(dni);
                nuevoCiudadano.setTelefono(telefono);
                controlLogica.crearCiudadano(nuevoCiudadano);
                response.sendRedirect("CiudadanoSv?accion=listar");
            } else if ("editar".equals(accion)) {
                // Editar un ciudadano existente
                Long id = Long.parseLong(request.getParameter("id"));
                String nombre = Optional.ofNullable(request.getParameter("nombre")).orElse("");
                String apellido = Optional.ofNullable(request.getParameter("apellido")).orElse("");
                String dni = Optional.ofNullable(request.getParameter("dni")).orElse("");
                String telefono = Optional.ofNullable(request.getParameter("telefono")).orElse("");

                if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty() || telefono.isEmpty()) {
                    throw new IllegalArgumentException("Todos los campos son obligatorios.");
                }

                Optional<Ciudadano> ciudadanoOpt = controlLogica.traerCiudadano(id);
                if (ciudadanoOpt.isPresent()) {
                    Ciudadano ciudadano = ciudadanoOpt.get();
                    ciudadano.setNombre(nombre);
                    ciudadano.setApellido(apellido);
                    ciudadano.setDni(dni);
                    ciudadano.setTelefono(telefono);
                    controlLogica.editarCiudadano(ciudadano);
                    response.sendRedirect("CiudadanoSv?accion=listar");
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Ciudadano no encontrado");
                }
            } else if ("eliminar".equals(accion)) {
                // Eliminar un ciudadano
                Long id = Long.parseLong(request.getParameter("id"));
                controlLogica.eliminarCiudadano(id);
                response.sendRedirect("CiudadanoSv?accion=listar");
            } else {
                // Par�metro de acci�n no v�lido
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Acci�n no reconocida");
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inv�lido");
        } catch (IllegalArgumentException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error interno del servidor");
        }
    }
}















