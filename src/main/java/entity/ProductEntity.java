package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "product", schema = "avtosalon")
public class ProductEntity implements Serializable{
    private int idProd;
    private String nameprod;
    private Integer volume;
    private Double price;
    private String notes;
    private Collection<OrdersEntity> ordersByIdProd;

    public ProductEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_prod", nullable = false)
    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    @Basic
    @Column(name = "nameprod", nullable = false, length = 30)
    public String getNameprod() {
        return nameprod;
    }

    public void setNameprod(String nameprod) {
        this.nameprod = nameprod;
    }

    @Basic
    @Column(name = "volume", nullable = true)
    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 2)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "notes", nullable = true, length = 20)
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

        if (idProd != that.idProd) return false;
        if (nameprod != null ? !nameprod.equals(that.nameprod) : that.nameprod != null) return false;
        if (volume != null ? !volume.equals(that.volume) : that.volume != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProd;
        result = 31 * result + (nameprod != null ? nameprod.hashCode() : 0);
        result = 31 * result + (volume != null ? volume.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
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
}
