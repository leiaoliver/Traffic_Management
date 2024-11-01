package br.com.fiap.TrafficManagement.service;

import br.com.fiap.TrafficManagement.exception.ResourceNotFoundException;
import br.com.fiap.TrafficManagement.model.Rota;
import br.com.fiap.TrafficManagement.repository.RotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RotaService {

    @Autowired
    private RotaRepository rotaRepository;

    public List<Rota> getAllRotas() {
        return rotaRepository.findAll();
    }

    public Rota getRotaById(Long id) {
        return rotaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rota not found for this id :: " + id));
    }

    public Rota createRota(Rota rota) {
        return rotaRepository.save(rota);
    }

    public Rota updateRota(Long id, Rota rotaDetails) {
        Rota rota = rotaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rota not found for this id :: " + id));

        // Update rota details here

        return rotaRepository.save(rota);
    }

    public void deleteRota(Long id) {
        Rota rota = rotaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rota not found for this id :: " + id));

        rotaRepository.delete(rota);
    }
}
