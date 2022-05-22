package com.techreturners.teama.healthyfood.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MealIngredientsAs {
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    Integer id;

    @Column
    int mealid;

    @Column
    int ingredientid;

    @Column
    int quantity;
}
