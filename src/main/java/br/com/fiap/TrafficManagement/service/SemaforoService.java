package br.com.fiap.TrafficManagement.service;

import br.com.fiap.TrafficManagement.exception.ResourceNotFoundException;
import br.com.fiap.TrafficManagement.model.Semaforo;
import br.com.fiap.TrafficManagement.repository.SemaforoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemaforoService {

    @Autowired
    private SemaforoRepository semaforoRepository;

    public List<Semaforo> getAllSemaforos() {
        return semaforoRepository.findAll();
    }

    public Semaforo getSemaforoById(Long id) {
        return semaforoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Semaforo not found for this id :: " + id));
    }

    public Semaforo createSemaforo(Semaforo semaforo) {
        return semaforoRepository.save(semaforo);
    }

    public Semaforo updateSemaforo(Long id, Semaforo semaforoDetails) {
        Semaforo semaforo = semaforoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Semaforo not found for this id :: " + id));

        // Update semaforo details here

        return semaforoRepository.save(semaforo);
    }

    public void deleteSemaforo(Long id) {
        Semaforo semaforo = semaforoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Semaforo not found for this id :: " + id));

        semaforoRepository.delete(semaforo);
    }
}
