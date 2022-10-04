package com.pjem.Banco.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContaDTO {

    private Long id;

    @NotNull
    private String tipo;

    @NotEmpty
    private Long idCliente;
}
