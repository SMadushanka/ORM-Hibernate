package lk.ijse.orm.ormhibernatefinalcw.service.custom.impl;

import lk.ijse.orm.ormhibernatefinalcw.dao.DaoFactory;
import lk.ijse.orm.ormhibernatefinalcw.dao.DaoFactory.Type;
import lk.ijse.orm.ormhibernatefinalcw.dao.custom.AdminDao;
import lk.ijse.orm.ormhibernatefinalcw.dto.AdminDto;
import lk.ijse.orm.ormhibernatefinalcw.entity.Admin;
import lk.ijse.orm.ormhibernatefinalcw.service.custom.AdminService;

public class AdminServiceImpl implements AdminService{

    AdminDao adminDao = (AdminDao) DaoFactory.getInstance().getDao(Type.ADMIN);

    @Override
    public Boolean addNewAdmin(AdminDto adminDto) throws Exception{
        return adminDao.save(new Admin(adminDto.getEmail(),adminDto.getPassword()));
    }

}
