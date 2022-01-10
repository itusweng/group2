package com.trainingplatform.userservice.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ManagerGroup", schema = "tp-userservice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ManagerGroup {

    @Id
    @Column(name = "manager_group_id")
    private Long managerGroupId;

    @Column(name = "group_name")
    private String groupName;
}
