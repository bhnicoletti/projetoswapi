package br.com.bhnicoletti.ProjetoSWAPI.domain.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class People {

    private  String birth_year;
    private String eye_color;
    private List<String> films = new ArrayList<>();
    private String gender;
    private String hair_color;
    private String height;
    private String homeworld;
    private String mass;
    private String name;
    private String skin_color;
    private String created;
    private String  edited;
    private List<String> species = new ArrayList<>();
    private List<String> starships  = new ArrayList<>();
    private String url;
    private List<String> vehicles  = new ArrayList<>();
}
