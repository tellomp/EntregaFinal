package com.coderhouse.EntregaFinal.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Entity
@Table(name = "CLIENTE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private long id;

    @Column(name = "Nombre")
    @NotBlank(message = "Nombre no puede estar vacio")
    @Pattern(regexp = "[A-Za-z ]+", message = "Solo puedes poner letras")
    private String nombre;

    @Column(name = "Apellido")
    @NotBlank(message = "Apellido no puede estar vacio")
    @Pattern(regexp = "[A-Za-z ]+", message = "Solo puedes poner letras")
    private String apellido;

    @Column(name = "DNI")
    @Digits(fraction = 0, integer = 6, message = "Solo puede tener 6 digitos")
    private int dni;

    @Column(name = "Direccion")
    @Pattern(regexp = "[a-zA-Z0-9 ]+", message = "Solo puedes poner letras o numeros")
    @NotBlank(message = "Direccion no puede estar vacia")
    private String direccion;

}
