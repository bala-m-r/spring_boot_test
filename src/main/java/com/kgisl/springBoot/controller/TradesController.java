package com.kgisl.springBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kgisl.springBoot.Entity.Mytrades;
import com.kgisl.springBoot.service.TradesService;




@RestController
@RequestMapping("/trades")
public class TradesController {

	@Autowired
    TradesService tradesService;

	@GetMapping
	public List<Mytrades> getAllTrades() {
		return tradesService.getAllTrades();
	}


	@PutMapping("/{id}")
    public Mytrades updateTrade(@PathVariable("id") Integer tradeId, @RequestBody Mytrades trade) {    
        return tradesService.updateTrade(tradeId, trade);
    }

	@PostMapping("/{tradeId}/{scripCode}/{scripName}/{tradeType}/{quantity}/{price}/{exchange}")
    public void addNewTrade(
            @PathVariable Integer tradeId,
            @PathVariable String scripCode,
            @PathVariable String scripName,
            @PathVariable String tradeType,
            @PathVariable int quantity,
            @PathVariable double price,
            @PathVariable String exchange) {
        tradesService.addNewTrade(tradeId, scripCode, scripName, tradeType, quantity, price, exchange);
    }

	@DeleteMapping("/{id}")
    public void deleteTrade(@PathVariable("id") Integer tradeId) {
        tradesService.deleteTradeById(tradeId);
    }
}
