package com.example.springboot.servicios;

import java.util.List;

import com.example.springboot.model.Cliente;

public interface IClientesServicios {

    public void addCliente(Cliente cliente);
    public List<Cliente> verClientes();
    public Cliente getCliente(long id);
    public void deleteCliente(long id);
    public void updateCliente(Cliente cliente, long id);
    
    
}
