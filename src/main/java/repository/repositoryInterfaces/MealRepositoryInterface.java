package repository.repositoryInterfaces;

import model.Meal;

import java.time.LocalDateTime;
import java.util.List;

public interface MealRepositoryInterface {
    // null if updated meal do not belong to userId
    Meal save(Meal meal, Long userId, Long restoId);

    // false if meal do not belong to userId
    boolean delete(Long id, Long userId);

    // null if meal do not belong to userId
    Meal get(Long id, Long userId);

    //  null if meal do not belong to userId
    List getAll(Long userId);

}
