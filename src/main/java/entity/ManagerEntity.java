package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "manager", schema = "avtosalon")
public class ManagerEntity implements Serializable {
    private int idMan;
    private String nameman;
    private String phoneman;
    private Collection<OrdersEntity> ordersByIdMan;

    public ManagerEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_man", nullable = false)
    public int getIdMan() {
        return idMan;
    }

    public void setIdMan(int idMan) {
        this.idMan = idMan;
    }

    @Basic
    @Column(name = "nameman", nullable = false, length = 30)
    public String getNameman() {
        return nameman;
    }

    public void setNameman(String nameman) {
        this.nameman = nameman;
    }

    @Basic
    @Column(name = "phoneman", nullable = false, length = 30)
    public String getPhoneman() {
        return phoneman;
    }

    public void setPhoneman(String phoneman) {
        this.phoneman = phoneman;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ManagerEntity that = (ManagerEntity) o;

        if (idMan != that.idMan) return false;
        if (nameman != null ? !nameman.equals(that.nameman) : that.nameman != null) return false;
        if (phoneman != null ? !phoneman.equals(that.phoneman) : that.phoneman != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMan;
        result = 31 * result + (nameman != null ? nameman.hashCode() : 0);
        result = 31 * result + (phoneman != null ? phoneman.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "managerByManagerId")
    public Collection<OrdersEntity> getOrdersByIdMan() {
        return ordersByIdMan;
    }

    public void setOrdersByIdMan(Collection<OrdersEntity> ordersByIdMan) {
        this.ordersByIdMan = ordersByIdMan;
    }
}
