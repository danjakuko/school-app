package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table (name = "students")
@Data
public class Student extends AbstractEntity {
    @Column (name = "first_name")
    private String firstName;
    @Column (name = "last_name")
    private String lastName;
    @Column (name = "birth_date")
    private LocalDate birthDate;
    @ManyToOne
    @JoinColumn (name = "course_id")
    private Course course;
}
