package ateam.techreturners.healthyfood.service;

import ateam.techreturners.healthyfood.model.*;

import java.util.List;

public interface HealthyFoodService {

    List<Meal> getMeals(Long calories, List<String> excludedIngredients, List<String> excludedDiets, String category);

    List<Ingredient> getAllIngredients();
    Ingredient getIngredientById(Long id);

    List<Diet> getAllDiets();
    Diet getDietById(Long id);

    List<Category> getAllCategories();
    Category getCategoryById(Long id);

    List<Meal> getAllMeals();
    Meal getMealById(Long id);
}
