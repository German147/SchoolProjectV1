package proyecto.escuela.escalab.school.project.service;

import proyecto.escuela.escalab.school.project.dto.RegistroAcademicoDTO;
import proyecto.escuela.escalab.school.project.entity.RegistroAcademico;

import java.util.List;

public interface RegistroAcademicoService extends ICRUD<RegistroAcademico> {

    List<RegistroAcademico> findAll();

    RegistroAcademico findById(Integer id);

    RegistroAcademico save(RegistroAcademico registroAcademico);

    RegistroAcademico update(RegistroAcademico registroAcademico, Integer id);

    void deleteById(Integer id);

    List<RegistroAcademicoDTO> findAllRegistros();
}
