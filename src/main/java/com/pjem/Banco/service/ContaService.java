package com.pjem.Banco.service;

import com.pjem.Banco.dto.ContaDTO;
import com.pjem.Banco.exceptions.ExcessaoClienteInexistente;
import com.pjem.Banco.repository.ClienteRepository;
import com.pjem.Banco.repository.ContaRepository;
import com.pjem.Banco.entity.Cliente;
import com.pjem.Banco.entity.Conta;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ContaService {

    private ContaRepository contaRepository;
    private ClienteRepository clienteRepository;

    public ContaDTO criaConta(ContaDTO contaDTO) throws ExcessaoClienteInexistente {
        Optional<Cliente> clienteOptional = clienteRepository.findById(contaDTO.getIdCliente());
        if (clienteOptional.isPresent()){
            System.out.println("\n\n" + clienteOptional.get().getNome() +"\n\n");
            Conta conta = new Conta();
            BeanUtils.copyProperties(contaDTO, conta);
            conta.setCliente(clienteOptional.get());
            contaRepository.save(conta);
        }
        else{
            System.out.println("\n\n cliente não existe \n\n");
        }

        return contaDTO;
    }

    public ContaDTO listaContas(Long id){
        Optional<Conta> contas = contaRepository.findById(id);
        Optional<Cliente> cliente = clienteRepository.findById(contas.get().getIdCliente());
        String nomeCliente = cliente.get().getNome();

        System.out.println("\n" + contas + "\n------------------\n\n");

        ContaDTO contaDTO = new ContaDTO();
        BeanUtils.copyProperties(contas, contaDTO);

        System.out.println(contaDTO + "\n" + nomeCliente + "\n------------------\n\n");
        contaDTO.setCliente(nomeCliente);
        
        if(contas.isEmpty()){
            System.out.println("Não há contas cadastradas parao cliente "+ contas.get().getCliente());
            return null;
        }

        return contaDTO;
    }


    public void apagaConta(Long id){
        contaRepository.deleteById(id);
    }

}
