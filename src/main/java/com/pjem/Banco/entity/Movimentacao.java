package com.pjem.Banco.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@Getter
@Setter

public class Movimentacao {

    @Id
    private Long idConta;

    private LocalDate data;
    private String descricao;
    private Long movimentacao;

    @ManyToOne
    @JoinColumn(name="contaId", nullable=false)
    @JsonBackReference
    private Conta conta;

    public Movimentacao(){};
}
