package br.com.bhnicoletti.ProjetoSWAPI;

import br.com.bhnicoletti.ProjetoSWAPI.domain.model.Film;
import br.com.bhnicoletti.ProjetoSWAPI.domain.model.Usuario;
import br.com.bhnicoletti.ProjetoSWAPI.domain.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProjetoSwapiApplicationTests {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Test
	void verificarApiExterna() {
		var response = restTemplate.getForObject("https://swapi.dev/api/films/1", Film.class);
		assertThat(this.restTemplate.getForObject("https://swapi.dev/api/films/1", Film.class)).isNotNull();
	}

	@Test
	void verificarDB(){

		var user = new Usuario();
		user.setLogin("teste");
		user.setSenha("123");
		user = usuarioRepository.save(user);

		System.out.println(user.toString());

		usuarioRepository.delete(user);
		assertThat(usuarioRepository.findAll()).isNotNull();

	}

}
