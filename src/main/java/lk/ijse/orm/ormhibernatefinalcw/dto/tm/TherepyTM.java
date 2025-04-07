package lk.ijse.orm.ormhibernatefinalcw.dto.tm;

import lk.ijse.orm.ormhibernatefinalcw.dto.ProgrammeDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TherepyTM {
    private int id;
    private String name;
    private String proName;
    private int contact;
    private ProgrammeDto programme;  // This is a DTO, not an entity

//    public void setProgramme(ProgrammeDto programme) {
//        this.programme = programme;
//    }

    public TherepyTM(int id, String name, String proName, int contact) {
        this.id = id;
        this.name = name;
        this.proName = proName;
        this.contact = contact;
    }
}