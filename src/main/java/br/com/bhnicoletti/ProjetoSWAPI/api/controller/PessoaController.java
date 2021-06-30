package br.com.bhnicoletti.ProjetoSWAPI.api.controller;

import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.ListaPessoaDTO;
import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.PessoaDTO;
import br.com.bhnicoletti.ProjetoSWAPI.domain.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {


    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ListaPessoaDTO listar(@RequestParam(required = false) Integer pag){
        return pessoaService.listar(pag);
    }

    @GetMapping("/{id}")
    public PessoaDTO buscar(@PathVariable Integer id){
        return pessoaService.buscar(id);
    }
}
