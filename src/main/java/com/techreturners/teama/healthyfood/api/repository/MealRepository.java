package com.techreturners.teama.healthyfood.api.repository;

import com.techreturners.teama.healthyfood.api.model.Meal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends CrudRepository<Meal, Long> {

//     @Query(value = "SELECT DISTINCT m.* from meal m, meal_ingredient_as mia, " +
//             "meal_diet_as mda, meal_category_as mca" +
//             " where ?1" +
//            " LIMIT 3", nativeQuery = true)
//    List<Meal> getMeal(String query);

    @Query(value ="SELECT DISTINCT m.* FROM meal m " +
//            "LEFT table_join_meal_dietAs mda ON m.id = mda.mealId " +
//            "LEFT JOIN table_join_meal_categoryAs mca ON m.id = mca.mealId " +
//            "LEFT JOIN meal_ingredient_as mia ON m.id = mia.mealid " +
            "WHERE (:calories IS NULL OR m.calories <= :calories) " +
//            "AND (m.id NOT IN (SELECT DISTINCT mealid FROM table_join_meal_ingredientAs WHERE ingredientid IN :exclusion)) " +
//            "AND (:isDiets IS TRUE OR mda.dietId IN :diets) " +
//            "AND (:isCategories IS TRUE OR mca.categoryId IN :categories) " +
            "LIMIT 3", nativeQuery = true)
    List<Meal> getMeals(
            @Param(value = "calories") Integer calories);
//            @Param(value = "exclusion") List<Long> exclusion,
//            @Param(value = "diets") List<Long> diets,
//            @Param(value = "isDiets") Boolean dietsIsNull,
//            @Param(value = "categories") List<Long> categories,
//            @Param(value = "isCategories") Boolean categoriesIsNull);

}
