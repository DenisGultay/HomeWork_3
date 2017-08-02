package Entityes;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Користувач on 29.07.2017.
 */
@Entity
@Table(name = "projects", schema = "homework1", catalog = "")
public class ProjectsEntity {
    private int projectsId;
    private String projectsName;
    private int companyId;
    private int customersId;
    private Integer projectsCost;
    private Collection<PersonsProjectsEntity> personsProjectsByProjectsId;
    private Company companyByCompanyId;

    @Id
    @Column(name = "projects_id", nullable = false)
    public int getProjectsId() {
        return projectsId;
    }

    public void setProjectsId(int projectsId) {
        this.projectsId = projectsId;
    }

    @Basic
    @Column(name = "projects_name", nullable = false, length = 50)
    public String getProjectsName() {
        return projectsName;
    }

    public void setProjectsName(String projectsName) {
        this.projectsName = projectsName;
    }

    @Basic
    @Column(name = "company_id", nullable = false)
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "customers_id", nullable = false)
    public int getCustomersId() {
        return customersId;
    }

    public void setCustomersId(int customersId) {
        this.customersId = customersId;
    }

    @Basic
    @Column(name = "projects_cost", nullable = true)
    public Integer getProjectsCost() {
        return projectsCost;
    }

    public void setProjectsCost(Integer projectsCost) {
        this.projectsCost = projectsCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectsEntity that = (ProjectsEntity) o;

        if (projectsId != that.projectsId) return false;
        if (companyId != that.companyId) return false;
        if (customersId != that.customersId) return false;
        if (projectsName != null ? !projectsName.equals(that.projectsName) : that.projectsName != null) return false;
        if (projectsCost != null ? !projectsCost.equals(that.projectsCost) : that.projectsCost != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = projectsId;
        result = 31 * result + (projectsName != null ? projectsName.hashCode() : 0);
        result = 31 * result + companyId;
        result = 31 * result + customersId;
        result = 31 * result + (projectsCost != null ? projectsCost.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "projectsByProjectsId")
    public Collection<PersonsProjectsEntity> getPersonsProjectsByProjectsId() {
        return personsProjectsByProjectsId;
    }

    public void setPersonsProjectsByProjectsId(Collection<PersonsProjectsEntity> personsProjectsByProjectsId) {
        this.personsProjectsByProjectsId = personsProjectsByProjectsId;
    }

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "company_id", nullable = false)
    public Company getCompanyByCompanyId() {
        return companyByCompanyId;
    }

    public void setCompanyByCompanyId(Company companyByCompanyId) {
        this.companyByCompanyId = companyByCompanyId;
    }
}
