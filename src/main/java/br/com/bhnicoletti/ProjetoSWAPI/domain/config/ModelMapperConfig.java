package br.com.bhnicoletti.ProjetoSWAPI.domain.config;

import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.FilmeDTO;
import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.ListaFilmeDTO;
import br.com.bhnicoletti.ProjetoSWAPI.domain.model.Film;
import br.com.bhnicoletti.ProjetoSWAPI.domain.model.ListFilm;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        var modelMapper = new ModelMapper();

        modelMapper.createTypeMap(Film.class, FilmeDTO.class)
                .<String>addMapping(src -> src.getTitle(), (dest, value) -> dest.setTitulo(value))
                .<Integer>addMapping(src -> src.getEpisode_id(), (dest, value) -> dest.setEpisodio_id(value))
                .<String>addMapping(src -> src.getOpening_crawl(), (dest, value) -> dest.setSequencia_abertura(value))
                .<String>addMapping(src -> src.getDirector(), (dest, value) -> dest.setDiretor(value))
                .<String>addMapping(src -> src.getProducer(), (dest, value) -> dest.setProdutor(value))
                .<LocalDate>addMapping(src -> src.getRelease_date(), (dest, value) -> dest.setData_lancamento(value))
                .<List<String>>addMapping(src -> src.getCharacters(), (dest, value) -> dest.setPersonagens(value))
                .<List<String>>addMapping(src -> src.getStarships(), (dest, value) -> dest.setNaves(value))
                .<List<String>>addMapping(src -> src.getVehicles(), (dest, value) -> dest.setVeiculos(value))
                .<List<String>>addMapping(src -> src.getPlanets(), (dest, value) -> dest.setPlanetas(value))
                .<List<String>>addMapping(src -> src.getSpecies(), (dest, value) -> dest.setEspecies(value))
                .<String>addMapping(src -> src.getCreated(), (dest, value) -> dest.setCriado(value))
                .<String>addMapping(src -> src.getEdited(), (dest, value) -> dest.setEditado(value))
                .<String>addMapping(src -> src.getUrl(), (dest, value) -> dest.setUrl(value));

        modelMapper.createTypeMap(ListFilm.class, ListaFilmeDTO.class)
                .<Integer>addMapping(src -> src.getCount(), (dest, value) -> dest.setContagem(value))
                .<Integer>addMapping(src -> src.getNext(), (dest, value) -> dest.setProximo(value))
                .<Integer>addMapping(src -> src.getPrevious(), (dest, value) -> dest.setAnterior(value))
                .<List<FilmeDTO>>addMapping(src -> src.getResults(), (dest, value) -> dest.setResultado(value));

        return modelMapper;
    }


}
