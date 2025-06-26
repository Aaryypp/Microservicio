package com.banca.microservicio.controller;

import com.banca.microservicio.model.Factura;
import com.banca.microservicio.repository.FacturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
@RequiredArgsConstructor
public class FacturaController {

    private final FacturaRepository facturaRepository;

    @GetMapping
    public List<Factura> listarTodas() {
        return facturaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Factura> obtenerPorId(@PathVariable Long id) {
        return facturaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Factura> crear(@RequestBody Factura factura) {
        Factura nueva = facturaRepository.save(factura);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (facturaRepository.existsById(id)) {
            facturaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

