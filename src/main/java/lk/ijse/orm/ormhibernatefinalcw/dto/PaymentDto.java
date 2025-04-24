package lk.ijse.orm.ormhibernatefinalcw.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDto {
    private int id;
    private LocalDate date;
    private Double amount;
    private int patcient;
    private int programme;

    public PaymentDto(LocalDate now, double double1, int paID, int id2) {
        //TODO Auto-generated constructor stub
        this.date = now;
        this.amount = double1;
        this.patcient = paID;
        this.programme = id2;
    }
}

