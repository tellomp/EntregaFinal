package com.coderhouse.EntregaFinal.repository;


import com.coderhouse.EntregaFinal.entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura,Long> {
}
