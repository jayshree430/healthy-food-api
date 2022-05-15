package ateam.techreturners.healthyfood.controller;

import ateam.techreturners.healthyfood.model.*;
import ateam.techreturners.healthyfood.service.FoodManagerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/food")
@Tag(name = "Food")
public class FoodController {

    @Autowired
    FoodManagerService foodManagerService;

    @GetMapping({"/ingredient"})
    @Operation(summary = "Gets a list of all ingredients")
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        List<Ingredient> allIngredients = foodManagerService.getAllIngredients();
        return new ResponseEntity<>(allIngredients, HttpStatus.OK);
    }

    @GetMapping({"/diet"})
    @Operation(summary = "Gets a list of all diets")
    public ResponseEntity<List<Diet>> getAllDiets() {
        List<Diet> allDiets = foodManagerService.getAllDiets();
        return new ResponseEntity<>(allDiets, HttpStatus.OK);
    }

    @GetMapping({"/meal"})
    @Operation(summary = "Gets a selection of meals based on restrictions")
    public ResponseEntity<List<Meal>> getMeals(@RequestParam Long calories, @RequestParam List<String> excludedIngredients, @RequestParam List<String> excludedDiets) {
        List<Meal> meals = foodManagerService.getMeals(calories, excludedIngredients, excludedDiets);
        return new ResponseEntity<>(meals, HttpStatus.OK);
    }
}
