package lk.ijse.orm.ormhibernatefinalcw.dao;

import lk.ijse.orm.ormhibernatefinalcw.dao.custom.impl.*;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return daoFactory != null ? daoFactory : new DaoFactory();
    }

    public SuperDao getDao(Type type) {
        switch (type) {
            case ADMIN:
                return new AdminDaoImpl();
            case PATCIENT:
                return new PatcientDaoImpl();
            case RICIEPTION:
                return new RicieptionDaoImpl();
            case PROGRAMME:
                return new ProgrammeDaoImpl();
            case THEREPIST:
                return new TherepistDaoImpl();
            case THE_SESSION:
                return new SessionDaoImpl();
            case PAYMENT:
                return new PatmentDaoImpl();
            default:
                return null;
        }
    }

    public enum Type {
        ADMIN, RICIEPTION, PATCIENT, PROGRAMME, THEREPIST,THE_SESSION,PAYMENT
    }
}
