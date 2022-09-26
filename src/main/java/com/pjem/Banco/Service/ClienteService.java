package com.pjem.Banco.Service;

import com.pjem.Banco.DTO.ClienteDTO;
import com.pjem.Banco.Repository.ClienteRepository;
import com.pjem.Banco.entity.Cliente;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public List<Cliente> lista(){
        return clienteRepository.findAll();
    }

    @GetMapping("lista/um/{id}")
    public Optional<Cliente> listaIndividual(Long id){
        return clienteRepository.findById(id);
    }

    @PostMapping("cadastro/")
    public ClienteDTO grava(ClienteDTO clienteDTO){
        LocalDate data = LocalDate.now();
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteDTO, cliente);
        cliente.setData_abertura(data);
        clienteRepository.save(cliente);
        return clienteDTO;
    }

    @DeleteMapping("delete/{id}")
    public void apaga(Long id){

        System.out.println(id);
        clienteRepository.deleteById(id);
    }

}
