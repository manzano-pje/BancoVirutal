package com.pjem.Banco.Service;

import com.pjem.Banco.DTO.ContaDTO;
import com.pjem.Banco.Repository.ClienteRepository;
import com.pjem.Banco.Repository.ContaRepository;
import com.pjem.Banco.entity.Cliente;
import com.pjem.Banco.entity.Conta;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class ContaService {

    private ContaRepository contaRepository;
    private ClienteRepository clienteRepository;

    public ContaDTO criaConta(ContaDTO contaDTO){
        Optional<Cliente> clienteOptional = clienteRepository.findById(contaDTO.getIdCliente());
        Conta conta = new Conta();
        BeanUtils.copyProperties(contaDTO, conta);
        conta.setCliente(clienteOptional.get());
        contaRepository.save(conta);
        return contaDTO;
    }

    public Optional<Conta> listaContas(Long id){
        Optional<Conta> contas = contaRepository.findById(id);

        return contas;
    }

    public void apagaConta(Long id){
        contaRepository.deleteById(id);
    }

}