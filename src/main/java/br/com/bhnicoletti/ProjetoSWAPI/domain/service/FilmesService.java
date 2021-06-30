package br.com.bhnicoletti.ProjetoSWAPI.domain.service;

import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.FilmeDTO;
import br.com.bhnicoletti.ProjetoSWAPI.domain.model.Film;
import br.com.bhnicoletti.ProjetoSWAPI.domain.model.ListFilm;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class FilmesService {

    @Autowired
    private ModelMapper modelMapper;

    public List<Film> listar(){
        RestTemplate restTemplate = new RestTemplate();
        ListFilm response = restTemplate.getForObject("https://swapi.dev/api/films",ListFilm.class);
        List<Film> films = response.getResults();
        return films;
    }

    public FilmeDTO buscar(Integer id){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://swapi.dev/api/films/" + id;
        Film filme = restTemplate.getForObject(url,Film.class);
        FilmeDTO filmeDTO = modelMapper.map(filme, FilmeDTO.class);
        return filmeDTO;
    }
}
