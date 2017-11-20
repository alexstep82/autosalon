import DAO.impl.*;
import entity.OrdersEntity;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class TestCRUDbyOrder {

    private ImplOrdersDAO implOrdersDAO = new ImplOrdersDAO();

    @Test

    public void addOrder() throws SQLException {

        OrdersEntity ordersEntity = new OrdersEntity();
        ordersEntity.setSumprice(250000.0);
        ordersEntity.setKol(2);
        ordersEntity.setClientByClientId(new ImplClientDAO().getClientByID(2));
        ordersEntity.setManagerByManagerId(new ImplManagerDAO().getManagerByID(17));
        ordersEntity.setOptionsByOptionsId(new ImplOptionsDAO().getOptionsById(22));
        ordersEntity.setProductByIdProd(new ImplProductDAO().getProductById(24));
        implOrdersDAO.addOrder(ordersEntity);
        assertEquals(new Double(250000.0),implOrdersDAO.getOrderByID(25).getSumprice() );
        assertEquals(2, implOrdersDAO.getOrderByID(25).getKol());
    }

}
