package br.com.bhnicoletti.ProjetoSWAPI.api.controller;

import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.FilmeDTO;
import br.com.bhnicoletti.ProjetoSWAPI.domain.model.Film;
import br.com.bhnicoletti.ProjetoSWAPI.domain.model.ListFilm;
import br.com.bhnicoletti.ProjetoSWAPI.domain.service.FilmesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmesController {

    @Autowired
    private FilmesService filmesService;

    @GetMapping
    public List<Film> listarFilmes(){
        return filmesService.listar();
    }

    @GetMapping("/{id}")
    public FilmeDTO buscarFilme(@PathVariable Integer id){
        return filmesService.buscar(id);
    }
}
