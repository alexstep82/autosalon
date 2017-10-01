package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orders", schema = "avtosalon")
public class OrdersEntity implements Serializable{
    private int idOrd;
    private int kol;
    private Double sumprice;
    private ProductEntity productByIdProd;
    private ManagerEntity managerByManagerId;
    private ClientEntity clientByClientId;
    private OptionsEntity optionsByOptionsId;

    public OrdersEntity() {
    }

    @Id
    @Column(name = "id_ord", nullable = false)
    public int getIdOrd() {
        return idOrd;
    }

    public void setIdOrd(int idOrd) {
        this.idOrd = idOrd;
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
    @Column(name = "sumprice",precision = 2)
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

        if (idOrd != that.idOrd) return false;
        if (kol != that.kol) return false;

        if (sumprice != null ? !sumprice.equals(that.sumprice) : that.sumprice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOrd;
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
    @JoinColumn(name = "manager_id", referencedColumnName = "id_man", nullable = false)
    public ManagerEntity getManagerByManagerId() {
        return managerByManagerId;
    }

    public void setManagerByManagerId(ManagerEntity managerByManagerId) {
        this.managerByManagerId = managerByManagerId;
    }

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id_pot", nullable = false)
    public ClientEntity getClientByClientId() {
        return clientByClientId;
    }

    public void setClientByClientId(ClientEntity clientByClientId) {
        this.clientByClientId = clientByClientId;
    }

    @ManyToOne
    @JoinColumn(name = "options_id", referencedColumnName = "id_fac", nullable = false)
    public OptionsEntity getOptionsByOptionsId() {
        return optionsByOptionsId;
    }

    public void setOptionsByOptionsId(OptionsEntity optionsByOptionsId) {
        this.optionsByOptionsId = optionsByOptionsId;
    }
}
