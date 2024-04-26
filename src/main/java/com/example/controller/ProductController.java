package com.example.controller;

import com.example.service.IProductService;
import com.example.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @PostMapping("/productSave")
    public Product productSave(@RequestBody Product theProduct) {
        productService.save(theProduct);
        return theProduct;
    }

    @GetMapping("/all-product-list")
    public Iterable<Product> getAllProductList() {
        return productService.findAll();

    }


    @GetMapping("/single-product-view/{theproductId}")
    public Product getSingleproductView(@PathVariable int theproductId) {
        productService.findById(theproductId).get();
        System.out.println("first level call");
        productService.findById(theproductId).get();
        return productService.findById(theproductId).get();
    }


    @DeleteMapping("/delete/{theproductId}")
    public String deleteProductById(@PathVariable int theproductId) {
        Optional<Product> product = productService.findById(theproductId);
        if (!product.isPresent()) {
            throw new RuntimeException("Employee id not found  :" + theproductId);
        }
        productService.deleteById(theproductId);

        return "Delete product id :" + theproductId;
    }

    @PutMapping("/update")
    public Product getEmployeeUpdate(@RequestBody Product product) {
        productService.save(product);
        return product;
    }
}
