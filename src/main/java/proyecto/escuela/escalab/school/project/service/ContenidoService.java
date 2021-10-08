package proyecto.escuela.escalab.school.project.service;

import proyecto.escuela.escalab.school.project.entity.Contenido;

import java.util.List;

public interface ContenidoService {

    List<Contenido> findAll();

    Contenido findById(Integer id);

    Contenido save(Contenido contenido);

    Contenido update(Contenido contenido, Integer id);

    void deleteById(Integer id);
}
