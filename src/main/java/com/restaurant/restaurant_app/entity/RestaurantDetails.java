package com.restaurant.restaurant_app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column(name = "restro_id")
    private Integer restroId;

    @Column(name = "restro_name")
    private String restroName;

    @Column(name = "restro_type")
    private String restroType;
}
