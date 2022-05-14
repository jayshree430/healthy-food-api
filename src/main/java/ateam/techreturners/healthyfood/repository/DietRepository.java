package ateam.techreturners.healthyfood.repository;

import ateam.techreturners.healthyfood.model.Diet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DietRepository extends CrudRepository<Diet, Long> {
}
