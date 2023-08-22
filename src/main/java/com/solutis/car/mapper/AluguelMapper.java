package com.solutis.car.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.solutis.car.model.dto.AluguelDTO;
import com.solutis.car.model.entity.Aluguel;

@Component
public class AluguelMapper {

    private final ModelMapper modelMapper;

    public AluguelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public AluguelDTO toDto(Aluguel aluguel) {
        return modelMapper.map(aluguel, AluguelDTO.class);
    }

    public Aluguel toEntity(AluguelDTO aluguelDTO) {
        return modelMapper.map(aluguelDTO, Aluguel.class);
    }
}
