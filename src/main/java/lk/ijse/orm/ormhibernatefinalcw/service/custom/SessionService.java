package lk.ijse.orm.ormhibernatefinalcw.service.custom;

import lk.ijse.orm.ormhibernatefinalcw.dto.SessionDto;

import java.util.ArrayList;

public interface SessionService {
    boolean addSession(SessionDto dto) throws Exception;

    boolean deleteSession(int sessionTMId) throws Exception;

    boolean updateSession(SessionDto dto);

    ArrayList<SessionDto> getAll();
}
