package com.coderhouse.EntregaFinal.service;

import com.coderhouse.EntregaFinal.dto.DetalleFacturaDto;
import com.coderhouse.EntregaFinal.dto.FacturaDto;
import com.coderhouse.EntregaFinal.entities.*;
import com.coderhouse.EntregaFinal.exception.DbException;
import com.coderhouse.EntregaFinal.repository.FacturaRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class FacturaServiceImpl implements FacturaService {
    private SessionFactory sessionFactory;

    @Autowired
    FacturaRepository facturaRepository;

    @Autowired
    ProductoService productoService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    EmpresaService empresaService;

    public Factura agregarProducto(FacturaDto facturaDto) {
        Cliente cliente = clienteService.obtenerClientePorDni(facturaDto.getCliente());
        Empresa empresa = empresaService.getEmpresa(1L);
        List<Producto>productoList = new ArrayList<>();
        Factura factura = new Factura();
        factura.setCliente(cliente);
        factura.setFecha(facturaDto.getFecha());
        factura.setTipoFactura('A');
        factura.setDetalleFactura(new HashSet<>());
        factura.setEmpresa(empresa);
        System.out.println(productoList + "producto list");
        for (DetalleFacturaDto detalleFacturaDto : facturaDto.getDetalleFacturaDtos()) {
            Producto producto = productoService.getProductoByNombre(detalleFacturaDto.getProducto().getNombre());
            productoList.add(producto);
            log.error(producto.toString() + "producto");
            factura.agregarDetalle(crearDetalleFactura(detalleFacturaDto));
            log.error("detalle" + detalleFacturaDto.getProducto().getNombre());
        }

        for (Producto productoPrecio : productoList){

        }

        log.error(productoList.toString() + "producto list");
//        Factura factura = new Factura();
//        factura.setCliente(cliente);
//        factura.setFecha(facturaDto.getFecha());
//        factura.setTipoFactura('A');
//        factura.setDetalleFactura(new HashSet<>());
//        factura.setEmpresa(empresa);
//        System.out.println(productoList + "producto list");
//        for (DetalleFacturaDto detalleFacturaDto : facturaDto.getDetalleFacturaDtos()){
//            factura.agregarDetalle(crearDetalleFactura(detalleFacturaDto));
//            log.error("detalle" + detalleFacturaDto.getProducto().getNombre());
//        }
        Factura factura1 = facturaRepository.save(factura);
        log.error("Informacion de factura warning {} " + factura1);
        productoService.restarStock(productoList);
        return factura;
    }

//    El sistema deberá ser capaz de recibir por medio de un método POST un cliente
//    (sino existe el cliente crearlo en la base de datos)
//    y una lista de productos con sus respectivas cantidades(la lista pueden ser los ID y la cantidad de cada producto).
//    A partir de esto generar la factura con los productos seleccionados
//    si hubiera stock de ellos, caso contrario avisar al usuario CUAL es el PRODUCTO del que no se encuentra stock,
//    en caso de que existiera stock de todo, generar una factura utilizando MÍNIMO la estructura del JSON al final de este
//    documento.


    DetalleFactura crearDetalleFactura(DetalleFacturaDto detalleFactura) {
            DetalleFactura detalleFacturaAGuardar = new DetalleFactura();
            detalleFacturaAGuardar.setNombreProducto(detalleFactura.getProducto().getNombre());
            detalleFacturaAGuardar.setPrecioPorUnidad(detalleFactura.getProducto().getPrecio());
            detalleFacturaAGuardar.setDescripcion(detalleFactura.getProducto().getDescripcion());
            return detalleFacturaAGuardar;
        }


//    Factura totalDeFactura(FacturaDto totalFactura){
//    totalParcial = cantidad * precioPorUnidad
//    total = total parcial de todos los producto
//    return total;
//    }

    public Factura getFactura(Long id){
        Optional<Factura> facturaObtener = facturaRepository.findById(id);
        if(facturaObtener.isPresent()){
            return facturaObtener.get();
        }
        else{throw new DbException("La factura con el id " + id + " no existe");
        }
    }

    public List<Factura> getClienteFactura(Long id){
        Cliente cliente = clienteService.getCliente(id);
        List<Factura> facturasList = facturaRepository.findAll();
        List<Factura> facturasDelCliente = new ArrayList<>();
        for(Factura factura : facturasList){
            if(factura.getCliente() == cliente){
                facturasDelCliente.add(factura);
            }
            else{throw new DbException("El cliente con el id " + id + " no tiene ninguna factura bajo su nombre");
            }
        }
        return facturasDelCliente;
    }


}
