package org.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table (name = "teachers")
@Data
public class Teacher extends AbstractEntity {
}
