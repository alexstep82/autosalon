package DAO;

import entity.OrdersEntity;

import java.sql.SQLException;
import java.util.Collection;

public interface OrdersDAO {
    public void addOrder(OrdersEntity ordersEntity) throws SQLException;
    public OrdersEntity getOrderByID(int id) throws SQLException;
    public void updateOrder (OrdersEntity ordersEntity) throws SQLException;
    public void deleteOrder (int id) throws SQLException;
    public Collection getAllOrders () throws SQLException;

}
