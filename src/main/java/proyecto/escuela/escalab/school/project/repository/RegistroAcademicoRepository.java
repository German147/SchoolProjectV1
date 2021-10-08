package proyecto.escuela.escalab.school.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.escuela.escalab.school.project.entity.RegistroAcademico;

@Repository
public interface RegistroAcademicoRepository extends JpaRepository<RegistroAcademico, Integer> {
}
