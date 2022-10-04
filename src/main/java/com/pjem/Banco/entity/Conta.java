package com.pjem.Banco.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor

public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contaId;
    private String tipo;
    private Long idCliente;


    @ManyToOne
    @JoinColumn(name="clienteId", nullable=false)
    private Cliente cliente;

    public Conta() {}

}


