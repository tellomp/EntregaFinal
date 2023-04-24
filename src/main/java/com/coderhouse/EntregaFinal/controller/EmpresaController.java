package com.coderhouse.EntregaFinal.controller;


import com.coderhouse.EntregaFinal.entities.Empresa;
import com.coderhouse.EntregaFinal.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @GetMapping("/getEmpresa/{id}")
    public Empresa getEmpresa(@PathVariable(value = "id") Long id){
        return empresaService.getEmpresa(id);
    }

    @PostMapping("/setEmpresa")
    public Empresa setEmpresa(@RequestBody Empresa empresa){
        return empresaService.setEmpresa(empresa);
    }

    @PutMapping("/editarEmpresa")
    public Empresa modificarEmpresa(@RequestBody Empresa empresa){
        return empresaService.modificarEmpresa(empresa);
    }

    @DeleteMapping("/borrarEmpresa/{id}")
    public String borrarEmpresa(@PathVariable(value = "id")Long id){
        return empresaService.borrarEmpresa(id);
    }
}
