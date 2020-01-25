package restovote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import restovote.SecurityUtil;
import restovote.model.Restaurant;
import restovote.service.RestaurantService;

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
        long authorisedUser = SecurityUtil.authUserId();
        Restaurant createdRestaurant = restaurantService.create(restaurant, authorisedUser);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/resto/" + "/{id")
                .buildAndExpand(createdRestaurant.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(createdRestaurant);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRestaurant(@PathVariable long id) {
        long authorisedUser = SecurityUtil.authUserId();
        restaurantService.delete(id, authorisedUser);
    }
}
