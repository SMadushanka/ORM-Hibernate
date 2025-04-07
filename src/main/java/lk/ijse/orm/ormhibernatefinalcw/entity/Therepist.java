package lk.ijse.orm.ormhibernatefinalcw.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "therepist")
@Table(name = "therepist")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Therepist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "pro_Id")
    private Programme programme;
    private int contact;

}
