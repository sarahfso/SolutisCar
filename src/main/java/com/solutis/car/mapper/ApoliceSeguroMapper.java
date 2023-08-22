package com.solutis.car.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.solutis.car.model.dto.ApoliceSeguroDTO;
import com.solutis.car.model.entity.ApoliceSeguro;

@Component
public class ApoliceSeguroMapper {

    private final ModelMapper modelMapper;

    public ApoliceSeguroMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ApoliceSeguroDTO toDto(ApoliceSeguro apolice) {
        return modelMapper.map(apolice, ApoliceSeguroDTO.class);
    }

    public ApoliceSeguro toEntity(ApoliceSeguroDTO apoliceDTO) {
        return modelMapper.map(apoliceDTO, ApoliceSeguro.class);
    }
}
