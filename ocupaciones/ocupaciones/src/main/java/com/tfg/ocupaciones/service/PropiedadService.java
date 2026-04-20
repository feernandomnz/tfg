package com.tfg.ocupaciones.service;

import com.tfg.ocupaciones.model.Propiedad;
import com.tfg.ocupaciones.repository.PropiedadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropiedadService {

    private final PropiedadRepository propiedadRepository;

    public PropiedadService(PropiedadRepository propiedadRepository) {
        this.propiedadRepository = propiedadRepository;
    }

    public List<Propiedad> obtenerTodas() {
        return propiedadRepository.findAll();
    }

    public Optional<Propiedad> obtenerPorId(Long id) {
        return propiedadRepository.findById(id);
    }

    public Propiedad guardar(Propiedad propiedad) {
        return propiedadRepository.save(propiedad);
    }

    public boolean eliminar(Long id) {
        if (!propiedadRepository.existsById(id)) {
            return false;
        }

        propiedadRepository.deleteById(id);
        return true;
    }
}
