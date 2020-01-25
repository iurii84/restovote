package restovote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restovote.model.Meal;
import restovote.service.MealService;

import java.util.List;

@RestController
@RequestMapping(value = "/meal", produces = MediaType.APPLICATION_JSON_VALUE)
public class MealController {
    private MealService mealService;


    @Autowired
    public MealController(MealService mealService){
        this.mealService = mealService;
    }

    @GetMapping("/{id}")
    public Meal getMealById(@PathVariable Long id) {
        return mealService.getById(id);
    }

    @SuppressWarnings("unchecked")
    //@Secured("IS_AUTHENTICATED")
    @GetMapping("/resto/{restoId}")
    public List<Meal> getAllMealByRestoID(@PathVariable Long restoId) {
        System.out.println("getallmealbyrestaurantid");
        return mealService.getAllMealByRestoId(restoId);
    }
}
