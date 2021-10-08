package proyecto.escuela.escalab.school.project.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import proyecto.escuela.escalab.school.project.service.RoleService;
import proyecto.escuela.escalab.school.project.service.SchoolApliUserService;
import proyecto.escuela.escalab.school.project.users.Role;
import proyecto.escuela.escalab.school.project.users.SchoolApliUser;

import java.util.ArrayList;

@Configuration
public class SeedUserToDatabase {

@Autowired
    private final SchoolApliUserService schoolApliUserService;
    private final RoleService roleService;

    public SeedUserToDatabase(SchoolApliUserService schoolApliUserService,
                              RoleService roleService) {
        this.schoolApliUserService = schoolApliUserService;
        this.roleService = roleService;
    }
    @Bean
    CommandLineRunner User(SchoolApliUserService schoolApliUserService, RoleService roleService){
        return args -> {
            roleService.saveRole(new Role(null,"ROLE_ALUMNO"));
            roleService.saveRole(new Role(null,"ROLE_APODERADO"));
            roleService.saveRole(new Role(null,"ROLE_PRECEPTOR"));
            roleService.saveRole(new Role(null,"ROLE_PROFESOR"));
            roleService.saveRole(new Role(null,"ROLE_SECRETARIA"));
            roleService.saveRole(new Role(null,"ROLE_DIRECTOR"));

            schoolApliUserService.saveUser(new SchoolApliUser(null,"Lucas Paez","lucas","1234",new ArrayList<>()));
            schoolApliUserService.saveUser(new SchoolApliUser(null,"Carlos Paez","carlos","1234",new ArrayList<>()));
            schoolApliUserService.saveUser(new SchoolApliUser(null,"Maricel Rojas","maricel","1234",new ArrayList<>()));
            schoolApliUserService.saveUser(new SchoolApliUser(null,"German Barrera","german","1234",new ArrayList<>()));
            schoolApliUserService.saveUser(new SchoolApliUser(null,"Paola Fraire","paola","1234",new ArrayList<>()));
            schoolApliUserService.saveUser(new SchoolApliUser(null,"Claudia Guilevsky","claudia","1234",new ArrayList<>()));

            schoolApliUserService.addRoleToUser("lucas","ROLE_ALUMNO");
            schoolApliUserService.addRoleToUser("carlos","ROLE_APODERADO");
            schoolApliUserService.addRoleToUser("maricel","ROLE_PRECEPTOR");
            schoolApliUserService.addRoleToUser("german","ROLE_PROFESOR");
            schoolApliUserService.addRoleToUser("paola","ROLE_SECRETARIA");
            schoolApliUserService.addRoleToUser("claudia","ROLE_DIRECTOR");

        };
    }
}
