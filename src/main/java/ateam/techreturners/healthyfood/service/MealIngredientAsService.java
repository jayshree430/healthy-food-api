package ateam.techreturners.healthyfood.service;

import ateam.techreturners.healthyfood.model.MealIngredientAs;

import java.util.List;

public interface MealIngredientAsService {

    List<MealIngredientAs> getAllMealIngredientAs();

    MealIngredientAs getMealIngredientAsById(Long id);

}
