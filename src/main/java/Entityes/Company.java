package Entityes;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Користувач on 29.07.2017.
 */
@Entity
@Table(name = "company", schema = "homework1", catalog = "")
public class Company {
    private int companyId;
    private String companyName;
    private Collection<Persons> personsByCompanyId;
    private Collection<Projects> projectsByCompanyId;

    @Id
    @Column(name = "company_id", nullable = false)
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "company_name", nullable = false, length = 45)
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company that = (Company) o;

        if (companyId != that.companyId) return false;
        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = companyId;
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "companyByCompanyId")
    public Collection<Persons> getPersonsByCompanyId() {
        return personsByCompanyId;
    }

    public void setPersonsByCompanyId(Collection<Persons> personsByCompanyId) {
        this.personsByCompanyId = personsByCompanyId;
    }

    @OneToMany(mappedBy = "companyByCompanyId")
    public Collection<Projects> getProjectsByCompanyId() {
        return projectsByCompanyId;
    }

    public void setProjectsByCompanyId(Collection<Projects> projectsByCompanyId) {
        this.projectsByCompanyId = projectsByCompanyId;
    }
}
