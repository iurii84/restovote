package restovoteApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    private long authorisedUser = 1;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant createdRestaurant = restaurantService.create(restaurant, authorisedUser);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/resto/" + "/{id")
                .buildAndExpand(createdRestaurant.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(createdRestaurant);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRestaurant(@PathVariable long id) {
        restaurantService.delete(id, authorisedUser);
    }
}
