package com.trainingplatform.userservice.repository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import java.util.List;

@RequiredArgsConstructor
@Component
public class KeycloakNativeRepo {

    private final EntityManagerFactory emf;

    public List<String> getInstructorUserIds(){
        EntityManager session = emf.createEntityManager();
        String sqlQuery = "SELECT r.user_id FROM USER_ROLE_MAPPING r where role_id = 'dbbd49f0-0eb4-4155-ae02-1ffb61e504cc'";
        Query query = session.createNativeQuery(sqlQuery);
        final List<String> resultList = query.getResultList();
        return resultList;
    }

    public String getUsernameByInstructorId(String instructorId){
        EntityManager session = emf.createEntityManager();
        String sqlQuery = String.format("SELECT ue.username FROM USER_ENTITY ue where id = '%s'", instructorId);
        Query query = session.createNativeQuery(sqlQuery);
        String result = query.getResultList().get(0).toString();
        return result;
    }
}
