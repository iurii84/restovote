package restovoteApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import restovoteApp.model.Meal;
import restovoteApp.service.MealService;

import java.util.List;

@RestController
@RequestMapping(value = "/meal", produces = MediaType.APPLICATION_JSON_VALUE)
public class MealRestController {
    private MealService mealService;


    @Autowired
    public MealRestController (MealService mealService){
        this.mealService = mealService;

    }


    @GetMapping
    public String helloMessanger() {
        return "Hello from restoVote";
    }


    @SuppressWarnings("unchecked")
    @GetMapping("/resto")
    public List<Meal> getAllMealByRestoID(@RequestParam(name = "id") Long restoId) {
        System.out.println("getallmealbyrestaurantid");
        return mealService.getAllMealByRestoId(restoId);
    }


}
