package com.example.idenbot.dataBase.queries;

import com.example.idenbot.dataBase.UserItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserItemQuery extends JpaRepository<UserItem, String> {

    @Query(value = "SELECT a FROM UserItem a WHERE a.subscribtion = true")
    List<UserItem> allIfTrue();

}
