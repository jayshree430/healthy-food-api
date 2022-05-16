package ateam.techreturners.healthyfood.repository;

import ateam.techreturners.healthyfood.model.Ingredients;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientsRepository extends CrudRepository<Ingredients, Long> {
}
