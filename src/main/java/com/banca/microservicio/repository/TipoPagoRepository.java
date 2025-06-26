package com.banca.microservicio.repository;

import com.banca.microservicio.model.Rol;
import com.banca.microservicio.model.TipoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPagoRepository extends JpaRepository<TipoPago, Long> {
}
