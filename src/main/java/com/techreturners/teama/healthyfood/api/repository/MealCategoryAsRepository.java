package com.techreturners.teama.healthyfood.api.repository;

import com.techreturners.teama.healthyfood.api.model.Ingredient;
import com.techreturners.teama.healthyfood.api.model.MealCategoryAs;
import org.springframework.data.repository.CrudRepository;

public interface MealCategoryAsRepository  extends CrudRepository<MealCategoryAs, Integer> {
}
