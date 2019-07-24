package restovoteApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restovoteApp.model.Meal;
import restovoteApp.repository.repositoryInterfaces.MealRepositoryInterface;

import java.util.List;

@RestController
@RequestMapping("/")
public class MealRestController {
    private MealRepositoryInterface mealRepositoryInterface;


    @Autowired
    public MealRestController (MealRepositoryInterface mealRepositoryInterface){
        this.mealRepositoryInterface = mealRepositoryInterface;

    }


    @GetMapping("/")
    public String helloMessanger() {
        return "Hello from restoVote";
    }


    @GetMapping("/getallmealbyrestaurantid")
    public List<Meal> getAllMeal(){
        System.out.println("getallmealbyrestaurantid");
        return mealRepositoryInterface.getByRestaurant(1L);
    }
}
