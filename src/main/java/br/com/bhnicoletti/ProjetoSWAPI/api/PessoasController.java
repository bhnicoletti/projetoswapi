package br.com.bhnicoletti.ProjetoSWAPI.api;

import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.ListaPessoaDTO;
import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.PessoaDTO;
import br.com.bhnicoletti.ProjetoSWAPI.domain.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoas")
public class PessoasController {
    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ListaPessoaDTO listarFilmes(){
        return pessoaService.listar();
    }

    @GetMapping("/{id}")
    public PessoaDTO buscarFilme(@PathVariable Integer id){
        return pessoaService.buscar(id);
    }
}
