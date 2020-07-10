package org.example.service;

import org.example.domain.Product;
import org.example.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepo productRepo;

    private Product fromDb;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Iterable<Product> findAll() {
        return productRepo.findAll();
    }

    public boolean isProduct(Product product) {
        fromDb = productRepo.findByName(product.getName());
        if (fromDb != null) {
            return false;
        }
        return true;
    }

    public boolean productSave(Product product) {
        productRepo.save(product);
        return true;
    }

    public boolean productDelete(Product product) {
        if (!isProduct(product)) {
            productRepo.delete(product);
            return true;
        } else {
            return false;
        }
    }

    public boolean productAdd(Product product) {
        Product productFromDb = productRepo.findByName(product.getName());

        if (productFromDb != null) {
            return false;
        }

        productRepo.save(product);

        return true;
    }

}
