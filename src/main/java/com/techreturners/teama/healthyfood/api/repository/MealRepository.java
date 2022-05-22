package com.techreturners.teama.healthyfood.api.repository;

import com.techreturners.teama.healthyfood.api.model.Meal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends CrudRepository<Meal, Long> {

     @Query(value = "SELECT DISTINCT m.id, m.name, m.shortdesc, m.longdesc, m.category, m.preptime," +
             "m.servings, m.calories, m.ingredient, m.diet, m.photo, m.url, m.dateadded, m.start, m.end " +
             "from meal m, meal_ingredient_as mia, " +
             "meal_diet_as mda, meal_category_as mca" +
             " where ?1" +
            " LIMIT 3", nativeQuery = true)
    List<Meal> getMeal(String query);

}
