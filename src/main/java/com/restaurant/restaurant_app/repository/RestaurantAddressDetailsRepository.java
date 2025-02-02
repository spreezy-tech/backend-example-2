package com.restaurant.restaurant_app.repository;

import com.restaurant.restaurant_app.entity.RestaurantAddressDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantAddressDetailsRepository extends JpaRepository<RestaurantAddressDetails, Integer> {
}
