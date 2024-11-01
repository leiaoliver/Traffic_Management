package br.com.fiap.TrafficManagement.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_condicoes_climaticas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CondicoesClimaticas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "temperatura", nullable = false)
    private BigDecimal temperatura;

    @Column(name = "umidade", nullable = false)
    private BigDecimal umidade;

    @Column(name = "vento_km_h", nullable = false)
    private BigDecimal ventoKmH;

    @Column(name = "precipitacao")
    private String precipitacao;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;
}
