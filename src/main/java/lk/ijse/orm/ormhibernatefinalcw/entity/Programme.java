package lk.ijse.orm.ormhibernatefinalcw.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "programme")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "programme")
public class Programme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String duration;
    private Double fees;

    public Programme(String name, String duration, Double fees) {
        this.name = name;
        this.duration = duration;
        this.fees = fees;
    }
}

