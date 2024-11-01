package br.com.fiap.TrafficManagement.service;

import br.com.fiap.TrafficManagement.exception.ResourceNotFoundException;
import br.com.fiap.TrafficManagement.model.Veiculo;
import br.com.fiap.TrafficManagement.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> getAllVeiculos() {
        return veiculoRepository.findAll();
    }

    public Veiculo getVeiculoById(Long id) {
        return veiculoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Veiculo not found for this id :: " + id));
    }

    public Veiculo createVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public Veiculo updateVeiculo(Long id, Veiculo veiculoDetails) {
        Veiculo veiculo = veiculoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Veiculo not found for this id :: " + id));

        // Update veiculo details here

        return veiculoRepository.save(veiculo);
    }

    public void deleteVeiculo(Long id) {
        Veiculo veiculo = veiculoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Veiculo not found for this id :: " + id));

        veiculoRepository.delete(veiculo);
    }
}
