package ateam.techreturners.healthyfood.service;

import ateam.techreturners.healthyfood.model.*;

import java.time.LocalDateTime;
import java.util.List;

public interface FoodManagerService {
    List<Ingredient> getAllIngredients();

    List<Diet> getAllDiets();

    List<Meal> getMeals(Long calories, List<String> excludedIngredients, List<String> excludedDiets);

    List<MealPlan> getMealPlans();

    MealPlan createMealPlan(Long mealid, Long userId, LocalDateTime dateadded);
}
