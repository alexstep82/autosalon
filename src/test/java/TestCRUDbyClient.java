import DAO.implement.ClientImplements;
import entity.ClientEntity;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class TestCRUDbyClient {

    private ClientImplements clientImplements = new ClientImplements();


   @Test
    public void addClient() throws SQLException {
        int id = 6;
        String name = "Bashmakov";
        String contact = "+7915-766-3868";
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setNamepotr(name);
        clientEntity.setContacts(contact);
        clientImplements.addClient(clientEntity);
        assertEquals("Bashmakov", clientImplements.getClientByID(id).getNamepotr());
        assertEquals("+7915-766-3868", clientImplements.getClientByID(id).getContacts());
    }

    @Test
    public void delete() throws SQLException{
        clientImplements.deleteClient(3);
        assertEquals(null, clientImplements.getClientByID(3));
    }
    @Test
    public void getClientById() throws SQLException {
        assertEquals("Malkov A.S.",clientImplements.getClientByID(1).getNamepotr());
        assertEquals("+7 920-931-95-15",clientImplements.getClientByID(1).getContacts());
    }

    @Test
    public void getAll() throws SQLException {
        List client = clientImplements.getAllClients();
        ClientEntity clienttest = (ClientEntity) client.get(1);
        assertEquals("Malkov A.S.", clienttest.getNamepotr());

    }

}
