package DAO.impl;

import DAO.ProductDAO;
import entity.OrdersEntity;
import entity.ProductEntity;
import main.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class ImplProductDAO implements ProductDAO {

    private Session session = HibernateSessionFactory.getSessionFactory().openSession();


    @Override
    public void addProduct(ProductEntity productEntity) throws SQLException {
        session.beginTransaction();
        session.save(productEntity);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public ProductEntity getProductById(int id) throws SQLException {
        ProductEntity productEntity = session.get(ProductEntity.class, id);
        session.close();
        return productEntity;
    }

    @Override
    public void updateProduct(ProductEntity productEntity) throws SQLException {
        session.beginTransaction();
        session.update(productEntity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteProduct(int id) throws SQLException {
        ProductEntity productDB = session.get(ProductEntity.class,id);
        if (null != productDB) {
            session.beginTransaction();
            session.delete(productDB);
            session.getTransaction().commit();
            session.close();
        } else  {
            System.out.println("Данной машины не существует");
            session.close();
        }
    }

    @Override
    public Collection getAllProducts() throws SQLException {
        Query query = session.createQuery("from ProductEntity");
        List result = query.list();
        session.close();
        return result;
    }
}
