package com.coderhouse.EntregaFinal.controller;

import com.coderhouse.EntregaFinal.entities.Producto;
import com.coderhouse.EntregaFinal.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @GetMapping("/getProducto/{id}")
    public Producto getProducto(@PathVariable(value = "id") Long id){
        return productoService.getProducto(id);
    }

    @GetMapping("/getProductos")
    public List<Producto> getAllProductos() {
        return productoService.obtenerTodosLosProductos();
    }

    @PostMapping("/setProducto")
    public Producto setProducto(@RequestBody Producto producto){
        return productoService.setProducto(producto);
    }

    @PutMapping("/editarProducto")
    public Producto modificarProducto(@RequestBody Producto producto){
        return productoService.modificarProducto(producto);
    }
//    @PutMapping("/restarStock/{id}/{cantidadARestar}")
//    public Producto restarStock(@PathVariable(value = "id") Long id, @PathVariable(value = "cantidadARestar") int cantidadARestar){
//        return productoService.restarStock(id,cantidadARestar);
//    }

    @DeleteMapping("/borrarProducto/{id}")
    public String borrarProducto(@PathVariable(value = "id")Long id){
        return productoService.borrarProducto(id);
    }

}
