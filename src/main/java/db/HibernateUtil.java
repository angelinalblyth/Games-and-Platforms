package db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    public HibernateUtil() {
    }

    private static SessionFactory buildSessionFactory() {
        try {
            return (new Configuration()).configure().buildSessionFactory();
        } catch (Throwable var1) {
            System.err.println("Initial SessionFactory creation failed." + var1);
            throw new ExceptionInInitializerError(var1);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
