package com.techreturners.teama.healthyfood.api.controller;

import com.techreturners.teama.healthyfood.api.model.MealPlan;
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
        mealPlans.add(new MealPlan(1L, 1L, 1L, LocalDateTime.now()));
        mealPlans.add(new MealPlan(2L, 2L, 2L, LocalDateTime.now()));

        when(mockMealPlanServiceImpl.getAllMealPlans(userId)).thenReturn(mealPlans);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/api/v1/mealplan/" + userId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.*", hasSize(2)));

        verify(mockMealPlanServiceImpl, times(1)).getAllMealPlans(userId);
    }

    @Test
    public void testCreateMealPlanByUser() throws Exception {

        Long mealId = 1L;
        Long userId = 1L;
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatterISO = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");

        MealPlan mealPlan = new MealPlan(1L, userId, mealId, date);

        when(mockMealPlanServiceImpl.createMealPlan(mealId, userId, date)).thenReturn(mealPlan);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.post("/api/v1/mealplan/" + userId)
                                .param("mealId", String.valueOf(mealId))
                                .param("date", date.format(dateTimeFormatterISO))
                )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.meal_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.date").value(date.format(dateTimeFormatter)));

        verify(mockMealPlanServiceImpl, times(1)).createMealPlan(mealId, userId, date);
    }
}
