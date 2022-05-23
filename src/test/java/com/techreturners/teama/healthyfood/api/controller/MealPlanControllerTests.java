package com.techreturners.teama.healthyfood.api.controller;

import com.techreturners.teama.healthyfood.api.model.Meal;
import com.techreturners.teama.healthyfood.api.model.MealPlan;
import com.techreturners.teama.healthyfood.api.model.User;
import com.techreturners.teama.healthyfood.api.service.MealPlanServiceImpl;
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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@AutoConfigureMockMvc
@SpringBootTest
public class MealPlanControllerTests {

    @Mock
    private MealPlanServiceImpl mockMealPlanServiceImpl;

    @InjectMocks
    private MealPlanController mealPlanController;

    @Autowired
    private MockMvc mockMvcController;

    @BeforeEach
    public void setup() {
        mockMvcController = MockMvcBuilders.standaloneSetup(mealPlanController).build();
    }

    @Test
    public void testGetMealPlansByUser() throws Exception {

        Long userId = 1L;
        List<MealPlan> mealPlans = new ArrayList<>();
        User user = new User();
        Meal meal = new Meal();
        mealPlans.add(new MealPlan(1L, user, meal, LocalDateTime.now()));
        mealPlans.add(new MealPlan(2L, user, meal, LocalDateTime.now()));

        when(mockMealPlanServiceImpl.getAllMealPlans(userId)).thenReturn(mealPlans);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/api/v1/mealplan/" + userId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.*", hasSize(2)));

        verify(mockMealPlanServiceImpl, times(1)).getAllMealPlans(userId);
    }

    @Test
    public void testCreateMealPlanByUser() throws Exception {

        User user = new User();
        user.setId(1L);
        Meal meal = new Meal();
        meal.setId(1L);
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatterISO = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");

        MealPlan mealPlan = new MealPlan(1L, user, meal, date);

        when(mockMealPlanServiceImpl.createMealPlan(meal.getId(), user.getId(), date)).thenReturn(mealPlan);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.post("/api/v1/mealplan/" + user.getId())
                                .param("mealId", String.valueOf(meal.getId()))
                                .param("date", date.format(dateTimeFormatterISO))
                )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user.id").value(user.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.meal.id").value(meal.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.date").value(date.format(dateTimeFormatter)));

        verify(mockMealPlanServiceImpl, times(1)).createMealPlan(meal.getId(), user.getId(), date);
    }
}
