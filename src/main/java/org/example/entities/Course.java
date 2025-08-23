package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table (name = "courses")
@Data
public class Course extends AbstractEntity {
    @Column (name = "name")
    private String name;
    @ManyToOne
    @JoinColumn (name = "teacher_id")
    private Teacher teacher;
    @OneToMany (mappedBy = "course")
    private List<Student> students;
}
