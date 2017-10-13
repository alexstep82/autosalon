package main;

import entity.ClientEntity;
import org.hibernate.Session;

/**
 * Created by alexbash on 20.05.17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hibernate tutorial");

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

//        session.beginTransaction();
//        ClientEntity clientEntity = new ClientEntity();
//        clientEntity.setNamepotr("Malkov A.S.");
//        clientEntity.setContacts("+7 920-931-95-15");
//        session.save(clientEntity);
//        session.getTransaction().commit();
//
//        session.close();
    }

}
