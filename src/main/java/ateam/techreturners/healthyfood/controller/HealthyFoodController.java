package ateam.techreturners.healthyfood.controller;

import ateam.techreturners.healthyfood.model.*;
import ateam.techreturners.healthyfood.service.HealthyFoodManagerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Healthy Food")
public class HealthyFoodController {

    @Autowired
    HealthyFoodManagerService healthyFoodManagerService;

    @GetMapping({"/ingredient"})
    @Operation(summary = "Gets a list of all ingredients")
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        List<Ingredient> allIngredients = healthyFoodManagerService.getAllIngredients();
        return new ResponseEntity<>(allIngredients, HttpStatus.OK);
    }

    @GetMapping({"/diet"})
    @Operation(summary = "Gets a list of all diets")
    public ResponseEntity<List<Diet>> getAllDiets() {
        List<Diet> allDiets = healthyFoodManagerService.getAllDiets();
        return new ResponseEntity<>(allDiets, HttpStatus.OK);
    }

    @GetMapping({"/meal"})
    @Operation(summary = "Gets a selection of meals based on restrictions")
    public ResponseEntity<List<Meal>> getMeals(@RequestParam Long calories, @RequestParam List<String> excludedIngredients, @RequestParam List<String> diet, String category) {
        List<Meal> meals = healthyFoodManagerService.getMeals(calories, excludedIngredients, diet, category);
        return new ResponseEntity<>(meals, HttpStatus.OK);
    }
}
