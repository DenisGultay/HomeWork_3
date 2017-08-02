package Entityes;

import javax.persistence.*;

/**
 * Created by Користувач on 29.07.2017.
 */
@Entity
@Table(name = "customers", schema = "homework1", catalog = "")
public class Customers {
    private int customersId;
    private String customersName;

    @Id
    @Column(name = "customers_id", nullable = false)
    public int getCustomersId() {
        return customersId;
    }

    public void setCustomersId(int customersId) {
        this.customersId = customersId;
    }

    @Basic
    @Column(name = "customers_name", nullable = false, length = 45)
    public String getCustomersName() {
        return customersName;
    }

    public void setCustomersName(String customersName) {
        this.customersName = customersName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customers that = (Customers) o;

        if (customersId != that.customersId) return false;
        if (customersName != null ? !customersName.equals(that.customersName) : that.customersName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customersId;
        result = 31 * result + (customersName != null ? customersName.hashCode() : 0);
        return result;
    }
}
