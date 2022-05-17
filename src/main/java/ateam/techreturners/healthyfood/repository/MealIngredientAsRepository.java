package ateam.techreturners.healthyfood.repository;

import ateam.techreturners.healthyfood.model.MealIngredientAs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealIngredientAsRepository extends CrudRepository <MealIngredientAs, Long>{
}
