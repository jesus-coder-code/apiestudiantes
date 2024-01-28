package com.example.apiestudiantes.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    @NotBlank
    @NotNull(message = "debe añadir una descripcion de la tarea")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "solo se permiten letras")
    private String description;

    @Column
    @NotNull(message = "debe marcar si la tarea fue completada o no")
    private boolean complete;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @NotNull(message = "ingrese el id del estudiante")
    private Student student;

}
