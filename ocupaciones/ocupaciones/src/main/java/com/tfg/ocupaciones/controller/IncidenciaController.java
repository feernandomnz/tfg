package com.tfg.ocupaciones.controller;

import com.tfg.ocupaciones.model.Incidencia;
import com.tfg.ocupaciones.service.IncidenciaService;
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
@RequestMapping("/incidencias")
public class IncidenciaController {

    private final IncidenciaService incidenciaService;

    public IncidenciaController(IncidenciaService incidenciaService) {
        this.incidenciaService = incidenciaService;
    }

    @GetMapping
    public List<Incidencia> listarIncidencias() {
        return incidenciaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Incidencia> obtenerIncidencia(@PathVariable Long id) {
        return incidenciaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Incidencia> crearIncidencia(@RequestBody Incidencia incidencia) {
        return ResponseEntity.status(HttpStatus.CREATED).body(incidenciaService.guardar(incidencia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarIncidencia(@PathVariable Long id) {
        if (!incidenciaService.eliminar(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
