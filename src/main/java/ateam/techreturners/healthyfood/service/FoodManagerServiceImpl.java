package ateam.techreturners.healthyfood.service;

import ateam.techreturners.healthyfood.model.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class FoodManagerServiceImpl implements FoodManagerService {

    @Override
    public List<Ingredient> getAllIngredients() {
        return new ArrayList<>();
    }

    @Override
    public List<Diet> getAllDiets() {
        return new ArrayList<>();
    }

    @Override
    public List<Meal> getMeals(Long calories, List<String> excludedIngredients, List<String> excludedDiets) {
        return new ArrayList<>();
    }

    @Override
    public List<MealPlan> getMealPlans() {
        return new ArrayList<>();
    }

    @Override
    public MealPlan createMealPlan(Long mealid, Long userId, LocalDateTime dateadded) {
        return null;
    }
}
