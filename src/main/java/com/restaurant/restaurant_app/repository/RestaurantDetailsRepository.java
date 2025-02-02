package com.restaurant.restaurant_app.repository;

import com.restaurant.restaurant_app.entity.RestaurantDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantDetailsRepository extends JpaRepository<RestaurantDetails, Integer> {
}
