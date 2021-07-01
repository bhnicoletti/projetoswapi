package br.com.bhnicoletti.ProjetoSWAPI.api.controller;

import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.ListaPlanetaDTO;
import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.PlanetaDTO;
import br.com.bhnicoletti.ProjetoSWAPI.domain.service.PlanetaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/planetas")
@Api("API para listagem de planetas")
public class PlanetaController {

    @Autowired
    private PlanetaService planetaService;

    @GetMapping
    @ApiOperation("Listar planetas")
    @ResponseStatus(HttpStatus.OK)
    public ListaPlanetaDTO listar(@RequestParam(required = false) Integer pag){
        return planetaService.listar(pag);
    }

    @GetMapping("/{id}")
    @ApiOperation("buscar único planeta")
    @ResponseStatus(HttpStatus.OK)
    public PlanetaDTO buscar(@PathVariable Integer id){
        return planetaService.buscar(id);
    }
}
