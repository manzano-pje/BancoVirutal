package com.pjem.Banco.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;

    private String cpf;
    private String nome;
    private String endereco;
    private short  numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String uf;
    private String rg;
    private String telefone;
    private String email;
    private LocalDate aniversario;
    private LocalDate data_abertura;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER, cascade = {CascadeType.DETACH})
    @JsonManagedReference
    private List<Conta> contas = new ArrayList<>();

}

