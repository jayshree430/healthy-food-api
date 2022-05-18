package ateam.techreturners.healthyfood.service;

import ateam.techreturners.healthyfood.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HealthyFoodManagerServiceImpl implements HealthyFoodManagerService {

    @Override
    public List<Ingredient> getAllIngredients() {
        return new ArrayList<>();
    }

    @Override
    public List<Diet> getAllDiets() {
        return new ArrayList<>();
    }

    @Override
    public List<Meal> getMeals(Long calories, List<String> excludedIngredients, List<String> excludedDiets, String category) {
        return new ArrayList<>();
    }

    @Override
    public List<Category> getAllCategories() {
        return new ArrayList<>();
    }
}
