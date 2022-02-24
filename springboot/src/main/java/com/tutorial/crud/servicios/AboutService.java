package com.tutorial.crud.servicios;

import java.util.List;
import java.util.Optional;

import com.tutorial.crud.entity.AboutMy;
import com.tutorial.crud.repositorio.AboutRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AboutService {

    @Autowired
    AboutRepository aboutRepository;

    public List<AboutMy> getAll() {
        return aboutRepository.findAll();
    }

   public void save(AboutMy aboutMy) {
        aboutRepository.save(aboutMy);
    }

    public void delete(int id) {
        aboutRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return aboutRepository.existsById(id);
    }

    public Optional<AboutMy> findById(int id) {
        return aboutRepository.findById(id);
    }

    
}
