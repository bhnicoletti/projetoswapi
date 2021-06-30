package br.com.bhnicoletti.ProjetoSWAPI.domain.exception;

public class SenhaInvalidaException extends RuntimeException{
    public SenhaInvalidaException() {
        super("Senha Inválida");
    }
}