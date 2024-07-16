package com.example.Farmer.s.Delight.services;

import com.example.Farmer.s.Delight.data.model.Product;
import com.example.Farmer.s.Delight.data.repository.ProductRepository;
import com.example.Farmer.s.Delight.dtos.request.UploadRequest;
import com.example.Farmer.s.Delight.dtos.response.UpdateResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;


@Service
@Slf4j
@AllArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ProductRepository productRepository;

    @Override
    public UpdateResponse<?> uploadImage(UploadRequest file) {

        log.info("Uploading image");
        Product image = createImage(file);
        log.info("Image created");
        productRepository.save(image);
        log.info("Image saved");
        String content = image.getImageUrl();
        log.info("Content of image: {}", content);
        writeToFile(content);
        log.info("Image saved");
        return UpdateResponse.success(null, "Image uploaded successfully");
    }

    private Product createImage(UploadRequest request){
        Product product = new Product();
        product.setImageUrl(request.getUrl());
        return product;
    }
    public void writeToFile(String content) {
        try (FileWriter writer = new FileWriter("pictureUrls.txt", true)) {
            writer.write(content + System.lineSeparator());
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }
    }
}
