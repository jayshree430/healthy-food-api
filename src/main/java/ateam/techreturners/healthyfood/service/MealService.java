package ateam.techreturners.healthyfood.service;

import ateam.techreturners.healthyfood.model.Meal;

import java.util.List;

public interface MealService {

    List<Meal> getAllMeals();
    Meal getMealById(Long id);
}
