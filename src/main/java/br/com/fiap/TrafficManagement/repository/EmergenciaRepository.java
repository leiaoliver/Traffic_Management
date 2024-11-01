package br.com.fiap.TrafficManagement.repository;

import br.com.fiap.TrafficManagement.model.Emergencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmergenciaRepository extends JpaRepository<Emergencia, Long> {
}
