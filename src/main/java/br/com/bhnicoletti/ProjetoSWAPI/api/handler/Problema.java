package br.com.bhnicoletti.ProjetoSWAPI.api.handler;

import lombok.Getter;

public class Problema {

    @Getter
    private String erro;

    public Problema(String msg){
        this.erro = msg;
    }
}

