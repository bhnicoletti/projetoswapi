package br.com.bhnicoletti.ProjetoSWAPI.domain.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PlanetaDTO {
    private String nome;
    private String diametro;
    private String periodo_rotacao;
    private String periodo_orbita;
    private String gravidade;
    private String populacao;
    private String clima;
    private String terreno;
    private String superficie_agua;
    private List<String> residentes = new ArrayList<>();
    private List<String> filmes = new ArrayList<>();
    private String url;
    private String criado;
    private String editado;
}
