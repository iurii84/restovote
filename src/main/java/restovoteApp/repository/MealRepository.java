package restovoteApp.repository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;
import restovoteApp.model.Meal;
import restovoteApp.model.Restaurant;
import restovoteApp.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
@Transactional(readOnly = true)
public class MealRepository {
    @PersistenceContext
    private EntityManager em;



    @Transactional
    public Meal save(Meal meal, Long userId, Long restoId) {
        if (!meal.isNew() && get(meal.getId()) == null) {
            return null;
        }
        meal.setUser(em.getReference(User.class, userId));
        meal.setRestaurant(em.getReference(Restaurant.class, restoId));

        if (meal.isNew()) {
            em.persist(meal);
            return meal;
        } else return em.merge(meal);

    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @Modifying
    @Transactional
    public boolean delete(Long id, Long userId) {
        return em.createNamedQuery(Meal.DELETE)
                .setParameter("id", id)
                .setParameter("userId", userId)
                .executeUpdate() != 0;

    }


    public Meal get(Long id) {
        Query getQuery = em.createNamedQuery(Meal.GET_BY_ID)
                .setParameter("id", id);
        return (Meal) getQuery.getSingleResult();
    }

    @SuppressWarnings("unchecked")

    public List<Meal> getByRestaurant(Long restoId) {
        Query getQuery = em.createNamedQuery(Meal.GET_BY_RESTO_ID)
                .setParameter("restoid", restoId);

        return getQuery.getResultList();
    }
}

