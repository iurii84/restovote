package restovoteApp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import restovoteApp.service.MealService;

@RestController
@RequestMapping(value = "/admin/meal", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminMealRestController {
    private MealService mealService;

    @Autowired
    public AdminMealRestController(MealService mealService) {
        this.mealService = mealService;

    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMeal(@PathVariable Long id) {
        long authorisedUser = 1;

        System.out.println("meal_id = " + id);
        mealService.delete(id, authorisedUser); // TODO implement users authentication


    }
}
