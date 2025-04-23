package lk.ijse.orm.ormhibernatefinalcw.dao.custom.impl;

import lk.ijse.orm.ormhibernatefinalcw.config.SessionFactoryConfiguration;
import lk.ijse.orm.ormhibernatefinalcw.dao.custom.PatcientDao;
import lk.ijse.orm.ormhibernatefinalcw.entity.Patcient;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PatcientDaoImpl implements PatcientDao {

    private final SessionFactoryConfiguration sessionFactoryConfiguration = SessionFactoryConfiguration.getInstance();

    @Override
    public boolean save(Patcient patcient) throws Exception {
        Session session = sessionFactoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try{
            session.persist(patcient);
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
    public boolean update(Patcient patcient) {
        Session session = sessionFactoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try{
            session.merge(patcient);
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

            Patcient patcient = session.get(Patcient.class,pk);

            if (patcient != null){
                session.remove(patcient);
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
    public List<Patcient> getAll() {
        Session session = sessionFactoryConfiguration.getSession();
        Query<Patcient> query = session.createQuery("from patcient", Patcient.class);
        return query.list();
    }

    @Override
    public Patcient search(int id) {
        Session session = sessionFactoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        Patcient patcient = null;

        try {
            patcient = session.get(Patcient.class,id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }finally {
            if (session != null){
                session.close();
            }
        }
        return patcient;
    }

    @Override
    public Patcient findById(int id) {
        Session session = sessionFactoryConfiguration.getSession();
        return session.get(Patcient.class, id);
    }

}

