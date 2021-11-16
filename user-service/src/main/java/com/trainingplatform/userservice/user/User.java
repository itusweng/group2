package com.trainingplatform.userservice.user;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name="User", schema = "tp-userservice",  uniqueConstraints = {
        @UniqueConstraint(name = "user_email_unique", columnNames = "email")
})
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {

    @Id
    private Long id;

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

    public User(String first_name, String last_name, String email,  Long role_id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.role_id = role_id;
    }

}
