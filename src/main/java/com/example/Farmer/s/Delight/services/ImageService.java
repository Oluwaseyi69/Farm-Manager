package com.example.Farmer.s.Delight.services;

import com.example.Farmer.s.Delight.dtos.request.UploadRequest;
import com.example.Farmer.s.Delight.dtos.response.UpdateResponse;

public interface ImageService {
    UpdateResponse<?> uploadImage(UploadRequest file);
}
