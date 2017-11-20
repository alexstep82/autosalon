import DAO.impl.ImplOptionsDAO;
import entity.OptionsEntity;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class TestCRUDbyOptions {

    private ImplOptionsDAO implOptionsDAO = new ImplOptionsDAO();

    @Test
    public void addOptions() throws SQLException {
        OptionsEntity optionsEntity = new OptionsEntity();
        optionsEntity.setNamefac("Elegans");
        optionsEntity.setContactfac("65444454645656");
        optionsEntity.setPrice(15000);
        implOptionsDAO.addOptions(optionsEntity);
        assertEquals("Elegans", implOptionsDAO.getOptionsById(20).getNamefac());
        assertEquals("65444454645656", implOptionsDAO.getOptionsById(20).getContactfac());
        assertEquals(15000, implOptionsDAO.getOptionsById(20).getPrice(),12);
    }

}
