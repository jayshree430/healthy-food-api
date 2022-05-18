package ateam.techreturners.healthyfood.service;

import ateam.techreturners.healthyfood.model.MealPlan;

import java.time.LocalDateTime;
import java.util.List;

public interface MealPlanService {

    List<MealPlan> getAllMealPlans();

    MealPlan createMealPlan(Long mealid, Long userId, LocalDateTime dateadded);

    MealPlan getMealPlanById(Long id);

    MealPlan insertIntoMealPlan(MealPlan mealPlan);

    void updateMealPlanById(Long id);

    void deleteMealPlanById(Long id);
}
