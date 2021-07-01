package br.com.bhnicoletti.ProjetoSWAPI.domain.model;

import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.ListaPlanetaDTO;
import br.com.bhnicoletti.ProjetoSWAPI.domain.util.Convertible;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListPlanet implements Convertible<ListaPlanetaDTO> {
    private Integer count;
    private String next;
    private String previous;
    private List<Planet> results = new ArrayList<>();

    @Override
    public ListaPlanetaDTO converter(ModelMapper modelMapper) {
        return modelMapper.map(this, ListaPlanetaDTO.class);
    }
}
