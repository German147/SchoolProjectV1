package proyecto.escuela.escalab.school.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.escuela.escalab.school.project.users.SchoolApliUser;

@Repository
public interface SchoolApliUserRepository extends JpaRepository<SchoolApliUser,Long> {
    SchoolApliUser findByUsername(String username);
}
