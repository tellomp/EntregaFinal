package com.coderhouse.EntregaFinal.repository;


import com.coderhouse.EntregaFinal.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

   Optional<Producto> getProductoByNombre(String nombre);

    Optional<Producto> getProductoById(Long id);

}
