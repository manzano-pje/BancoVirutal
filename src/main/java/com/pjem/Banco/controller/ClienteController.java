package com.pjem.Banco.controller;

import com.pjem.Banco.dto.ClienteDTO;
import com.pjem.Banco.dto.ContaDTO;
import com.pjem.Banco.entity.Conta;
import com.pjem.Banco.exceptions.ExcessaoClienteInexistente;
import com.pjem.Banco.service.ClienteService;
import com.pjem.Banco.entity.Cliente;

import com.pjem.Banco.service.ContaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

import javax.validation.Valid;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("api/v01/cliente")
public class ClienteController {

    private final ClienteService clienteService;
    private final ContaService contaService;

    //cria cadastode cliente
    @PostMapping("/cria/")
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDTO grava(@RequestBody @Valid ClienteDTO clienteDTO){
        return  clienteService.grava(clienteDTO);
    }

    // consulta cadastro do cliente
    @GetMapping("/lista/{id}")
    public Optional<Cliente> listaCliente(@PathVariable Long id) throws ExcessaoClienteInexistente {

        return  clienteService.listaCliente(id);
    }

    


    // apaga cadasdtro do cliente
    @DeleteMapping("/apagar/{id}")
    public void apaga(@PathVariable Long id){
        clienteService.apaga(id);
    }

}

