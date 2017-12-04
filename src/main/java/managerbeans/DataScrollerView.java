package managerbeans;

import entity.ProductEntity;
import serviceview.CarService;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="dataScrollerView")
@ViewScoped
public class DataScrollerView implements Serializable {

    private List<ProductEntity> cars;

    @ManagedProperty("#{carService}")
    private CarService service;

    @PostConstruct
    public void init() {
        cars = service.createCars();
    }

    public List<ProductEntity> getCars() {
        return cars;
    }

    public void setService(CarService service) {
        this.service = service;
    }
}
