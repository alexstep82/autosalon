package main;

import DAO.implement.ClientImplements;
import entity.ClientEntity;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by alexbash on 20.05.17.
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Hibernate tutorial");
        ClientImplements clientImplements = new ClientImplements();
        List <ClientEntity> list = clientImplements.getAllClients();
        for (ClientEntity client: list) {
            System.out.print(client.getIdPot() + " " + client.getNamepotr() + " " + client.getContacts());
            System.out.println("");
        }


    }

}
