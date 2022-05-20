package com.techreturners.teama.healthyfood.api.repository;

import com.techreturners.teama.healthyfood.api.model.Meal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends CrudRepository<Meal, Long> {
    @Query(value = "SELECT * FROM meal where calories = :calories" +
            " AND diet =:diet AND ingredient not in (:exclusion) AND category = :category", nativeQuery = true)
    List<Meal> getMeal(@Param(value = "calories") int calories,
                       @Param(value = "diet") String diet,
                       @Param(value = "exclusion") String excludedIngredients,
                       @Param(value = "category") String category);
}
