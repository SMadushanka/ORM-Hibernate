package lk.ijse.orm.ormhibernatefinalcw.dao.custom;

import lk.ijse.orm.ormhibernatefinalcw.dao.CrudDao;
import lk.ijse.orm.ormhibernatefinalcw.entity.Patcient;

public interface PatcientDao extends CrudDao<Patcient> {
    int saves(Patcient patcient);

}
