package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table (name = "assignments")
@Data

public class Assignment extends AbstractEntity {
}
