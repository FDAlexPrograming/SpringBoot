package com.tutorial.crud.baner.repositorio;




import java.util.Optional;

import com.tutorial.crud.baner.entity.Baner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BanerRepository extends JpaRepository<Baner, Integer> {

    Optional<Baner> findById(int id);
    public boolean existsById(int id);


   


}
    

