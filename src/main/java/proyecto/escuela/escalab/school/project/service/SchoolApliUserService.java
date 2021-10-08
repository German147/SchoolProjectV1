package proyecto.escuela.escalab.school.project.service;

import proyecto.escuela.escalab.school.project.users.SchoolApliUser;

import java.util.List;

public interface SchoolApliUserService {

    SchoolApliUser saveUser(SchoolApliUser schoolApliUser);

    void addRoleToUser(String username, String rolename);

    SchoolApliUser getUser(String username);

    List<SchoolApliUser> getAllAppliSchoolUsers(); //here we shoul return a page to a user..
}
