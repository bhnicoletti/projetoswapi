package br.com.bhnicoletti.ProjetoSWAPI.domain.service;

import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.FilmeDTO;
import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.ListaFilmeDTO;
import br.com.bhnicoletti.ProjetoSWAPI.domain.model.Film;
import br.com.bhnicoletti.ProjetoSWAPI.domain.model.ListFilm;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


@Service
public class FilmesService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RestTemplate restTemplate;

    public ListaFilmeDTO listar(Integer pag){
        var url = "https://swapi.dev/api/films/";
        if(pag != null){
            url += "?page="+pag;
        }

        try {
            ListFilm films = restTemplate.getForObject(url, ListFilm.class);
            return films.converter(modelMapper);
        } catch (HttpClientErrorException ex){
            return new ListaFilmeDTO();
        }
    }

    public FilmeDTO buscar(Integer id){
        String url = "https://swapi.dev/api/films/" + id;
        Film filme = restTemplate.getForObject(url,Film.class);
        return filme.converter(modelMapper);
    }


}
