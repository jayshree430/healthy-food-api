package ateam.techreturners.healthyfood.service;

import ateam.techreturners.healthyfood.model.MealPlan;

import java.util.List;

public interface MealPlanService {

    List<MealPlan> getAllMealPlans();

    MealPlan getMealPlanById(Long id);

    void updateMealPlanById(Long id);

    void deleteMealPlanById(Long id);
}
