package com.banca.microservicio.controller;


import com.banca.microservicio.model.Clasificacion;
import com.banca.microservicio.repository.ClasificacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clasificaciones")
@RequiredArgsConstructor
public class ClasificacionController {
    private final ClasificacionRepository clasificacionRepository;

    @GetMapping
    public List<Clasificacion> listarTodas() {
        return clasificacionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clasificacion> obtenerPorId(@PathVariable Long id) {
        return clasificacionRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Clasificacion> crear(@RequestBody Clasificacion clasificacion) {
        Clasificacion nueva = clasificacionRepository.save(clasificacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (clasificacionRepository.existsById(id)) {
            clasificacionRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
