package br.com.bhnicoletti.ProjetoSWAPI.domain.model;

import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.ListaFilmeDTO;
import br.com.bhnicoletti.ProjetoSWAPI.domain.util.Convertible;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListFilm implements Convertible<ListaFilmeDTO> {
    private Integer count;
    private String next;
    private String previous;
    private List<Film> results = new ArrayList<>();

    @Override
    public ListaFilmeDTO converter(ModelMapper modelMapper) {
       return modelMapper.map(this, ListaFilmeDTO.class);
    }
}
