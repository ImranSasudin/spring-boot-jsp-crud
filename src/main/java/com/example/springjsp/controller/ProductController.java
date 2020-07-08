package com.example.springjsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.springjsp.dao.ProductRepository;
import com.example.springjsp.model.Product;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @RequestMapping("/")
    public String Welcome(Model product) {
    	product.addAttribute("message", "Test");
        return "index";
    }
    
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return repository.save(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return repository.saveAll(products);
    }

    @GetMapping("/products")
    public String findAllProducts(Model model) {
    	model.addAttribute("products",repository.findAll());
        return "list";
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id) {
        return repository.findById(id).orElse(null);
    }

    @GetMapping("/product/{name}")
    public Product findProductByName(@PathVariable String name) {
        return repository.findByName(name);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
    	Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }
}
