package com.parcial.demo.services;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.parcial.demo.repositories.BibliotecaRepository;
import com.parcial.demo.models.Biblioteca;
import com.parcial.demo.DTOs.BibliotecaDTO;
@Service
public class BibliotecaService {
    @Autowired

    private BibliotecaRepository bibliotecaRepository;

    @Autowired
    ModelMapper modelMapper;

    public Biblioteca insertar(Biblioteca biblioteca){
        return bibliotecaRepository.save(biblioteca);
    };

    public Biblioteca actualizar(Biblioteca biblioteca){
        return bibliotecaRepository.save(biblioteca);
    };

    public BibliotecaDTO buscar(String name){
        Optional<Biblioteca>BibliotecaOptional =  bibliotecaRepository.findBibliotecaByName(name);
		Biblioteca Biblioteca = null;
		BibliotecaDTO BibliotecaDTO = null;
		if( BibliotecaOptional.isPresent() ) {
			Biblioteca = BibliotecaOptional.get();
			BibliotecaDTO = modelMapper.map(Biblioteca, BibliotecaDTO.class);
		}
		return BibliotecaDTO;
    };

    public List<BibliotecaDTO> listar() {
        Iterable<Biblioteca> Bibliotecas = bibliotecaRepository.findAll();
        List<BibliotecaDTO> BibliotecaDTOs = new ArrayList<>();
        for (Biblioteca Biblioteca : Bibliotecas) {
            BibliotecaDTO BibliotecaDTO = modelMapper.map(Biblioteca, BibliotecaDTO.class);
            BibliotecaDTOs.add(BibliotecaDTO);
        }
        return BibliotecaDTOs;
    }

    public void eliminar(Biblioteca Biblioteca){
        bibliotecaRepository.delete(Biblioteca);
    };
}
