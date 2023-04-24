package com.coderhouse.EntregaFinal.dto;

import com.coderhouse.EntregaFinal.entities.Cliente;
import com.coderhouse.EntregaFinal.entities.Empresa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FacturaDto {

    private Date fecha;

    private Cliente cliente;

    private List<DetalleFacturaDto> detalleFacturaDtos;

    private Empresa empresa;

}
