import DAO.DAOImpl.DAOCompanyImp;
import Entityes.Company;
import Utils.EntityesFactory;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.Map;

import static Utils.EntityesFactory.getCompanyInstance;

/**
 * Created by Користувач on 29.07.2017.
 */
public class Main {

    public static void main(final String[] args) throws Exception {

        DAOCompanyImp daoCompanyImp = new DAOCompanyImp();

        Company amazon = getCompanyInstance();
        daoCompanyImp.create(amazon);
    }
}