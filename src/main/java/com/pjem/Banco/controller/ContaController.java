package com.pjem.Banco.controller;

import com.pjem.Banco.dto.ContaDTO;
import com.pjem.Banco.exceptions.ExcessaoClienteInexistente;
import com.pjem.Banco.service.ClienteService;
import com.pjem.Banco.service.ContaService;
import com.pjem.Banco.entity.Conta;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import javax.validation.Valid;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/a01/conta")
public class ContaController {

    private ContaService contaService;
    private ClienteService clienteService;


    @PostMapping("/cria")
    @ResponseStatus(HttpStatus.CREATED)
    public ContaDTO cria(@RequestBody @Valid ContaDTO contaDTO) throws ExcessaoClienteInexistente {
        return contaService.criaConta(contaDTO);
    }

    @GetMapping("/lista")
    public ContaDTO listaContas(@PathVariable Long conta){

        return contaService.listaContas(conta);
    }


}
