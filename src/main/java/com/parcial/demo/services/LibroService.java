package com.parcial.demo.services;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.parcial.demo.repositories.LibroRepository;
import com.parcial.demo.models.Libro;
import com.parcial.demo.DTOs.LibroDTO;
@Service
public class LibroService{
    @Autowired

    private LibroRepository LibroRepository;

    @Autowired
    ModelMapper modelMapper;

    public Libro insertar(Libro Libro){
        return LibroRepository.save(Libro);
    };

    public Libro actualizar(Libro Libro){
        return LibroRepository.save(Libro);
    };

    public LibroDTO buscar(String name){
        Optional<Libro>LibroOptional =  LibroRepository.findLibroByName(name);
		Libro Libro = null;
		LibroDTO LibroDTO = null;
		if( LibroOptional.isPresent() ) {
			Libro = LibroOptional.get();
			LibroDTO = modelMapper.map(Libro, LibroDTO.class);
		}
		return LibroDTO;
    };

    public List<LibroDTO> listar() {
        Iterable<Libro> Libros = LibroRepository.findAll();
        List<LibroDTO> LibroDTOs = new ArrayList<>();
        for (Libro Libro : Libros) {
            LibroDTO LibroDTO = modelMapper.map(Libro, LibroDTO.class);
            LibroDTOs.add(LibroDTO);
        }
        return LibroDTOs;
    }

    public void eliminar(Libro Libro){
        LibroRepository.delete(Libro);
    };
}
