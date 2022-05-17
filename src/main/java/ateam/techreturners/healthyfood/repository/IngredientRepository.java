package ateam.techreturners.healthyfood.repository;

import ateam.techreturners.healthyfood.model.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
