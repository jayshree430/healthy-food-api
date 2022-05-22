package com.techreturners.teama.healthyfood.api.service;

import com.techreturners.teama.healthyfood.api.model.*;
import com.techreturners.teama.healthyfood.api.repository.CategoryRepository;
import com.techreturners.teama.healthyfood.api.repository.DietRepository;
import com.techreturners.teama.healthyfood.api.repository.IngredientRepository;
import com.techreturners.teama.healthyfood.api.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class HealthyFoodServiceImpl implements HealthyFoodService {

    private final int MAX_MEAL_FILTERED_RESULTS = 3;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    IngredientRepository ingredientRepository;
    @Autowired
    DietRepository dietRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    MealRepository mealRepository;

    @Override
    public List<Meal> getMeals(Integer calories, List<Long> excludedIngredients, List<Long> diets, String category) {
        return mealRepository.getMeals(calories,
                excludedIngredients == null ? new ArrayList<>() : excludedIngredients,
                diets == null ? new ArrayList<>() : diets, diets == null,
                MAX_MEAL_FILTERED_RESULTS);
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(ingredients::add);
        return ingredients;
    }

    @Override
    public Ingredient getIngredientById(Long id) {
        return null;
    }

    @Override
    public List<Diet> getAllDiets() {
        List<Diet> diets = new ArrayList<>();
        dietRepository.findAll().forEach(diets::add);
        return diets;
    }

    @Override
    public Diet getDietById(Long id) {
        return null;
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        categoryRepository.findAll().forEach(categories::add);
        return categories;
    }

    @Override
    public Category getCategoryById(Long id) {
        return null;
    }

    @Override
    public List<Meal> getAllMeals() {
        List<Meal> meals = new ArrayList<>();
        mealRepository.findAll().forEach(meals::add);
        return meals;
    }

    @Override
    public Meal getMealById(Long id) {
        return null;
    }
}
