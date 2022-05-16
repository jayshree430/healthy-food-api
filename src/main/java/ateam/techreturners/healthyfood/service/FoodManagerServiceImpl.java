package ateam.techreturners.healthyfood.service;

import ateam.techreturners.healthyfood.model.*;
import org.springframework.stereotype.Service;

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
    public MealPlan createMealPlan(MealPlanRequest mealPlanRequest) {
        MealPlan newMealPlan = new MealPlan();
        newMealPlan.setUserId(1L);
        newMealPlan.setDailyMeals(mealPlanRequest.getDailyMeals());

        return newMealPlan;
    }

    @Override
    public List<MealPlan> getMealPlans() {
        return new ArrayList<>();
    }
}
