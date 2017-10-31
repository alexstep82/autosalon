package DAO;

import entity.OptionsEntity;
import java.sql.SQLException;
import java.util.Collection;

public interface OptionsDAO {
    public void addOptions(OptionsEntity optionsEntity) throws SQLException;
    public OptionsEntity getOptionsById(int id) throws SQLException;
    public void updateOptions (OptionsEntity optionsEntity) throws SQLException;
    public void deleteOptions (int id) throws SQLException;
    public Collection getAllOptions () throws SQLException;
}
