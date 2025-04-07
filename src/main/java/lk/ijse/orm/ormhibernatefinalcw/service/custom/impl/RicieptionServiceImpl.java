package lk.ijse.orm.ormhibernatefinalcw.service.custom.impl;

import lk.ijse.orm.ormhibernatefinalcw.dao.DaoFactory;
import lk.ijse.orm.ormhibernatefinalcw.dao.DaoFactory.Type;
import lk.ijse.orm.ormhibernatefinalcw.dao.custom.RicieptionDao;
import lk.ijse.orm.ormhibernatefinalcw.dto.RicieptionDto;
import lk.ijse.orm.ormhibernatefinalcw.entity.Riciepion;
import lk.ijse.orm.ormhibernatefinalcw.service.custom.RicieptionService;

public class RicieptionServiceImpl implements RicieptionService{

    RicieptionDao ricieptionDao = (RicieptionDao) DaoFactory.getInstance().getDao(Type.RICIEPTION);

    @Override
    public Boolean addNewRicieption(RicieptionDto ricieptionDto) throws Exception{
        return ricieptionDao.save(new Riciepion(ricieptionDto.getEmail(), ricieptionDto.getPassword()));
    }

}

