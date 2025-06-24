package com.banca.microservicio.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tipo_pago")
@Data // Incluye @Getter, @Setter, @ToString, @EqualsAndHashCode y @RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Tipo_Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "descrip")
    private String descrip;
}
