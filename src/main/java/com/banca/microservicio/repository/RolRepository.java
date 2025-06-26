package com.banca.microservicio.repository;

import com.banca.microservicio.model.Competencia;
import com.banca.microservicio.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
}
