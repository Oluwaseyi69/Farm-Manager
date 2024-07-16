package com.example.Farmer.s.Delight.services;

import com.example.Farmer.s.Delight.data.model.Product;
import com.example.Farmer.s.Delight.dtos.request.AddProductRequest;
import com.example.Farmer.s.Delight.dtos.request.UpdateProductRequest;

import java.util.List;

public interface AdminService {

    void add(AddProductRequest addProductRequest);

    void update(UpdateProductRequest request);
    List<Product> getAllProducts();

}
