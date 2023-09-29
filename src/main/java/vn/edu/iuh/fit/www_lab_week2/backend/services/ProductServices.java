package vn.edu.iuh.fit.www_lab_week2.backend.services;

import vn.edu.iuh.fit.www_lab_week2.backend.models.Product;
import vn.edu.iuh.fit.www_lab_week2.backend.repositories.ProductRepository;
import vn.edu.iuh.fit.www_lab_week2.backend.enums.ProductStatus;
import java.util.List;

public class ProductServices {
    private final ProductRepository repository;

    public ProductServices() {
        repository=new ProductRepository();
    }

    public void insert(Product product){
        repository.insert(product);
    }

    public List<Product>getActiveProducts(){
        return repository.getActiveProduct();
    }

    public void updateStatus(long id, ProductStatus status) {
        repository.updateStatus(id,status);
    }
}
