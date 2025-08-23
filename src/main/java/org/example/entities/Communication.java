package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "communications")
@Data
public class Communication extends AbstractEntity {
    @Column(name = "message")
    private String message;
    @Column(name = "sent_date")
    private LocalDate sentDate;

    @ManyToOne
    @JoinColumn(name = "students_id")
    private Student students;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

}
