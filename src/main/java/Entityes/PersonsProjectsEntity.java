package Entityes;

import javax.persistence.*;

/**
 * Created by Користувач on 29.07.2017.
 */
@Entity
@Table(name = "persons_projects", schema = "homework1", catalog = "")
public class PersonsProjectsEntity {
    private int personsId;
    private int projectsId;
    private PersonsEntity personsByPersonsId;
    private ProjectsEntity projectsByProjectsId;

    @Basic
    @Column(name = "persons_id", nullable = false)
    public int getPersonsId() {
        return personsId;
    }

    public void setPersonsId(int personsId) {
        this.personsId = personsId;
    }

    @Basic
    @Column(name = "projects_id", nullable = false)
    public int getProjectsId() {
        return projectsId;
    }

    public void setProjectsId(int projectsId) {
        this.projectsId = projectsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonsProjectsEntity that = (PersonsProjectsEntity) o;

        if (personsId != that.personsId) return false;
        if (projectsId != that.projectsId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personsId;
        result = 31 * result + projectsId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "persons_id", referencedColumnName = "persons_id", nullable = false)
    public PersonsEntity getPersonsByPersonsId() {
        return personsByPersonsId;
    }

    public void setPersonsByPersonsId(PersonsEntity personsByPersonsId) {
        this.personsByPersonsId = personsByPersonsId;
    }

    @ManyToOne
    @JoinColumn(name = "projects_id", referencedColumnName = "projects_id", nullable = false)
    public ProjectsEntity getProjectsByProjectsId() {
        return projectsByProjectsId;
    }

    public void setProjectsByProjectsId(ProjectsEntity projectsByProjectsId) {
        this.projectsByProjectsId = projectsByProjectsId;
    }
}
