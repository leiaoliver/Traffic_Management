package br.com.fiap.TrafficManagement.controller;

import br.com.fiap.TrafficManagement.model.Trafego;
import br.com.fiap.TrafficManagement.repository.TrafegoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/trafegos")
@Tag(name = "Trafego", description = "API para gerenciamento de tráfego")
public class TrafegoController {

    @Autowired
    private TrafegoRepository trafegoRepository;

    @Operation(summary = "Listar todos os tráfegos")
    @GetMapping
    public List<Trafego> getAllTrafegos() {
        return trafegoRepository.findAll();
    }

    @Operation(summary = "Criar um novo tráfego")
    @PostMapping
    public ResponseEntity<Trafego> createTrafego(@RequestBody @Valid Trafego trafego) {
        Trafego createdTrafego = trafegoRepository.save(trafego);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTrafego);
    }

    @Operation(summary = "Buscar tráfego por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Trafego> getTrafegoById(@PathVariable Long id) {
        Optional<Trafego> trafego = trafegoRepository.findById(id);
        return trafego.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Atualizar tráfego existente")
    @PutMapping("/{id}")
    public ResponseEntity<Trafego> updateTrafego(
            @PathVariable Long id,
            @RequestBody @Valid Trafego updatedTrafego) {
        if (!trafegoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedTrafego.setId(id);
        Trafego savedTrafego = trafegoRepository.save(updatedTrafego);
        return ResponseEntity.ok(savedTrafego);
    }

    @Operation(summary = "Deletar tráfego por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrafego(@PathVariable Long id) {
        if (!trafegoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        trafegoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
