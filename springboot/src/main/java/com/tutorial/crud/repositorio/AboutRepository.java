package com.tutorial.crud.repositorio;




import java.util.Optional;

import com.tutorial.crud.entity.AboutMy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRepository extends JpaRepository<AboutMy, Integer> {

   Optional<AboutMy> findById(int id);
    public boolean existsById(int id);


   


}
    

