package com.banca.microservicio.repository;

import com.banca.microservicio.model.Clasificacion;
import com.banca.microservicio.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasificacionRepository extends JpaRepository<Clasificacion, Long> {
}
