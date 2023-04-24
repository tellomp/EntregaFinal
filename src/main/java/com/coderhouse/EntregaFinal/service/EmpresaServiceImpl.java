package com.coderhouse.EntregaFinal.service;


import com.coderhouse.EntregaFinal.entities.Empresa;
import com.coderhouse.EntregaFinal.repository.EmpresaRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmpresaServiceImpl implements EmpresaService {
    private SessionFactory sessionFactory;

    @Autowired
    EmpresaRepository empresaRepository;

    public Empresa getEmpresa(Long id){
        Empresa empresaObtener = empresaRepository.findById(id).orElseThrow(RuntimeException::new);

        return empresaObtener;
    }

    public Empresa setEmpresa(Empresa empresa){
        return empresaRepository.save(empresa);
    }

    public Empresa modificarEmpresa(Empresa empresa){
        Empresa empresaModificado = empresaRepository.findById(empresa.getId()).get();
        empresaModificado.setNombre(empresa.getNombre());
        return empresaRepository.save(empresa);
    }

    public String borrarEmpresa(Long id){
        Empresa empresaBorrado = empresaRepository.findById(id).orElseThrow(RuntimeException::new);
        empresaRepository.deleteById(id);
        return "Borraste a " + empresaBorrado.getNombre();
    }


}
