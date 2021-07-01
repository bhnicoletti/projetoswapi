package br.com.bhnicoletti.ProjetoSWAPI.api.controller;

import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.FilmeDTO;
import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.ListaFilmeDTO;
import br.com.bhnicoletti.ProjetoSWAPI.domain.service.FilmesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/filmes")
@Api("API listagem de filmes")
public class FilmesController {

    @Autowired
    private FilmesService filmesService;

    @GetMapping
    @ApiOperation("Listar filmes")
    @ResponseStatus(HttpStatus.OK)
    public ListaFilmeDTO listarFilmes(@RequestParam(required = false) Integer pag){
        return filmesService.listar(pag);
    }

    @GetMapping("/{id}")
    @ApiOperation("Buscar único filme")
    @ResponseStatus(HttpStatus.OK)
    public FilmeDTO buscarFilme(@PathVariable Integer id){
        return filmesService.buscar(id);
    }
}
