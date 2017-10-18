package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "options", schema = "avtosalon")
public class OptionsEntity implements Serializable{
    private int idFac;
    private String namefac;
    private double price;
    private String contactfac;
    private Collection<OrdersEntity> ordersByIdFac;

    public OptionsEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_fac", nullable = false)
    public int getIdFac() {
        return idFac;
    }

    public void setIdFac(int idFac) {
        this.idFac = idFac;
    }

    @Basic
    @Column(name = "namefac", nullable = false, length = 30)
    public String getNamefac() {
        return namefac;
    }

    public void setNamefac(String namefac) {
        this.namefac = namefac;
    }

    @Basic
    @Column (name = "price", nullable = false)
    public double getPrice(){
        return price;}
    public void setPrice(double price){
        this.price = price;
    }

    @Basic
    @Column(name = "contactfac", nullable = false, length = 30)
    public String getContactfac() {
        return contactfac;
    }

    public void setContactfac(String contactfac) {
        this.contactfac = contactfac;
    }

    @OneToMany(mappedBy = "optionsByOptionsId")
    public Collection<OrdersEntity> getOrdersByIdFac() {
        return ordersByIdFac;
    }

    public void setOrdersByIdFac(Collection<OrdersEntity> ordersByIdFac) {
        this.ordersByIdFac = ordersByIdFac;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OptionsEntity that = (OptionsEntity) o;

        if (idFac != that.idFac) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (namefac != null ? !namefac.equals(that.namefac) : that.namefac != null) return false;
        if (contactfac != null ? !contactfac.equals(that.contactfac) : that.contactfac != null) return false;
        return ordersByIdFac != null ? ordersByIdFac.equals(that.ordersByIdFac) : that.ordersByIdFac == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idFac;
        result = 31 * result + (namefac != null ? namefac.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (contactfac != null ? contactfac.hashCode() : 0);
        result = 31 * result + (ordersByIdFac != null ? ordersByIdFac.hashCode() : 0);
        return result;
    }
}
