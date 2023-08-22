package com.solutis.car.model.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Entity
@EqualsAndHashCode(callSuper=true)
public class Motorista extends Pessoa {
	
	@NotBlank(message = "O número da CNH é obrigatório")
	@Size(min = 11, max = 11, message = "O número da CNH deve ter 11 digitos")
	@Pattern(regexp = "\\d{11}", message = "Número da CNH inválido")
	@Column(nullable = false, unique = true)
	private String numeroCNH;

	@JsonIgnoreProperties("motorista")
	@OneToMany(mappedBy = "motorista", cascade = CascadeType.ALL)
	private List<Aluguel> alugueis;

}
