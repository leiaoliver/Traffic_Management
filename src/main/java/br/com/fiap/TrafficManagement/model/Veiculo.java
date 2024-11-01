package br.com.fiap.TrafficManagement.model;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;

@Entity
@Table(name = "tbl_veiculos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    @Column(name = "placa", nullable = false)
    private String placa;

    @Column(name = "ano", nullable = false)
    private Integer ano;

    @Column(name = "cor")
    private String cor;

    @Column(name = "ultima_manutencao")
    private LocalDate ultimaManutencao;
}
