package com.example.springboot.Controller;

import java.util.List;

import com.example.springboot.model.Cliente;
import com.example.springboot.model.Persona;
import com.example.springboot.servicios.IClientesServicios;
import com.example.springboot.servicios.IPersonaSercicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private IPersonaSercicios personaServ;
    @Autowired
    private IClientesServicios clienteServ;

    
    @PostMapping ("api/new/persona")
    public void crearPersona(@RequestBody Persona persona) {
        personaServ.addPersona(persona);
    }

    @GetMapping ("/api/ver/personas")
    @ResponseBody
    public List<Persona> verPersonas() {
        return personaServ.verPersonas();
    }

    @DeleteMapping ("api/delete/{id}")
    public void deletePersona(@PathVariable long id) {
        personaServ.deletePersona(id);
    }

    @PutMapping ("api/update/{id}")
    public void updatePersona(@RequestBody Persona persona, @PathVariable long id) {
        persona.setId(id);
        personaServ.updatePersona(persona, id);
    }

    
    @PostMapping ("api/new/cliente")
    public void crearCliente(@RequestBody Cliente cliente) {
        clienteServ.addCliente(cliente);
    } 

    @GetMapping ("/api/ver/clientes")
    @ResponseBody
    public List<Cliente> verClientes() {
        return clienteServ.verClientes();
    }

    @DeleteMapping ("/api/delete/cliente/{id}")
    public void deleteCliente(@PathVariable long id) {
        clienteServ.deleteCliente(id);
    }

    @PutMapping ("/api/update/cliente/{id}")
    public void updateCliente(@RequestBody Cliente cliente, @PathVariable long id) {
        cliente.setId(id);
        clienteServ.updateCliente(cliente, id);
    }
    

  
}
