package ateam.techreturners.healthyfood.service;

import ateam.techreturners.healthyfood.model.Ingredient;

import java.util.List;

public interface IngredientService {

    List<Ingredient> getAllIngredients();
    Ingredient getIngredientById(Long id);
}
