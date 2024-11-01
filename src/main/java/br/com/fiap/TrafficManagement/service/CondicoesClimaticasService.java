package br.com.fiap.TrafficManagement.service;

import br.com.fiap.TrafficManagement.exception.ResourceNotFoundException;
import br.com.fiap.TrafficManagement.model.CondicoesClimaticas;
import br.com.fiap.TrafficManagement.repository.CondicoesClimaticasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondicoesClimaticasService {

    @Autowired
    private CondicoesClimaticasRepository condicoesClimaticasRepository;

    public List<CondicoesClimaticas> getAllCondicoesClimaticas() {
        return condicoesClimaticasRepository.findAll();
    }

    public CondicoesClimaticas createCondicoesClimaticas(CondicoesClimaticas condicoesClimaticas) {
        return condicoesClimaticasRepository.save(condicoesClimaticas);
    }

    public CondicoesClimaticas getCondicoesClimaticasById(Long id) {
        return condicoesClimaticasRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Condições climáticas not found for this id :: " + id));
    }

    public void deleteCondicoesClimaticas(Long id) {
        CondicoesClimaticas condicoesClimaticas = condicoesClimaticasRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Condições climáticas not found for this id :: " + id));
        condicoesClimaticasRepository.delete(condicoesClimaticas);
    }
}
