package com.coderhouse.EntregaFinal.service;


import com.coderhouse.EntregaFinal.dto.DetalleFacturaDto;
import com.coderhouse.EntregaFinal.entities.DetalleFactura;
import com.coderhouse.EntregaFinal.entities.Producto;
import com.coderhouse.EntregaFinal.exception.DbException;
import com.coderhouse.EntregaFinal.repository.FacturaRepository;
import com.coderhouse.EntregaFinal.repository.ProductoRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductoServiceImpl implements ProductoService {
    private SessionFactory sessionFactory;

    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    FacturaRepository facturaRepository;

    public Producto getProducto(Long id){
       Optional<Producto> productoObtener = productoRepository.findById(id);
       if(productoObtener.isPresent()){
           return productoObtener.get();
       }
       else{
           throw new DbException("No encontre el producto con el id " + id);
       }
    }
    public Producto getProductoByNombre(String nombre){
        Producto producto = productoRepository.getProductoByNombre(nombre).orElseThrow(() -> new DbException("No existe el producto" + nombre));
        producto.setPrecio(producto.getPrecio());
        producto.setDescripcion(producto.getDescripcion());
        return producto;
    }

    public Producto getProductoById(Long id){
        return productoRepository.getProductoById(id).orElseThrow(() -> new DbException("No existe el producto"));
    }
    public List<Producto> obtenerTodosLosProductos(){
        return productoRepository.findAll();
    }
    public Producto setProducto(Producto producto){
        return productoRepository.save(producto);
    }

    public Producto modificarProducto(Producto producto){
        Producto productoModificado = productoRepository.findById(producto.getId()).get();
        productoModificado.setNombre(producto.getNombre());
        productoModificado.setDescripcion(producto.getDescripcion());
        productoModificado.setId(producto.getId());
        productoModificado.setCantidadEnStock(producto.getCantidadEnStock());
        productoModificado.setPrecio(producto.getPrecio());
        return productoRepository.save(producto);
    }

//    public Producto restarStock(Long id, int cantidadARestar) {
//        Producto producto = productoRepository.findById(id).orElseThrow(RuntimeException::new);
//            if (cantidadARestar > producto.getCantidadEnStock()) {
//                log.error("No hay suficiente stock");
//                throw new DbException("No hay suficiente stock para esa cantidad. Solo tenemos " + producto.getCantidadEnStock() + " en stock.");
//            } else{
//                producto.setCantidadEnStock(producto.getCantidadEnStock() - cantidadARestar);
//            }
//            return productoRepository.save(producto);
//        }

//        public void restarStock(List<Producto> productoList) {
//            DetalleFactura detalleFactura =facturaRepository.
//            for (Producto producto : productoList) {
//                if (producto.getCantidadEnStock() == 0) {
//                    log.error("No hay suficiente stock");
//                    throw new DbException("No hay suficiente stock para esa cantidad. Solo tenemos " + producto.getCantidadEnStock() + " en stock.");
//                } else {
//                    producto.setCantidadEnStock(producto.getCantidadEnStock() - cantidad);
//                }
//            }
//            productoRepository.save(productoList);
//        }



    public void restarStock(List<Producto> productoList){
        for(Producto producto : productoList){
            if(producto.getCantidadEnStock() == 0){
                throw new DbException("No hay mas productos en stock de: " + producto.getNombre());
            }else{
                producto.setCantidadEnStock(producto.getCantidadEnStock() - 1);
            }
        }
        productoRepository.saveAll(productoList);
    }

    public String borrarProducto(Long id){
        Producto productoBorrado = productoRepository.findById(id).orElseThrow(RuntimeException::new);
        productoRepository.deleteById(id);
        return "Borraste a " + productoBorrado.getNombre();
    }


}
