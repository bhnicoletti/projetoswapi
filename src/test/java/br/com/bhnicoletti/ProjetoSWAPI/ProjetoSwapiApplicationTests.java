package br.com.bhnicoletti.ProjetoSWAPI;

import br.com.bhnicoletti.ProjetoSWAPI.domain.model.Film;
import br.com.bhnicoletti.ProjetoSWAPI.domain.model.Usuario;
import br.com.bhnicoletti.ProjetoSWAPI.domain.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class ProjetoSwapiApplicationTests {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private UsuarioService usuarioService;

	@Test
	void verificarApiExterna() {
		var response = restTemplate.getForObject("https://swapi.dev/api/films/1", Film.class);
		if(response!= null){
			System.out.println(response.toString());
		}
	}

	@Test
	void verificarDB(){

		var user = new Usuario();
		user.setLogin("teste");
		user.setSenha("123");
		user = usuarioService.salvar(user);

		System.out.println(user.toString());
	}

}
