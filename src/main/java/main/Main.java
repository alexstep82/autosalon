package main;

import DAO.impl.ImplProductDAO;
import entity.ProductEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        List <ProductEntity> list = new ArrayList <ProductEntity>();
        list.addAll(new ImplProductDAO().getAllProducts());
        for (ProductEntity result: list) {
            System.out.println(result.getNameprod());
        }
    }


}
