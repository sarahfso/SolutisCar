package com.solutis.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.solutis.car.mapper.ApoliceSeguroMapper;
import com.solutis.car.model.dto.ApoliceSeguroDTO;
import com.solutis.car.model.entity.ApoliceSeguro;
import com.solutis.car.repositories.ApoliceSeguroRepository;
import com.solutis.car.service.exception.NotFoundException;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApoliceSeguroService implements CrudService<ApoliceSeguroDTO> {

    @Autowired
    private ApoliceSeguroRepository repository;

    @Autowired
    private ApoliceSeguroMapper mapper;

    @Transactional(readOnly = true)
    public ApoliceSeguroDTO findById(Long id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Apolice não encontrado")));
    }

    @Transactional(readOnly = true)
    public List<ApoliceSeguroDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
    
    @Transactional
    public ApoliceSeguroDTO add(ApoliceSeguroDTO apoliceDTO) {
        ApoliceSeguro apolice = mapper.toEntity(apoliceDTO);
        apolice = repository.save(apolice);
        return mapper.toDto(apolice);
    }

    @Transactional
    public ApoliceSeguroDTO update(Long id, ApoliceSeguroDTO apoliceDTO) {
        ApoliceSeguro existingApolice = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Apolice não encontrado"));
        ApoliceSeguro apoliceUpdate = mapper.toEntity(apoliceDTO);
        apoliceUpdate.setId(existingApolice.getId());
        apoliceUpdate = repository.save(apoliceUpdate);
        return mapper.toDto(apoliceUpdate);
    }

    @Transactional
    public void deleteById(Long id) {
        ApoliceSeguro apolice = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Apolice não encontrado"));
        repository.delete(apolice);
    }
}
