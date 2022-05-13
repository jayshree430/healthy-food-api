package techreturners.healthyfood.service;

import techreturners.healthyfood.model.*;

import java.util.List;

public interface FoodManagerService {
    List<Ingredient> getAllIngredients();

    List<Diet> getAllDiets();

    List<Meal> getMeals(Long calories, List<String> excludedIngredients, List<String> excludedDiets);

    MealPlan createMealPlan(MealPlanRequest mealPlanRequest);

    List<MealPlan> getMealPlans();
}
