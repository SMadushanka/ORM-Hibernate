package lk.ijse.orm.ormhibernatefinalcw.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatcientDto {
    private int id;
    private String name;
    protected ProgrammeDto programmeDto;
    private String email;
    private int contact;

    public PatcientDto(String name, ProgrammeDto programmeDto, String email, int contact) {
        this.name = name;
        this.programmeDto = programmeDto;
        this.email = email;
        this.contact = contact;
    }
}
