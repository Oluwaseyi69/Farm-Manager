package com.example.Farmer.s.Delight.services;

import com.example.Farmer.s.Delight.data.model.Product;
import com.example.Farmer.s.Delight.dtos.request.AddProductRequest;
import com.example.Farmer.s.Delight.dtos.request.DeleteProduct;
import com.example.Farmer.s.Delight.dtos.request.UpdateProductRequest;

import java.util.List;

public interface ProductService {
    void addProduct(AddProductRequest addProductRequest);
    void updateProduct(UpdateProductRequest updateProductRequest);
    List<Product> getAllProducts();
    void deleteProduct(DeleteProduct deleteProduct);
}
