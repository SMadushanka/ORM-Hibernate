package lk.ijse.orm.ormhibernatefinalcw.service.custom;

import lk.ijse.orm.ormhibernatefinalcw.dto.AdminDto;

import java.sql.SQLException;

public interface AdminService {
    Boolean addNewAdmin(AdminDto adminDto) throws Exception;
}
