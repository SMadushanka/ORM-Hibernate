package lk.ijse.orm.ormhibernatefinalcw.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "session")
@Table(name = "session")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ThereSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "therepist_Id")
    private Therepist therepist;
}
