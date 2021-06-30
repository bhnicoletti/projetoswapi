package br.com.bhnicoletti.ProjetoSWAPI.api.controller;

import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.ListaPlanetaDTO;
import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.PlanetaDTO;
import br.com.bhnicoletti.ProjetoSWAPI.domain.service.PlanetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/planetas")
public class PlanetaController {

    @Autowired
    private PlanetaService planetaService;

    @GetMapping
    public ListaPlanetaDTO listar(@RequestParam(required = false) Integer pag){
        return planetaService.listar(pag);
    }

    @GetMapping("/{id}")
    public PlanetaDTO buscar(@PathVariable Integer id){
        return planetaService.buscar(id);
    }
}
