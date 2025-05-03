package com.restaurant.restaurant_app.service;

import com.restaurant.restaurant_app.entity.RestaurantDetails;
import com.restaurant.restaurant_app.model.RestaurantRequest;
import com.restaurant.restaurant_app.model.RestaurantResponse;
import com.restaurant.restaurant_app.repository.RestaurantDetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@TestPropertySource(properties = "test.property.dummy=ABC")
class RestaurantServiceImplTest {

    @Mock
    private RestaurantDetailsRepository restaurantDetailsRepository;

    @InjectMocks
    private RestaurantServiceImpl restaurantService;

    private RestaurantRequest mockRequest;
    private RestaurantDetails mockResponseDetails;

    @BeforeEach
    void setup() {
        mockRequest = RestaurantRequest.builder()
                .restroName("Test Restro")
                .restroType("Non-veg")
                .address("Mock Address")
                .city("Pune")
                .state("Maharashtra")
                .pinCode(122345)
                .mobile(1234567890L)
                .build();

        mockResponseDetails = RestaurantDetails.builder()
                .restroId(2)
                .restroName("Test Restro")
                .restroType("Non-veg")
                .build();
    }

    @Test
    void itShouldReturnTrueIfRestaurantAddedSuccessfully() {
        // when
        when(restaurantDetailsRepository.save(any(RestaurantDetails.class))).thenReturn(mockResponseDetails);

        Boolean result = restaurantService.addRestaurant(mockRequest);

        // then
        assertTrue(result);
    }

    @Test
    void itShouldReturnFalseIfRestaurantIsNotSaved() {
        // when
        when(restaurantDetailsRepository.save(any(RestaurantDetails.class))).thenReturn(null);

        Boolean result = restaurantService.addRestaurant(mockRequest);

        // then
        assertFalse(result);
    }

    @Test
    void itShouldReturnListOfRestaurantsForAValidRestroType() {
        // when
        when(restaurantDetailsRepository.getRestaurantByRestroType(anyString())).thenReturn(List.of(mockResponseDetails));

        List<RestaurantResponse> result = restaurantService.getRestuarantsByRestroType("Non-veg");

        // then
        assertFalse(result.isEmpty());
        assertEquals(mockResponseDetails.getRestroType(), result.get(0).getRestroType());
    }

    @Test
    void itShouldReturnEmptyListOfRestaurantsForRestroType() {
        // when
        when(restaurantDetailsRepository.getRestaurantByRestroType(anyString())).thenReturn(Collections.emptyList());

        List<RestaurantResponse> result = restaurantService.getRestuarantsByRestroType("Veg");

        // then
        assertTrue(result.isEmpty());
    }
}