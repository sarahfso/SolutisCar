package com.solutis.car.model.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MotoristaDTO extends PessoaDTO {

    @NotBlank(message = "O número da CNH é obrigatório")
    @Size(min = 11, max = 11, message = "O número da CNH deve ter 11 digitos")
    @Pattern(regexp = "\\d{11}", message = "Número da CNH inválido")
    private String numeroCNH;

    @JsonIgnoreProperties({"motorista"})
    @OneToMany(mappedBy = "motorista", cascade = CascadeType.ALL)
    private List<AluguelDTO> alugueis;

}
