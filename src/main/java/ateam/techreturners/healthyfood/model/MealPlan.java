package ateam.techreturners.healthyfood.model;

import java.util.List;

public class MealPlan {
    Long userId;
    List<DailyMeal> dailyMeals;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<DailyMeal> getDailyMeals() {
        return dailyMeals;
    }

    public void setDailyMeals(List<DailyMeal> dailyMeals) {
        this.dailyMeals = dailyMeals;
    }
}
