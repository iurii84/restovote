package repository;

import model.Meal;
import model.Restaurant;
import model.User;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import repository.repositoryInterfaces.MealRepositoryInterface;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class MealRepositoryInterfaceImpl implements MealRepositoryInterface {
    @PersistenceContext
    private EntityManager em;


    @Override
    @Transactional
    public Meal save(Meal meal, Long userId, Long restoId) {
        if (!meal.isNew() && get(meal.getId()) == null) {
            return null;
        }
        meal.setUser(em.getReference(User.class, userId));
        meal.setRestaurant(em.getReference(Restaurant.class, restoId));

        if (meal.isNew()){
            em.persist(meal);
            return meal;
        }
        else return em.merge(meal);

    }

    @Override
    @Transactional
    public boolean delete(Long id, Long userId) {
        return em.createNamedQuery(Meal.DELETE)
                .setParameter("id", id)
                .setParameter("userId", userId)
                .executeUpdate() != 0;
    }

    @Override
    public Meal get(Long id) {
        Query getQuery = em.createNamedQuery(Meal.GET_BY_ID)
                .setParameter("id", id);
        return (Meal) getQuery.getSingleResult();
    }

    @Override
    public List getByRestaurant(Long restoId) {
        return null;
    }
}

