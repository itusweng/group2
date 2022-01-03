package com.trainingplatform.userservice.model.entity;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "User", schema = "tp-userservice", uniqueConstraints = {
        @UniqueConstraint(name = "user_email_unique", columnNames = "email"),
        @UniqueConstraint(name = "username_unique", columnNames = "username")

})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(
            name = "username",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String username;

    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String password;

    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String first_name;

    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String last_name;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    @Column(
            name = "role_id",
            nullable = false,
            columnDefinition = "BIGINT"
    )
    private Long role_id;

    @Column(
            name = "profile_photo",
            columnDefinition = "TEXT"
    )
    private String profile_photo;

    @Column(
            name = "job_title",
            nullable = false,
            columnDefinition = "CHAR(50)"
    )
    private String job_title;

    @Column(
            name = "manager_group_id",
            nullable = false,
            columnDefinition = "BIGINT"
    )
    private Long manager_group_id;

}
