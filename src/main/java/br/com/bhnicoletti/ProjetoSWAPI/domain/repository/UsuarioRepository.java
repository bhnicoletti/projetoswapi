package br.com.bhnicoletti.ProjetoSWAPI.domain.repository;

import br.com.bhnicoletti.ProjetoSWAPI.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByLogin(String login);

}
