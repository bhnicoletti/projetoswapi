package br.com.bhnicoletti.ProjetoSWAPI.domain.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListaFilmeDTO {
    private Integer contagem;
    private String proximo;
    private String anterior;
    private List<FilmeDTO> resultado = new ArrayList<>();
}
