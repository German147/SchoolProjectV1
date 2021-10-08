package proyecto.escuela.escalab.school.project.service;

import proyecto.escuela.escalab.school.project.entity.Curso;

import java.util.List;

public interface CursoService {

    List<Curso> findAll();

    Curso findById(Integer id);

    Curso findByNombreAndJornada(String nombre, String jornada);

    Curso save(Curso curso );

    Curso update(Curso curso, Integer id);

    void deleteById(Integer id);
}
