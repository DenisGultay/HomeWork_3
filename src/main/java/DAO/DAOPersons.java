package DAO;

import Entityes.Persons;

/**
 * Created by Користувач on 03.08.2017.
 */
public interface DAOPersons extends DAO<Integer, Persons> {

    void addSkillsToPersons (Persons person, int personId);
}
