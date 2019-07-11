package restovoteApp.repository.repositoryInterfaces;

import restovoteApp.model.Meal;

import java.util.List;

public interface MealRepositoryInterface {
    // null if updated meal do not belong to userId
    Meal save(Meal meal, Long userId, Long restoId);

    // false if meal do not belong to userId
    boolean delete(Long id, Long userId);


    Meal get(Long id);


    List getByRestaurant(Long restoId);

}
