package lk.ijse.orm.ormhibernatefinalcw.dao;

import java.util.List;

public interface CrudDao<T> extends SuperDao{
    boolean save(T t) throws Exception;
    boolean update(T t);
    boolean deleteByPK(String pk) throws Exception;
    List<T> getAll();
    T search(int id);
    T findById(int id);
}