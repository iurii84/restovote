package restovoteApp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import restovoteApp.SecurityUtil;
import restovoteApp.model.Meal;
import restovoteApp.service.MealService;

import java.net.URI;

@RestController
@RequestMapping(value = "/admin/meal", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminMealController {
    private MealService mealService;


    @Autowired
    public AdminMealController(MealService mealService) {
        this.mealService = mealService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Meal> createMeal(@RequestBody Meal meal,
                                           @RequestParam Long restoId) {
        long authorisedUser = SecurityUtil.authUserId();
        System.out.println("Authorised user ID is - " + authorisedUser);
        Meal created = mealService.createMeal(meal, authorisedUser, restoId);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/meal/" + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMeal(@PathVariable Long id) {
        long authorisedUser = SecurityUtil.authUserId();
        System.out.println("meal_id = " + id);
        mealService.delete(id, authorisedUser); // TODO implement users authentication
    }
}
