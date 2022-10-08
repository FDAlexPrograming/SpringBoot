package com.tutorial.crud.baner.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Baner {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String img;


    public Baner() {
    }

    public Baner(int id, String img) {
        this.id = id;
        this.img = img;
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

}
