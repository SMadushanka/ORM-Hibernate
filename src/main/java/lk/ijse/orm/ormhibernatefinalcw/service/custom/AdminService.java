package lk.ijse.orm.ormhibernatefinalcw.service.custom;

import lk.ijse.orm.ormhibernatefinalcw.dto.AdminDto;
import lk.ijse.orm.ormhibernatefinalcw.service.SuperService;

import java.sql.SQLException;

public interface AdminService extends SuperService {

    Boolean addNewAdmin(AdminDto adminDto) throws Exception;

}