package com.example.idenbot.services;

import com.example.idenbot.dataBase.UserItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserService {
    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public void setUser(UserItem userItem){
        entityManager.createNativeQuery("INSERT INTO users (chat_id,first_name,last_name) " +
                "VALUES (?,?,?) on duplicate key update " +
                "first_name = VALUES (first_name),last_name = VALUES (last_name)")
                .setParameter(1,userItem.getChatId())
                .setParameter(2,userItem.getFirstName())
                .setParameter(3,userItem.getLastName())
                .executeUpdate();
    }
    @Transactional
    public void setSubscription(UserItem userItem){
        entityManager.createNativeQuery("INSERT INTO users (chat_id,first_name,last_name,subscribtion) " +
                        "VALUES (?,?,?,true) on duplicate key update " +
                        "first_name = VALUES (first_name),last_name = VALUES (last_name),subscribtion = VALUES (subscribtion)")
                .setParameter(1,userItem.getChatId())
                .setParameter(2,userItem.getFirstName())
                .setParameter(3,userItem.getLastName())
                .executeUpdate();
    }
    @Transactional
    public void denySubscribtion(UserItem userItem){
        entityManager.createNativeQuery("INSERT INTO users (chat_id,first_name,last_name,subscribtion) " +
                        "VALUES (?,?,?,false) on duplicate key update " +
                        "first_name = VALUES (first_name),last_name = VALUES (last_name),subscribtion = VALUES (subscribtion)")
                .setParameter(1,userItem.getChatId())
                .setParameter(2,userItem.getFirstName())
                .setParameter(3,userItem.getLastName())
                .executeUpdate();
    }
}
