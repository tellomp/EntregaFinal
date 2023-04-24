package com.coderhouse.EntregaFinal.controller;


import com.coderhouse.EntregaFinal.entities.Cliente;
import com.coderhouse.EntregaFinal.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/getCliente/{id}")
    public Cliente getCliente(@PathVariable(value = "id") Long id){
        return clienteService.getCliente(id);
    }

    @GetMapping("/getClientes")
    public List<Cliente> getAllClientes() {
        return clienteService.obtenerTodosLosCLientes();
    }

    @PostMapping("/setCliente")
    public Cliente setCliente(@RequestBody Cliente cliente){
        return clienteService.setCliente(cliente);
    }

    @PutMapping("/editarCliente")
    public Cliente modificarCliente(@RequestBody Cliente cliente){
        return clienteService.modificarCliente(cliente);
    }

    @DeleteMapping("/borrarCliente/{id}")
    public String borrarCliente(@PathVariable(value = "id")Long id){
        return clienteService.borrarCliente(id);
    }
}
