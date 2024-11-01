package br.com.fiap.TrafficManagement.model;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_emergencias")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Emergencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "localizacao", nullable = false)
    private String localizacao;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;
}
