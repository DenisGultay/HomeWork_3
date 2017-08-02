package DAO;

import Entityes.Projects;

/**
 * Created by Користувач on 03.08.2017.
 */
public interface DAOProjects extends DAO <Integer, Projects> {

    void addPersonsToProject(Projects project, int projectId);
}
