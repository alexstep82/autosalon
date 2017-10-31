package DAO;

import entity.ManagerEntity;

import java.sql.SQLException;
import java.util.Collection;

public interface ManagerDAO {
    public void addManager (ManagerEntity managerEntity) throws SQLException;
    public ManagerEntity getManagerByID(int id) throws SQLException;
    public void updateManager (ManagerEntity managerEntity) throws SQLException;
    public void deleteManager (int id) throws SQLException;
    public Collection getAllManager () throws SQLException;
}
