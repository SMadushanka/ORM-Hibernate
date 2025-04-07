package lk.ijse.orm.ormhibernatefinalcw.service.custom;

import lk.ijse.orm.ormhibernatefinalcw.dto.ThereoistDto;
import lk.ijse.orm.ormhibernatefinalcw.service.SuperService;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TherepistService extends SuperService{
    boolean addTherepist(ThereoistDto thereoistDto) throws Exception;

    ArrayList<ThereoistDto> getAll();

    boolean deleteTherepy(int id) throws Exception;

    boolean updateTherepist(ThereoistDto thereoistDto) throws Exception;

    ThereoistDto search(int id);
}
