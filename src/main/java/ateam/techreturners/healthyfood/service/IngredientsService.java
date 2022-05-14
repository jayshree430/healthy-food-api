package ateam.techreturners.healthyfood.service;

import ateam.techreturners.healthyfood.model.Ingredients;

import java.util.List;

public interface IngredientsService {

    List<Ingredients> getAllIngredients();
    Ingredients getIngredientById(Long id);
}
