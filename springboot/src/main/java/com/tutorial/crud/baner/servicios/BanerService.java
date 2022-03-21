package com.tutorial.crud.baner.servicios;

import java.util.List;
import java.util.Optional;
import com.tutorial.crud.baner.entity.Baner;
import com.tutorial.crud.baner.repositorio.BanerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BanerService {

    @Autowired
    BanerRepository banerRepository;

    public List<Baner> getAll() {
        return banerRepository.findAll();
    }

   public void save(Baner baner) {
    banerRepository.save(baner);
    }

    public void delete(int id) {
        banerRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return banerRepository.existsById(id);
    }

    public Optional<Baner> findById(int id) {
        return banerRepository.findById(id);
    }

    
}
