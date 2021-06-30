package br.com.bhnicoletti.ProjetoSWAPI.domain.service;

import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.FilmeDTO;
import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.ListaFilmeDTO;
import br.com.bhnicoletti.ProjetoSWAPI.domain.model.Film;
import br.com.bhnicoletti.ProjetoSWAPI.domain.model.ListFilm;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FilmesService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RestTemplate restTemplate;

    public ListaFilmeDTO listar(){
        ListFilm response = restTemplate.getForObject("https://swapi.dev/api/films",ListFilm.class);
        ListaFilmeDTO filmes = modelMapper.map(response, ListaFilmeDTO.class);
        return filmes;
    }

    public FilmeDTO buscar(Integer id){
        String url = "https://swapi.dev/api/films/" + id;
        Film filme = restTemplate.getForObject(url,Film.class);
        return modelMapper.map(filme, FilmeDTO.class);
    }
}
