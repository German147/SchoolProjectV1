package proyecto.escuela.escalab.school.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.escuela.escalab.school.project.users.Role;

@Repository
public interface RoleRepositoy extends JpaRepository<Role, Long> {
    Role findByname(String rolename);
}
