package com.banca.microservicio.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "producto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;

    @Column(name = "stock", nullable = false)
    private int stock;

    @Column(name = "precio_unitario", nullable = false)
    private double precioUnitario;

    @Column(name = "unidad", nullable = false)
    private String unidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clasificacio_id", nullable = false)
    private Clasificacion clasificacion;

    @Column(name = "iva", nullable = false)
    private boolean iva;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proveedor_id", nullable = false)
    private Proveedores proveedor;
}
