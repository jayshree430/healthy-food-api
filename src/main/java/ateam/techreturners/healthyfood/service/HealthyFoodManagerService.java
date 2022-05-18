package ateam.techreturners.healthyfood.service;

import ateam.techreturners.healthyfood.model.*;

import java.util.List;

public interface HealthyFoodManagerService {
    List<Ingredient> getAllIngredients();

    List<Diet> getAllDiets();

    List<Meal> getMeals(Long calories, List<String> excludedIngredients, List<String> excludedDiets, String category);

    List<Category> getAllCategories();
}
