package org.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table (name = "courses")
@Data
public class Course extends AbstractEntity {
}
