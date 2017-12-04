package serviceview;

import DAO.impl.ImplProductDAO;
import entity.ProductEntity;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.sql.SQLException;
import java.util.*;

@ManagedBean(name = "carService")
@ApplicationScoped
public class CarService {


        public List<ProductEntity> createCars ()  {
            Collection cars = null;
        try {

            cars = new ImplProductDAO().getAllProducts();

        } catch (SQLException e){

            System.out.println("Ошибка запроса к базе");
        }

        List<ProductEntity> list = new ArrayList<ProductEntity>();
            list.addAll(cars);
        return list;


    }

}