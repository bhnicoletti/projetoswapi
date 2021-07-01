package br.com.bhnicoletti.ProjetoSWAPI.api.controller;

import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.ListaPessoaDTO;
import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.PessoaDTO;
import br.com.bhnicoletti.ProjetoSWAPI.domain.service.PessoaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
@Api("API listagem de pessoas")
public class PessoaController {


    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    @ApiOperation("Listar pessoas")
    @ResponseStatus(HttpStatus.OK)
    public ListaPessoaDTO listar(@RequestParam(required = false) Integer pag){
        return pessoaService.listar(pag);
    }

    @GetMapping("/{id}")
    @ApiOperation("Buscar única pessoa")
    @ResponseStatus(HttpStatus.OK)
    public PessoaDTO buscar(@PathVariable Integer id){
        return pessoaService.buscar(id);
    }
}
