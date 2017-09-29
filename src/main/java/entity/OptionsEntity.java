package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "options", schema = "avtosalon")
public class OptionsEntity {
    private int idFac;
    private String namefac;
    private String contactfac;
    private Collection<OrdersEntity> ordersByIdFac;

    @Id
    @Column(name = "id_fac", nullable = false)
    public int getIdFac() {
        return idFac;
    }

    public void setIdFac(int idFac) {
        this.idFac = idFac;
    }

    @Basic
    @Column(name = "namefac", nullable = false, length = -1)
    public String getNamefac() {
        return namefac;
    }

    public void setNamefac(String namefac) {
        this.namefac = namefac;
    }

    @Basic
    @Column(name = "contactfac", nullable = false, length = -1)
    public String getContactfac() {
        return contactfac;
    }

    public void setContactfac(String contactfac) {
        this.contactfac = contactfac;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OptionsEntity that = (OptionsEntity) o;

        if (idFac != that.idFac) return false;
        if (namefac != null ? !namefac.equals(that.namefac) : that.namefac != null) return false;
        if (contactfac != null ? !contactfac.equals(that.contactfac) : that.contactfac != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFac;
        result = 31 * result + (namefac != null ? namefac.hashCode() : 0);
        result = 31 * result + (contactfac != null ? contactfac.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "optionsByOptionsId")
    public Collection<OrdersEntity> getOrdersByIdFac() {
        return ordersByIdFac;
    }

    public void setOrdersByIdFac(Collection<OrdersEntity> ordersByIdFac) {
        this.ordersByIdFac = ordersByIdFac;
    }
}
