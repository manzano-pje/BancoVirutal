package com.pjem.Banco.dto;

import com.pjem.Banco.entity.Conta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContaDTO {

    private Long id;
    private String tipo;
    private Long idCliente;
    private double saldo;
    private String cliente;

    public ContaDTO(Conta conta){
        this.id = conta.getContaId();
        this.tipo = conta.getTipo();
        this.idCliente = conta.getIdCliente();
        this.saldo = conta.getSaldo();
    }

}
