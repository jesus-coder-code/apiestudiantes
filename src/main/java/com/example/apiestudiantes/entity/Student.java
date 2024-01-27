package com.example.apiestudiantes.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;



@Data
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    @NotBlank
    @NotNull(message = "debe llenarse")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "solo se permiten letras")
    private String firstname;

    @Column
    @NotBlank
    @NotNull(message = "apellido debe llenarse")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "solo se permiten letras")
    private String lastname;

    @Column(unique = true)
    @NotBlank(message = "ingrese un email")
    @Email(message = "email no valido")
    private String email;
}
