package main;

import dao.datasource.ClientEntity;
import org.hibernate.Session;

/**
 * Created by alexbash on 20.05.17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hibernate tutorial");

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setNamepotr("Lagunov A.V.");
        clientEntity.setContacts("+7 915-766-38-68");
        session.save(clientEntity);
        session.getTransaction().commit();

        session.close();
    }

}
