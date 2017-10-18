package DAO.implement;

import DAO.ClientDAO;
import entity.ClientEntity;
import main.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientImplements implements ClientDAO{

    public void addClient(ClientEntity clientEntity) throws SQLException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(clientEntity);
        session.getTransaction().commit();
        session.close();
    }

    public ClientEntity getClientByID(int id) throws SQLException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        ClientEntity clientEntity = session.get(ClientEntity.class, id);
        session.close();
        return clientEntity;
    }

    public void updateClient (ClientEntity clientEntity) throws SQLException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(clientEntity);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteClient(int id) throws SQLException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        ClientEntity clientDB = session.get(ClientEntity.class,id);
        if (null != clientDB) {
            session.beginTransaction();
            session.delete(clientDB);
            session.getTransaction().commit();
            session.close();
        } else  {
            System.out.println("Данного клиента не существует");
            session.close();
        }

    }

    public List getAllClients() throws SQLException {
        List list;
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        list = session.createCriteria(ClientEntity.class).list();
        session.close();
        return list;
     }
}
