package lk.ijse.orm.ormhibernatefinalcw.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProgrammeTM {
    public ProgrammeTM(String name2) {
        this.name = name2;
    }
    private int id;
    private String name;
    private String duration;
    private Double fees;
}
