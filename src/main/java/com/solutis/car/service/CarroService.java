package com.solutis.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.solutis.car.mapper.CarroMapper;
import com.solutis.car.model.dto.CarroDTO;
import com.solutis.car.model.entity.Carro;
import com.solutis.car.repositories.CarroRepository;
import com.solutis.car.service.exception.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarroService implements CrudService<CarroDTO> {

    @Autowired
    private CarroRepository repository;

    @Autowired
    private CarroMapper mapper;

    @Transactional(readOnly = true)
    public CarroDTO findById(Long id) {
        return this.mapper.toDto(this.repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Carro não encontrado")));
    }

    @Transactional(readOnly = true)
    public List<CarroDTO> findAll() {
        return this.repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CarroDTO add(CarroDTO payload) {
        Carro carro = this.mapper.toEntity(payload);
        carro = this.repository.save(carro);
        return this.mapper.toDto(carro);
    }

    @Transactional
    public CarroDTO update(Long id, CarroDTO carroDTO) {
        Carro existingCarro = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Carro não encontrado"));
        Carro carroUpdate = this.mapper.toEntity(carroDTO);
        carroUpdate.setId(existingCarro.getId());
        carroUpdate = repository.save(carroUpdate);
        return this.mapper.toDto(carroUpdate);
    }

    @Transactional
    public void deleteById(Long id) {
        Carro carro = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Carro não encontrado"));
        repository.delete(carro);
    }

    @Transactional(readOnly = true)
    public List<CarroDTO> findVeiculosDisponiveis(String categoria, List<String> acessorios) {
        List<Carro> veiculosDisponiveis = repository.findVeiculosDisponiveis(categoria, acessorios);
        return veiculosDisponiveis.stream().map(mapper::toDto).collect(Collectors.toList());
    }

}
