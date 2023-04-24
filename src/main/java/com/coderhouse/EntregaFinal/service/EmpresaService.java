package com.coderhouse.EntregaFinal.service;

import com.coderhouse.EntregaFinal.entities.Empresa;

public interface EmpresaService {
    public Empresa getEmpresa(Long id);

    public Empresa setEmpresa(Empresa empresa);

    public Empresa modificarEmpresa(Empresa empresa);

    public String borrarEmpresa(Long id);

}

