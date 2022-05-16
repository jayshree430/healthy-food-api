package ateam.techreturners.healthyfood.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Meal {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    Long id;

    @Column
    String name;

    @Column
    String shortdesc;

    @Column
    String longdesc;

    @Column
    String category;

    @Column
    int preptime;

    @Column
    int servings;

    @Column
    String diet;

    @Column
    String photo;

    @Column
    String url;

    @Column
    LocalDateTime dateadded;
}
