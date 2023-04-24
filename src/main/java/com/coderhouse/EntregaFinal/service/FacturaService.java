package com.coderhouse.EntregaFinal.service;


import com.coderhouse.EntregaFinal.dto.FacturaDto;
import com.coderhouse.EntregaFinal.entities.Factura;

import java.util.List;

public interface FacturaService {
    public Factura agregarProducto(FacturaDto facturaDto);

    public Factura getFactura(Long id);

    public List<Factura> getClienteFactura(Long id);

}