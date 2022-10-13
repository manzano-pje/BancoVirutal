package com.pjem.Banco.dto;

import com.pjem.Banco.entity.Movimentacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovimentacaoDTO {

    private Long idConta;
    private LocalDate data;
    private String descricao;
    private Long movimentacao;

    public MovimentacaoDTO(Movimentacao movimentacao){
        this.idConta = movimentacao.getIdConta();
        this.data = movimentacao.getData();
        this.movimentacao = movimentacao.getMovimentacao();
        this.descricao = movimentacao.getDescricao();
    }
}
