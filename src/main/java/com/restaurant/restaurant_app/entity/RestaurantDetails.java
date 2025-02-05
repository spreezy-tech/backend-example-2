package com.restaurant.restaurant_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "restaurant_details")
public class RestaurantDetails {

    @Id
    @SequenceGenerator(name = "seq_restaurant_details", sequenceName = "seq_restaurant_details", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_restaurant_details")
    @Column(name = "restro_id")
    private Integer restroId;

    @Column(name = "restro_name")
    private String restroName;

    @Column(name = "restro_type")
    private String restroType;
}
