package com.trainingplatform.trainingservice.trainingservice.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="training", schema = "tp-trainingservice")
@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property  = "id",
        scope     = Long.class)
public class TrainingModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(
            name="is_online",
            nullable = false,
            columnDefinition = "BOOLEAN"
    )
    private Boolean is_online;

    @Column(
            name="user_created_id",
            nullable = false,
            columnDefinition = "BIGINT"
    )
    private Long user_created_id;

    @Column(
            name="instructor_id",
            nullable = false,
            columnDefinition = "BIGINT"
    )
    private Long instructor_id;

    @Column(
            name="capacity",
            nullable = false,
            columnDefinition = "INT"
    )
    private Integer capacity;

    @Column(
            name="title",
            nullable = false,
            columnDefinition = "CHAR(50)"
    )
    private String title;

    @Column(
            name="description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String description;

    private Date created_date;

    private Date updated_date;
}
