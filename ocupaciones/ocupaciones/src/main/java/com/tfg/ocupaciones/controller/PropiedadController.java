package com.tfg.ocupaciones.controller;

import com.tfg.ocupaciones.model.Propiedad;
import com.tfg.ocupaciones.service.PropiedadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/propiedades")
public class PropiedadController {

    private final PropiedadService propiedadService;

    public PropiedadController(PropiedadService propiedadService) {
        this.propiedadService = propiedadService;
    }

    @GetMapping
    public List<Propiedad> listarPropiedades() {
        return propiedadService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Propiedad> obtenerPropiedad(@PathVariable Long id) {
        return propiedadService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Propiedad> crearPropiedad(@RequestBody Propiedad propiedad) {
        return ResponseEntity.status(HttpStatus.CREATED).body(propiedadService.guardar(propiedad));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPropiedad(@PathVariable Long id) {
        if (!propiedadService.eliminar(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
