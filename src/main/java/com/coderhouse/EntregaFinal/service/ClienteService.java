package com.coderhouse.EntregaFinal.service;


import com.coderhouse.EntregaFinal.entities.Cliente;

import java.util.List;

public interface ClienteService {
    public Cliente getCliente(Long id);

    Cliente obtenerClientePorDni(Cliente cliente);

    public List<Cliente> obtenerTodosLosCLientes();

    public Cliente setCliente(Cliente cliente);


    public Cliente modificarCliente(Cliente cliente);

    public String borrarCliente(Long id);

    }

