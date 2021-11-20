package com.trainingplatform.trainingservice.trainingservice.offlinelesson;

import com.trainingplatform.trainingservice.trainingservice.training.Training;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="offlinelesson", schema = "tp-trainingservice")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class OfflineLesson implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(
            name = "description",
            nullable = false,
            columnDefinition = "DATE"
    )
    private String description;

    @Column(
            name = "video_link",
            nullable = false,
            columnDefinition = "MEDIUMTEXT"
    )
    private String video_link;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "training_id", nullable = false)
    private Training training;

    @Column(
            name="files",
            nullable = true,
            columnDefinition = "MEDIUMTEXT"
    )
    private String files;

    public OfflineLesson(String description, String video_link, Training training) {
        this.description = description;
        this.video_link = video_link;
        this.training = training;
    }

    public OfflineLesson(String description, String video_link, Training training, String files) {
        this.description = description;
        this.video_link = video_link;
        this.training = training;
        this.files = files;
    }

}