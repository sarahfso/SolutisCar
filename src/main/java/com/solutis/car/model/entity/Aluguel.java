package com.solutis.car.model.entity;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "A data do pedido é obrigatória")
    @Column(name = "data_pedido" ,nullable = false)
	private Calendar dataPedido;

    @NotNull(message = "A data de entrega é obrigatória")
    @Column(name = "data_entrega",nullable = false)
    private Date dataEntrega;

    @NotNull(message = "A data de devolução é obrigatória")
    @Column(name = "data_devolucao",nullable = false)
    private Date dataDevolucao;

    @NotNull(message = "O valor total é obrigatório")
    @Column(name = "valor_total",nullable = false)
    private BigDecimal valorTotal;

    @JsonIgnoreProperties("alugueis")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carro_id", nullable = false)
    private Carro carro;

    @JsonIgnoreProperties("alugueis")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "motorista_id", nullable = false)
    private Motorista motorista;

    @JsonIgnore
    @OneToOne(mappedBy = "aluguel", cascade = CascadeType.ALL)
    @JoinColumn(name = "apolice_seguro_id", nullable = false)
    private ApoliceSeguro apoliceSeguro;

}
