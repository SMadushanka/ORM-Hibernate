package lk.ijse.orm.ormhibernatefinalcw.dao.custom.impl;

import lk.ijse.orm.ormhibernatefinalcw.config.SessionFactoryConfiguration;
import lk.ijse.orm.ormhibernatefinalcw.dao.custom.SessionDao;
import lk.ijse.orm.ormhibernatefinalcw.entity.ThereSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SessionDaoImpl implements SessionDao {

    SessionFactoryConfiguration sessionFactoryConfiguration = SessionFactoryConfiguration.getInstance();

    @Override
    public boolean save(ThereSession thereSession) throws Exception {
        Session session = sessionFactoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.persist(thereSession);
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
    public boolean update(ThereSession thereSession) {
        Session session = sessionFactoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.merge(thereSession);
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
        ThereSession thereSession = session.get(ThereSession.class,pk);

        try{
            session.remove(thereSession);
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
    public List<ThereSession> getAll() {
        Session session = sessionFactoryConfiguration.getSession();
        Query<ThereSession> query = session.createQuery("from session", ThereSession.class);
        return query.list();
    }

    @Override
    public ThereSession search(int id) {
        Session session = sessionFactoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        ThereSession thereSession = null;
        try {
            thereSession = session.get(ThereSession.class,id);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            if (session != null){
                session.close();
            }
        }
        return thereSession;
    }

    @Override
    public ThereSession findById(int id) {
        Session session = sessionFactoryConfiguration.getSession();
        return session.get(ThereSession.class, id);
    }
}

