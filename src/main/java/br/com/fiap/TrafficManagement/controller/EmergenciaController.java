package br.com.fiap.TrafficManagement.controller;

import br.com.fiap.TrafficManagement.model.Emergencia;
import br.com.fiap.TrafficManagement.repository.EmergenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid; // Atualizado para usar jakarta.validation
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/emergencias")
public class EmergenciaController {

    @Autowired
    private EmergenciaRepository emergenciaRepository;

    @GetMapping
    public List<Emergencia> getAllEmergencias() {
        return emergenciaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Emergencia> createEmergencia(@RequestBody @Valid Emergencia emergencia) {
        Emergencia createdEmergencia = emergenciaRepository.save(emergencia);
        return ResponseEntity.ok(createdEmergencia);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emergencia> getEmergenciaById(@PathVariable Long id) {
        Optional<Emergencia> emergencia = emergenciaRepository.findById(id);
        return emergencia.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Emergencia> updateEmergencia(@PathVariable Long id, @RequestBody @Valid Emergencia updatedEmergencia) {
        if (!emergenciaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedEmergencia.setId(id);
        Emergencia savedEmergencia = emergenciaRepository.save(updatedEmergencia);
        return ResponseEntity.ok(savedEmergencia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmergencia(@PathVariable Long id) {
        if (!emergenciaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        emergenciaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
