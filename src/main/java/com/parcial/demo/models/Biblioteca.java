package com.parcial.demo.models;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Biblioteca {
    @Id
    @Getter @Setter
    private String Nombre;
    
    @Getter @Setter
    private String Dirección;
    
    @Getter @Setter
    private String Ciudad;
}
