package br.com.bhnicoletti.ProjetoSWAPI.domain.model;

import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.PlanetaDTO;
import br.com.bhnicoletti.ProjetoSWAPI.domain.util.Convertible;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.List;

@Data
public class Planet implements Convertible<PlanetaDTO> {
    private String name;
    private String diameter;
    private String rotation_period;
    private String orbital_period;
    private String gravity;
    private String population;
    private String climate;
    private String terrain;
    private String surface_water;
    private List<String> residents;
    private List<String> films;
    private String url;
    private String created;
    private String edited;


    @Override
    public PlanetaDTO converter(ModelMapper modelMapper) {
        return modelMapper.map(this, PlanetaDTO.class);
    }
}
