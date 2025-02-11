package com.restaurant.restaurant_app.repository;

import com.restaurant.restaurant_app.entity.RestaurantDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantDetailsRepository extends JpaRepository<RestaurantDetails, Integer> {

    // Query as function Name
    public List<RestaurantDetails> findByRestroType(String restroType);
    // select * from restaurants where restro_type = :restroType

    @Query(value = """
            select
              *
            from
              restaurant_details rd
            where
              rd.restro_type = ?
            """, nativeQuery = true)
    public List<RestaurantDetails> getRestaurantByRestroType(String restroType);
}
