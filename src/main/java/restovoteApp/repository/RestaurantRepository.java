package restovoteApp.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import restovoteApp.model.Restaurant;

@Repository
public class RestaurantRepository {
    @Transactional
    public Restaurant save() {
        return null;
    }

}
