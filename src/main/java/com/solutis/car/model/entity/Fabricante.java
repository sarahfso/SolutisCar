package com.solutis.car.model.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Fabricante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 200, message = "O nome deve ter entre 3 e 200 caracteres")
    @Column(nullable = false)
    private String nome;

    @JsonIgnoreProperties("fabricante")
    @OneToMany(mappedBy = "fabricante", cascade = CascadeType.ALL)
    private List<ModeloCarro> modeloCarro;
}
