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
import com.parcial.demo.services.BibliotecaService;
import com.parcial.demo.DTOs.BibliotecaDTO;
import com.parcial.demo.models.Biblioteca;

@RestController
@RequestMapping("/Biblioteca")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class BibliotecaController {

    @Autowired
    private BibliotecaService BibliotecaService;
    

    @GetMapping("/Lista")
    public List<BibliotecaDTO> lista(){
        return BibliotecaService.listar();
    }

    @GetMapping("/Buscar/{name}")
    public BibliotecaDTO buscar(@PathVariable("name")String name){
        return BibliotecaService.buscar(name);
    }

    @PostMapping("/Agregar")
    public Biblioteca insertar(@RequestBody Biblioteca Biblioteca){
        return BibliotecaService.insertar(Biblioteca);
    }

    @PutMapping("/Actualizar")
    public Biblioteca actualizar(@RequestBody Biblioteca Biblioteca){
        return BibliotecaService.actualizar(Biblioteca);
    }

    @DeleteMapping("/Borrar")
    public void eliminar(@RequestBody Biblioteca Biblioteca){
        BibliotecaService.eliminar(Biblioteca);
    }
}
