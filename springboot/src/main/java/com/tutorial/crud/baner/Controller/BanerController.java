package com.tutorial.crud.baner.Controller;

import java.util.List;
import com.tutorial.crud.baner.entity.Baner;
import com.tutorial.crud.baner.servicios.BanerService;
import com.tutorial.crud.dto.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")

public class BanerController {

    @Autowired
    BanerService banerService;

    @GetMapping("baner")
    public ResponseEntity<List<Baner>> getAll() {
        List<Baner> baners = banerService.getAll();
        return new ResponseEntity<List<Baner>>(baners,HttpStatus.OK);
    }

    @PostMapping("/new/baner")
    public ResponseEntity<?> save(@RequestBody Baner baner) {
        banerService.save(baner);
        Mensaje mensaje = new Mensaje("Se guardo correctamente");
        return new ResponseEntity<Mensaje>(mensaje,HttpStatus.CREATED);
    }

    @PutMapping("baner/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Baner banerOld) {
        if(banerService.existsById(id)) {
            Baner baner = banerService.findById(id).get();
               
            baner.setImg(banerOld.getImg());
            banerService.save(baner);

            Mensaje mensaje = new Mensaje("Se actualizo correctamente");
            return new ResponseEntity<Mensaje>(mensaje,HttpStatus.OK);
        }else{
            Mensaje mensaje = new Mensaje("No existe el id");
            return new ResponseEntity<Mensaje>(mensaje,HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping ("/baner/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(banerService.existsById(id)) {
            banerService.delete(id);
            Mensaje mensaje = new Mensaje("Se elimino correctamente");
            return new ResponseEntity<Mensaje>(mensaje,HttpStatus.OK);
        }else{
            Mensaje mensaje = new Mensaje("No existe el id");
            return new ResponseEntity<Mensaje>(mensaje,HttpStatus.NOT_FOUND);
        }

          
       
    }

}

