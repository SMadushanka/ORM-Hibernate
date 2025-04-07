package lk.ijse.orm.ormhibernatefinalcw.service.custom.impl;

import lk.ijse.orm.ormhibernatefinalcw.dao.DaoFactory;
import lk.ijse.orm.ormhibernatefinalcw.dao.custom.ProgrammeDao;
import lk.ijse.orm.ormhibernatefinalcw.dto.ProgrammeDto;
import lk.ijse.orm.ormhibernatefinalcw.entity.Programme;
import lk.ijse.orm.ormhibernatefinalcw.service.custom.ProgrammeService;

import java.util.ArrayList;
import java.util.List;

public class ProgrammeServiceImpl implements ProgrammeService {

    ProgrammeDao programmeDao = (ProgrammeDao) DaoFactory.getInstance().getDao(DaoFactory.Type.PROGRAMME);

    @Override
    public boolean addProgramme(ProgrammeDto programmeDto) throws Exception {
        return programmeDao.save(new Programme(
                programmeDto.getName(),
                programmeDto.getDuration(),
                programmeDto.getFees()
        ));
    }

    @Override
    public boolean deleteProgramme(int id) throws Exception {
        return programmeDao.deleteByPK(String.valueOf(id));
    }

    @Override
    public boolean updateProgramme(ProgrammeDto programmeDto) {
        return programmeDao.update(new Programme(
                programmeDto.getName(),
                programmeDto.getDuration(),
                programmeDto.getFees()
        ));
    }

    @Override
    public ArrayList<ProgrammeDto> getAll() {
        ArrayList<ProgrammeDto>programmeDtos = new ArrayList<>();
        List<Programme>programmes = programmeDao.getAll();

        for (Programme programme  :programmes){
            programmeDtos.add(new ProgrammeDto(
                    programme.getId(),
                    programme.getName(),
                    programme.getDuration(),
                    programme.getFees()
            ));
        }
        return programmeDtos;
    }

    @Override
    public ProgrammeDto search(int id) {
        Programme programme = programmeDao.search(id);
        ProgrammeDto programmeDto = new ProgrammeDto();

        programmeDto.setId(programme.getId());
        programmeDto.setName(programme.getName());
        programmeDto.setDuration(programme.getDuration());
        programmeDto.setFees(programme.getFees());

        return programmeDto;
    }
}