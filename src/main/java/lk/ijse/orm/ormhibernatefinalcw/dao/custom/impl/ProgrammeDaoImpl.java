package lk.ijse.orm.ormhibernatefinalcw.dao.custom.impl;

import lk.ijse.orm.ormhibernatefinalcw.config.SessionFactoryConfiguration;
import lk.ijse.orm.ormhibernatefinalcw.dao.custom.ProgrammeDao;
import lk.ijse.orm.ormhibernatefinalcw.entity.Programme;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ProgrammeDaoImpl implements ProgrammeDao {

    SessionFactoryConfiguration sessionFactoryConfiguration = SessionFactoryConfiguration.getInstance();

    @Override
    public boolean save(Programme programme) throws Exception {
        Session session = sessionFactoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.persist(programme);
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
    public boolean update(Programme programme) {
        Session session = sessionFactoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.merge(programme);
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
    public boolean deleteByPK(String pk) throws Exception {
        Session session = sessionFactoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Programme programme = session.get(Programme.class,pk);

            if (programme != null){
                session.remove(programme);
                transaction.commit();
                return true;
            }
            return false;
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
    public List<Programme> getAll() {
        Session session = sessionFactoryConfiguration.getSession();
        Query<Programme> query = session.createQuery("from programme", Programme.class);
        return query.list();
    }

    @Override
    public Programme search(int id) {
        Session session = sessionFactoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        Programme programme = null;

        try {
            programme = session.get(Programme.class,id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }finally {
            if (session != null){
                session.close();
            }
        }
        return  programme;
    }

    @Override
    public Programme findById(int id) {
        Session session = sessionFactoryConfiguration.getSession();
        return session.get(Programme.class, id);
    }

}

