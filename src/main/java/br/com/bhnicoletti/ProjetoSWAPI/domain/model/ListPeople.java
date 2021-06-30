package br.com.bhnicoletti.ProjetoSWAPI.domain.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListPeople {
    private Integer count;
    private String next;
    private String previous;
    private List<People> results = new ArrayList<>();
}
