package dao.datasource;



import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by alexbash on 21.05.17.
 */
@Entity
@Table(name = "orders", schema = "avtosalon", catalog = "")
public class OrdersEntity implements Serializable{
    private int id_ord;
    private int kol;
    private Double sumprice;
    private ProductEntity productByIdProd;
    private ManagerEntity managerByManagerIdMan;
    private ClientEntity clientByClientIdPot;

    @Id
    @Column(name = "id_ord", nullable = false)
    public int getId_ord() {
        return id_ord;
    }

    public void setId_ord(int idOrd) {
        this.id_ord = idOrd;
    }

    @Basic
    @Column(name = "kol", nullable = false)
    public int getKol() {
        return kol;
    }

    public void setKol(int kol) {
        this.kol = kol;
    }

    @Basic
    @Column(name = "sumprice", nullable = true, precision = 2)
    public Double getSumprice() {
        return sumprice;
    }

    public void setSumprice(Double sumprice) {
        this.sumprice = sumprice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersEntity that = (OrdersEntity) o;

        if (id_ord != that.id_ord) return false;
        if (kol != that.kol) return false;
        if (sumprice != null ? !sumprice.equals(that.sumprice) : that.sumprice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id_ord;
        result = 31 * result + kol;
        result = 31 * result + (sumprice != null ? sumprice.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_prod", referencedColumnName = "id_prod", nullable = false)
    public ProductEntity getProductByIdProd() {
        return productByIdProd;
    }

    public void setProductByIdProd(ProductEntity productByIdProd) {
        this.productByIdProd = productByIdProd;
    }

    @ManyToOne
    @JoinColumn(name = "manager_id_man", referencedColumnName = "id_man", nullable = false)
    public ManagerEntity getManagerByManagerIdMan() {
        return managerByManagerIdMan;
    }

    public void setManagerByManagerIdMan(ManagerEntity managerByManagerIdMan) {
        this.managerByManagerIdMan = managerByManagerIdMan;
    }

    @ManyToOne
    @JoinColumn(name = "client_id_pot", referencedColumnName = "id_pot", nullable = false)
    public ClientEntity getClientByClientIdPot() {
        return clientByClientIdPot;
    }

    public void setClientByClientIdPot(ClientEntity clientByClientIdPot) {
        this.clientByClientIdPot = clientByClientIdPot;
    }
}
