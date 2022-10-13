package com.pjem.Banco.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString

public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contaId;
    private String tipo;
    private Long idCliente;
    private double saldo;

    @ManyToOne
    @JoinColumn(name="clienteId", nullable=false)
    @JsonBackReference
    private Cliente cliente;

    @OneToMany(mappedBy = "conta", fetch=FetchType.EAGER)
    @JsonManagedReference
    private List<Movimentacao> movimentacao = new ArrayList<>();

    public Conta() {}


}


