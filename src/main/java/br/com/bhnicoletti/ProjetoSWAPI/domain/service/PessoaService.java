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

    @Autowired
    private RestTemplate restTemplate;

    public ListaPessoaDTO listar(Integer pag){
        var url = "https://swapi.dev/api/people/";
        if(pag != null){
            url += "?page="+pag;
        }
        ListPeople peoples = restTemplate.getForObject(url,ListPeople.class);
        return peoples.converter(modelMapper);
    }

    public PessoaDTO buscar(Integer id){
        String url = "https://swapi.dev/api/people/" + id;
        People people = restTemplate.getForObject(url,People.class);
        return modelMapper.map(people, PessoaDTO.class);
    }
}
