package com.restaurant.restaurant_app.service;

import com.restaurant.restaurant_app.entity.RestaurantDetails;
import com.restaurant.restaurant_app.model.RestaurantRequest;
import com.restaurant.restaurant_app.model.RestaurantResponse;
import com.restaurant.restaurant_app.repository.RestaurantDetailsRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<RestaurantResponse> getRestuarants() {
        List<RestaurantDetails> restaurantDetails = restaurantDetailsRepository.findAll();
        List<RestaurantResponse> listOfRestaurants = mapEntityToDTO(restaurantDetails);
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
