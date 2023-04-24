package com.coderhouse.EntregaFinal.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "FACTURA")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "factura_id")
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(name = "tipo_factura")
    private char tipoFactura;

    @Column(name = "total_factura")
    private double totalFactura;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @OneToMany(mappedBy = "factura", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<DetalleFactura> detalleFactura;

    public DetalleFactura agregarDetalle(DetalleFactura detalleFactura){
        getDetalleFactura().add(detalleFactura);
        detalleFactura.setFactura(this);
        return detalleFactura;
    }

    public DetalleFactura removerDetalle(DetalleFactura detalleFactura){
        getDetalleFactura().remove(detalleFactura);
        detalleFactura.setFactura(null);
        return detalleFactura;
    }

    @Override
    public String toString() {
        return "Factura: cliente = " + cliente + "; tipoFactura = " + tipoFactura + "; totalFactura = " + totalFactura + "; empresa = " + empresa + "; detalleFactura = " + detalleFactura;
    }
}
