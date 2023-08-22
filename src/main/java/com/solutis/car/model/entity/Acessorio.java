package com.solutis.car.model.entity;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Acessorio {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A descrição é obrigatória")
    @Size(min = 3, max = 200, message = "A descrição deve ter entre 3 e 200 caracteres")
    @Column(nullable = false)
    private String descricao;

    @ManyToMany(mappedBy = "acessorios")
    private List<Carro> carros;
}
