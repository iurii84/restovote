package restovoteApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restovoteApp.model.Meal;
import restovoteApp.repository.MealRepositoryInterface;

import java.util.List;

@Service
public class MealService {
    private final MealRepositoryInterface mealRepository;

    @Autowired
    public MealService(MealRepositoryInterface mealRepository) {
        this.mealRepository = mealRepository;
    }


    public void delete(Long mealId, Long userId) {
        mealRepository.delete(mealId, userId);
    }

    public List getAllMealByRestoId(Long restoId) {
        return mealRepository.getByRestaurant(restoId);
    }

    public Meal createMeal(Meal meal, Long authUser, Long restoId) {
        System.out.println("Meal " + meal.getDescription() + " " + meal.getPrice());
        System.out.println("resto ID " + restoId);

        return mealRepository.save(meal, authUser, restoId);
    }

    public Meal getById(Long id) {
        return mealRepository.get(id);
    }
}
