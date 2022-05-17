package ateam.techreturners.healthyfood.repository;

import ateam.techreturners.healthyfood.model.MealPlan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealPlanRepository extends CrudRepository<MealPlan, Long> {
}
