package com.dago.todo_api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "todos")
public class Todo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Veuillez donner un titre à la tâche")
    private String title;

    private String description;

    private String status;

    private Date dueDate;

    private boolean favorite;

    private boolean done;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
