package restovote.service;

import org.springframework.stereotype.Service;
import restovote.model.Restaurant;
import restovote.repository.RestaurantRepository;

import java.util.List;

@Service
public class RestaurantService {
    private RestaurantRepository restaurantRepository;
    public RestaurantService (RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }
    public Restaurant create(Restaurant restaurant, Long authUser) {
        return restaurantRepository.save(restaurant, authUser);
    }

    public void delete(long restoId, long userId ) {
        restaurantRepository.delete(restoId, userId);
    }

    public List getAllParticipatingRestaurants() {
        return restaurantRepository.getAll();
    }
}
