package com.tfg.ocupaciones.service;

import com.tfg.ocupaciones.model.Incidencia;
import com.tfg.ocupaciones.repository.IncidenciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncidenciaService {

    private final IncidenciaRepository incidenciaRepository;

    public IncidenciaService(IncidenciaRepository incidenciaRepository) {
        this.incidenciaRepository = incidenciaRepository;
    }

    public List<Incidencia> obtenerTodas() {
        return incidenciaRepository.findAll();
    }

    public Optional<Incidencia> obtenerPorId(Long id) {
        return incidenciaRepository.findById(id);
    }

    public Incidencia guardar(Incidencia incidencia) {
        return incidenciaRepository.save(incidencia);
    }

    public boolean eliminar(Long id) {
        if (!incidenciaRepository.existsById(id)) {
            return false;
        }

        incidenciaRepository.deleteById(id);
        return true;
    }
}
