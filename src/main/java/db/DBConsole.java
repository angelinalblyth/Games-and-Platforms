package db;

import models.Console;
import models.Game;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;


public class DBConsole {
    private static Session session;
    private static Transaction transaction;

    public DBConsole() {
    }

    public static void addGameToConsole(Console console, Game game) {
        console.addGame(game);
        game.addConsole(console);
        DBHelper.update(console);
    }

    public static List<Game> getListOfGamesForConsole(Console console) {
        session = HibernateUtil.getSessionFactory().openSession();
        List results = null;

        try {
            Criteria criteria = session.createCriteria(Game.class);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            criteria.createAlias("consoles", "console");
            criteria.add(Restrictions.eq("console.id", console.getId()));
            results = criteria.list();
        } catch (HibernateException var6) {
            var6.printStackTrace();
        } finally {
            session.close();
        }

        return results;
    }
}
