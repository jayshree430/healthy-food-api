package com.techreturners.teama.healthyfood.api.service;

import com.techreturners.teama.healthyfood.api.model.Category;
import com.techreturners.teama.healthyfood.api.model.Diet;
import com.techreturners.teama.healthyfood.api.model.Ingredient;
import com.techreturners.teama.healthyfood.api.model.Meal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HealthyFoodServiceImpl implements HealthyFoodService {

    @Override
    public List<Meal> getMeals(Long calories, List<String> excludedIngredients, List<String> excludedDiets, String category) {
        return new ArrayList<>();
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return new ArrayList<>();
    }

    @Override
    public Ingredient getIngredientById(Long id) {
        return null;
    }

    @Override
    public List<Diet> getAllDiets() {
        return new ArrayList<>();
    }

    @Override
    public Diet getDietById(Long id) {
        return null;
    }

    @Override
    public List<Category> getAllCategories() {
        return new ArrayList<>();
    }

    @Override
    public Category getCategoryById(Long id) {
        return null;
    }

    @Override
    public List<Meal> getAllMeals() {
        return null;
    }

    @Override
    public Meal getMealById(Long id) {
        return null;
    }
}
