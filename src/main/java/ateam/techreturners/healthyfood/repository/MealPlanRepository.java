package ateam.techreturners.healthyfood.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealPlanRepository extends CrudRepository<MealPlanRepository, Long> {
}
