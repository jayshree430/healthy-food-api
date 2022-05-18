package ateam.techreturners.healthyfood.controller;

import ateam.techreturners.healthyfood.model.MealPlan;
import ateam.techreturners.healthyfood.service.MealPlanServiceImpl;
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
    public void setup(){
        mockMvcController = MockMvcBuilders.standaloneSetup(mealPlanController).build();
    }

    @Test
    public void testGetMealPlans() throws Exception {

        List<MealPlan> mealPlans = new ArrayList<>();
        mealPlans.add(new MealPlan(1L, 1L, 1L, LocalDateTime.now()));
        mealPlans.add(new MealPlan(2L, 2L, 2L, LocalDateTime.now()));

        when(mockMealPlanServiceImpl.getAllMealPlans()).thenReturn(mealPlans);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/api/v1/mealplan/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.*", hasSize(2)));

        verify(mockMealPlanServiceImpl, times(1)).getAllMealPlans();
    }

    @Test
    public void testCreateMealPlan() throws Exception {

        Long mealId = 1L;
        Long userId = 1L;
        LocalDateTime dateAdded = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        MealPlan mealPlan = new MealPlan(1L, userId, mealId, dateAdded);

        when(mockMealPlanServiceImpl.createMealPlan(mealId, userId, dateAdded)).thenReturn(mealPlan);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.post("/api/v1/mealplan/")
                                .param("mealId", String.valueOf(mealId))
                                .param("userId", String.valueOf(userId))
                                .param("dateAdded", dateAdded.format(dateFormatter))
                )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userid").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mealid").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.date").value(dateAdded.format(dateFormatter)));;

        verify(mockMealPlanServiceImpl, times(1)).createMealPlan(mealId, userId, dateAdded);
    }
}
