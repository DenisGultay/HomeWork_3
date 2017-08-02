package Entityes;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Користувач on 29.07.2017.
 */
@Entity
@Table(name = "persons", schema = "homework1", catalog = "")
public class PersonsEntity {
    private int personsId;
    private String personsName;
    private int personsAge;
    private Integer companyId;
    private Integer salary;
    private Company companyByCompanyId;
    private Collection<PersonsProjectsEntity> personsProjectsByPersonsId;
    private Collection<PersonsSkillsEntity> personsSkillsByPersonsId;

    @Id
    @Column(name = "persons_id", nullable = false)
    public int getPersonsId() {
        return personsId;
    }

    public void setPersonsId(int personsId) {
        this.personsId = personsId;
    }

    @Basic
    @Column(name = "persons_name", nullable = false, length = 45)
    public String getPersonsName() {
        return personsName;
    }

    public void setPersonsName(String personsName) {
        this.personsName = personsName;
    }

    @Basic
    @Column(name = "persons_age", nullable = false)
    public int getPersonsAge() {
        return personsAge;
    }

    public void setPersonsAge(int personsAge) {
        this.personsAge = personsAge;
    }

    @Basic
    @Column(name = "company_id", nullable = true)
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "salary", nullable = true)
    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonsEntity that = (PersonsEntity) o;

        if (personsId != that.personsId) return false;
        if (personsAge != that.personsAge) return false;
        if (personsName != null ? !personsName.equals(that.personsName) : that.personsName != null) return false;
        if (companyId != null ? !companyId.equals(that.companyId) : that.companyId != null) return false;
        if (salary != null ? !salary.equals(that.salary) : that.salary != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personsId;
        result = 31 * result + (personsName != null ? personsName.hashCode() : 0);
        result = 31 * result + personsAge;
        result = 31 * result + (companyId != null ? companyId.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    public Company getCompanyByCompanyId() {
        return companyByCompanyId;
    }

    public void setCompanyByCompanyId(Company companyByCompanyId) {
        this.companyByCompanyId = companyByCompanyId;
    }

    @OneToMany(mappedBy = "personsByPersonsId")
    public Collection<PersonsProjectsEntity> getPersonsProjectsByPersonsId() {
        return personsProjectsByPersonsId;
    }

    public void setPersonsProjectsByPersonsId(Collection<PersonsProjectsEntity> personsProjectsByPersonsId) {
        this.personsProjectsByPersonsId = personsProjectsByPersonsId;
    }

    @OneToMany(mappedBy = "personsByPersonsId")
    public Collection<PersonsSkillsEntity> getPersonsSkillsByPersonsId() {
        return personsSkillsByPersonsId;
    }

    public void setPersonsSkillsByPersonsId(Collection<PersonsSkillsEntity> personsSkillsByPersonsId) {
        this.personsSkillsByPersonsId = personsSkillsByPersonsId;
    }
}
