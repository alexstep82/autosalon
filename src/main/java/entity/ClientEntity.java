package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by alexbash on 21.05.17.
 */
@Entity
@Table(name = "client", schema = "avtosalon")
public class ClientEntity implements Serializable{
    private int id_pot;
    private String namepotr;
    private String contacts;
    private Collection<OrdersEntity> ordersByIdPot;

    public ClientEntity(){
    }
    @Id
    @Column(name = "id_pot", nullable = false)
    public int getId_pot() {
        return id_pot;
    }

    public void setId_pot(int idPot) {
        this.id_pot = idPot;
    }

    @Basic
    @Column(name = "namepotr", nullable = false, length = -1)
    public String getNamepotr() {
        return namepotr;
    }

    public void setNamepotr(String namepotr) {
        this.namepotr = namepotr;
    }

    @Basic
    @Column(name = "contacts", nullable = false, length = -1)
    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientEntity that = (ClientEntity) o;

        if (id_pot != that.id_pot) return false;
        if (namepotr != null ? !namepotr.equals(that.namepotr) : that.namepotr != null) return false;
        if (contacts != null ? !contacts.equals(that.contacts) : that.contacts != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id_pot;
        result = 31 * result + (namepotr != null ? namepotr.hashCode() : 0);
        result = 31 * result + (contacts != null ? contacts.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "clientByClientIdPot")
    public Collection<OrdersEntity> getOrdersByIdPot() {
        return ordersByIdPot;
    }

    public void setOrdersByIdPot(Collection<OrdersEntity> ordersByIdPot) {
        this.ordersByIdPot = ordersByIdPot;
    }
}
