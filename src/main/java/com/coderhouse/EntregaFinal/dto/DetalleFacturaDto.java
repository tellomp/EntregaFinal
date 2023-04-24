package com.coderhouse.EntregaFinal.dto;


import com.coderhouse.EntregaFinal.entities.Producto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DetalleFacturaDto {

    private Producto producto;

    private int cantidad;

    private double totalParcial;
}
