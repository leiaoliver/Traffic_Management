package br.com.fiap.TrafficManagement.controller;

import br.com.fiap.TrafficManagement.model.Veiculo;
import br.com.fiap.TrafficManagement.repository.VeiculoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @GetMapping
    public List<Veiculo> getAllVeiculos() {
        return veiculoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Veiculo> createVeiculo(@RequestBody @Valid Veiculo veiculo) {
        Veiculo createdVeiculo = veiculoRepository.save(veiculo);
        return ResponseEntity.ok(createdVeiculo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> getVeiculoById(@PathVariable Long id) {
        Optional<Veiculo> veiculo = veiculoRepository.findById(id);
        return veiculo.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> updateVeiculo(@PathVariable Long id, @RequestBody @Valid Veiculo updatedVeiculo) {
        if (!veiculoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedVeiculo.setId(id);
        Veiculo savedVeiculo = veiculoRepository.save(updatedVeiculo);
        return ResponseEntity.ok(savedVeiculo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVeiculo(@PathVariable Long id) {
        if (!veiculoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        veiculoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
