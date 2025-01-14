package persistencia;

import logica.Ciudadano;
import logica.Turno;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ControladoraPersistencia {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Luis_Turnero1_war_1.0-SNAPSHOTPU");
    private CiudadanoJpaController ciudadanoJpaController = new CiudadanoJpaController(emf);
    private TurnoJpaController turnoJpaController = new TurnoJpaController(emf);

    // Métodos para ciudadanos
    public void crearCiudadano(Ciudadano ciudadano) {
        ciudadanoJpaController.create(ciudadano);
    }

    public List<Ciudadano> traerCiudadanos() {
        return ciudadanoJpaController.findCiudadanoEntities();
    }

    public Optional<Ciudadano> traerCiudadano(Long id) {
        return ciudadanoJpaController.findCiudadano(id);
    }

    public void editarCiudadano(Ciudadano ciudadano) {
        try {
            ciudadanoJpaController.edit(ciudadano);
        } catch (Exception e) {
            throw new RuntimeException("Error al editar ciudadano", e);
        }
    }

    public void eliminarCiudadano(Long id) {
        try {
            ciudadanoJpaController.destroy(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar ciudadano", e);
        }
    }

    // Métodos para turnos
    public void crearTurno(Turno turno) {
        turnoJpaController.create(turno);
    }

    public List<Turno> traerTurnos() {
        return turnoJpaController.findTurnoEntities();
    }

    public List<Turno> traerTurnosPorFecha(Date fecha) {
        return turnoJpaController.findTurnoEntities()
                .stream()
                .filter(turno -> turno.getFecha().equals(fecha))
                .collect(Collectors.toList());
    }

    public List<Turno> traerTurnosPorFechaYEstado(Date fecha, Turno.Atendido estado) {
        return turnoJpaController.findTurnoEntities()
                .stream()
                .filter(turno -> turno.getFecha().equals(fecha) && turno.getAtendido().equals(estado))
                .collect(Collectors.toList());
    }

    public Optional<Turno> traerTurno(Long id) {
        return turnoJpaController.findTurno(id);
    }

    public void editarTurno(Turno turno) {
        try {
            turnoJpaController.edit(turno);
        } catch (Exception e) {
            throw new RuntimeException("Error al editar turno", e);
        }
    }

    public void eliminarTurno(Long id) {
        try {
            turnoJpaController.destroy(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar turno", e);
        }
    }
}


