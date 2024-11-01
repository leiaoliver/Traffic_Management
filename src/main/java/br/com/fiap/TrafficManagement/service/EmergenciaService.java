package br.com.fiap.TrafficManagement.service;

import br.com.fiap.TrafficManagement.exception.ResourceNotFoundException;
import br.com.fiap.TrafficManagement.model.Emergencia;
import br.com.fiap.TrafficManagement.repository.EmergenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmergenciaService {

    @Autowired
    private EmergenciaRepository emergenciaRepository;

    public List<Emergencia> getAllEmergencias() {
        return emergenciaRepository.findAll();
    }

    public Emergencia getEmergenciaById(Long id) {
        return emergenciaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Emergencia not found for this id :: " + id));
    }

    public Emergencia createEmergencia(Emergencia emergencia) {
        return emergenciaRepository.save(emergencia);
    }

    public Emergencia updateEmergencia(Long id, Emergencia emergenciaDetails) {
        Emergencia emergencia = emergenciaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Emergencia not found for this id :: " + id));

        // Update emergencia details here

        return emergenciaRepository.save(emergencia);
    }

    public void deleteEmergencia(Long id) {
        Emergencia emergencia = emergenciaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Emergencia not found for this id :: " + id));

        emergenciaRepository.delete(emergencia);
    }
}
