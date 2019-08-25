package restovoteApp.service;

import org.springframework.stereotype.Service;
import restovoteApp.model.Restaurant;
import restovoteApp.repository.RestaurantRepository;

@Service
public class RestaurantService {
    private RestaurantRepository restaurantRepository;
    public RestaurantService (RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }
    public Restaurant create(Restaurant restaurant, Long authUser) {
        return restaurantRepository.save(restaurant, authUser);
    }
}
