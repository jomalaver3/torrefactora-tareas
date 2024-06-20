import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {
    
    @Autowired
    private TareaRepository tareaRepository;

    public List<Tarea> listarTareas() {
        return tareaRepository.findAll();
    }

    public Tarea crearTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public Tarea actualizarTarea(Long id, Tarea tareaDetalles) {
        Tarea tarea = tareaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
        tarea.setDescripcion(tareaDetalles.getDescripcion());
        tarea.setEstado(tareaDetalles.getEstado());
        tarea.setPrioridad(tareaDetalles.getPrioridad());
        return tareaRepository.save(tarea);
    }

    public void eliminarTarea(Long id) {
        Tarea tarea = tareaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
        tareaRepository.delete(tarea);
    }
}