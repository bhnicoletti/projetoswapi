package br.com.bhnicoletti.ProjetoSWAPI.domain.service;


import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.ListaPessoaDTO;
import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.PessoaDTO;
import br.com.bhnicoletti.ProjetoSWAPI.domain.model.ListPeople;
import br.com.bhnicoletti.ProjetoSWAPI.domain.model.People;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PessoaService {

    @Autowired
    private ModelMapper modelMapper;

    public ListaPessoaDTO listar(){
        RestTemplate restTemplate = new RestTemplate();
        ListPeople response = restTemplate.getForObject("https://swapi.dev/api/people",ListPeople.class);
        ListaPessoaDTO pessoas = modelMapper.map(response, ListaPessoaDTO.class);
        return pessoas;
    }

    public PessoaDTO buscar(Integer id){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://swapi.dev/api/people/" + id;
        People people = restTemplate.getForObject(url,People.class);
        return modelMapper.map(people, PessoaDTO.class);
    }
}
