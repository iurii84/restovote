package restovoteApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import restovoteApp.model.Restaurant;
import restovoteApp.service.RestaurantService;

import java.net.URI;

@RestController
@RequestMapping(value = "/resto", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminRestaurantController {

    private RestaurantService restaurantService;
    @Autowired
    public AdminRestaurantController(RestaurantService restaurantService){
        this.restaurantService = restaurantService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant createdRestaurant = restaurantService.create();
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/resto/" + "/{id")
                .buildAndExpand(createdRestaurant.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(createdRestaurant);
    }
}
