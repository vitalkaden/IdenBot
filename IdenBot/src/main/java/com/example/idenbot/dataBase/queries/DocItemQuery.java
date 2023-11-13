package com.example.idenbot.dataBase.queries;

import com.example.idenbot.dataBase.DocItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface DocItemQuery extends JpaRepository<DocItem, String> {

    @Query(value = "SELECT a FROM DocItem a WHERE a.greenCard BETWEEN CURRENT_DATE() AND CURRENT_DATE() +10 or a.cyvilka BETWEEN CURRENT_DATE() AND CURRENT_DATE() +10 or a.whiteCert BETWEEN CURRENT_DATE() AND CURRENT_DATE() +10 or a.mytne BETWEEN CURRENT_DATE() AND CURRENT_DATE() +10 or a.teh BETWEEN CURRENT_DATE() AND CURRENT_DATE() +10 or a.tacho BETWEEN CURRENT_DATE() AND CURRENT_DATE() +10")
    List<DocItem> findAllBeforeEnds();

    @Query(value = "SELECT u FROM DocItem u WHERE u.TZ = :TZ")
    String findByTZ(@Param("TZ") String TZ);

}
