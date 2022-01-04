package com.trainingplatform.userservice.model.entity;

import com.trainingplatform.userservice.model.entity.compositekeys.Manager_ManagerGroupPK;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Manager_ManagerGroup", schema = "tp-userservice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@IdClass(Manager_ManagerGroupPK.class)
public class Manager_ManagerGroup {

    @Id
    @Column(name="manager_id")
    private Long managerId;

    @Id
    @Column(name="manager_group_id")
    private Long managerGroupId;

}