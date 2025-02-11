package com.restaurant.restaurant_app.controller;


import com.restaurant.restaurant_app.model.RestaurantRequest;
import com.restaurant.restaurant_app.model.RestaurantResponse;
import com.restaurant.restaurant_app.service.RestaurantService;
import com.restaurant.restaurant_app.service.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/restro")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(@Qualifier("restaurantServiceImpl") RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }


    @GetMapping("/new")
    public ResponseEntity<String> helloWorld() {
        return new ResponseEntity<>("Hello from API", HttpStatus.ACCEPTED);
    }

    @GetMapping("/new/{name}/{type}")
    public ResponseEntity<String> helloWorld2(@PathVariable String name, @PathVariable String type){
        return new ResponseEntity<>("Hello from API | Name : " + name + " | Type : " + type, HttpStatus.OK);
    }

    @GetMapping("/getAllRestaurants")
    public ResponseEntity<List<RestaurantResponse>> getAllRestaurants(){
        return new ResponseEntity<>(restaurantService.getRestuarants(), HttpStatus.OK);
    }


    @GetMapping("/getRestaurants/{restroType}")
    public ResponseEntity<List<RestaurantResponse>> getRestaurantsByType(@PathVariable String restroType){
        return new ResponseEntity<>(restaurantService.getRestuarantsByRestroType(restroType), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> registerRestaurant(@RequestBody RestaurantRequest restaurantRequest) {
//        System.out.println(restaurantRequest);
        restaurantService.addRestaurant(restaurantRequest);
        return new ResponseEntity<>("Restro Name is " + restaurantRequest.getRestroName() + " and city is " + restaurantRequest.getCity(), HttpStatus.OK);
    }


}
