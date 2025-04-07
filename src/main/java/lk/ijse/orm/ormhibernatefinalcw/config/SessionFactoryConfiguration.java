package lk.ijse.orm.ormhibernatefinalcw.config;

import com.mysql.cj.xdevapi.SessionFactory;
import lk.ijse.orm.ormhibernatefinalcw.entity.*;
import org.hibernate.Session;

import java.lang.module.Configuration;

public class SessionFactoryConfiguration {
    private static SessionFactoryConfiguration sessionFactoryConfiguration;
    private final SessionFactory sessionFactory;

    private SessionFactoryConfiguration() {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Admin.class)
                .addAnnotatedClass(Riciepion.class)
                .addAnnotatedClass(Programme.class)
                .addAnnotatedClass(Therepist.class)
                .addAnnotatedClass(ThereSession.class)
                .addAnnotatedClass(Payment.class);
        sessionFactory = configuration.buildSessionFactory();
    }
    public static SessionFactoryConfiguration getInstance() {
        if (sessionFactoryConfiguration == null) {
            sessionFactoryConfiguration = new SessionFactoryConfiguration();
        }
        return sessionFactoryConfiguration;
    }
    public Session getSession() {
        return sessionFactory.openSession();
    }
}
