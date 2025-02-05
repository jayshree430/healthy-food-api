package com.techreturners.teama.healthyfood.api.model;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class MealIngredientsAsId implements Serializable {

    Long mealId;
    Long ingredientId;
}
