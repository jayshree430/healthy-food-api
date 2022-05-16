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
@RequestMapping("/api/v1/mealplan")
@Tag(name = "Meal Plan")
public class MealPlanController {

    @Autowired
    FoodManagerService foodManagerService;

    @GetMapping({"/"})
    @Operation(summary = "Gets the list of meal plans for a user")
    public ResponseEntity<List<MealPlan>> getMealPlans() {
        List<MealPlan> mealPlans = foodManagerService.getMealPlans(); // For Authenticated user
        return new ResponseEntity<>(mealPlans, HttpStatus.OK);
    }

    @PostMapping(value = {"/"})
    @Operation(summary = "Creates a meal plan for a user")
    public ResponseEntity<MealPlan> createMealPlan(@RequestBody MealPlanRequest mealPlanRequest) {
        MealPlan mealPlan = foodManagerService.createMealPlan(mealPlanRequest);
        return new ResponseEntity<>(mealPlan, HttpStatus.CREATED);
    }
}
