package lk.ijse.orm.ormhibernatefinalcw.service;

import lk.ijse.orm.ormhibernatefinalcw.service.custom.impl.*;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    private ServiceFactory(){}

    public static ServiceFactory getInstance() {
        return serviceFactory != null ? serviceFactory : new ServiceFactory();
    }

    public AdminServiceImpl getService(Type type){
        switch (type){
            case ADMIN :
                return new AdminServiceImpl();

            case RICIEPTION:
               return new RicieptionServiceImpl();

            case PATCIENT:
                return new PatcientServiceImpl();

            case PROGRAMME:
                return new ProgrammeServiceImpl();

            case THEREPIST:
                return new TherepistServiceImpl();

            case THE_SESSION:
                return new SessionServiceImpl();

            case PAYMENT:
                return new PaymentServiceImpl();

            default:
                return null;
        }
    }

    public enum Type{
        ADMIN,RICIEPTION,PATCIENT,PROGRAMME,THEREPIST,THE_SESSION,PAYMENT
    }
}
