package com.solutis.car.model.entity;

import java.math.BigDecimal;
import org.hibernate.validator.constraints.URL;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Carro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "A placa é obrigatória")
	@Size(min = 7, max = 7, message = "A placa deve ter 7 caracteres")
	@Column(nullable = false, unique = true)
	private String placa;

	@NotBlank(message = "O chassi é obrigatório")
	@Size(min = 17, max = 17, message = "O chassi deve ter 17 caracteres")
	@Column(nullable = false, unique = true)
	private String chassi;

	@NotBlank(message = "A cor é obrigatória")
	@Size(min = 3, max = 200, message = "A cor deve ter entre 3 e 200 caracteres")
	@Column(nullable = false)
	private String cor;

	@NotNull(message = "O valor da diária é obrigatório")
	@Column(nullable = false)
	private BigDecimal valorDiaria;

	@NotBlank(message = "A imagem é obrigatória")
	@Size(min = 3, max = 200, message = "A imagem deve ter entre 3 e 200 caracteres")
	@URL(message = "A imagem deve ser uma URL válida")
	@Column(nullable = false)
	private String imageUrl;

	@JsonIgnoreProperties("carro")
	@OneToMany(mappedBy = "carro", cascade = CascadeType.ALL)
	private List<Aluguel> alugueis;

	private boolean alugado = false;

	@JsonIgnoreProperties("carros")
	@ManyToMany
    @JoinTable(
        name = "carro_acessorio",
        joinColumns = @JoinColumn(name = "carro_id"),
        inverseJoinColumns = @JoinColumn(name = "acessorio_id")
    )
    private List<Acessorio> acessorios;

	@JsonIgnoreProperties("carros")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "modelo_carro_id", nullable = false)
	private ModeloCarro modeloCarro;
}