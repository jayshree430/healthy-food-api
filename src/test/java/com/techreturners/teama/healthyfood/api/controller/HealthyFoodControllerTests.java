package com.techreturners.teama.healthyfood.api.controller;

import com.techreturners.teama.healthyfood.api.model.Category;
import com.techreturners.teama.healthyfood.api.model.Diet;
import com.techreturners.teama.healthyfood.api.model.Ingredient;
import com.techreturners.teama.healthyfood.api.model.Meal;
import com.techreturners.teama.healthyfood.api.service.HealthyFoodServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@AutoConfigureMockMvc
@SpringBootTest
public class HealthyFoodControllerTests {

    @Mock
    private HealthyFoodServiceImpl healthyFoodManagerService;

    @InjectMocks
    private HealthyFoodController healthyFoodController;

    @Autowired
    private MockMvc mockMvcController;

    @BeforeEach
    public void setup(){
        mockMvcController = MockMvcBuilders.standaloneSetup(healthyFoodController).build();
    }

    @Test
    public void testGetAllIngredients() throws Exception {

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient(1L, "Ingredient1", 100, 10, 10, 10, "photo1", 1, "3,4", 5L));
        ingredients.add(new Ingredient(2L, "Ingredient2", 200, 20, 20, 20, "photo2", 0, "5,7", 6L));

        when(healthyFoodManagerService.getAllIngredients()).thenReturn(ingredients);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/api/v1/ingredient/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.*", hasSize(2)));

        verify(healthyFoodManagerService, times(1)).getAllIngredients();
    }

    @Test
    public void testGetAllDiets() throws Exception {

        List<Diet> diets = new ArrayList<>();
        diets.add(new Diet(1L, "Diet1", "5,7", " "));
        diets.add(new Diet(2L, "Diet2", "3,4", " "));

        when(healthyFoodManagerService.getAllDiets()).thenReturn(diets);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/api/v1/diet/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.*", hasSize(2)));

        verify(healthyFoodManagerService, times(1)).getAllDiets();
    }

    @Test
    public void testGetAllCategories() throws Exception {

        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1L, "Cat1", "10,12", LocalDate.now(), LocalDate.now().plusDays(5), LocalTime.now(), LocalTime.now().plusHours(15), Locale.UK.getCountry()));
        categories.add(new Category(2L, "Cat2", "11,14", LocalDate.now(), LocalDate.now().plusDays(5), LocalTime.now(), LocalTime.now().plusHours(15), Locale.UK.getCountry()));

        when(healthyFoodManagerService.getAllCategories()).thenReturn(categories);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/api/v1/category/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.*", hasSize(2)));

        verify(healthyFoodManagerService, times(1)).getAllCategories();
    }

    @Test
    public void testGetMeals() throws Exception {

        int calories = 1000;
        List<String> excludedIngredients = Arrays.asList("Ing10", "Ing20");
        List<String> diet = Arrays.asList("Diet10", "Diet20");
        String category = "Cat1";
        List<Meal> meals = new ArrayList<>();
        meals.add(new Meal(1L, "Meal1", "ShortDesc1", "LongDesc1", "Category1", 10, 10, 2000 ,"1,3","Diet1", "Photo1", "Url1", LocalDateTime.now(),LocalTime.now(), LocalTime.now().plusHours(10)));
        meals.add(new Meal(2L, "Meal2", "ShortDesc2", "LongDesc2", "Category2", 20, 20, 1500,"5,6", "Diet2", "Photo2", "Url2", LocalDateTime.now(),LocalTime.now(), LocalTime.now().plusHours(10)));

        when(healthyFoodManagerService.getMeals(calories, excludedIngredients, diet, category)).thenReturn(meals);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/api/v1/meal/")
                                .param("calories", String.valueOf(calories))
                                .param("excludedIngredients", String.join(",", excludedIngredients))
                                .param("diet", String.join(",", diet))
                                .param("category", category))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.*", hasSize(2)));

        verify(healthyFoodManagerService, times(1)).getMeals(calories, excludedIngredients, diet, category);
    }
}
