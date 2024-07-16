package com.example.Farmer.s.Delight.services;

import com.example.Farmer.s.Delight.data.model.Product;
import com.example.Farmer.s.Delight.dtos.request.AddProductRequest;
import com.example.Farmer.s.Delight.dtos.request.UpdateProductRequest;
import com.example.Farmer.s.Delight.dtos.response.UpdateResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService{
    private final ProductService productService;

    @Override
    public void add(AddProductRequest addProductRequest) {
        productService.addProduct(addProductRequest);
    }

    @Override
    public void update(UpdateProductRequest request) {
        productService.updateProduct(request);

    }

    @Override
    public List<Product> getAllProducts() {
       return productService.getAllProducts();

    }


}
