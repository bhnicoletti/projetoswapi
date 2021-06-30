package br.com.bhnicoletti.ProjetoSWAPI.domain.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListaPlanetaDTO {
    private Integer contagem;
    private Integer proximo;
    private Integer anterior;
    private List<PlanetaDTO> resultado = new ArrayList<>();
}
