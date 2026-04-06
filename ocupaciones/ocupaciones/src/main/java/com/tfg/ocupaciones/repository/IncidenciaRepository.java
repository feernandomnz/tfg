package com.tfg.ocupaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tfg.ocupaciones.model.Incidencia;

public interface IncidenciaRepository extends JpaRepository<Incidencia, Long> {
}