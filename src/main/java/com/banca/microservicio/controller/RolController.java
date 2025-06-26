package com.banca.microservicio.controller;

import com.banca.microservicio.model.Rol;
import com.banca.microservicio.repository.RolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolRepository rolRepository;

    // Listar todos los roles
    @GetMapping
    public List<Rol> listarRoles() {
        return rolRepository.findAll();
    }

    // Obtener rol por id
    @GetMapping("/{id}")
    public ResponseEntity<Rol> obtenerRol(@PathVariable Long id) {
        Optional<Rol> rolOpt = rolRepository.findById(id);
        if (rolOpt.isPresent()) {
            return ResponseEntity.ok(rolOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear nuevo rol
    @PostMapping
    public Rol crearRol(@RequestBody Rol rol) {
        return rolRepository.save(rol);
    }

    // Actualizar rol
    @PutMapping("/{id}")
    public ResponseEntity<Rol> actualizarRol(@PathVariable Long id, @RequestBody Rol rolDetalles) {
        Optional<Rol> rolOpt = rolRepository.findById(id);
        if (!rolOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Rol rol = rolOpt.get();
        rol.setRol(rolDetalles.getRol());
        rol.setEstado(rolDetalles.getEstado());
        rol.setCompetencia(rolDetalles.getCompetencia());

        Rol rolActualizado = rolRepository.save(rol);
        return ResponseEntity.ok(rolActualizado);
    }

    // Eliminar rol
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRol(@PathVariable Long id) {
        if (!rolRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        rolRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

