package lk.ijse.orm.ormhibernatefinalcw.service.custom;

import lk.ijse.orm.ormhibernatefinalcw.dto.ProgrammeDto;
import lk.ijse.orm.ormhibernatefinalcw.service.SuperService;

import java.util.ArrayList;

public interface ProgrammeService extends SuperService {
    ArrayList<ProgrammeDto> getAll();

    ProgrammeDto search(int id);

    boolean addProgramme(ProgrammeDto programmeDto) throws Exception;

    boolean deleteProgramme(int id) throws Exception;

    boolean updateProgramme(ProgrammeDto programmeDto);
}
