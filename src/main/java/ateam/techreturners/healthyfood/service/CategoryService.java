package ateam.techreturners.healthyfood.service;

import ateam.techreturners.healthyfood.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category getCategoryById(Long id);
}
