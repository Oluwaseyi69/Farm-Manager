package com.example.Farmer.s.Delight.data.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document("ProductImages")
public class ProductImage {
    private String id;
    private String name;
    private String link;
}
