package com.example.springboot.servicios;


import java.util.List;

import com.example.springboot.model.Cliente;
import com.example.springboot.repositorio.ClienteRepositorio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServicios implements IClientesServicios {

    @Autowired
    public ClienteRepositorio clienteRepo;

    @Override
    public void addCliente(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    @Override
    public List<Cliente> verClientes() {
        return clienteRepo.findAll();
    }

    @Override
    public Cliente getCliente(long id) {
        return clienteRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteCliente(long id) {
        clienteRepo.deleteById(id);
        
    }

    @Override
    public void updateCliente(Cliente cliente, long id) {
        if (clienteRepo.existsById(id)) {
            clienteRepo.save(cliente);
        }
    }

    
}
