package com.example.service;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public Iterable<Product> findAll() {
        Iterable<Product> productList = productRepository.findAll();
        return productList;
    }

    @Override
    @Transactional
    public Optional<Product> findById(int productId) {
        return productRepository.findById(productId);
    }

    @Override
    @Transactional
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    @Transactional
    public void deleteById(int productId) {
        productRepository.deleteById(productId);
    }

    @Override
    @Transactional
    public Optional<Product> findByName(String productName) {
        return productRepository.findByPname(productName);
    }
}
