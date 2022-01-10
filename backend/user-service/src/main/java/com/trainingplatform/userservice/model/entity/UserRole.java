package com.trainingplatform.userservice.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "UserRole", schema = "tp-userservice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="role_id")
    private Long roleId;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "manager_group_id")
    private Long managerGroupId;
}
