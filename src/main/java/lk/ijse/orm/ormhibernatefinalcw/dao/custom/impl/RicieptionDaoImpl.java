package lk.ijse.orm.ormhibernatefinalcw.dao.custom.impl;

import lk.ijse.orm.ormhibernatefinalcw.config.SessionFactoryConfiguration;
import lk.ijse.orm.ormhibernatefinalcw.dao.custom.RicieptionDao;
import lk.ijse.orm.ormhibernatefinalcw.entity.Riciepion;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RicieptionDaoImpl implements RicieptionDao {


    private final SessionFactoryConfiguration sessionFactoryConfiguration = SessionFactoryConfiguration.getInstance();

    @Override
    public boolean save(Riciepion t) throws Exception {
        Session session = sessionFactoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.persist(t);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }finally {
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public boolean update(Riciepion t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean deleteByPK(String pk) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteByPK'");
    }

    @Override
    public List<Riciepion> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Riciepion search(int id) {
        return null;
    }

    @Override
    public Riciepion findById(int id) {
        return null;
    }

}
