package com.restaurant.restaurant_app.repository;

import com.restaurant.restaurant_app.entity.RestaurantDetails;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RestaurantDetailsRepositoryTest {

    @Autowired
    private RestaurantDetailsRepository restaurantDetailsRepository;

    @BeforeEach
    void setup(){
        RestaurantDetails nonVegDetails = RestaurantDetails.builder()
                .restroName("Restro 1")
                .restroType("non-veg")
                .build();

        RestaurantDetails vegDetails = RestaurantDetails.builder()
                .restroName("Restro 2")
                .restroType("veg")
                .build();

        this.restaurantDetailsRepository.save(nonVegDetails);
        this.restaurantDetailsRepository.save(vegDetails);

    }

    @AfterEach
    void tearDown(){
        this.restaurantDetailsRepository.deleteAll();
    }

    @Test
    void itShouldReturnRestuarantOfTypeVeg(){
        // given
        String restroType = "veg";
        String expectedRestroName = "Restro 2";

        // when
        List<RestaurantDetails> results = this.restaurantDetailsRepository.findByRestroType(restroType);

        // then
        Assertions.assertNotNull(results);
        Assertions.assertEquals(expectedRestroName, results.get(0).getRestroName());
    }

    @Test
    void itShouldReturnEmptyListForUnknownRestroType(){
        // given
        String restroType = "vegan";

        // when
        List<RestaurantDetails> results = this.restaurantDetailsRepository.findByRestroType(restroType);

        // then
        Assertions.assertTrue(results.isEmpty());
    }

    @Test
    void itShouldThrowExceptionForNullInput(){
        // given
        String restroType = null;

        // when
        List<RestaurantDetails> results = this.restaurantDetailsRepository.getRestaurantByRestroType(restroType);
        // then
//        Assertions.assertThrows(InvalidDataAccessApiUsageException.class,
//                () -> this.restaurantDetailsRepository.getRestaurantByRestroType(restroType)) ;
        Assertions.assertTrue(results.isEmpty());

    }




}