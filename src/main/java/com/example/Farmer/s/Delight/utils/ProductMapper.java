package com.example.Farmer.s.Delight.utils;

import com.example.Farmer.s.Delight.data.model.Product;
import com.example.Farmer.s.Delight.dtos.request.AddProductRequest;

public class ProductMapper {

    public static Product mapProductToProduct(AddProductRequest request) {
        Product product = new Product();
        product.setProductName(request.getProductName());
        product.setProductType(request.getProductType());
        product.setPrice(request.getProductPrice());
        product.setImageUrl(request.getProductImage());

        return product;
    }
}
