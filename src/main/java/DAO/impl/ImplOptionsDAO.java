package DAO.impl;

import DAO.OptionsDAO;
import entity.ManagerEntity;
import entity.OptionsEntity;
import main.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class ImplOptionsDAO implements OptionsDAO{

    private Session session = HibernateSessionFactory.getSessionFactory().openSession();

    @Override
    public void addOptions(OptionsEntity optionsEntity) throws SQLException {
        session.beginTransaction();
        session.save(optionsEntity);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public OptionsEntity getOptionsById(int id) throws SQLException {
        OptionsEntity optionsEntity = session.get(OptionsEntity.class, id);
        session.close();
        return optionsEntity;
    }

    @Override
    public void updateOptions(OptionsEntity optionsEntity) throws SQLException {
        session.beginTransaction();
        session.update(optionsEntity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteOptions(int id) throws SQLException {
        OptionsEntity optionsDB = session.get(OptionsEntity.class,id);
        if (null != optionsDB) {
            session.beginTransaction();
            session.delete(optionsDB);
            session.getTransaction().commit();
            session.close();
        } else  {
            System.out.println("Данной опции не существует");
            session.close();
        }

    }

    @Override
    public Collection getAllOptions() throws SQLException {
        Query query = session.createQuery("from OptionsEntity");
        List result = query.list();
        session.close();
        return result;
    }
}
