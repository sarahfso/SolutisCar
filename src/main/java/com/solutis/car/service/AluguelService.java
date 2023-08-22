package com.solutis.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.solutis.car.mapper.AluguelMapper;
import com.solutis.car.model.dto.AluguelDTO;
import com.solutis.car.model.entity.Aluguel;
import com.solutis.car.repositories.AluguelRepository;
import com.solutis.car.service.exception.NotFoundException;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class AluguelService implements CrudService<AluguelDTO> {

    @Autowired
    private AluguelRepository repository;

    @Autowired
    private AluguelMapper mapper;

    @Transactional(readOnly = true)
    public AluguelDTO findById(Long id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Acessório não encontrado")));
    }

    @Transactional(readOnly = true)
    public List<AluguelDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
    
    @Transactional
    public AluguelDTO add(AluguelDTO aluguelDTO) {
        Aluguel aluguel = mapper.toEntity(aluguelDTO);
        aluguel = repository.save(aluguel);
        return mapper.toDto(aluguel);
    }

    @Transactional
    public AluguelDTO update(Long id, AluguelDTO aluguelDTO) {
        Aluguel existingAluguel = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Acessório não encontrado"));
        Aluguel aluguelUpdate = mapper.toEntity(aluguelDTO);
        aluguelUpdate.setId(existingAluguel.getId());
        aluguelUpdate = repository.save(aluguelUpdate);
        return mapper.toDto(aluguelUpdate);
    }

    @Transactional
    public void deleteById(Long id) {
        Aluguel aluguel = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Acessório não encontrado"));
        repository.delete(aluguel);
    }
}
