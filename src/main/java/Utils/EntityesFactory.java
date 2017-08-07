package Utils;

import Entityes.Company;

/**
 * Created by Користувач on 07.08.2017.
 */
public class EntityesFactory {



    public  static Company getCompanyInstance() {

        return new Company("Amazon");
    }
}
