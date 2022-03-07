package com.nnk.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.Trade;

import com.nnk.springboot.repositories.TradeRepository;

@Service
public class TradeService {
	@Autowired
	TradeRepository tradeRepo;

	public List<Trade> findAllTrades() {
		return tradeRepo.findAll();
	}

	public Trade saveTrade(Trade trade) {
		tradeRepo.save(trade);
		return trade;
	}

	public Optional<Trade> getTradeById(Integer integer) {
		return tradeRepo.findById(integer);
	}

	public Trade updateTrade(Trade _trade) {
		Optional<Trade> opttrade = getTradeById(_trade.getTradeId());
		Trade updateTrade = opttrade.get();
		updateTrade.setAccount(_trade.getAccount());
		updateTrade.setType(_trade.getType());
		
		
		tradeRepo.save(updateTrade);
		return updateTrade;
	}

	public Trade deleteTrade(int id) {
		Trade deleteTrade = tradeRepo.getById((id));
		tradeRepo.delete(deleteTrade);

		return deleteTrade;

	}
}
