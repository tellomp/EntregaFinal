package com.coderhouse.EntregaFinal.controller;


import com.coderhouse.EntregaFinal.dto.FacturaDto;
import com.coderhouse.EntregaFinal.entities.Cliente;
import com.coderhouse.EntregaFinal.entities.Factura;
import com.coderhouse.EntregaFinal.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FacturaController {

    @Autowired
    FacturaService facturaService;

    @PostMapping("/agregarProducto")
    public Factura agregarProducto(@RequestBody FacturaDto factura){
        return facturaService.agregarProducto(factura);
    }

    @GetMapping("/getFactura/{id}")
    public Factura getFactura(@PathVariable(value = "id") Long id){
        return facturaService.getFactura(id);
    }

    @GetMapping("/getClienteFactura/{id}")
    public List<Factura> getClienteFactura(@PathVariable(value = "id") Long id) {
        return facturaService.getClienteFactura(id);
    }

}
