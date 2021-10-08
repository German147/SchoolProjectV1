package proyecto.escuela.escalab.school.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.escuela.escalab.school.project.entity.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

    Curso findCursoByNombreAndJornada(String nombre, String jornada);

    Curso findCursoByNombre(String nombre);

    Curso findCursoByJornada(String jornada);


}
