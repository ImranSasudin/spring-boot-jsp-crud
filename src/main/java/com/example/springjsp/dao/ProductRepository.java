package com.example.springjsp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springjsp.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByName(String name);
}

