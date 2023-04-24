package com.coderhouse.EntregaFinal.service;

import com.coderhouse.EntregaFinal.entities.Producto;


import java.util.List;

public interface ProductoService {
    public Producto getProducto(Long id);

    public Producto getProductoById(Long id);

   public Producto getProductoByNombre(String nombre);

    public List<Producto> obtenerTodosLosProductos();

    public Producto setProducto(Producto producto);

    public Producto modificarProducto(Producto producto);

    public String borrarProducto(Long id);

//    public Producto restarStock(Long id, int cantidadARestar);

//    public void restarStock(List<Producto> productoList);

    public void restarStock(List<Producto> productoList);


}

