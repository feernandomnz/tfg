package com.tfg.ocupaciones.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Incidencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private String descripcion;
    private LocalDateTime fecha = LocalDateTime.now();
    private String prioridad;

    @ManyToOne(optional = false)
    @JoinColumn(name = "propiedad_id", nullable = false)
    private Propiedad propiedad;
}
