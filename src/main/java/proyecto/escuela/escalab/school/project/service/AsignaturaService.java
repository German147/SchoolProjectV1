package proyecto.escuela.escalab.school.project.service;

import proyecto.escuela.escalab.school.project.entity.Asignatura;

import java.util.List;

public interface AsignaturaService {

    List<Asignatura> findAll();

    Asignatura findById(Integer id);

    Asignatura findByNombreAndJornada(String nombre, String jornada);

    Asignatura save(Asignatura asignatura);

    Asignatura update(Asignatura asignatura, Integer id);

    void deleteById(Integer id);




}
