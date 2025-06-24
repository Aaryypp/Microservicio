package com.banca.microservicio.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clasificacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clasificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "grupo", nullable = false)
    private String grupo;
}
