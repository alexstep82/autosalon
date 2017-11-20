import DAO.impl.ImplManagerDAO;
import entity.ManagerEntity;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestCRUDbyManager {

    private ImplManagerDAO implManagerDAO = new ImplManagerDAO();

    @Test
    public void addManager() throws SQLException{
        String name = "Maxim Shenogin";
        String phone = "+7 926-698-54-69";
        ManagerEntity managerEntity = new ManagerEntity();
        managerEntity.setNameman(name);
        managerEntity.setPhoneman(phone);
        implManagerDAO.addManager(managerEntity);
        assertEquals(name, implManagerDAO.getManagerByID(14).getNameman());
        assertEquals(phone, implManagerDAO.getManagerByID(14).getPhoneman());

    }

    @Test
    public void delete() throws SQLException{
        implManagerDAO.deleteManager(16);
        assertEquals(null, implManagerDAO.getManagerByID(16));
    }

    @Test
    public void getManagerByID() throws SQLException {
        assertEquals("Maxim Shenogin", implManagerDAO.getManagerByID(14).getNameman());
        assertEquals("+7 926-698-54-69", implManagerDAO.getManagerByID(14).getPhoneman());
    }

    @Test
    public void updateManager() throws SQLException {
        ManagerEntity managerEntity = new ManagerEntity();
        managerEntity.setNameman("Karpov");
        managerEntity.setPhoneman("8811111111");
        managerEntity.setIdMan(17);
        implManagerDAO.updateManager(managerEntity);
        assertEquals("Karpov", implManagerDAO.getManagerByID(17).getNameman());
        assertEquals("8811111111", implManagerDAO.getManagerByID(17).getPhoneman());
    }

    @Test
    public void getAllManager() throws SQLException{
        List manager = implManagerDAO.getAllManager();
        ManagerEntity managerTest = (ManagerEntity) manager.get(0);
        assertEquals("Maxim Shenogin", managerTest.getNameman());
    }
}
