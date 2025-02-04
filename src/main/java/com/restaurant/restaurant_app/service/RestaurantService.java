package com.restaurant.restaurant_app.service;

import com.restaurant.restaurant_app.model.RestaurantRequest;
import com.restaurant.restaurant_app.model.RestaurantResponse;

import java.util.List;

public interface RestaurantService {

    public boolean addRestaurant(RestaurantRequest request);

    public List<RestaurantResponse> getRestuarants();
}
