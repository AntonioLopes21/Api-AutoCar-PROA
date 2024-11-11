package com.autocar.autocarbackend.models;


import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "tb_carro")
@AllArgsConstructor
@NoArgsConstructor
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String nome;
    private String modelo;
    private Double preco;

}
