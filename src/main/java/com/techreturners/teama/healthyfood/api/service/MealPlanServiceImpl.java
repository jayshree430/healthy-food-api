package com.techreturners.teama.healthyfood.api.service;

import com.mysql.cj.log.Log;
import com.techreturners.teama.healthyfood.api.model.MealPlan;
import com.techreturners.teama.healthyfood.api.repository.MealPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MealPlanServiceImpl implements MealPlanService {

    @Autowired
    MealPlanRepository mealRepository;

    @Override
    public List<MealPlan> getAllMealPlans(Long userId){
         return mealRepository.getAllMealPlan(userId);
    }

    @Override
    public MealPlan createMealPlan(Long mealid, Long userId, LocalDateTime date) {
        return (MealPlan) mealRepository.createMealPlan(mealid, userId, date);

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
