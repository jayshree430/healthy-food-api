package ateam.techreturners.healthyfood.controller;

import ateam.techreturners.healthyfood.model.Diet;
import ateam.techreturners.healthyfood.model.Ingredient;
import ateam.techreturners.healthyfood.model.Meal;
import ateam.techreturners.healthyfood.service.HealthyFoodManagerServiceImpl;
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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@AutoConfigureMockMvc
@SpringBootTest
public class HealthyFoodControllerTests {

    @Mock
    private HealthyFoodManagerServiceImpl healthyFoodManagerService;

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
        ingredients.add(new Ingredient(1L, "Ingredient1", 100, 10, 10, 10, "photo1"));
        ingredients.add(new Ingredient(2L, "Ingredient2", 200, 20, 20, 20, "photo2"));

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
        diets.add(new Diet(1L, "Diet1"));
        diets.add(new Diet(2L, "Diet2"));

        when(healthyFoodManagerService.getAllDiets()).thenReturn(diets);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/api/v1/diet/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.*", hasSize(2)));

        verify(healthyFoodManagerService, times(1)).getAllDiets();
    }

    @Test
    public void testGetMeals() throws Exception {

        Long calories = 1000L;
        List<String> excludedIngredients = Arrays.asList("Ing10", "Ing20");
        List<String> excludedDiets = Arrays.asList("Diet10", "Diet20");
        List<Meal> meals = new ArrayList<>();
        meals.add(new Meal(1L, "Meal1", "ShortDesc1", "LongDesc1", "Category1", 10, 10, "Diet1", "Photo1", "Url1", LocalDateTime.now()));
        meals.add(new Meal(2L, "Meal2", "ShortDesc2", "LongDesc2", "Category2", 20, 20, "Diet2", "Photo2", "Url2", LocalDateTime.now()));

        when(healthyFoodManagerService.getMeals(calories, excludedIngredients, excludedDiets)).thenReturn(meals);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/api/v1/meal/")
                                .param("calories", String.valueOf(calories))
                                .param("excludedIngredients", String.join(",", excludedIngredients))
                                .param("excludedDiets", String.join(",", excludedDiets)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.*", hasSize(2)));

        verify(healthyFoodManagerService, times(1)).getMeals(calories, excludedIngredients, excludedDiets);
    }
}
