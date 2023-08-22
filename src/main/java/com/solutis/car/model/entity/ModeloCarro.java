package com.solutis.car.model.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.solutis.car.model.entity.enums.Categoria;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ModeloCarro {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotBlank(message = "A descrição é obrigatória")
	@Size(min = 3, max = 200, message = "A descrição deve ter entre 3 e 200 caracteres")
	@Column(nullable = false)
	private String descricao;

	@JsonIgnoreProperties("modeloCarro")
	@OneToMany(mappedBy = "modeloCarro")
	private List<Carro> carros;

	@JsonIgnoreProperties("modeloCarro")
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "fabricante_id", nullable = false)
	private Fabricante fabricante;

	@NotNull(message = "A categoria é obrigatória")
	@Enumerated(EnumType.STRING)
	@Column(name= "categoria", nullable = false)
	private Categoria categoria;

}

