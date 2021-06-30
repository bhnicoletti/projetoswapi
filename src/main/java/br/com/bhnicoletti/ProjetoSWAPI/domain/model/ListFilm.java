package br.com.bhnicoletti.ProjetoSWAPI.domain.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListFilm {
    private List<Film> films = new ArrayList<>();
}
