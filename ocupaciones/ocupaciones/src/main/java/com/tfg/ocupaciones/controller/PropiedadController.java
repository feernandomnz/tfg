package com.tfg.ocupaciones.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.tfg.ocupaciones.model.Propiedad;
import com.tfg.ocupaciones.repository.PropiedadRepository;

@RestController
@RequestMapping("/propiedades")
public class PropiedadController {

    private final PropiedadRepository propiedadRepository;

    public PropiedadController(PropiedadRepository propiedadRepository) {
        this.propiedadRepository = propiedadRepository;
    }

    @GetMapping
    public List<Propiedad> listarPropiedades() {
        return propiedadRepository.findAll();
    }
}