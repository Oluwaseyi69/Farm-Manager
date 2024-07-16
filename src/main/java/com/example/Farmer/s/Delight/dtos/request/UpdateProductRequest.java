package com.example.Farmer.s.Delight.dtos.request;

import lombok.Data;

@Data
public class UpdateProductRequest {
    private String productName;
    private String productDescription;
    private String productPrice;
    private String productQuantity;

}
