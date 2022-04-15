package com.nnk.springboot.service.IT;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.service.TradeService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TradeServiceIT {
	@Autowired
	private TradeService tradeService;
	
	@Test
	public void ratingTest() throws Exception{
		Trade trade = new Trade("account", "type");

		// Save
		trade = tradeService.saveTrade(trade);
		Integer id = trade.getTradeId();
		Assertions.assertNotNull(trade.getTradeId());
		Assertions.assertEquals(trade.getTradeId(), id);
		
	
		// Update
		trade.setTradeId(id);
		trade = tradeService.updateTrade(trade);
		Assertions.assertEquals(trade.getTradeId(),  id);
			
		// Find
		List<Trade> listResult = tradeService.findAllTrades();
		Assertions.assertTrue(listResult.size() > 0);
		
		// Delete
		id = trade.getTradeId();
		tradeService.deleteTrade(id.intValue());
		Optional<Trade> optTrade = tradeService.getTradeById(id);
		Assertions.assertFalse(optTrade.isPresent());

	}
}
