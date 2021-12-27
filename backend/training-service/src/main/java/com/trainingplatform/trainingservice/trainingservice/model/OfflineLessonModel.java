package com.trainingplatform.trainingservice.trainingservice.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="offlinelesson", schema = "tp-trainingservice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property  = "id",
        scope     = Long.class)
public class OfflineLessonModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(
            name="title",
            nullable = false,
            unique = true,
            columnDefinition = "CHAR(50)"
    )
    private String title;

    @Column(
            name = "description",
            nullable = false,
            columnDefinition = "MEDIUMTEXT"
    )
    private String description;

    @Column(
            name = "video_link",
            nullable = false,
            unique = true,
            columnDefinition = "MEDIUMTEXT"
    )
    private String video_link;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "training_id", nullable = false)
    private TrainingModel training;

    @Column(
            name="files",
            nullable = true,
            columnDefinition = "MEDIUMTEXT"
    )
    private String files;

    public OfflineLessonModel(String description, String video_link, TrainingModel training) {
        this.description = description;
        this.video_link = video_link;
        this.training = training;
    }

    public OfflineLessonModel(String description, String video_link, TrainingModel training, String files) {
        this.description = description;
        this.video_link = video_link;
        this.training = training;
        this.files = files;
    }

}