package br.com.bhnicoletti.ProjetoSWAPI.domain.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListFilm {
    private Integer count;
    private Integer next;
    private Integer previous;
    private List<Film> results = new ArrayList<>();
}
