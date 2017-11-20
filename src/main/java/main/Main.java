package main;

import DAO.impl.ImplClientDAO;
import DAO.impl.ImplManagerDAO;
import entity.ClientEntity;
import entity.ManagerEntity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by alexbash on 20.05.17.
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Hibernate tutorial");
        ImplClientDAO implClientDAO = new ImplClientDAO();
        List <ClientEntity> list = implClientDAO.getAllClients();
        for (ClientEntity client: list) {
            System.out.print(client.getIdPot() + " " + client.getNamepotr() + " " + client.getContacts());
            System.out.println("");
        }
        ImplManagerDAO implManagerDAO = new ImplManagerDAO();
        List <ManagerEntity> list1 = implManagerDAO.getAllManager();
        for (ManagerEntity manager: list1) {
            System.out.println(manager.getIdMan() + " " + manager.getNameman() + " " + manager.getPhoneman());
        }


    }

}
