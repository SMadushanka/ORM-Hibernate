package lk.ijse.orm.ormhibernatefinalcw.service.custom;

import lk.ijse.orm.ormhibernatefinalcw.dto.RicieptionDto;

import java.sql.SQLException;

public interface RicieptionService {

    Boolean addNewRicieption(RicieptionDto ricieptionDto) throws Exception;
}
