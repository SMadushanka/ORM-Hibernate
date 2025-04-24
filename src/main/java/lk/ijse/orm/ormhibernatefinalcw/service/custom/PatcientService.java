package lk.ijse.orm.ormhibernatefinalcw.service.custom;

import lk.ijse.orm.ormhibernatefinalcw.dto.PatcientDto;
import lk.ijse.orm.ormhibernatefinalcw.service.SuperService;

import java.util.ArrayList;

public interface PatcientService extends SuperService {

    PatcientDto search(int id);

    boolean addPatcient(PatcientDto patcientDto) throws Exception;

    ArrayList<PatcientDto> getAll();

    boolean deletePatcient(int id) throws Exception;

    int saves(PatcientDto patcientDto) throws Exception;
}


