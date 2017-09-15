package dao.datasource;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by alexbash on 21.05.17.
 */
@Entity
@Table(name = "manager", schema = "avtosalon", catalog = "")
public class ManagerEntity  implements Serializable{
    private int id_man;
    private String nameman;
    private String phoneman;
    private Collection<OrdersEntity> ordersByIdMan;

    @Id
    @Column(name = "id_man", nullable = false)
    public int getId_man() {
        return id_man;
    }

    public void setId_man(int idMan) {
        this.id_man = idMan;
    }

    @Basic
    @Column(name = "nameman", nullable = false, length = -1)
    public String getNameman() {
        return nameman;
    }

    public void setNameman(String nameman) {
        this.nameman = nameman;
    }

    @Basic
    @Column(name = "phoneman", nullable = false, length = -1)
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

        if (id_man != that.id_man) return false;
        if (nameman != null ? !nameman.equals(that.nameman) : that.nameman != null) return false;
        if (phoneman != null ? !phoneman.equals(that.phoneman) : that.phoneman != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id_man;
        result = 31 * result + (nameman != null ? nameman.hashCode() : 0);
        result = 31 * result + (phoneman != null ? phoneman.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "managerByManagerIdMan")
    public Collection<OrdersEntity> getOrdersByIdMan() {
        return ordersByIdMan;
    }

    public void setOrdersByIdMan(Collection<OrdersEntity> ordersByIdMan) {
        this.ordersByIdMan = ordersByIdMan;
    }
}
