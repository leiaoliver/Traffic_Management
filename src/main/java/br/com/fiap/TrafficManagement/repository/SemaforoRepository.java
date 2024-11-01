package br.com.fiap.TrafficManagement.repository;

import br.com.fiap.TrafficManagement.model.Semaforo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemaforoRepository extends JpaRepository<Semaforo, Long> {
}
