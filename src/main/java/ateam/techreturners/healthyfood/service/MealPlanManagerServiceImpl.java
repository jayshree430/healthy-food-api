package ateam.techreturners.healthyfood.service;

import ateam.techreturners.healthyfood.model.MealPlan;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MealPlanManagerServiceImpl implements MealPlanManagerService {
    @Override
    public List<MealPlan> getMealPlans() {
        return new ArrayList<>();
    }

    @Override
    public MealPlan createMealPlan(Long mealid, Long userId, LocalDateTime dateadded) {
        return null;
    }
}
