package br.com.fiap.TrafficManagement.controller;

import br.com.fiap.TrafficManagement.model.Semaforo;
import br.com.fiap.TrafficManagement.repository.SemaforoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid; // Atualizado para usar jakarta.validation
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/semaforos")
public class SemaforoController {

    @Autowired
    private SemaforoRepository semaforoRepository;

    @GetMapping
    public List<Semaforo> getAllSemaforos() {
        return semaforoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Semaforo> createSemaforo(@RequestBody @Valid Semaforo semaforo) {
        Semaforo createdSemaforo = semaforoRepository.save(semaforo);
        return ResponseEntity.ok(createdSemaforo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Semaforo> getSemaforoById(@PathVariable Long id) {
        Optional<Semaforo> semaforo = semaforoRepository.findById(id);
        return semaforo.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Semaforo> updateSemaforo(@PathVariable Long id, @RequestBody @Valid Semaforo updatedSemaforo) {
        if (!semaforoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedSemaforo.setId(id);
        Semaforo savedSemaforo = semaforoRepository.save(updatedSemaforo);
        return ResponseEntity.ok(savedSemaforo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSemaforo(@PathVariable Long id) {
        if (!semaforoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        semaforoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
