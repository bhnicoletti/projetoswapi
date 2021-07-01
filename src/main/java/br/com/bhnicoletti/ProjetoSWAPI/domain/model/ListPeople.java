package br.com.bhnicoletti.ProjetoSWAPI.domain.model;

import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.ListaPessoaDTO;
import br.com.bhnicoletti.ProjetoSWAPI.domain.util.Convertible;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListPeople implements Convertible<ListaPessoaDTO> {
    private Integer count;
    private String next;
    private String previous;
    private List<People> results = new ArrayList<>();

    @Override
    public ListaPessoaDTO converter(ModelMapper modelMapper) {
        return modelMapper.map(this, ListaPessoaDTO.class);
    }
}
