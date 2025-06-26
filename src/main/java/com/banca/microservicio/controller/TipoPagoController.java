package com.banca.microservicio.controller;

import com.banca.microservicio.model.TipoPago;
import com.banca.microservicio.repository.TipoPagoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipopagos")
@RequiredArgsConstructor
public class TipoPagoController {

    private final TipoPagoRepository tipoPagoRepository;

    @GetMapping
    public List<TipoPago> listarTodos() {
        return tipoPagoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoPago> obtenerPorId(@PathVariable Long id) {
        return tipoPagoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TipoPago> crear(@RequestBody TipoPago tipoPago) {
        TipoPago nuevo = tipoPagoRepository.save(tipoPago);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoPago> actualizar(@PathVariable Long id, @RequestBody TipoPago tipoPago) {
        return tipoPagoRepository.findById(id)
                .map(tp -> {
                    tp.setTipo(tipoPago.getTipo());
                    tp.setDescrip(tipoPago.getDescrip());
                    tipoPagoRepository.save(tp);
                    return ResponseEntity.ok(tp);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (tipoPagoRepository.existsById(id)) {
            tipoPagoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
