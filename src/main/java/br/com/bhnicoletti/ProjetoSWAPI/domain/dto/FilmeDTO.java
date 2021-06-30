package br.com.bhnicoletti.ProjetoSWAPI.domain.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class FilmeDTO {
    private String titulo;
    private Integer episodio_id;
    private String sequencia_abertura;
    private String diretor;
    private String produtor;
    private LocalDate data_lancamento;
    private List<String> personagens;
    private List<String> planetas;
    private List<String> naves;
    private List<String> veiculos;
    private List<String> especies;
    private String criado;
    private String editado;
    private String url;

}
