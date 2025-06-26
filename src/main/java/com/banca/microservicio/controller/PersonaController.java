package com.banca.microservicio.controller;

import com.banca.microservicio.model.Persona;
import com.banca.microservicio.repository.PersonaRepository;
import com.banca.microservicio.services.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
@RequiredArgsConstructor
public class PersonaController {

    private final PersonaRepository personaRepository;
    private final PersonaService personaService;

    @GetMapping
    public List<Persona> listarTodas() {
        return personaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> obtenerPorId(@PathVariable Long id) {
        return personaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Persona> crear(@RequestBody Persona persona) {
        Persona nueva = personaRepository.save(persona);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (personaRepository.existsById(id)) {
            personaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/buscar/{dni}")
    public ResponseEntity<Persona> buscarPorDni(@PathVariable String dni) {
        Persona persona = personaService.buscaP(dni);
        return persona != null ? ResponseEntity.ok(persona) : ResponseEntity.notFound().build();
    }

    @GetMapping("/nombre-completo/{dni}")
    public ResponseEntity<String> obtenerNombreCompleto(@PathVariable String dni) {
        String nombreCompleto = personaService.nombreCompl(dni);
        return nombreCompleto != null ? ResponseEntity.ok(nombreCompleto) : ResponseEntity.notFound().build();
    }
}

