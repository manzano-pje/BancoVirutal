package com.pjem.Banco.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Long id;

    @NotEmpty
    @CPF
    private String cpf;

    @NotEmpty
    @Size(min=3, max=150)
    private String nome;

    @NotEmpty
    @Size(min=3, max=150)
    private String endereco;

    @NotEmpty
    @Size(max=5)
    private short  numero;

    @Size(max=75)
    private String complemento;

    @NotEmpty
    @Size(min=8, max=8)
    private String cep;

    @NotEmpty
    @Size(min=3, max=100)
    private String cidade;

    @NotEmpty
    @Size(min=2, max=2)
    private String uf;

    @NotNull
    @Size(max=12)
    private String rg;

    @NotNull
    @Size(min=10, max=11)
    private String telefone;

    @NotEmpty
    @Size(min=3, max=150)
    @Email
    private String email;

    @NotNull
    private LocalDate aniversario;

    @NotEmpty
    private LocalDate data_abertura;

}
