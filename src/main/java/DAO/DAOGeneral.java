package DAO;

import Utils.DatabaseException;
import Utils.SessionFactoryDB;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;

/**
 * Created by Користувач on 03.08.2017.
 */
public abstract class DAOGeneral<K extends Serializable, T> implements DAO<K, T> {


    @Override
    public void create(T entity) {
        Transaction transaction = null;
        try (Session session = SessionFactoryDB.getSession()) {
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (RuntimeException e1) {
                    throw new DatabaseException(e1);
                }
            }
            throw new DatabaseException(e);
        }
    }

    @Override
    public void update(T entity) {
        Transaction transaction = null;
        try (Session session = SessionFactoryDB.getSession()) {
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (RuntimeException e1) {
                    throw new DatabaseException(e1);
                }
            }
            throw new DatabaseException(e);
        }
    }

    @Override
    public void delete(T entity) {
        Transaction transaction = null;
        try (Session session = SessionFactoryDB.getSession()) {
            transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (RuntimeException e1) {
                    throw new DatabaseException(e1);
                }
            }
        }
    }
}
