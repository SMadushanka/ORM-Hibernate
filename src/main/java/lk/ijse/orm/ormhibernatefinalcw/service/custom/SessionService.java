package lk.ijse.orm.ormhibernatefinalcw.service.custom;

import lk.ijse.orm.ormhibernatefinalcw.dto.SessionDto;
import lk.ijse.orm.ormhibernatefinalcw.service.SuperService;

import java.util.ArrayList;

public interface SessionService extends SuperService {
    boolean addSession(SessionDto dto) throws Exception;

    boolean deleteSession(int sessionTMId) throws Exception;

    ArrayList<SessionDto> getAll();

    boolean updateSession(SessionDto dto);
}

