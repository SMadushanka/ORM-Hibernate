package lk.ijse.orm.ormhibernatefinalcw.service.custom;

import lk.ijse.orm.ormhibernatefinalcw.dto.PatcientDto;

import java.util.ArrayList;

public interface PatcientService {
    boolean addPatcient(PatcientDto patcientDto) throws Exception;

    PatcientDto search(int id);

    boolean deletePatcient(int id) throws Exception;

    ArrayList<PatcientDto> getAll();
}

