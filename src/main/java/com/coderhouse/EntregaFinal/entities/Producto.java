package com.coderhouse.EntregaFinal.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "PRODUCTO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","referenceList"})
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(name = "Nombre")
    @NotBlank(message = "Nombre no puede estar vacio")
    @Pattern(regexp = "[A-Za-z ]+", message = "Solo puedes poner letras")
    private String nombre;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "precio")
    @Digits(integer = 5, fraction = 2)
    private double precio;

    @Column(name = "Cantidad_En_Stock")
    @PositiveOrZero
    @Digits(integer = 6, fraction = 0)
    private int cantidadEnStock;

    @Override
    public String toString() {
        return "Producto: nombre = " + nombre + "; descripcion = " + descripcion + "; precio = " + precio + "; cantidadEnStock = " + cantidadEnStock + "; hashCode = " + hashCode();
    }


}
