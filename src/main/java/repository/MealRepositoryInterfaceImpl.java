package repository;

import model.Meal;
import model.Restaurant;
import model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import repository.repositoryInterfaces.MealRepositoryInterface;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class MealRepositoryInterfaceImpl implements MealRepositoryInterface {
    @PersistenceContext
    private EntityManager em;


    @Override
    @Transactional
    public Meal save(Meal meal, Long userId, Long restoId) {
        if (!meal.isNew() && get(meal.getId(), userId) == null) {
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
        return false;
    }

    @Override
    public Meal get(Long id, Long userId) {
        return null;
    }

    @Override
    public List getAll(Long userId) {
        return null;
    }
}

