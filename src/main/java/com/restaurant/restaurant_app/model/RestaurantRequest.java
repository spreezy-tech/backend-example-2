package com.restaurant.restaurant_app.model;

import lombok.Data;

@Data
public class RestaurantRequest {

    private String restroName;
    private Long mobile;
    private String restroType;
    private String address;
    private String city;
    private String state;
    private String country;
    private Integer pinCode;
}
