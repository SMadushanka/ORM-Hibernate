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
    public Payment(int id2, LocalDate date2, Double amount2, int patcient2, Programme programme2) {
        //TODO Auto-generated constructor stub
    }

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

