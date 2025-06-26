package com.banca.microservicio.repository;

import com.banca.microservicio.model.Competencia;
import com.banca.microservicio.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenciaRepository extends JpaRepository<Competencia, Long> {
}
