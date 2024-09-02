package com.kgisl.springBoot.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.kgisl.springBoot.Entity.Mytrades;

@Repository
public interface TradesRepository extends ListCrudRepository<Mytrades, Integer>{

    @Modifying
    @Query("INSERT INTO MYTRADES (TRADEID, SCRIPCODE, SCRIPNAME, TRADETYPE, QUANTITY, PRICE, EXCHANGE) VALUES (:tradeId, :scripCode, :scripName, :tradeType, :quantity, :price, :exchange)")
    void addNewTrade(Integer tradeId, String scripCode, String scripName, String tradeType, int quantity, double price, String exchange);
    
}
