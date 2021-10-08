package proyecto.escuela.escalab.school.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.escuela.escalab.school.project.entity.Asignatura;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Integer> {

    Asignatura findAsignaturaByNombreAndJornada(String nombre, String jornada);

    Asignatura findAsignaturaByNombre(String nombre);

    Asignatura findAsignaturaByJornada(String jornada);
}
