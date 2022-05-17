package ateam.techreturners.healthyfood.service;

import ateam.techreturners.healthyfood.model.MealPlan;

import java.time.LocalDateTime;
import java.util.List;

public interface MealPlanManagerService {
    List<MealPlan> getMealPlans();

    MealPlan createMealPlan(Long mealid, Long userId, LocalDateTime dateadded);
}
