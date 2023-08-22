package com.solutis.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.solutis.car.mapper.ModeloCarroMapper;

import com.solutis.car.model.dto.ModeloCarroDTO;
import com.solutis.car.model.entity.ModeloCarro;
import com.solutis.car.repositories.ModeloCarroRepository;
import com.solutis.car.service.exception.NotFoundException;
import java.util.List;

import java.util.stream.Collectors;

@Service
public class ModeloCarroService implements CrudService<ModeloCarroDTO> {

    @Autowired
    private ModeloCarroRepository modeloCarroRepository;

    @Autowired
    private ModeloCarroMapper mapper;

    @Transactional(readOnly = true)
    public ModeloCarroDTO findById(Long id) {
        return this.mapper.toDto(this.modeloCarroRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ModeloCarro não encontrado")));
    }

    @Transactional(readOnly = true)
    public List<ModeloCarroDTO> findAll() {
        return this.modeloCarroRepository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public ModeloCarroDTO add(ModeloCarroDTO modeloCarroDTO) {
    ModeloCarro modeloCarro = this.mapper.toEntity(modeloCarroDTO);
    modeloCarro = modeloCarroRepository.save(modeloCarro);
    return this.mapper.toDto(modeloCarro);
    }

    @Transactional
    public ModeloCarroDTO update(Long id, ModeloCarroDTO modeloCarroDTO) {
        ModeloCarro existingModeloCarro = modeloCarroRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ModeloCarro não encontrado"));
        ModeloCarro modeloCarroUpdate = this.mapper.toEntity(modeloCarroDTO);
        modeloCarroUpdate.setId(existingModeloCarro.getId());
        modeloCarroUpdate = modeloCarroRepository.save(modeloCarroUpdate);
        return this.mapper.toDto(modeloCarroUpdate);
    }

    @Transactional
    public void deleteById(Long id) {
        ModeloCarro modeloCarro = modeloCarroRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ModeloCarro não encontrado"));
        modeloCarroRepository.delete(modeloCarro);
    }
}
