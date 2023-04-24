package com.coderhouse.EntregaFinal.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Entity
@Table(name = "DETALLE_FACTURA")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","referenceList"})
public class DetalleFactura implements Serializable {
    private static final long serialVesionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detalle_factura_id")
    @JsonIgnore
    private long id;

    @Column(name = "nombre_producto")
    @Pattern(regexp = "[A-Za-z ]+", message = "Solo puedes poner letras")
    private String nombreProducto;

    @Column(name = "precio_por_unidad")
    private double precioPorUnidad;

    @Column(name = "descripcion")
    private String descripcion;

//   @Column(name = "cantidad")
//    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "factura_id")
    @JsonBackReference
    private Factura factura;

}
