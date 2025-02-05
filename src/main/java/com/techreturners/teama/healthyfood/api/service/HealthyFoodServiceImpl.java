package com.techreturners.teama.healthyfood.api.service;

import com.techreturners.teama.healthyfood.api.model.Category;
import com.techreturners.teama.healthyfood.api.model.Diet;
import com.techreturners.teama.healthyfood.api.model.Ingredient;
import com.techreturners.teama.healthyfood.api.model.Meal;
import com.techreturners.teama.healthyfood.api.repository.CategoryRepository;
import com.techreturners.teama.healthyfood.api.repository.DietRepository;
import com.techreturners.teama.healthyfood.api.repository.IngredientRepository;
import com.techreturners.teama.healthyfood.api.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HealthyFoodServiceImpl implements HealthyFoodService {

    private final int MAX_MEAL_FILTERED_RESULTS = 3;

    @Autowired
    MealRepository mealRepository;

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    DietRepository dietRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Meal> getMeals(Integer calories, List<Long> excludedIngredients, List<Long> diets, List<Long> categories) {
        return mealRepository.getMeals(calories,
                excludedIngredients == null ? new ArrayList<>() : excludedIngredients,
                diets == null ? new ArrayList<>() : diets, diets == null,
                categories == null ? new ArrayList<>() : categories, categories == null,
                MAX_MEAL_FILTERED_RESULTS);
    }

    @Override
    public List<Ingredient> getAllIngredients(){
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(ingredients::add);
        return ingredients;
    }

    @Override
    public Ingredient getIngredientById(Long id) {
        return ingredientRepository.findById(id).get();
    }

    @Override
    public Ingredient getIngredientByName(String ingredientName){
        return ingredientRepository.findByName(ingredientName);
    }

    @Override
    public List<Diet> getAllDiets() {
        List<Diet> diet = new ArrayList<>();
        dietRepository.findAll().forEach(diet::add);
        return diet;
    }

    @Override
    public Diet getDietById(Long id) {
        return dietRepository.findById(id).get();
    }

    @Override
     public Diet getDietByName(String dietName){

        return dietRepository.findByName(dietName);
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> category = new ArrayList<>();
        categoryRepository.findAll().forEach(category::add);
        return category;
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category getCategoryByName(String categoryName){
        return categoryRepository.findByName(categoryName);
    }

    @Override
    public List<Meal> getAllMeals() {
        List<Meal> meal = new ArrayList<>();
        mealRepository.findAll().forEach(meal::add);
        return meal;
    }

    @Override
    public Meal getMealById(Long id) {
        return mealRepository.findById(id).get();
    }
}
