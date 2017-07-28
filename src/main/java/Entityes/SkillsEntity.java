package Entityes;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Користувач on 29.07.2017.
 */
@Entity
@Table(name = "skills", schema = "homework1", catalog = "")
public class SkillsEntity {
    private int skillsId;
    private String skillsName;
    private Collection<PersonsSkillsEntity> personsSkillsBySkillsId;

    @Id
    @Column(name = "skills_id", nullable = false)
    public int getSkillsId() {
        return skillsId;
    }

    public void setSkillsId(int skillsId) {
        this.skillsId = skillsId;
    }

    @Basic
    @Column(name = "skills_name", nullable = false, length = 45)
    public String getSkillsName() {
        return skillsName;
    }

    public void setSkillsName(String skillsName) {
        this.skillsName = skillsName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SkillsEntity that = (SkillsEntity) o;

        if (skillsId != that.skillsId) return false;
        if (skillsName != null ? !skillsName.equals(that.skillsName) : that.skillsName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = skillsId;
        result = 31 * result + (skillsName != null ? skillsName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "skillsBySkillsId")
    public Collection<PersonsSkillsEntity> getPersonsSkillsBySkillsId() {
        return personsSkillsBySkillsId;
    }

    public void setPersonsSkillsBySkillsId(Collection<PersonsSkillsEntity> personsSkillsBySkillsId) {
        this.personsSkillsBySkillsId = personsSkillsBySkillsId;
    }
}
