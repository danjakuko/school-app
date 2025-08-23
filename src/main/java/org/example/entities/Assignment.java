package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table (name = "assignments")
@Data

public class Assignment extends AbstractEntity {
    @Column (name = "description")
    private String description;
    @Column (name = "due_date")
    private LocalDate dueDate;
    @ManyToOne
    @JoinColumn (name = "course_id")
    private Course course;
}
