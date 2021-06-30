package br.com.bhnicoletti.ProjetoSWAPI.api.handler;

import br.com.bhnicoletti.ProjetoSWAPI.domain.exception.EntidadeNaoEncontradaException;
import br.com.bhnicoletti.ProjetoSWAPI.domain.exception.SenhaInvalidaException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(SenhaInvalidaException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Problema handleSenhaInvalidaException(SenhaInvalidaException ex){
        return new Problema( ex.getMessage());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Problema handleUsernameNotFound(UsernameNotFoundException ex){
        return new Problema( ex.getMessage());
    }

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Problema handleEntidadeNaoEncontradaException(EntidadeNaoEncontradaException ex){
        return new Problema( ex.getMessage());
    }
}
