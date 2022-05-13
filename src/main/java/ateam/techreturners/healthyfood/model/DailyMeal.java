package ateam.techreturners.healthyfood.model;

import java.time.LocalDate;
import java.util.List;

public class DailyMeal {

    LocalDate date;
    private List<Meal> meals;

    public List<Meal> getMeals() {
        return meals;
    }

    public LocalDate getDate() {
        return date;
    }
}
