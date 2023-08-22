package com.solutis.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.solutis.car.mapper.FuncionarioMapper;
import com.solutis.car.model.dto.FuncionarioDTO;
import com.solutis.car.model.entity.Funcionario;
import com.solutis.car.repositories.FuncionarioRepository;
import com.solutis.car.service.exception.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioService implements CrudService<FuncionarioDTO> {

    @Autowired
    private FuncionarioRepository repository;

    @Autowired
    private FuncionarioMapper mapper;

    @Transactional(readOnly = true)
    public FuncionarioDTO findById(Long id) {
        return this.mapper.toDto(this.repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Funcionário não encontrado")));
    }

    @Transactional(readOnly = true)
    public List<FuncionarioDTO> findAll() {
        return this.repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public FuncionarioDTO add(FuncionarioDTO payload) {
        Funcionario funcionario = this.mapper.toEntity(payload);
        funcionario = this.repository.save(funcionario);
        return this.mapper.toDto(funcionario);
    }
    
    @Transactional
    public FuncionarioDTO update(Long id, FuncionarioDTO funcionarioDTO) {
        Funcionario existingFuncionario = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Funcionário não encontrado"));
        Funcionario funcionarioUpdate = this.mapper.toEntity(funcionarioDTO);
        funcionarioUpdate.setId(existingFuncionario.getId());
        funcionarioUpdate = repository.save(funcionarioUpdate);
        return this.mapper.toDto(funcionarioUpdate);
    }

    @Transactional
    public void deleteById(Long id) {
        Funcionario funcionario = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Funcionário não encontrado"));
        repository.delete(funcionario);
    }
    
}

