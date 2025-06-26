package com.banca.microservicio.repository;

import com.banca.microservicio.model.Producto;
import com.banca.microservicio.model.Proveedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedores, Long> {
}
