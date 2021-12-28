package com.trainingplatform.trainingservice.trainingservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="onlinelesson", schema = "tp-trainingservice")
@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property  = "id",
        scope     = Long.class)
public class OnlineLessonModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(
            name="meeting_date",
            nullable = false,
            columnDefinition = "DATE"
    )
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate meeting_date;

    @Column(
            name="zoom_link",
            nullable = false,
            columnDefinition = "MEDIUMTEXT"
    )
    private String zoom_link;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "training_id", nullable = false)
    private TrainingModel training;

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

    public OnlineLessonModel(LocalDate meeting_date, String zoom_link) {
        this.meeting_date = meeting_date;
        this.zoom_link = zoom_link;
    }

}
