package org.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table (name = "communications")
@Data
public class Communication extends AbstractEntity{
}
