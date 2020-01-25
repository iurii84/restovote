package restovote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restovote.model.Restaurant;
import restovote.service.RestaurantService;

import java.util.List;

@RestController
@RequestMapping(value = "/restaurants", produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantController {
    private RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @SuppressWarnings("unchecked")
    @GetMapping
    public List<Restaurant> getAllParticipatingRestaurants() {
        System.out.println("getAllParticipatingRestaurants");
        return restaurantService.getAllParticipatingRestaurants();
    }
}
