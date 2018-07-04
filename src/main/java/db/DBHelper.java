package db;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;

public class DBHelper {
    private static Session session;
    private static Transaction transaction;

    public DBHelper() {
    }

    public static void save(Object object) {
        session = HibernateUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public static void update(Object object) {
        session = HibernateUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            session.update(object);
            transaction.commit();
        } catch (HibernateException var5) {
            transaction.rollback();
            var5.printStackTrace();
        } finally {
            session.close();
        }

    }

    public static void delete(Object object) {
        session = HibernateUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
        } catch (HibernateException var5) {
            transaction.rollback();
            var5.printStackTrace();
        } finally {
            session.close();
        }

    }

    public static <T> List<T> getAll(Class classType) {
        session = HibernateUtil.getSessionFactory().openSession();
        List results = null;

        try {
            Criteria criteria = session.createCriteria(classType);
            results = criteria.list();
        } catch (HibernateException var6) {
            var6.printStackTrace();
        } finally {
            session.close();
        }

        return results;
    }
}
