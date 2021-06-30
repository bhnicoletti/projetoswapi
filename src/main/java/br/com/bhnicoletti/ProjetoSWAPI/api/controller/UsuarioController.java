package br.com.bhnicoletti.ProjetoSWAPI.api.controller;

import br.com.bhnicoletti.ProjetoSWAPI.domain.model.Usuario;
import br.com.bhnicoletti.ProjetoSWAPI.domain.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private String salvar(@RequestBody Usuario usuario){
        usuarioService.salvar(usuario);
        return String.format("Usuário %s criado com sucesso", usuario.getLogin());
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private void atualizarSenha(@PathVariable Long id, @RequestBody Map<String, Object> senha){
        usuarioService.atualizarSenha(senha.get("senha").toString(), id);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    private String login(@RequestBody Usuario usuario){
        return usuarioService.autenticar(usuario);
    }


}
