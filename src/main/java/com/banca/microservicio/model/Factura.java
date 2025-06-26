package com.banca.microservicio.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruc;

    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "tipo_pago_id", nullable = false)
    private TipoPago tipoPago;

    private Double descuento;
    private Double total;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ItemFactura> items;
}
