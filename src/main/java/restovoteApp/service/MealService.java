package restovoteApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restovoteApp.repository.repositoryInterfaces.MealRepositoryInterface;

@Service
public class MealService {
    private final MealRepositoryInterface mealRepository;

    @Autowired
    public MealService(MealRepositoryInterface mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Transactional
    public void delete(Long mealId, Long userId) {
        mealRepository.delete(mealId, userId);
    }
}
