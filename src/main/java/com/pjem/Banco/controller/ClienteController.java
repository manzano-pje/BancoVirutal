package com.pjem.Banco.controller;

import com.pjem.Banco.DTO.ClienteDTO;
import com.pjem.Banco.Repository.ClienteRepository;
import com.pjem.Banco.Service.ClienteService;
import com.pjem.Banco.entity.Cliente;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("api/v01/cliente/")
public class ClienteController {

    private final ClienteService clienteService;


    @GetMapping("lista/")
    public List<Cliente> lista(){
        return clienteService.lista();
    }

    @GetMapping("lista/um/{id}")
    public Optional<Cliente> listaIndividual(@PathVariable Long id){
        return  clienteService.listaIndividual(id);
    }

    @PostMapping("cadastro/")
    public ClienteDTO grava(@RequestBody @Valid ClienteDTO clienteDTO){

        return  clienteService.grava(clienteDTO);
    }

    @DeleteMapping("delete/{id}")
    public void apaga(@PathVariable Long id){
        clienteService.apaga(id);
    }

}

