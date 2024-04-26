package com.example.service;
import com.example.entity.Product;

import java.util.Optional;

public interface IProductService
{
    public Iterable<Product> findAll();
    public Optional<Product> findById(int customerId);
    public void save(Product customer);
    public void deleteById(int customerId);
    public Optional<Product> findByName(String productName);
}
