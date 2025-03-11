package com.project.todolist.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(unique = true, nullable = false, updatable = false)
    private Long id;

    @Size(min = 1, max = 50)
    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm")
    @Column
    private LocalDateTime dueDate;

    @Column
    private boolean isCompleted = false;
}
