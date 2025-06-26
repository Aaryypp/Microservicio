package com.banca.microservicio.repository;

import com.banca.microservicio.model.Factura;
import com.banca.microservicio.model.ItemFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemFacturaRepository extends JpaRepository<ItemFactura, Long> {
}
