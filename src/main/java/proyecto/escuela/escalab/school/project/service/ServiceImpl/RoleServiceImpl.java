package proyecto.escuela.escalab.school.project.service.ServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proyecto.escuela.escalab.school.project.repository.RoleRepositoy;
import proyecto.escuela.escalab.school.project.service.RoleService;
import proyecto.escuela.escalab.school.project.users.Role;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RoleServiceImpl implements RoleService {

    @Autowired
    private final RoleRepositoy roleRepositoy;

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database",role.getName());
        return roleRepositoy.save(role);
    }
}
