package com.restaurant.restaurant_app.service;

import com.restaurant.restaurant_app.entity.RestaurantDetails;
import com.restaurant.restaurant_app.model.RestaurantRequest;
import com.restaurant.restaurant_app.model.RestaurantResponse;
import com.restaurant.restaurant_app.repository.RestaurantDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Value("${test.property.dummy}")
    private String dummyProperty = "";

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

    @Override
    public List<RestaurantResponse> getRestuarants() {
        List<RestaurantDetails> restaurantDetails = restaurantDetailsRepository.findAll();
        List<RestaurantResponse> listOfRestaurants = mapEntityToDTO(restaurantDetails);
        log.info("Value captured from properties file : {}", dummyProperty);

        return listOfRestaurants;
    }

    private RestaurantDetails mapDTOToEntity(RestaurantRequest restaurantRequest) {
        return RestaurantDetails.builder()
                .restroName(restaurantRequest.getRestroName())
                .restroType(restaurantRequest.getRestroType())
                .build();
    }

    private List<RestaurantResponse> mapEntityToDTO(List<RestaurantDetails> restaurantDetails){
        List<RestaurantResponse> restaurantResponseList = new ArrayList<>();
        for(RestaurantDetails restaurant : restaurantDetails){
            restaurantResponseList.add(
                    RestaurantResponse.builder()
                            .restroName(restaurant.getRestroName())
                            .restroType(restaurant.getRestroType())
                            .build()
            );
        }
        return restaurantResponseList;
    }
}
