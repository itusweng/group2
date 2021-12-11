package com.trainingplatform.trainingservice.trainingservice.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

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
            name="trainer_id",
            nullable = false,
            columnDefinition = "BIGINT"
    )
    private Long trainer_id;

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

    public TrainingModel(boolean is_online, long user_created_id, long trainer_id, int capacity) {
        this.is_online = is_online;
        this.user_created_id = user_created_id;
        this.trainer_id = trainer_id;
        this.capacity = capacity;
    }

}
