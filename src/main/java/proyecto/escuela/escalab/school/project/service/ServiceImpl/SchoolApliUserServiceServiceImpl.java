package proyecto.escuela.escalab.school.project.service.ServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proyecto.escuela.escalab.school.project.repository.RoleRepositoy;
import proyecto.escuela.escalab.school.project.repository.SchoolApliUserRepository;
import proyecto.escuela.escalab.school.project.service.SchoolApliUserService;
import proyecto.escuela.escalab.school.project.users.Role;
import proyecto.escuela.escalab.school.project.users.SchoolApliUser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SchoolApliUserServiceServiceImpl implements SchoolApliUserService, UserDetailsService {

    @Autowired
    private final SchoolApliUserRepository schoolApliUserRepository;
    private final RoleRepositoy roleRepositoy;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SchoolApliUser user = schoolApliUserRepository.findByUsername(username);
        if (user == null) {
            log.error("User Not Found in the database");
            throw new UsernameNotFoundException("User Not Found in the database");
        } else {
            log.info("User Found in the database: {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new User(user.getUsername(), user.getPassword(), authorities);
    }


    @Override
    public SchoolApliUser saveUser(SchoolApliUser schoolApliUser) {
        log.info("Saving new user {} to the database", schoolApliUser.getName());
        return schoolApliUserRepository.save(schoolApliUser);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        log.info("Adding role {} to user {}", rolename, username);
        SchoolApliUser user = schoolApliUserRepository.findByUsername(username);
        Role role = roleRepositoy.findByname(rolename);
        user.getRoles().add(role);
    }

    @Override
    public SchoolApliUser getUser(String username) {
        log.info("Fetching user {}", username);
        return schoolApliUserRepository.findByUsername(username);
    }

    @Override
    public List<SchoolApliUser> getAllAppliSchoolUsers() {
        log.info("Fetching all users");
        return schoolApliUserRepository.findAll();
    }


}


