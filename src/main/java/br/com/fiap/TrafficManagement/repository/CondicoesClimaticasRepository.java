package br.com.fiap.TrafficManagement.repository;

import br.com.fiap.TrafficManagement.model.CondicoesClimaticas;
import br.com.fiap.TrafficManagement.model.CondicoesClimaticas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondicoesClimaticasRepository extends JpaRepository<CondicoesClimaticas, Long> {
}
