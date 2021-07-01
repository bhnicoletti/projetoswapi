package br.com.bhnicoletti.ProjetoSWAPI.domain.util;

import org.modelmapper.ModelMapper;

public interface Convertible<T> {
    T converter(ModelMapper modelMapper);
}
