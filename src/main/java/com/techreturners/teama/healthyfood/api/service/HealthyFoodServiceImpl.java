package com.techreturners.teama.healthyfood.api.service;

import com.techreturners.teama.healthyfood.api.model.Category;
import com.techreturners.teama.healthyfood.api.model.Diet;
import com.techreturners.teama.healthyfood.api.model.Ingredient;
import com.techreturners.teama.healthyfood.api.model.Meal;
import com.techreturners.teama.healthyfood.api.repository.CategoryRepository;
import com.techreturners.teama.healthyfood.api.repository.DietRepository;
import com.techreturners.teama.healthyfood.api.repository.IngredientRepository;
import com.techreturners.teama.healthyfood.api.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HealthyFoodServiceImpl implements HealthyFoodService {

    private final String ingredientQuery = "m.id = mia.mealid And mia.ingredientid not in (";
    private final String dietQuery = "m.id = mda.mealId And mda.dietId IN (";
    private final String categoryQuery = "m.id = mca.mealId And mca.categoryId IN (";
    private final String caloriesQuery = "calories <= ";

    @Autowired
    MealRepository mealRepository;

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    DietRepository dietRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Meal> getMeals(int calories, List<String> excludedIngredients, List<String> diets, List<String> category) {
        String exString = "";
        String dietString = "";
        String categoryString = "" ;
        String queryString = "";

        for (String dietName: diets) {
            Diet  diet = getDietByName(dietName);
            if (diet != null){
                if (dietString.length()>0)
                    dietString += ","+ diet.getId();
                else
                    dietString = String.valueOf(diet.getId());
            }
        }
        for (String ingredientName: excludedIngredients) {
            Ingredient ingredient = getIngredientByName(ingredientName);
            if (ingredient != null){
                if (exString.length()>0)
                    exString += "," + ingredient.getId();
                else
                    exString = String.valueOf(ingredient.getId());
            }
        }
        for (String categoryName: category) {
            Category categoryDb = getCategoryByName(categoryName);
            if (categoryDb != null){
                if (categoryString.length()>0)
                    categoryString = ","+ categoryDb.getId();
                else
                    categoryString = String.valueOf(categoryDb.getId());
            }
        }
        if (dietString.length()>0){
            queryString += dietQuery + dietString + ")";
        }
        if (categoryString.length()>0){
            if (queryString.length()>0)
                queryString += " and ";
            queryString += categoryQuery + categoryString + ")";
        }
        if (exString.length()>0){
            if (queryString.length()>0)
                queryString += " and ";
            queryString += ingredientQuery + exString + ")";
        }
        if (calories > 0){
            if (queryString.length()>0)
                queryString += " and ";
            queryString += caloriesQuery + calories;
        }
        System.out.println(queryString);
         return mealRepository.getMeal(queryString);
    }

    @Override
    public List<Ingredient> getAllIngredients(){
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(ingredients::add);
        return ingredients;
    }

    @Override
    public Ingredient getIngredientById(Long id) {
        return ingredientRepository.findById(id).get();
    }

    @Override
    public Ingredient getIngredientByName(String ingredientName){
        return ingredientRepository.findByName(ingredientName);
    }

    @Override
    public List<Diet> getAllDiets() {
        List<Diet> diet = new ArrayList<>();
        dietRepository.findAll().forEach(diet::add);
        return diet;
    }

    @Override
    public Diet getDietById(Long id) {
        return dietRepository.findById(id).get();
    }

    @Override
     public Diet getDietByName(String dietName){

        return dietRepository.findByName(dietName);
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> category = new ArrayList<>();
        categoryRepository.findAll().forEach(category::add);
        return category;
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category getCategoryByName(String categoryName){
        return categoryRepository.findByName(categoryName);
    }

    @Override
    public List<Meal> getAllMeals() {
        List<Meal> meal = new ArrayList<>();
        mealRepository.findAll().forEach(meal::add);
        return meal;
    }

    @Override
    public Meal getMealById(Long id) {
        return mealRepository.findById(id).get();
    }
}
