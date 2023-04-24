package com.coderhouse.EntregaFinal.repository;


import com.coderhouse.EntregaFinal.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
