package com.kgisl.springBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgisl.springBoot.Entity.Mytrades;
import com.kgisl.springBoot.repository.TradesRepository;

@Service
public class TradesService {

    @Autowired
    TradesRepository tradesRepository;

    public List<Mytrades> getAllTrades() {
        return tradesRepository.findAll();
    }

    public Mytrades addTrade(Mytrades mytrades) {
        return tradesRepository.save(mytrades);
    }

    public Mytrades updateTrade(int tradeid, Mytrades trade) {
        Optional<Mytrades> existingTrade = tradesRepository.findById(tradeid);
        if (existingTrade.isPresent()) {
            return tradesRepository.save(trade);
        } else {
            throw new RuntimeException("Trade with ID " + tradeid + " not found");
        }
    }
    public void addNewTrade(Integer tradeId, String scripCode, String scripName, String tradeType, int quantity, double price, String exchange) {
        tradesRepository.addNewTrade(tradeId, scripCode, scripName, tradeType, quantity, price, exchange);

    }

    public void deleteTradeById(Integer tradeId) {
        if (tradesRepository.existsById(tradeId)) {
            tradesRepository.deleteById(tradeId);
        } else {
            throw new RuntimeException("Trade with ID " + tradeId + " not found");
        }
    }    
}
