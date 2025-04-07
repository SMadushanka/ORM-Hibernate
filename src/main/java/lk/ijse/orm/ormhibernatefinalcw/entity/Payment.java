package lk.ijse.orm.ormhibernatefinalcw.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "payment")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    private Double amount;
    @ManyToOne
    @JoinColumn(name = "Pat_Id")
    private Patcient patcient;

    @ManyToOne
    @JoinColumn(name = "Pro_Id")
    private Programme programme;
}

