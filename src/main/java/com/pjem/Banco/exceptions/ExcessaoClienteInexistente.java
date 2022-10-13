package com.pjem.Banco.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class ExcessaoClienteInexistente extends Exception {
    public ExcessaoClienteInexistente(Long id) {
        super(String.format("Cliente ID não localizado", id));
    }
}
