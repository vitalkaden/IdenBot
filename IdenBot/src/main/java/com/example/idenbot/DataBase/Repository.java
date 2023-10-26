package com.example.idenbot.DataBase;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@org.springframework.stereotype.Repository
public class Repository {
    @PersistenceContext
    public EntityManager entityManager;

    public DocItem getByTZ(String TZ){
        Query query = entityManager.createQuery("SELECT mi FROM idenValidDocTable mi WHERE mi.TZ=:ТЗ", DocItem.class);
        query.setParameter("ТЗ",TZ);
        return (DocItem) query.getSingleResult();
    }
}
