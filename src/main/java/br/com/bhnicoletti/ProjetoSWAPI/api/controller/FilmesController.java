package br.com.bhnicoletti.ProjetoSWAPI.api.controller;

import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.FilmeDTO;
import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.ListaFilmeDTO;
import br.com.bhnicoletti.ProjetoSWAPI.domain.service.FilmesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/filmes")
public class FilmesController {

    @Autowired
    private FilmesService filmesService;

    @GetMapping
    public ListaFilmeDTO listarFilmes(@RequestParam(required = false) Integer pag){
        return filmesService.listar(pag);
    }

    @GetMapping("/{id}")
    public FilmeDTO buscarFilme(@PathVariable Integer id){
        return filmesService.buscar(id);
    }
}
