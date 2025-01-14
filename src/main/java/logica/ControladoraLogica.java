package logica;

import persistencia.ControladoraPersistencia;
import java.util.List;
import java.util.Date;
import java.util.Optional;

public class ControladoraLogica {

    private ControladoraPersistencia controlPersistencia = new ControladoraPersistencia();

    // Métodos para ciudadanos
    public void crearCiudadano(Ciudadano ciudadano) {
        try {
            controlPersistencia.crearCiudadano(ciudadano);
        } catch (Exception e) {
            throw new RuntimeException("Error al crear ciudadano", e);
        }
    }

    public List<Ciudadano> traerCiudadanos() {
        try {
            return controlPersistencia.traerCiudadanos();
        } catch (Exception e) {
            throw new RuntimeException("Error al traer lista de ciudadanos", e);
        }
    }

    public Optional<Ciudadano> traerCiudadano(Long id) {
        try {
            return controlPersistencia.traerCiudadano(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al traer ciudadano", e);
        }
    }

    public void editarCiudadano(Ciudadano ciudadano) {
        try {
            controlPersistencia.editarCiudadano(ciudadano);
        } catch (Exception e) {
            throw new RuntimeException("Error al editar ciudadano", e);
        }
    }

    public void eliminarCiudadano(Long id) {
        try {
            controlPersistencia.eliminarCiudadano(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar ciudadano", e);
        }
    }

    // Métodos para turnos
    public void crearTurno(Turno turno, Long ciudadanoId) {
        try {
            Optional<Ciudadano> ciudadanoOpt = controlPersistencia.traerCiudadano(ciudadanoId);
            if (ciudadanoOpt.isPresent()) {
                turno.setCiudadano(ciudadanoOpt.get());
                controlPersistencia.crearTurno(turno);
            } else {
                throw new RuntimeException("Ciudadano no encontrado");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al crear turno", e);
        }
    }

    public List<Turno> traerTurnos() {
        try {
            return controlPersistencia.traerTurnos();
        } catch (Exception e) {
            throw new RuntimeException("Error al traer lista de turnos", e);
        }
    }

    public List<Turno> traerTurnosPorFecha(Date fecha) {
        try {
            return controlPersistencia.traerTurnosPorFecha(fecha);
        } catch (Exception e) {
            throw new RuntimeException("Error al traer turnos por fecha", e);
        }
    }

    public List<Turno> traerTurnosPorFechaYEstado(Date fecha, Turno.Atendido estado) {
        try {
            return controlPersistencia.traerTurnosPorFechaYEstado(fecha, estado);
        } catch (Exception e) {
            throw new RuntimeException("Error al traer turnos por fecha y estado", e);
        }
    }

    public Optional<Turno> traerTurno(Long id) {
        try {
            return controlPersistencia.traerTurno(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al traer turno", e);
        }
    }

    public void editarTurno(Turno turno) {
        try {
            controlPersistencia.editarTurno(turno);
        } catch (Exception e) {
            throw new RuntimeException("Error al editar turno", e);
        }
    }

    public void eliminarTurno(Long id) {
        try {
            controlPersistencia.eliminarTurno(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar turno", e);
        }
    }
}




