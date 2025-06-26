package com.banca.microservicio.controller;
import com.banca.microservicio.model.Competencia;
import com.banca.microservicio.repository.CompetenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competencias")
@RequiredArgsConstructor
public class CompetenciaController {
    private final CompetenciaRepository competenciaRepository;

    @GetMapping
    public List<Competencia> listarTodas() {
        return competenciaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Competencia> obtenerPorId(@PathVariable Long id) {
        return competenciaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Competencia> crear(@RequestBody Competencia competencia) {
        Competencia nueva = competenciaRepository.save(competencia);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (competenciaRepository.existsById(id)) {
            competenciaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
