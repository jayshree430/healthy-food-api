package ateam.techreturners.healthyfood.service;

import ateam.techreturners.healthyfood.model.MealPlan;

import java.util.List;

public interface MealPlanService {

    List<MealPlan> getAllMealPlans();

    MealPlan getMealPlanById(Long id);

    MealPlan insertIntoMealPlan(MealPlan mealPlan);

    void updateMealPlanById(Long id);

    void deleteMealPlanById(Long id);
}
