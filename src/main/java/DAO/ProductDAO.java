package DAO;

import entity.ProductEntity;
import java.sql.SQLException;
import java.util.Collection;

public interface ProductDAO {
    public void addProduct(ProductEntity productEntity) throws SQLException;
    public ProductEntity getProductById (int id) throws SQLException;
    public void updateProduct (ProductEntity productEntity) throws SQLException;
    public void deleteProduct (int id) throws SQLException;
    public Collection getAllProducts () throws SQLException;
}
