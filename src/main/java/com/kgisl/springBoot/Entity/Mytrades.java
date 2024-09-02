package com.kgisl.springBoot.Entity;


import org.springframework.data.annotation.Id;


public record Mytrades(
        @Id
        // @Column(value = "TRADE_ID")
        int tradeid,

        // @Column(value = "TRADE_DATE")
        // Date tradeDate,

        // @Column(value = "SCRIP_CODE")
        String scripcode,

        // @Column(value = "SCRIP_NAME")
        String scripname,

        // @Column(value = "TRADE_TYPE")
        String tradetype,

        // @Column(value = "QUANTITY")
        int quantity,

        // @Column(value = "PRICE")
        double price,

        // @Column(value = "EXCHANGE")
        String exchange) {
}