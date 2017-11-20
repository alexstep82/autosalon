import DAO.impl.ImplProductDAO;
import entity.ProductEntity;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class TestCRUDbyProduct  {

    private ImplProductDAO implProductDAO = new ImplProductDAO();

    @Test
    public void addProduct () throws SQLException {

        ProductEntity productEntity = new ProductEntity();
        productEntity.setNameprod("Hyundai");
        productEntity.setNotes("Hatchback");
        productEntity.setVolume(15);
        productEntity.setPrice(200000.0);
        implProductDAO.addProduct(productEntity);
        assertEquals("Hyundai", implProductDAO.getProductById(23).getNameprod());
        assertEquals("Hatchback",implProductDAO.getProductById(23).getNotes());
        assertEquals(new Integer(15), implProductDAO.getProductById(23).getVolume());
        assertEquals(new Double(200000.0), implProductDAO.getProductById(23).getPrice());

    }
}
