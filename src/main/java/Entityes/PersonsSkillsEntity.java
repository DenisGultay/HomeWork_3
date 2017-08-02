package Entityes;

import javax.persistence.*;

/**
 * Created by Користувач on 29.07.2017.
 */
@Entity
@Table(name = "persons_skills", schema = "homework1", catalog = "")
public class PersonsSkillsEntity {
    private int personsId;
    private int skillsId;
    private Persons personsByPersonsId;
    private Skills skillsBySkillsId;

    @Basic
    @Column(name = "persons_id", nullable = false)
    public int getPersonsId() {
        return personsId;
    }

    public void setPersonsId(int personsId) {
        this.personsId = personsId;
    }

    @Basic
    @Column(name = "skills_id", nullable = false)
    public int getSkillsId() {
        return skillsId;
    }

    public void setSkillsId(int skillsId) {
        this.skillsId = skillsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonsSkillsEntity that = (PersonsSkillsEntity) o;

        if (personsId != that.personsId) return false;
        if (skillsId != that.skillsId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personsId;
        result = 31 * result + skillsId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "persons_id", referencedColumnName = "persons_id", nullable = false)
    public Persons getPersonsByPersonsId() {
        return personsByPersonsId;
    }

    public void setPersonsByPersonsId(Persons personsByPersonsId) {
        this.personsByPersonsId = personsByPersonsId;
    }

    @ManyToOne
    @JoinColumn(name = "skills_id", referencedColumnName = "skills_id", nullable = false)
    public Skills getSkillsBySkillsId() {
        return skillsBySkillsId;
    }

    public void setSkillsBySkillsId(Skills skillsBySkillsId) {
        this.skillsBySkillsId = skillsBySkillsId;
    }
}
