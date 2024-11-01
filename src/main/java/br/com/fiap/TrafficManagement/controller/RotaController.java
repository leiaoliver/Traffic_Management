package br.com.fiap.TrafficManagement.controller;

import br.com.fiap.TrafficManagement.model.Rota;
import br.com.fiap.TrafficManagement.repository.RotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid; // Atualizado para usar jakarta.validation
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rotas")
public class RotaController {

    @Autowired
    private RotaRepository rotaRepository;

    @GetMapping
    public List<Rota> getAllRotas() {
        return rotaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Rota> createRota(@RequestBody @Valid Rota rota) {
        Rota createdRota = rotaRepository.save(rota);
        // Alteração: retorna 201 Created com o recurso criado no corpo da resposta
        return ResponseEntity.status(201).body(createdRota);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rota> getRotaById(@PathVariable Long id) {
        Optional<Rota> rota = rotaRepository.findById(id);
        return rota.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rota> updateRota(@PathVariable Long id, @RequestBody @Valid Rota updatedRota) {
        if (!rotaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedRota.setId(id);
        Rota savedRota = rotaRepository.save(updatedRota);
        return ResponseEntity.ok(savedRota);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRota(@PathVariable Long id) {
        if (!rotaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        rotaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
