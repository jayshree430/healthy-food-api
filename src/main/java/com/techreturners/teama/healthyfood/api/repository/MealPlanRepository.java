package com.techreturners.teama.healthyfood.api.repository;

import com.techreturners.teama.healthyfood.api.model.MealPlan;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MealPlanRepository extends CrudRepository<MealPlan, Long> {
    @Query(value = "SELECT * FROM mealplan where userid = :userid ", nativeQuery = true)
    List<MealPlan> getAllMealPlan(@Param(value = "userid") Long userid);

    @Modifying
    @Query(value = "INSERT INTO mealplan (mealid, userid, date) values(:mealid, :userid, :date) ", nativeQuery = true)
    List<MealPlan> createMealPlan(@Param(value = "mealid") Long mealid,
                                  @Param(value = "userid") Long userid,
                                  @Param(value = "date") LocalDateTime date);
}
