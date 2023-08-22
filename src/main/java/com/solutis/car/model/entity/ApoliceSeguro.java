package com.solutis.car.model.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ApoliceSeguro {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotNull(message = "O valor da franquia é obrigatório")
	@Column(nullable = false)
	private BigDecimal valorFranquia;
	
	private boolean protecaoTerceiro = false;

	private boolean protecaoCausasNaturais = false;

	private boolean protecaoRoubo = false;

	@JsonIgnoreProperties("apoliceSeguro")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "aluguel_id")
	private Aluguel aluguel;

}
