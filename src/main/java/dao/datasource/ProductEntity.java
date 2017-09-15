package dao.datasource;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by alexbash on 21.05.17.
 */
@Entity
@Table(name = "product", schema = "avtosalon", catalog = "")
public class ProductEntity implements Serializable {
    private int id_prod;
    private String nameprod;
    private int volume;
    private double price;
    private String notes;
    private Collection<OrdersEntity> ordersByIdProd;
    private OptionsEntity optionsByOptionsIdFac;

    @Id
    @Column(name = "id_prod", nullable = false)
    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int idProd) {
        this.id_prod = idProd;
    }

    @Basic
    @Column(name = "nameprod", nullable = true, length = 30)
    public String getNameprod() {
        return nameprod;
    }

    public void setNameprod(String nameprod) {
        this.nameprod = nameprod;
    }

    @Basic
    @Column(name = "volume", nullable = false)
    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Basic
    @Column(name = "price", nullable = false, precision = 2)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "notes", nullable = false, length = -1)
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductEntity that = (ProductEntity) o;

        if (id_prod != that.id_prod) return false;
        if (volume != that.volume) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (nameprod != null ? !nameprod.equals(that.nameprod) : that.nameprod != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id_prod;
        result = 31 * result + (nameprod != null ? nameprod.hashCode() : 0);
        result = 31 * result + volume;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "productByIdProd")
    public Collection<OrdersEntity> getOrdersByIdProd() {
        return ordersByIdProd;
    }

    public void setOrdersByIdProd(Collection<OrdersEntity> ordersByIdProd) {
        this.ordersByIdProd = ordersByIdProd;
    }

    @ManyToOne
    @JoinColumn(name = "options_id_fac", referencedColumnName = "id_fac", nullable = false)
    public OptionsEntity getOptionsByOptionsIdFac() {
        return optionsByOptionsIdFac;
    }

    public void setOptionsByOptionsIdFac(OptionsEntity optionsByOptionsIdFac) {
        this.optionsByOptionsIdFac = optionsByOptionsIdFac;
    }
}
