package lk.ijse.orm.ormhibernatefinalcw.service.custom;

import lk.ijse.orm.ormhibernatefinalcw.dto.RicieptionDto;
import lk.ijse.orm.ormhibernatefinalcw.service.SuperService;

import java.sql.SQLException;

public interface RicieptionService extends SuperService {

    Boolean addNewRicieption(RicieptionDto ricieptionDto) throws Exception;

}