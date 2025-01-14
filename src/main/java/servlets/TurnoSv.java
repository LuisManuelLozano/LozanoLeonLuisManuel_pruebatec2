package servlets;

import logica.ControladoraLogica;
import logica.Ciudadano;
import logica.Turno;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "TurnoSv", urlPatterns = {"/TurnoSv"})
public class TurnoSv extends HttpServlet {

    // Instancia de la controladora lógica
    ControladoraLogica controlLogica = new ControladoraLogica();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        try {
            switch (accion) {
                case "crear":
                    // Redirigir al formulario de creación con la lista de ciudadanos
                    List<Ciudadano> listaCiudadanos = controlLogica.traerCiudadanos();
                    request.setAttribute("listaCiudadanos", listaCiudadanos);
                    request.getRequestDispatcher("crearTurno.jsp").forward(request, response);
                    break;
                case "listar":
                    // Listar todos los turnos
                    List<Turno> listaTurnos = controlLogica.traerTurnos();
                    request.setAttribute("listaTurnos", listaTurnos);
                    request.getRequestDispatcher("listarTurnos.jsp").forward(request, response);
                    break;
                case "listarPorFecha":
                    // Listar turnos por una fecha específica
                    String fechaString = request.getParameter("fecha");
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date fecha = dateFormat.parse(fechaString);
                    List<Turno> listaTurnosPorFecha = controlLogica.traerTurnosPorFecha(fecha);
                    request.setAttribute("listaTurnos", listaTurnosPorFecha);
                    request.getRequestDispatcher("listarTurnos.jsp").forward(request, response);
                    break;
                case "listarPorFechaYEstado":
                    // Listar turnos por una fecha específica y estado
                    String fechaStr = request.getParameter("fecha");
                    String estadoString = request.getParameter("estado");
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    Date fechaEstado = df.parse(fechaStr);
                    Turno.Atendido estado = Turno.Atendido.valueOf(estadoString);
                    List<Turno> listaTurnosPorFechaYEstado = controlLogica.traerTurnosPorFechaYEstado(fechaEstado, estado);
                    request.setAttribute("listaTurnos", listaTurnosPorFechaYEstado);
                    request.getRequestDispatcher("listarTurnos.jsp").forward(request, response);
                    break;
                case "editar":
                    // Redirigir al formulario de edición con datos del turno pre-rellenados
                    Long id = Long.parseLong(request.getParameter("id"));
                    Optional<Turno> turnoOpt = controlLogica.traerTurno(id);
                    if (turnoOpt.isPresent()) {
                        Turno turno = turnoOpt.get();
                        List<Ciudadano> ciudadanos = controlLogica.traerCiudadanos();
                        request.setAttribute("listaCiudadanos", ciudadanos);
                        request.setAttribute("turno", turno);
                        request.getRequestDispatcher("crearTurno.jsp").forward(request, response);
                    } else {
                        response.sendError(HttpServletResponse.SC_NOT_FOUND, "Turno no encontrado");
                    }
                    break;
                case "eliminar":
                    // Eliminar un turno y redirigir a la lista de turnos
                    Long turnId = Long.parseLong(request.getParameter("id"));
                    controlLogica.eliminarTurno(turnId);
                    response.sendRedirect("TurnoSv?accion=listar");
                    break;
                default:
                    // Parámetro de acción no válido
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Acción no reconocida");
                    break;
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido");
        } catch (ParseException e) {
            throw new ServletException("Fecha inválida");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error interno del servidor");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        try {
            if ("crear".equals(accion)) {
                // Crear un nuevo turno
                Long ciudadanoId = Long.parseLong(request.getParameter("ciudadanoId"));
                String numero = request.getParameter("numero");
                String fechaString = request.getParameter("fecha");
                String descripcion = request.getParameter("descripcion");
                String atendido = request.getParameter("atendido");

                if (numero.isEmpty() || fechaString.isEmpty() || descripcion.isEmpty() || atendido.isEmpty()) {
                    throw new IllegalArgumentException("Todos los campos son obligatorios.");
                }

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = dateFormat.parse(fechaString);

                Turno nuevoTurno = new Turno();
                nuevoTurno.setNumero(numero);
                nuevoTurno.setFecha(fecha);
                nuevoTurno.setDescripcion(descripcion);
                nuevoTurno.setAtendido(Turno.Atendido.valueOf(atendido));
                controlLogica.crearTurno(nuevoTurno, ciudadanoId);

                List<Turno> listaTurnos = controlLogica.traerTurnos();
                request.setAttribute("listaTurnos", listaTurnos);
                request.getRequestDispatcher("listarTurnos.jsp").forward(request, response);
            } else if ("editar".equals(accion)) {
                // Editar un turno existente
                Long id = Long.parseLong(request.getParameter("id"));
                Optional<Turno> turnoOpt = controlLogica.traerTurno(id);
                if (turnoOpt.isPresent()) {
                    Turno turno = turnoOpt.get();
                    String numero = request.getParameter("numero");
                    String fechaString = request.getParameter("fecha");
                    String descripcion = request.getParameter("descripcion");
                    String atendido = request.getParameter("atendido");

                    if (numero.isEmpty() || fechaString.isEmpty() || descripcion.isEmpty() || atendido.isEmpty()) {
                        throw new IllegalArgumentException("Todos los campos son obligatorios.");
                    }

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date fecha = dateFormat.parse(fechaString);

                    turno.setNumero(numero);
                    turno.setFecha(fecha);
                    turno.setDescripcion(descripcion);
                    turno.setAtendido(Turno.Atendido.valueOf(atendido));
                    controlLogica.editarTurno(turno);

                    List<Turno> listaTurnos = controlLogica.traerTurnos();
                    request.setAttribute("listaTurnos", listaTurnos);
                    request.getRequestDispatcher("listarTurnos.jsp").forward(request, response);
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Turno no encontrado");
                }
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido");
        } catch (IllegalArgumentException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
        } catch (ParseException e) {
            throw new ServletException("Fecha inválida");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error interno del servidor");
        }
    }
}














