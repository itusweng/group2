package com.trainingplatform.trainingservice.trainingservice.model;

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

    public TrainingModel(boolean is_online, long user_created_id, long trainer_id, int capacity) {
        this.is_online = is_online;
        this.user_created_id = user_created_id;
        this.trainer_id = trainer_id;
        this.capacity = capacity;
    }

}
