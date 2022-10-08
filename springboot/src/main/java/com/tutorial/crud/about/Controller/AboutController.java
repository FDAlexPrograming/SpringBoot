

package com.tutorial.crud.about.Controller;

import java.util.List;
import com.tutorial.crud.about.servicios.AboutService;
import com.tutorial.crud.dto.Mensaje;
import com.tutorial.crud.about.entity.AboutMy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")

public class AboutController {

    @Autowired
    AboutService aboutService;

    @RequestMapping("about")
    public ResponseEntity<List<AboutMy>> getAll() {
        List<AboutMy> abouts = aboutService.getAll();
        return new ResponseEntity<List<AboutMy>>(abouts,HttpStatus.OK);
    }

    @PostMapping("/new/about")
    public ResponseEntity<?> save(@RequestBody AboutMy aboutMy) {
        aboutService.save(aboutMy);
        Mensaje mensaje = new Mensaje("Se guardo correctamente");
        return new ResponseEntity<Mensaje>(mensaje,HttpStatus.CREATED);
    }

    @PutMapping("about/update/{id}")
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

    @DeleteMapping ("/about/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(aboutService.existsById(id)) {
            aboutService.delete(id);
            Mensaje mensaje = new Mensaje("Se elimino correctamente");
            return new ResponseEntity<Mensaje>(mensaje,HttpStatus.OK);
        }else{
            Mensaje mensaje = new Mensaje("No existe el id");
            return new ResponseEntity<Mensaje>(mensaje,HttpStatus.NOT_FOUND);
        }

          
       
    }

}


    



    

