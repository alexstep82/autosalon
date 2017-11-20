package DAO.impl;

import DAO.ManagerDAO;
import entity.ManagerEntity;
import main.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class ImplManagerDAO implements ManagerDAO {

    public void addManager(ManagerEntity managerEntity) throws SQLException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(managerEntity);
        session.getTransaction().commit();
        session.close();
    }


    public ManagerEntity getManagerByID(int id) throws SQLException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        ManagerEntity managerEntity = session.get(ManagerEntity.class, id);
        session.close();
        return managerEntity;
    }

    @Override
    public void updateManager (ManagerEntity managerEntity) throws SQLException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(managerEntity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteManager(int id) throws SQLException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        ManagerEntity managerDB = session.get(ManagerEntity.class,id);
        if (null != managerDB) {
            session.beginTransaction();
            session.delete(managerDB);
            session.getTransaction().commit();
            session.close();
        } else  {
            System.out.println("Данного менеджера не существует");
            session.close();
        }
    }

    @Override
    public List getAllManager() throws SQLException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Query query = session.createQuery("from ManagerEntity ");
        List result = query.list();
        session.close();
        return result;

    }
}
