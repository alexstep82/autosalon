import DAO.impl.ImplClientDAO;
import DAO.impl.ImplManagerDAO;
import DAO.impl.ImplOrdersDAO;
import entity.ClientEntity;
import entity.ManagerEntity;
import entity.OrdersEntity;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class TestCRUDbyOrders {

    private ImplOrdersDAO implOrdersDAO = new ImplOrdersDAO();
    private ImplClientDAO implClientDAO = new ImplClientDAO();

    @Test
    public void addOrder() throws SQLException {
        OrdersEntity ordersEntity = new OrdersEntity();
        ClientEntity clientEntity = implClientDAO.getClientByID(1);
        ordersEntity.setKol(2);
        ordersEntity.setSumprice((double) 200000);
        ordersEntity.setClientByClientId(clientEntity);
        implOrdersDAO.addOrder(ordersEntity);
        assertEquals(2,implOrdersDAO.getOrderByID(1).getKol());
        assertEquals(new Double(200000), implOrdersDAO.getOrderByID(1).getSumprice());
        assertEquals(clientEntity, implOrdersDAO.getOrderByID(1).getClientByClientId());
    }
}
