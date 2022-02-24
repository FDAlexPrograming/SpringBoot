package com.example.springboot.Controller;

import java.util.List;

import com.example.springboot.dto.Mensaje;
import com.example.springboot.entity.AboutMy;
import com.example.springboot.servicios.AboutService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/about")
@CrossOrigin(origins = "*")
public class AboutController {

    @Autowired
    AboutService aboutService;

    @RequestMapping("")
    public ResponseEntity<List<AboutMy>> getAll() {
        List<AboutMy> abouts = aboutService.getAll();
        return new ResponseEntity<List<AboutMy>>(abouts,HttpStatus.OK);
    }

    @RequestMapping("/new")
    public ResponseEntity<Mensaje> save(@RequestBody AboutMy aboutMy) {
        aboutService.save(aboutMy);
        Mensaje mensaje = new Mensaje("Se guardo correctamente");
        return new ResponseEntity<Mensaje>(mensaje,HttpStatus.CREATED);
    }

    @RequestMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody AboutMy aboutMy) {
        if(aboutService.existsById(id)) {
           AboutMy about = aboutService.findById(id).get();
              about.setNombre(aboutMy.getNombre());
                about.setTitulo(aboutMy.getTitulo());
                about.setImg(aboutMy.getImg());
                about.setResumenProfesional(aboutMy.getResumenProfesional());
                aboutService.save(about);

            Mensaje mensaje = new Mensaje("Se actualizo correctamente");
            return new ResponseEntity<Mensaje>(mensaje,HttpStatus.OK);
        }else{
            Mensaje mensaje = new Mensaje("No existe el id");
            return new ResponseEntity<Mensaje>(mensaje,HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping("/delete/{id}")
    public ResponseEntity<Mensaje> delete(@PathVariable("id") int id) {
        if (aboutService.existsById(id)) {
            aboutService.delete(id);
            Mensaje mensaje = new Mensaje("Se elimino correctamente");
            return new ResponseEntity<Mensaje>(mensaje,HttpStatus.OK);
        } else {
            Mensaje mensaje = new Mensaje("No se encontro el id");
            return new ResponseEntity<Mensaje>(mensaje,HttpStatus.NOT_FOUND);
        }
    }

}


    

