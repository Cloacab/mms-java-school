package com.yuri.mmsjavaschool.services.impls;

import com.yuri.mmsjavaschool.models.Product;
import com.yuri.mmsjavaschool.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id: " + id + " was not found"));
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }
}
