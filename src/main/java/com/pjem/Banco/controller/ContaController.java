package com.pjem.Banco.controller;

import com.pjem.Banco.DTO.ContaDTO;
import com.pjem.Banco.Service.ClienteService;
import com.pjem.Banco.Service.ContaService;
import com.pjem.Banco.entity.Conta;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/api/a01/conta")
public class ContaController {

    private ContaService contaService;
    private ClienteService clienteService;


    @PostMapping("/cria")
    public ContaDTO cria(@RequestBody @Valid ContaDTO contaDTO){
        return contaService.criaConta(contaDTO);
    }

    @GetMapping("/lista")
    public Optional<Conta> listaContas(@PathVariable Long conta){
        return contaService.listaContas(conta);
    }

}