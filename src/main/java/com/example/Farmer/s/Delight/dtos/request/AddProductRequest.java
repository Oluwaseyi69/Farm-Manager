package com.example.Farmer.s.Delight.dtos.request;


import lombok.Data;

@Data
public class AddProductRequest {
    private String productName;
    private String productType;
    private String productDescription;
    private String productPrice;
    private String productQuantity;
    private String productCategory;
    private String productImage;
    private String productBrand;
}
