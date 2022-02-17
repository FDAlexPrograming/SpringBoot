package com.example.springboot.repositorio;

import com.example.springboot.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepositorio extends JpaRepository <Persona,Long>{
    
}
