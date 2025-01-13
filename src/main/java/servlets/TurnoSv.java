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
    ControladoraLogica controlLogica = new ControladoraLogica();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        try {
            if ("crear".equals(accion)) {
                List<Ciudadano> listaCiudadanos = controlLogica.traerCiudadanos();
                request.setAttribute("listaCiudadanos", listaCiudadanos);
                request.getRequestDispatcher("crearTurno.jsp").forward(request, response);
            } else if ("listar".equals(accion)) {
                List<Turno> listaTurnos = controlLogica.traerTurnos();
                request.setAttribute("listaTurnos", listaTurnos);
                request.getRequestDispatcher("listarTurnos.jsp").forward(request, response);
            } else if ("listarPorFecha".equals(accion)) {
                String fechaString = request.getParameter("fecha");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = dateFormat.parse(fechaString);
                List<Turno> listaTurnos = controlLogica.traerTurnosPorFecha(fecha);
                request.setAttribute("listaTurnos", listaTurnos);
                request.getRequestDispatcher("listarTurnos.jsp").forward(request, response);
            } else if ("listarPorFechaYEstado".equals(accion)) {
                String fechaString = request.getParameter("fecha");
                String estadoString = request.getParameter("estado");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = dateFormat.parse(fechaString);
                Turno.Atendido estado = Turno.Atendido.valueOf(estadoString);
                List<Turno> listaTurnos = controlLogica.traerTurnosPorFechaYEstado(fecha, estado);
                request.setAttribute("listaTurnos", listaTurnos);
                request.getRequestDispatcher("listarTurnos.jsp").forward(request, response);
            } else if ("editar".equals(accion)) {
                Long id = Long.parseLong(request.getParameter("id"));
                Optional<Turno> turnoOpt = controlLogica.traerTurno(id);
                if (turnoOpt.isPresent()) {
                    List<Ciudadano> listaCiudadanos = controlLogica.traerCiudadanos();
                    request.setAttribute("listaCiudadanos", listaCiudadanos);
                    request.setAttribute("turno", turnoOpt.get());
                    request.getRequestDispatcher("crearTurno.jsp").forward(request, response);
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Turno no encontrado");
                }
            } else if ("eliminar".equals(accion)) {
                Long id = Long.parseLong(request.getParameter("id"));
                controlLogica.eliminarTurno(id);
                response.sendRedirect("TurnoSv?accion=listar");  // Asegura que la lista de turnos se actualice después de eliminar
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
                Long ciudadanoId = Long.parseLong(request.getParameter("ciudadanoId"));
                String numero = request.getParameter("numero");
                String fechaString = request.getParameter("fecha");
                String descripcion = request.getParameter("descripcion");
                String atendido = request.getParameter("atendido");

                if (Optional.ofNullable(numero).orElse("").isEmpty() ||
                        Optional.ofNullable(fechaString).orElse("").isEmpty() ||
                        Optional.ofNullable(descripcion).orElse("").isEmpty() ||
                        Optional.ofNullable(atendido).orElse("").isEmpty()) {
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
                Long id = Long.parseLong(request.getParameter("id"));
                Optional<Turno> turnoOpt = controlLogica.traerTurno(id);
                if (turnoOpt.isPresent()) {
                    Turno turno = turnoOpt.get();
                    String numero = request.getParameter("numero");
                    String fechaString = request.getParameter("fecha");
                    String descripcion = request.getParameter("descripcion");
                    String atendido = request.getParameter("atendido");

                    if (Optional.ofNullable(numero).orElse("").isEmpty() ||
                            Optional.ofNullable(fechaString).orElse("").isEmpty() ||
                            Optional.ofNullable(descripcion).orElse("").isEmpty() ||
                            Optional.ofNullable(atendido).orElse("").isEmpty()) {
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















