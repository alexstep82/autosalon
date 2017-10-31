import DAO.impl.ImplClientDAO;
import entity.ClientEntity;
import org.junit.Test;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestCRUDbyClient {

    private ImplClientDAO implClientDAO = new ImplClientDAO();


   @Test
    public void addClient() throws SQLException {
        int id = 6;
        String name = "Bashmakov";
        String contact = "+7915-766-3868";
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setNamepotr(name);
        clientEntity.setContacts(contact);
        implClientDAO.addClient(clientEntity);
        assertEquals("Bashmakov", implClientDAO.getClientByID(id).getNamepotr());
        assertEquals("+7915-766-3868", implClientDAO.getClientByID(id).getContacts());
    }

    @Test
    public void delete() throws SQLException{
        implClientDAO.deleteClient(3);
        assertEquals(null, implClientDAO.getClientByID(3));
    }
    @Test
    public void getClientById() throws SQLException {
        assertEquals("Malkov A.S.", implClientDAO.getClientByID(1).getNamepotr());
        assertEquals("+7 920-931-95-15", implClientDAO.getClientByID(1).getContacts());
    }

    @Test
    public void getAll() throws SQLException {
        List client = implClientDAO.getAllClients();
        ClientEntity clientTest = (ClientEntity) client.get(1);
        assertEquals("Malkov A.S.", clientTest.getNamepotr());

    }

    @Test
    public void updateClient () throws SQLException {
       ClientEntity clientEntity = new ClientEntity();
       clientEntity.setNamepotr("Suvorov");
       clientEntity.setContacts("880090030000");
       clientEntity.setIdPot(4);
       implClientDAO.updateClient(clientEntity);
       assertEquals(clientEntity, implClientDAO.getClientByID(4));
    }

}
