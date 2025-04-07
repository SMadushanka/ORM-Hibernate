package lk.ijse.orm.ormhibernatefinalcw.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SessionDto {
    private int id;
    private String name;
    private LocalDate date;
    private ThereoistDto thereoistDto;

    public SessionDto(String name, LocalDate date, ThereoistDto thereoistDto) {
        this.name = name;
        this.date = date;
        this.thereoistDto = thereoistDto;
    }
}

