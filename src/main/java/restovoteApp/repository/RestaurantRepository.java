package restovoteApp.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import restovoteApp.model.Restaurant;
import restovoteApp.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
@Transactional(readOnly = true)
public class RestaurantRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Restaurant save(Restaurant restaurant, Long authUser) {
        if (!restaurant.isNew() && get(restaurant.getId()) == null)
            return null;
        restaurant.setCreatedBy(entityManager.getReference(User.class, authUser));
        if (restaurant.isNew()) {
            entityManager.persist(restaurant);
            return restaurant;
        }
        else return entityManager.merge(restaurant);
    }

    private Restaurant get(Long restaurantId) {
        Query getQuery = entityManager.createNamedQuery(Restaurant.GET_BY_ID)
                .setParameter("id", restaurantId);
        return (Restaurant) getQuery.getSingleResult();

    }

}
