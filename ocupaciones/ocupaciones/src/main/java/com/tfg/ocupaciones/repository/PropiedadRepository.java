package com.tfg.ocupaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tfg.ocupaciones.model.Propiedad;

public interface PropiedadRepository extends JpaRepository<Propiedad, Long> {
}