package com.restaurant.restaurant_app.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
@Table(name = "restaurant_address_details")
public class RestaurantAddressDetails {

    @Id
    @Column(name = "restro_address_id")
    private Integer restroAddressId;

    @ManyToOne
    @JoinColumn(name = "restro_id", referencedColumnName = "restro_id")
    private RestaurantDetails restaurantDetails;

    @Column(name = "address_line_1")
    private String address_line_1;

    @Column(name = "address_line_2")
    private String address_line_2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "pin_code")
    private Integer pinCode;

}
