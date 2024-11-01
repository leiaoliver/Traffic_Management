package br.com.fiap.TrafficManagement.model;

import jakarta.persistence.*;
import lombok.*;


import java.math.BigDecimal;

@Entity
@Table(name = "tbl_rotas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Rota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "origem", nullable = false)
    private String origem;

    @Column(name = "destino", nullable = false)
    private String destino;

    @Column(name = "distancia_km", nullable = false)
    private BigDecimal distanciaKm;

    @Column(name = "duracao_minutos", nullable = false)
    private Integer duracaoMinutos;
}
