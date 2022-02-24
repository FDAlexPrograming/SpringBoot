package com.tutorial.crud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AboutMy {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String img;
    private String nombre;
    private String titulo;
    private String resumenProfesional;

  

    public AboutMy() {
    }

    public AboutMy(int id, String img, String nombre, String titulo, String resumenProfesional) {
        this.id = id;
        this.img = img;
        this.nombre = nombre;
        this.titulo = titulo;
        this.resumenProfesional = resumenProfesional;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
  

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumenProfesional() {
        return resumenProfesional;
    }

    public void setResumenProfesional(String resumenProfesional) {
        this.resumenProfesional = resumenProfesional;
    }


    
}
