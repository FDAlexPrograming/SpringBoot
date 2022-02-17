package com.example.springboot.servicios;


import java.util.List;

import com.example.springboot.model.Persona;

public interface IPersonaSercicios {

    public void  addPersona(Persona persona);
    public List<Persona> verPersonas();
    public Persona getPersona(long id);
    public void deletePersona(long id);
    public void updatePersona(Persona persona,long id);
    
}
