package com.restaurant.restaurant_app.service;

import com.restaurant.restaurant_app.entity.RestaurantDetails;
import com.restaurant.restaurant_app.model.RestaurantRequest;
import com.restaurant.restaurant_app.repository.RestaurantDetailsRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantDetailsRepository restaurantDetailsRepository;

    public RestaurantServiceImpl(RestaurantDetailsRepository restaurantDetailsRepository) {
        this.restaurantDetailsRepository = restaurantDetailsRepository;
    }

    @Override
    public boolean addRestaurant(RestaurantRequest request) {
        RestaurantDetails restaurantDetails = mapDTOToEntity(request);
        RestaurantDetails persistedDetails = restaurantDetailsRepository.save(restaurantDetails);

        if (ObjectUtils.isEmpty(persistedDetails)) {
            return false;
        }

        return true;
    }

    private RestaurantDetails mapDTOToEntity(RestaurantRequest restaurantRequest) {
        return RestaurantDetails.builder()
                .restroId(1)
                .restroName(restaurantRequest.getRestroName())
                .restroType(restaurantRequest.getRestroType())
                .build();
    }
}
