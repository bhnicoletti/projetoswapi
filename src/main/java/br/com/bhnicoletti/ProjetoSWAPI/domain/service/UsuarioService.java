package br.com.bhnicoletti.ProjetoSWAPI.domain.service;

import br.com.bhnicoletti.ProjetoSWAPI.api.security.JwtService;
import br.com.bhnicoletti.ProjetoSWAPI.domain.exception.EntidadeNaoEncontradaException;
import br.com.bhnicoletti.ProjetoSWAPI.domain.exception.SenhaInvalidaException;
import br.com.bhnicoletti.ProjetoSWAPI.domain.model.Usuario;
import br.com.bhnicoletti.ProjetoSWAPI.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    public PasswordEncoder encoder;

    public Usuario salvar(Usuario usuario){
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    public void atualizarSenha(String senha, Long id){
        var usuario = usuarioRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Usuário não encontrado. Cod. informado: "+ id));
        usuario.setSenha(encoder.encode(senha));
        usuarioRepository.save(usuario);
    }

    public String autenticar(Usuario usuario) {
        UserDetails user = loadUserByUsername(usuario.getLogin());
        boolean verificaSenha = encoder.matches(usuario.getSenha(), user.getPassword());
        if (verificaSenha) {
            return jwtService.gerarToken(usuario);
        }
        throw new SenhaInvalidaException();
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByLogin(login)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Usuário não encontrado"));

        String[] roles = new String[]{"USER"};
        return User.builder()
                .username(usuario.getLogin())
                .password(usuario.getSenha())
                .roles(roles)
                .build();
    }

}
