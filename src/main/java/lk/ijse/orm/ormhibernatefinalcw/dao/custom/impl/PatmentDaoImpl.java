package lk.ijse.orm.ormhibernatefinalcw.dao.custom.impl;

import lk.ijse.orm.ormhibernatefinalcw.config.SessionFactoryConfiguration;
import lk.ijse.orm.ormhibernatefinalcw.dao.custom.PaymentDao;
import lk.ijse.orm.ormhibernatefinalcw.entity.Payment;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PatmentDaoImpl implements PaymentDao {

    SessionFactoryConfiguration sessionFactoryConfiguration = SessionFactoryConfiguration.getInstance();

    @Override
    public boolean save(Payment payment) throws Exception {
        Session session = sessionFactoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.persist(payment);
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
    public boolean update(Payment payment) {
        return false;
    }

    @Override
    public boolean deleteByPK(String pk) throws Exception {
        return false;
    }

    @Override
    public List<Payment> getAll() {
        return List.of();
    }

    @Override
    public Payment search(int id) {
        return null;
    }

    @Override
    public Payment findById(int id) {
        return null;
    }
}

