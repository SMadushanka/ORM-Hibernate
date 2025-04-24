package lk.ijse.orm.ormhibernatefinalcw.service.custom.impl;

import lk.ijse.orm.ormhibernatefinalcw.dao.DaoFactory;
import lk.ijse.orm.ormhibernatefinalcw.dao.custom.PatcientDao;
import lk.ijse.orm.ormhibernatefinalcw.dao.custom.ProgrammeDao;
import lk.ijse.orm.ormhibernatefinalcw.dto.PatcientDto;
import lk.ijse.orm.ormhibernatefinalcw.dto.ProgrammeDto;
import lk.ijse.orm.ormhibernatefinalcw.entity.Patcient;
import lk.ijse.orm.ormhibernatefinalcw.entity.Programme;
import lk.ijse.orm.ormhibernatefinalcw.service.custom.PatcientService;

import java.util.ArrayList;
import java.util.List;

public class PatcientServiceImpl implements PatcientService {
    PatcientDao patcientDao = (PatcientDao) DaoFactory.getInstance().getDao(DaoFactory.Type.PATCIENT);
    ProgrammeDao programmeDao = (ProgrammeDao) DaoFactory.getInstance().getDao(DaoFactory.Type.PROGRAMME);

    @Override
    public PatcientDto search(int id) {
        Patcient patcient = patcientDao.search(id);
        PatcientDto patcientDto = new PatcientDto();

        patcientDto.setId(patcient.getId());
        patcientDto.setName(patcient.getName());
        patcientDto.setContact(patcient.getContact());

        return patcientDto;
    }

    @Override
    public boolean addPatcient(PatcientDto patcientDto) throws Exception{
        Programme programme = programmeDao.findById(patcientDto.getProgrammeDto().getId());
        Patcient patcient = new Patcient();

        patcient.setId(patcientDto.getId());
        patcient.setName(patcientDto.getName());
        patcient.setProgramme(programme);
        patcient.setEmail(patcientDto.getEmail());
        patcient.setContact(patcientDto.getContact());

        boolean resp = patcientDao.save(patcient);

        if (resp){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public ArrayList<PatcientDto> getAll() {
        ArrayList<PatcientDto> patcientDtos = new ArrayList<>();
        List<Patcient> patcients = patcientDao.getAll();

        for (Patcient patcient : patcients) {
            Programme programme = patcient.getProgramme(); // Get Programme entity directly

            if (programme != null) {
                ProgrammeDto programmeDto = new ProgrammeDto(programme.getName()); // Convert Programme to ProgrammeDto

                patcientDtos.add(new PatcientDto(
                        patcient.getId(),
                        patcient.getName(),
                        programmeDto,
                        patcient.getEmail(),
                        patcient.getContact()
                ));
            }
        }
        return patcientDtos;
    }

    @Override
    public boolean deletePatcient(int id) throws Exception{
        return patcientDao.deleteByPK(String.valueOf(id));
    }

    @Override
    public int saves(PatcientDto patcientDto) throws Exception{
        Programme programme = programmeDao.findById(patcientDto.getProgrammeDto().getId());
        Patcient patcient = new Patcient();

        patcient.setId(patcientDto.getId());
        patcient.setName(patcientDto.getName());
        patcient.setProgramme(programme);
        patcient.setEmail(patcientDto.getEmail());
        patcient.setContact(patcientDto.getContact());

        return patcientDao.saves(patcient);
    }

}