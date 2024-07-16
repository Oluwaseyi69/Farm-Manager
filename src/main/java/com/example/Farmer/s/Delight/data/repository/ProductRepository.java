package com.example.Farmer.s.Delight.data.repository;

import com.example.Farmer.s.Delight.data.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {
    Optional<Product> findByProductNameAndCategory(String productName, String category);
}
