package ateam.techreturners.healthyfood.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
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
public class User {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    Integer id;

    @Column
    String email;

    @Column
    String firstname;

    @Column
    String lastname;

    @Column
    String dietid;

    @Column
    String exclude;

    @Column
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    LocalDateTime dateadded;
}
