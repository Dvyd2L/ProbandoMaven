package com.arelance.prueba.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true) // Para incluir los campos de las superclase
public class User extends GenericCrudRecord<Integer> {
    private String nombre;
    private String apellido;
    private String dni;
}