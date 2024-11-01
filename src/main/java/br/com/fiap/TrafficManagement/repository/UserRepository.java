package br.com.fiap.TrafficManagement.repository;

import br.com.fiap.TrafficManagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByEmail (String email);
}
