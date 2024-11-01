package br.com.fiap.TrafficManagement.repository;

import br.com.fiap.TrafficManagement.model.Trafego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrafegoRepository extends JpaRepository<Trafego, Long> {
}
