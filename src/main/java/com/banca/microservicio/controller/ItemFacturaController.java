package com.banca.microservicio.controller;

import com.banca.microservicio.model.ItemFactura;
import com.banca.microservicio.repository.ItemFacturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items-factura")
@RequiredArgsConstructor
public class ItemFacturaController {

    private final ItemFacturaRepository itemFacturaRepository;

    @GetMapping
    public List<ItemFactura> listarTodos() {
        return itemFacturaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemFactura> obtenerPorId(@PathVariable Long id) {
        return itemFacturaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ItemFactura> crear(@RequestBody ItemFactura itemFactura) {
        ItemFactura nuevo = itemFacturaRepository.save(itemFactura);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (itemFacturaRepository.existsById(id)) {
            itemFacturaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
