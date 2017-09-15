package dao.datasource;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by alexbash on 21.05.17.
 */
@Entity
@Table(name = "options", schema = "avtosalon", catalog = "")
public class OptionsEntity implements Serializable{
    private int id_fac;
    private String namefac;
    private String contactfac;
    private Collection<ProductEntity> productsByIdFac;

    @Id
    @Column(name = "id_fac", nullable = false)
    public int getId_fac() {
        return id_fac;
    }

    public void setId_fac(int idFac) {
        this.id_fac = idFac;
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

        if (id_fac != that.id_fac) return false;
        if (namefac != null ? !namefac.equals(that.namefac) : that.namefac != null) return false;
        if (contactfac != null ? !contactfac.equals(that.contactfac) : that.contactfac != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id_fac;
        result = 31 * result + (namefac != null ? namefac.hashCode() : 0);
        result = 31 * result + (contactfac != null ? contactfac.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "optionsByOptionsIdFac")
    public Collection<ProductEntity> getProductsByIdFac() {
        return productsByIdFac;
    }

    public void setProductsByIdFac(Collection<ProductEntity> productsByIdFac) {
        this.productsByIdFac = productsByIdFac;
    }
}
