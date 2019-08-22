package restovoteApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restovoteApp.repository.repositoryInterfaces.MealRepositoryInterface;

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
}
