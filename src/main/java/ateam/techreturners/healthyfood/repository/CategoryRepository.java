package ateam.techreturners.healthyfood.repository;

import ateam.techreturners.healthyfood.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
