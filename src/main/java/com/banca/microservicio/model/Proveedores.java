package com.banca.microservicio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "proveedores")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Proveedores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ruc", nullable = false)
    private String ruc;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "pais")
    private String pais;

    @Column(name = "correo")
    private String correo;

    @Column(name = "moneda")
    private String moneda;
}
