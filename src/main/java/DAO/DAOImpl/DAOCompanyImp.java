package DAO.DAOImpl;

import DAO.DAOCompany;
import DAO.DAOGeneral;
import Entityes.Company;
import Utils.DatabaseException;
import Utils.SessionFactoryDB;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Користувач on 03.08.2017.
 */
public class DAOCompanyImp extends DAOGeneral<Integer, Company> implements DAOCompany {

    @Override
    public Optional<Company> read(Integer key) {
        Transaction transaction = null;
        Company company = null;
        try (Session session = SessionFactoryDB.getSession()) {
            transaction = session.beginTransaction();
            company = session.get(Company.class, key);
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
        return Optional.of(company);
    }

    @Override
    public List<Company> getAll() {
        Transaction transaction = null;
        List<Company> company = new ArrayList<>();
        try (Session session = SessionFactoryDB.getSession()) {
            transaction = session.beginTransaction();
            company = (List<Company>)session.createQuery("FROM Company").list();
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
        return company;
    }
}
