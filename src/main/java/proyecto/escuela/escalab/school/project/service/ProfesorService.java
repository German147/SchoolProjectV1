package proyecto.escuela.escalab.school.project.service;

import proyecto.escuela.escalab.school.project.entity.Profesor;

import java.util.List;

public interface ProfesorService {
    
    List<Profesor> findAll();

    Profesor findById(Integer id);

    Profesor save(Profesor profesor);

    Profesor update(Profesor profesor, Integer id);

    void deleteById(Integer id);
}
