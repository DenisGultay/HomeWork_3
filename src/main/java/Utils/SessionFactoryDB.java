package Utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

/**
 * Created by Користувач on 02.08.2017.
 */
public class SessionFactoryDB {

private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public SessionFactoryDB() {
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
