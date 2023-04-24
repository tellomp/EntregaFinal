package com.coderhouse.EntregaFinal.service;

import com.coderhouse.EntregaFinal.dto.ClienteDto;
import com.coderhouse.EntregaFinal.dto.DetalleFacturaDto;
import com.coderhouse.EntregaFinal.entities.Cliente;
import com.coderhouse.EntregaFinal.entities.Factura;
import com.coderhouse.EntregaFinal.entities.Producto;
import com.coderhouse.EntregaFinal.exception.DbException;
import com.coderhouse.EntregaFinal.repository.ClienteRepository;
import com.coderhouse.EntregaFinal.repository.FacturaRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ClienteServiceImpl implements ClienteService {
    private SessionFactory sessionFactory;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    FacturaRepository facturaRepository;

    public Cliente getCliente(Long id) {
        Optional<Cliente> clienteObtener = clienteRepository.findById(id);
        if (clienteObtener.isPresent()) {

            return clienteObtener.get();
        } else {
            throw new DbException("No encontre el cliente con el ID " + id);
        }
    }

    public Cliente obtenerClientePorDni(Cliente cliente){
        Optional<Cliente> buscarCliente = clienteRepository.findByDni(cliente.getDni());
        if(buscarCliente.isPresent()){
            log.info("Ya existe el socio");
            return buscarCliente.get();
        }
        else{
            log.info("Se guardo cliente nuevo");
            return clienteRepository.save(cliente);
        }
    }


    public List<Cliente> obtenerTodosLosCLientes() {
        return clienteRepository.findAll();
    }

    public Cliente setCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente modificarCliente(Cliente cliente){
        Cliente clienteModificado = clienteRepository.findById(cliente.getId()).get();
        clienteModificado.setId(cliente.getId());
        clienteModificado.setNombre(cliente.getNombre());
        clienteModificado.setApellido(cliente.getApellido());
        clienteModificado.setDni(cliente.getDni());
        clienteModificado.setDireccion(cliente.getDireccion());
        return clienteRepository.save(cliente);
    }

    public String borrarCliente(Long id){
        Cliente clienteBorrado = clienteRepository.findById(id).orElseThrow(RuntimeException::new);
        clienteRepository.deleteById(id);
        return "Borraste a " + clienteBorrado.getNombre();
    }
}
