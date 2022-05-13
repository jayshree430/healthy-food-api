package techreturners.healthyfood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import techreturners.healthyfood.model.*;
import techreturners.healthyfood.service.FoodManagerService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/healthyfood")
public class HealthyFoodController {

    @Autowired
    FoodManagerService foodManagerService;

    @GetMapping({"/ingredient"})
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        List<Ingredient> allIngredients = foodManagerService.getAllIngredients();
        return new ResponseEntity<>(allIngredients, HttpStatus.OK);
    }

    @GetMapping({"/diet"})
    public ResponseEntity<List<Diet>> getAllDiets() {
        List<Diet> allDiets = foodManagerService.getAllDiets();
        return new ResponseEntity<>(allDiets, HttpStatus.OK);
    }

    @GetMapping({"/meal"})
    public ResponseEntity<List<Meal>> getMeals(@RequestParam Long calories, @RequestParam List<String> excludedIngredients, @RequestParam List<String> excludedDiets) {
        List<Meal> meals = foodManagerService.getMeals(calories, excludedIngredients, excludedDiets);
        return new ResponseEntity<>(meals, HttpStatus.OK);
    }

    @GetMapping({"/mealplan"})
    public ResponseEntity<List<MealPlan>> getMealPlans() {
        List<MealPlan> mealPlans = foodManagerService.getMealPlans(); // For Authenticated user
        return new ResponseEntity<>(mealPlans, HttpStatus.OK);
    }

    @PostMapping(value = {"/mealplan"})
    public ResponseEntity<MealPlan> createMealPlan(@RequestBody MealPlanRequest mealPlanRequest) {
        MealPlan mealPlan = foodManagerService.createMealPlan(mealPlanRequest);
        return new ResponseEntity<>(mealPlan, HttpStatus.CREATED);
    }
}
