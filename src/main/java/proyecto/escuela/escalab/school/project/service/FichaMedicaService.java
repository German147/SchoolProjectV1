package proyecto.escuela.escalab.school.project.service;


import proyecto.escuela.escalab.school.project.entity.FichaMedica;

import java.util.List;

public interface FichaMedicaService{


    List<FichaMedica> findAll();

    FichaMedica findById(Integer id);

    FichaMedica save(FichaMedica fichaMedica);

    FichaMedica update(FichaMedica fichaMedica, Integer id);

    void deleteById(Integer id);
}
