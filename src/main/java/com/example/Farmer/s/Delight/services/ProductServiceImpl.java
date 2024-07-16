package com.example.Farmer.s.Delight.services;

import com.example.Farmer.s.Delight.data.model.Product;
import com.example.Farmer.s.Delight.data.repository.ProductRepository;
import com.example.Farmer.s.Delight.dtos.request.AddProductRequest;
import com.example.Farmer.s.Delight.dtos.request.DeleteProduct;
import com.example.Farmer.s.Delight.dtos.request.UpdateProductRequest;
import com.example.Farmer.s.Delight.dtos.response.UpdateResponse;
import com.example.Farmer.s.Delight.exception.UserNotFound;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.Farmer.s.Delight.utils.ProductMapper.mapProductToProduct;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;


    @Override
    public void addProduct(AddProductRequest addProductRequest) {
        Product product = mapProductToProduct(addProductRequest);
        productRepository.save(product);
    }

    @Override
    public void updateProduct(UpdateProductRequest updateProductRequest) {
        Product product = new Product();
        product.setProductName(updateProductRequest.getProductName());
        product.setPrice(updateProductRequest.getProductPrice());
        product.setQuantity(updateProductRequest.getProductQuantity());
        productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(DeleteProduct deleteProduct) {
        Optional<Product> product = productRepository.findByProductNameAndCategory
                (deleteProduct.getProductName(), deleteProduct.getCategory());
        if (product.isPresent()) {
            productRepository.delete(product.get());
        }else throw new UserNotFound("Product not found");
    }

}
