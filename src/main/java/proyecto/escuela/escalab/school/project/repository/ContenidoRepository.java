package proyecto.escuela.escalab.school.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.escuela.escalab.school.project.entity.Contenido;

@Repository
public interface ContenidoRepository extends JpaRepository<Contenido, Integer> {

}
