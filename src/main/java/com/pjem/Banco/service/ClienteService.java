package com.pjem.Banco.service;

import com.pjem.Banco.dto.ClienteDTO;
import com.pjem.Banco.exceptions.ExcessaoClienteInexistente;
import com.pjem.Banco.repository.ClienteRepository;
import com.pjem.Banco.entity.Cliente;

import lombok.AllArgsConstructor;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public List<Cliente> lista(){
        return clienteRepository.findAll();
    }


    public Optional<Cliente> listaCliente(Long id)throws ExcessaoClienteInexistente {
        return clienteRepository.findById(id);
    }


    public ClienteDTO grava(ClienteDTO clienteDTO){
        LocalDate data = LocalDate.now();
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteDTO, cliente);
        cliente.setData_abertura(data);
        clienteRepository.save(cliente);
        return clienteDTO;
    }


    public void apaga(Long id){

        System.out.println(id);
        clienteRepository.deleteById(id);
    }

}
