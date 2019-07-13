package restovoteApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restovoteApp.model.Meal;
import restovoteApp.repository.repositoryInterfaces.MealRepositoryInterface;

import java.util.List;

@RestController
@RequestMapping("/meallist")
public class MealRestController {
    private MealRepositoryInterface mealRepositoryInterface;


    @Autowired
    public MealRestController (MealRepositoryInterface mealRepositoryInterface){
        this.mealRepositoryInterface = mealRepositoryInterface;

    }




    @GetMapping("/get")
    public List<Meal> getAllMeal(){
        System.out.println("getAllMeal");
        return mealRepositoryInterface.getByRestaurant(1l);
    }
}
