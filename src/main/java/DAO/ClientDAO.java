package DAO;

import entity.ClientEntity;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface ClientDAO {
    void addClient (ClientEntity clientEntity) throws SQLException;
    ClientEntity getClientByID(int id) throws SQLException;
    void updateClient (ClientEntity clientEntity) throws SQLException;
    void deleteClient (int id) throws SQLException;
    Collection getAllClients () throws SQLException;
}
