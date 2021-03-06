package br.com.bhnicoletti.ProjetoSWAPI.domain.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListaPessoaDTO {
    private Integer contagem;
    private String proximo;
    private String anterior;
    private List<PessoaDTO> resultado = new ArrayList<>();
}
