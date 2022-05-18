package com.techreturners.teama.healthyfood.api.service;

import com.techreturners.teama.healthyfood.api.model.MealPlan;

import java.time.LocalDateTime;
import java.util.List;

public interface MealPlanService {

    List<MealPlan> getAllMealPlans(Long userId);

    MealPlan createMealPlan(Long mealid, Long userId, LocalDateTime dateadded);

    MealPlan getMealPlanById(Long id);

    MealPlan insertIntoMealPlan(MealPlan mealPlan);

    void updateMealPlanById(Long id);

    void deleteMealPlanById(Long id);
}
