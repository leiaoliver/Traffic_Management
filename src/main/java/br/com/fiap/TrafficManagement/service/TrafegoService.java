package br.com.fiap.TrafficManagement.service;

import br.com.fiap.TrafficManagement.exception.ResourceNotFoundException;
import br.com.fiap.TrafficManagement.model.Trafego;
import br.com.fiap.TrafficManagement.repository.TrafegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrafegoService {

    @Autowired
    private TrafegoRepository trafegoRepository;

    public List<Trafego> getAllTrafego() {
        return trafegoRepository.findAll();
    }

    public Trafego createTrafego(Trafego trafego) {
        return trafegoRepository.save(trafego);
    }

    public Trafego getTrafegoById(Long id) {
        return trafegoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tráfego not found for this id :: " + id));
    }

    public void deleteTrafego(Long id) {
        Trafego trafego = trafegoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tráfego not found for this id :: " + id));
        trafegoRepository.delete(trafego);
    }
}
