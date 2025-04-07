package lk.ijse.orm.ormhibernatefinalcw.dao.custom.impl;

import lk.ijse.orm.ormhibernatefinalcw.config.SessionFactoryConfiguration;
import lk.ijse.orm.ormhibernatefinalcw.dao.custom.TherepistDao;
import lk.ijse.orm.ormhibernatefinalcw.entity.Therepist;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class TherepistDaoImpl implements TherepistDao {

    SessionFactoryConfiguration configuration = SessionFactoryConfiguration.getInstance();

    @Override
    public boolean save(Therepist t) throws Exception {
        Session session = configuration.getSession();
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
    public boolean update(Therepist t) {
        Session session = configuration.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.merge(t);
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
        Session session = configuration.getSession();
        Transaction transaction = session.beginTransaction();
        Therepist therepist = session.get(Therepist.class,pk);
        try {
            session.remove(therepist);
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
    public List<Therepist> getAll() {
        Session session = configuration.getSession();
        Query<Therepist> query = session.createQuery("from therepist", Therepist.class);
        return query.list();
    }

    @Override
    public Therepist search(int id) {
        Session session = configuration.getSession();
        Transaction transaction = session.beginTransaction();

        Therepist therepist = null;
        try {
            therepist = session.get(Therepist.class,id);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            if (session != null){
                session.close();
            }
        }
        return therepist;
    }

    @Override
    public Therepist findById(int id) {
        Session session = configuration.getSession();
        return session.get(Therepist.class, id);
    }

}

