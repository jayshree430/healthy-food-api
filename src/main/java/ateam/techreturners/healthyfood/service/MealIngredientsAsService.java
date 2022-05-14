package ateam.techreturners.healthyfood.service;

import ateam.techreturners.healthyfood.model.MealIngredientAs;

import java.util.List;

public interface MealIngredientsAsService {

    List<MealIngredientAs> getAllMealIngredientAs();

    MealIngredientAs getMealIngredientAsById(Long id);

    MealIngredientAs insertIntoMealIngredientsAs(MealIngredientAs mealIngredientAs);

    void deleteIngredientAsById(Long Id);

}
