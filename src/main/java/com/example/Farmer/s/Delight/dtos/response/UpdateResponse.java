package com.example.Farmer.s.Delight.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UpdateResponse<T>{
    private String status;
    private String message;
    private T data;



    public static <T> UpdateResponse<T> success(T data, String message) {
        return new UpdateResponse<>("Success", message, data);
    }

    public static <T> UpdateResponse<T> error(String message) {
        return new UpdateResponse<>("failed", message, null);
    }
}
