package com.example.springboot.servicios;

import java.util.List;

import com.example.springboot.model.Persona;
import com.example.springboot.repositorio.PersonaRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service

public class PersonaServivio implements IPersonaSercicios {

    @Autowired
    public PersonaRepositorio personaRepo;
    @Override
    public void addPersona(Persona persona) {
        personaRepo.save(persona);
    }

    @Override
    public List<Persona> verPersonas() {
     return personaRepo.findAll();
    }

    @Override
    public Persona getPersona(long id) {
        return personaRepo.findById(id).orElse(null);
    }

    @Override
    public void deletePersona(long id) {
        personaRepo.deleteById(id);
        
    }

    @Override
    public void updatePersona(Persona persona,long id) {
        if (personaRepo.existsById(id)) {
            personaRepo.save(persona);
        }

    }
    
}
