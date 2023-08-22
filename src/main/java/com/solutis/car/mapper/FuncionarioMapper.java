package com.solutis.car.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.solutis.car.model.dto.FuncionarioDTO;
import com.solutis.car.model.entity.Funcionario;

@Component
public class FuncionarioMapper {

    private final ModelMapper modelMapper;

    public FuncionarioMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public FuncionarioDTO toDto(Funcionario funcionario) {
        return modelMapper.map(funcionario, FuncionarioDTO.class);
    }

    public Funcionario toEntity(FuncionarioDTO funcionarioDTO) {
        return modelMapper.map(funcionarioDTO, Funcionario.class);
    }
}
