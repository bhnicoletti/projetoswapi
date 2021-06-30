package br.com.bhnicoletti.ProjetoSWAPI.domain.service;

import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.ListaPessoaDTO;
import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.ListaPlanetaDTO;
import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.PessoaDTO;
import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.PlanetaDTO;
import br.com.bhnicoletti.ProjetoSWAPI.domain.model.ListPeople;
import br.com.bhnicoletti.ProjetoSWAPI.domain.model.ListPlanet;
import br.com.bhnicoletti.ProjetoSWAPI.domain.model.People;
import br.com.bhnicoletti.ProjetoSWAPI.domain.model.Planet;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PlanetaService {
    @Autowired
    private ModelMapper modelMapper;

    public ListaPlanetaDTO listar(){
        RestTemplate restTemplate = new RestTemplate();
        ListPlanet response = restTemplate.getForObject("https://swapi.dev/api/planet",ListPlanet.class);
        ListaPlanetaDTO planetas = modelMapper.map(response, ListaPlanetaDTO.class);
        return planetas;
    }

    public PlanetaDTO buscar(Integer id){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://swapi.dev/api/planet/" + id;
        Planet planet = restTemplate.getForObject(url,Planet.class);
        return modelMapper.map(planet, PlanetaDTO.class);
    }
}
