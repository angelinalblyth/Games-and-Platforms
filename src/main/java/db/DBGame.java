package db;

import models.Console;
import models.Game;
import models.Owner;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;


public class DBGame {
    private static Session session;
    private static Transaction transaction;

    public DBGame() {
    }

    public static List<Console> getListOfConsolesForGame(Game game) {
        session = HibernateUtil.getSessionFactory().openSession();
        List results = null;

        try {
            Criteria criteria = session.createCriteria(Console.class);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            criteria.createAlias("games", "game");
            criteria.add(Restrictions.eq("game.id", game.getId()));
            results = criteria.list();
        } catch (HibernateException var6) {
            var6.printStackTrace();
        } finally {
            session.close();
        }

        return results;
    }

    public static List<Owner> getOwnersForGame(Game game) {
        session = HibernateUtil.getSessionFactory().openSession();
        List results = null;

        try {
            Criteria cr = session.createCriteria(Owner.class);
            cr.add(Restrictions.eq("game", game));
            results = cr.list();
        } catch (HibernateException var6) {
            var6.printStackTrace();
        } finally {
            session.close();
        }

        return results;
    }
}
