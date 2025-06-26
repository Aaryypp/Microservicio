package com.banca.microservicio.repository;

import com.banca.microservicio.model.Factura;
import com.banca.microservicio.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
