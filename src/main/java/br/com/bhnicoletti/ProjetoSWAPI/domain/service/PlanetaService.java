package br.com.bhnicoletti.ProjetoSWAPI.domain.service;

import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.ListaFilmeDTO;
import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.ListaPlanetaDTO;
import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.PlanetaDTO;
import br.com.bhnicoletti.ProjetoSWAPI.domain.model.ListFilm;
import br.com.bhnicoletti.ProjetoSWAPI.domain.model.ListPlanet;
import br.com.bhnicoletti.ProjetoSWAPI.domain.model.Planet;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class PlanetaService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RestTemplate restTemplate;

    public ListaPlanetaDTO listar(Integer pag){
        var url = "https://swapi.dev/api/planets/";
        if(pag != null){
            url += "?page="+pag;
        }

        try {
            ListPlanet planets = restTemplate.getForObject(url,ListPlanet.class);
            return planets.converter(modelMapper);
        } catch (HttpClientErrorException ex){
            return new ListaPlanetaDTO();
        }
    }

    public PlanetaDTO buscar(Integer id){
        String url = "https://swapi.dev/api/planets/" + id;
        Planet planet = restTemplate.getForObject(url,Planet.class);
        return modelMapper.map(planet, PlanetaDTO.class);
    }

}
