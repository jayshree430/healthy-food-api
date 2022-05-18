package com.techreturners.teama.healthyfood.api.service;

import com.techreturners.teama.healthyfood.api.model.MealPlan;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MealPlanServiceImpl implements MealPlanService {

    @Override
    public List<MealPlan> getAllMealPlans(Long userId) {
        return new ArrayList<>();
    }

    @Override
    public MealPlan createMealPlan(Long mealid, Long userId, LocalDateTime dateadded) {
        return null;
    }

    @Override
    public MealPlan getMealPlanById(Long id) {
        return null;
    }

    @Override
    public MealPlan insertIntoMealPlan(MealPlan mealPlan) {
        return null;
    }

    @Override
    public void updateMealPlanById(Long id) {

    }

    @Override
    public void deleteMealPlanById(Long id) {

    }
}
