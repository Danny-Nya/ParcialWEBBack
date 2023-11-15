package com.parcial.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.parcial.demo.services.LibroService;
import com.parcial.demo.DTOs.LibroDTO;
import com.parcial.demo.models.Libro;

@RestController
@RequestMapping("/Libro")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class LibroController {

    @Autowired
    private LibroService LibroService;
    

    @GetMapping("/Lista")
    public List<LibroDTO> lista(){
        return LibroService.listar();
    }

    @GetMapping("/Buscar/{name}")
    public LibroDTO buscar(@PathVariable("name")String name){
        return LibroService.buscar(name);
    }

    @PostMapping("/Agregar")
    public Libro insertar(@RequestBody Libro Libro){
        return LibroService.insertar(Libro);
    }

    @PutMapping("/Actualizar")
    public Libro actualizar(@RequestBody Libro Libro){
        return LibroService.actualizar(Libro);
    }

    @DeleteMapping("/Borrar")
    public void eliminar(@RequestBody Libro Libro){
        LibroService.eliminar(Libro);
    }
}
