package proyecto.escuela.escalab.school.project.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import proyecto.escuela.escalab.school.project.repository.RoleRepositoy;
import proyecto.escuela.escalab.school.project.service.SchoolApliUserService;
import proyecto.escuela.escalab.school.project.users.Role;
import proyecto.escuela.escalab.school.project.users.SchoolApliUser;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final RoleRepositoy roleRepositoy;
    private final SchoolApliUserService schoolApliUserService;

    @GetMapping("/listUsers")
    public ResponseEntity<List<SchoolApliUser>> getUsers() {
        return ResponseEntity.ok().body(schoolApliUserService.getAllAppliSchoolUsers());
    }
//
//    @GetMapping("/findrolename/{rolename}")
//    public @ResponseBody
//    Role findByname(@PathVariable("rolename") String rolename){
//        return roleRepository.findByname(rolename);
//    }

    @PostMapping("/save")
    public ResponseEntity<SchoolApliUser> saveUser(@RequestBody SchoolApliUser schoolApliUser) {
        //this URI builder is meant to respond with a 201 when the user is created
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/save").toUriString());
        return ResponseEntity.created(uri).body(schoolApliUserService.saveUser(schoolApliUser));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/role/save").toUriString());
        return ResponseEntity.created(uri).body(roleRepositoy.save(role));
    }

    @PostMapping("/role/addrole")
    public ResponseEntity<?> addRoletoUser(@RequestBody Role role,@RequestBody SchoolApliUser schoolApliUser){
        schoolApliUserService.addRoleToUser(role.getName(), schoolApliUser.getName());
        return ResponseEntity.ok().build();
    }

}