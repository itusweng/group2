package com.trainingplatform.trainingservice.trainingservice.onlinelesson;

import com.trainingplatform.trainingservice.trainingservice.training.Training;

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
public class OnlineLesson implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(
            name="meeting_date",
            nullable = false,
            columnDefinition = "DATE"
    )
    private LocalDate meeting_date;

    @Column(
            name="zoom_link",
            nullable = false,
            columnDefinition = "MEDIUMTEXT"
    )
    private String zoom_link;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "training_id", nullable = false)
    private Training training;

    public OnlineLesson(LocalDate meeting_date, String zoom_link) {
        this.meeting_date = meeting_date;
        this.zoom_link = zoom_link;
    }

}
