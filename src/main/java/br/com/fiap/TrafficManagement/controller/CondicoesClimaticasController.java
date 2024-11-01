package br.com.fiap.TrafficManagement.controller;

import br.com.fiap.TrafficManagement.model.CondicoesClimaticas;
import br.com.fiap.TrafficManagement.repository.CondicoesClimaticasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/condicoes-climaticas")
public class CondicoesClimaticasController {

    @Autowired
    private CondicoesClimaticasRepository condicoesClimaticasRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CondicoesClimaticas> getAllCondicoesClimaticas() {
        return condicoesClimaticasRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CondicoesClimaticas> createCondicoesClimaticas(@RequestBody @Valid CondicoesClimaticas condicoesClimaticas) {
        CondicoesClimaticas createdCondicoesClimaticas = condicoesClimaticasRepository.save(condicoesClimaticas);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCondicoesClimaticas);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CondicoesClimaticas> getCondicoesClimaticasById(@PathVariable Long id) {
        Optional<CondicoesClimaticas> condicoesClimaticas = condicoesClimaticasRepository.findById(id);
        return condicoesClimaticas.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CondicoesClimaticas> updateCondicoesClimaticas(@PathVariable Long id, @RequestBody @Valid CondicoesClimaticas updatedCondicoesClimaticas) {
        if (!condicoesClimaticasRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedCondicoesClimaticas.setId(id);
        CondicoesClimaticas savedCondicoesClimaticas = condicoesClimaticasRepository.save(updatedCondicoesClimaticas);
        return ResponseEntity.ok(savedCondicoesClimaticas);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteCondicoesClimaticas(@PathVariable Long id) {
        if (!condicoesClimaticasRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        condicoesClimaticasRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
