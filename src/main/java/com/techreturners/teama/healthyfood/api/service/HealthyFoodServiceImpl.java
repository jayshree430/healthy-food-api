package com.techreturners.teama.healthyfood.api.service;

import com.techreturners.teama.healthyfood.api.model.*;
import com.techreturners.teama.healthyfood.api.repository.CategoryRepository;
import com.techreturners.teama.healthyfood.api.repository.DietRepository;
import com.techreturners.teama.healthyfood.api.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HealthyFoodServiceImpl implements HealthyFoodService {

    @Autowired
    IngredientRepository ingredientRepository;
    @Autowired
    DietRepository dietRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Meal> getMeals(Long calories, List<String> excludedIngredients, List<String> excludedDiets, String category) {
        return new ArrayList<>();
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
        return null;
    }

    @Override
    public Meal getMealById(Long id) {
        return null;
    }
}
