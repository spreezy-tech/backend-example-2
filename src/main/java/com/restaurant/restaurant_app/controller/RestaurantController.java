package com.restaurant.restaurant_app.controller;


import com.restaurant.restaurant_app.model.RestaurantRequest;
import com.restaurant.restaurant_app.service.RestaurantService;
import com.restaurant.restaurant_app.service.RestaurantServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restro")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantServiceImpl restaurantService) {
        this.restaurantService = restaurantService;
    }


    @GetMapping("/new")
    public ResponseEntity<String> helloWorld() {
        return new ResponseEntity<>("Hello from API", HttpStatus.ACCEPTED);
    }

    @PostMapping("/create")
    public ResponseEntity<String> registerRestaurant(@RequestBody RestaurantRequest restaurantRequest) {
//        System.out.println(restaurantRequest);
        restaurantService.addRestaurant(restaurantRequest);
        return new ResponseEntity<>("Restro Name is " + restaurantRequest.getRestroName() + " and city is " + restaurantRequest.getCity(), HttpStatus.OK);
    }


}
