package br.com.fiap.TrafficManagement.repository;

import br.com.fiap.TrafficManagement.model.Rota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RotaRepository extends JpaRepository<Rota, Long> {
}
