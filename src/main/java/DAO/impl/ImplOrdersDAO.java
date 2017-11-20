package DAO.impl;

import DAO.OrdersDAO;
import entity.OrdersEntity;
import main.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class ImplOrdersDAO implements OrdersDAO {

    @Override
    public void addOrder(OrdersEntity ordersEntity) throws SQLException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(ordersEntity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public OrdersEntity getOrderByID(int id) throws SQLException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        OrdersEntity ordersEntity = session.get(OrdersEntity.class, id);
        session.close();
        return ordersEntity;
    }

    @Override
    public void updateOrder(OrdersEntity ordersEntity) throws SQLException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(ordersEntity);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void deleteOrder(int id) throws SQLException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        OrdersEntity ordersDB = session.get(OrdersEntity.class,id);
        if (null != ordersDB) {
            session.beginTransaction();
            session.delete(ordersDB);
            session.getTransaction().commit();
            session.close();
        } else  {
            System.out.println("Данного заказа не существует");
            session.close();
        }
    }

    @Override
    public Collection getAllOrders() throws SQLException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Query query = session.createQuery("from OrdersEntity ");
        List result = query.list();
        session.close();
        return result;
    }
}
