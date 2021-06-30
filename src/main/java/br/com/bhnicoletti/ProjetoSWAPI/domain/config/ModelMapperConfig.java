package br.com.bhnicoletti.ProjetoSWAPI.domain.config;

import br.com.bhnicoletti.ProjetoSWAPI.domain.dto.*;
import br.com.bhnicoletti.ProjetoSWAPI.domain.model.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
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
                .<String>addMapping(src -> src.getNext(), (dest, value) -> dest.setProximo(value))
                .<String>addMapping(src -> src.getPrevious(), (dest, value) -> dest.setAnterior(value))
                .<List<FilmeDTO>>addMapping(src -> src.getResults(), (dest, value) -> dest.setResultado(value));


        modelMapper.createTypeMap(Planet.class, PlanetaDTO.class)
                .<String>addMapping(src -> src.getName(), (dest, value) -> dest.setNome(value))
                .<String>addMapping(src -> src.getDiameter(), (dest, value) -> dest.setDiametro(value))
                .<String>addMapping(src -> src.getRotation_period(), (dest, value) -> dest.setPeriodo_rotacao(value))
                .<String>addMapping(src -> src.getOrbital_period(), (dest, value) -> dest.setPeriodo_orbita(value))
                .<String>addMapping(src -> src.getGravity(), (dest, value) -> dest.setGravidade(value))
                .<String>addMapping(src -> src.getPopulation(), (dest, value) -> dest.setPopulacao(value))
                .<String>addMapping(src -> src.getClimate(), (dest, value) -> dest.setClima(value))
                .<String>addMapping(src -> src.getTerrain(), (dest, value) -> dest.setTerreno(value))
                .<String>addMapping(src -> src.getSurface_water(), (dest, value) -> dest.setSuperficie_agua(value))
                .<List<String>>addMapping(src -> src.getResidents(), (dest, value) -> dest.setResidentes(value))
                .<List<String>>addMapping(src -> src.getFilms(), (dest, value) -> dest.setFilmes(value))
                .<String>addMapping(src -> src.getUrl(), (dest, value) -> dest.setUrl(value))
                .<String>addMapping(src -> src.getCreated(), (dest, value) -> dest.setCriado(value))
                .<String>addMapping(src -> src.getEdited(), (dest, value) -> dest.setEditado(value));

        modelMapper.createTypeMap(ListPlanet.class, ListaPlanetaDTO.class)
                .<Integer>addMapping(src -> src.getCount(), (dest, value) -> dest.setContagem(value))
                .<String>addMapping(src -> src.getNext(), (dest, value) -> dest.setProximo(value))
                .<String>addMapping(src -> src.getPrevious(), (dest, value) -> dest.setAnterior(value))
                .<List<PlanetaDTO>>addMapping(src -> src.getResults(), (dest, value) -> dest.setResultado(value));

        modelMapper.createTypeMap(People.class, PessoaDTO.class)
                .<String>addMapping(src -> src.getBirth_year(), (dest, value) -> dest.setData_nascimento(value))
                .<String>addMapping(src -> src.getEye_color(), (dest, value) -> dest.setCor_olho(value))
                .<String>addMapping(src -> src.getGender(), (dest, value) -> dest.setGenero(value))
                .<String>addMapping(src -> src.getHair_color(), (dest, value) -> dest.setCor_cabelo(value))
                .<String>addMapping(src -> src.getHeight(), (dest, value) -> dest.setAltura(value))
                .<String>addMapping(src -> src.getHomeworld(), (dest, value) -> dest.setPlaneta_natal(value))
                .<String>addMapping(src -> src.getMass(), (dest, value) -> dest.setPeso(value))
                .<String>addMapping(src -> src.getName(), (dest, value) -> dest.setNome(value))
                .<String>addMapping(src -> src.getSkin_color(), (dest, value) -> dest.setCor_pele(value))
                .<String>addMapping(src -> src.getCreated(), (dest, value) -> dest.setCriado(value))
                .<String>addMapping(src -> src.getEdited(), (dest, value) -> dest.setEditado(value))
                .<String>addMapping(src -> src.getUrl(), (dest, value) -> dest.setUrl(value))
                .<List<String>>addMapping(src -> src.getFilms(), (dest, value) -> dest.setFilmes(value))
                .<List<String>>addMapping(src -> src.getSpecies(), (dest, value) -> dest.setEspecies(value))
                .<List<String>>addMapping(src -> src.getStarships(), (dest, value) -> dest.setNaves(value))
                .<List<String>>addMapping(src -> src.getVehicles(), (dest, value) -> dest.setVeiculos(value));

        modelMapper.createTypeMap(ListPeople.class, ListaPessoaDTO.class)
                .<Integer>addMapping(src -> src.getCount(), (dest, value) -> dest.setContagem(value))
                .<String>addMapping(src -> src.getNext(), (dest, value) -> dest.setProximo(value))
                .<String>addMapping(src -> src.getPrevious(), (dest, value) -> dest.setAnterior(value))
                .<List<PessoaDTO>>addMapping(src -> src.getResults(), (dest, value) -> dest.setResultado(value));


        return modelMapper;
    }


}
