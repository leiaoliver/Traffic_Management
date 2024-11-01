package br.com.fiap.TrafficManagement.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_trafego")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Trafego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Outros campos da entidade
    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "localizacao", nullable = false)
    private String localizacao;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;
}
