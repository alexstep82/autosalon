package DAO.impl;

import DAO.ClientDAO;
import entity.ClientEntity;
import main.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.sql.SQLException;
import java.util.List;

public class ImplClientDAO implements ClientDAO{




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
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        Query query = session.createQuery("from ClientEntity");
        List result = query.list();
        session.close();
        return result;

     }
}
