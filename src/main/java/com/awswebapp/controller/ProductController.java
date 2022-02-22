package com.awswebapp.controller;

import com.awswebapp.model.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentHashMap;

@RestController
public class ProductController {

    private ConcurrentHashMap<String, Product> products = new ConcurrentHashMap<>();

    @RequestMapping(value = "product/{id}/add", method = RequestMethod.PUT, produces = "application/json")
    public void createProduct(@PathVariable("id") String id) {
        products.put(id, new Product(id));
    }

    @RequestMapping(value = "product/{id}", method = RequestMethod.GET, produces = "application/json")
    public Product getProduct(@PathVariable("id") String id) {
        return products.get(id);
    }
}
