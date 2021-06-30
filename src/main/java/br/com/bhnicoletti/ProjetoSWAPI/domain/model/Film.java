package br.com.bhnicoletti.ProjetoSWAPI.domain.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Film {
    private String title;
    private Integer episode_id;
    private String opening_crawl;
    private String director;
    private String producer;
    private LocalDate release_date;
    private List<String> characters;
    private List<String> planets;
    private List<String> starships;
    private List<String> vehicles;
    private List<String> species;
    private String created;
    private String edited;
    private String url;
}
