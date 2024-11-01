package br.com.fiap.TrafficManagement.service;

import br.com.fiap.TrafficManagement.model.User;
import br.com.fiap.TrafficManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User gravar (User usuario){

        String senhaCripto = new BCryptPasswordEncoder().encode(usuario.getPassword());
        usuario.setSenha(senhaCripto);

        return userRepository.save(usuario);
    }

}
