package ateam.techreturners.healthyfood.controller;

import ateam.techreturners.healthyfood.model.*;
import ateam.techreturners.healthyfood.service.MealPlanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/mealplan")
@Tag(name = "Meal Plan")
public class MealPlanController {

    @Autowired
    MealPlanService mealPlanManagerService;

    @GetMapping({"/"})
    @Operation(summary = "Gets the list of meal plans for a user")
    public ResponseEntity<List<MealPlan>> getMealPlans() {
        List<MealPlan> mealPlans = mealPlanManagerService.getAllMealPlans(); // For Authenticated user
        return new ResponseEntity<>(mealPlans, HttpStatus.OK);
    }

    @PostMapping(value = {"/"})
    @Operation(summary = "Creates a meal plan for a user")
    public ResponseEntity<MealPlan> createMealPlan(@RequestParam Long mealId, @RequestParam Long userId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateAdded) {
        MealPlan mealPlan = mealPlanManagerService.createMealPlan(mealId, userId, dateAdded);
        return new ResponseEntity<>(mealPlan, HttpStatus.CREATED);
    }
}
