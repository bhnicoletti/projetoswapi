package br.com.bhnicoletti.ProjetoSWAPI.domain.model;

import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.FilmeDTO;
import br.com.bhnicoletti.ProjetoSWAPI.domain.util.Convertible;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;

@Data
public class Film implements Convertible<FilmeDTO> {
    private String title;
    private Integer episode_id;
    private String opening_crawl;
    private String director;
    private String producer;
    private LocalDate release_date;
    private List<String> characters;
    private List<String> planets;
    private List<String> starships;
    private List<String> vehicles;
    private List<String> species;
    private String created;
    private String edited;
    private String url;

    @Override
    public FilmeDTO converter(ModelMapper modelMapper) {
        return modelMapper.map(this, FilmeDTO.class);
    }
}
