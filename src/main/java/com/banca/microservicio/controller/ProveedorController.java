package com.banca.microservicio.controller;

import com.banca.microservicio.model.Producto;
import com.banca.microservicio.model.Proveedores;
import com.banca.microservicio.repository.ProductoRepository;
import com.banca.microservicio.repository.ProveedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
@RequiredArgsConstructor
public class ProveedorController {

    private final ProveedorRepository proveedorRepository;

    @GetMapping
    public List<Proveedores> listarTodos() {
        return proveedorRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedores> obtenerPorId(@PathVariable Long id) {
        return proveedorRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Proveedores> crear(@RequestBody Proveedores proveedor) {
        Proveedores nuevo = proveedorRepository.save(proveedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (proveedorRepository.existsById(id)) {
            proveedorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
