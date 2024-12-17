package com.dago.todo_api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Veuillez renseigner le prénom")
    private String firstName;

    @NotEmpty(message = "Veuillez renseigner le nom")
    private String lastName;

    @NotEmpty(message = "Veuillez renseigner le nom")
    private String password;

    @NotEmpty(message = "Veuillez renseigner votre mail")
    @Email(message = "Votre adresse mail n'est pas valide")
    private String email;

    @NotEmpty(message = "Veuillez renseigner le nom d'utilisateur")
    private String username;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Category> categories;
}
