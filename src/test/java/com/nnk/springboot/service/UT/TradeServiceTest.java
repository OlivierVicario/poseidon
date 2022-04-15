package com.nnk.springboot.service.UT;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import com.nnk.springboot.service.TradeService;

@ExtendWith(MockitoExtension.class)
public class TradeServiceTest {

	@Mock
	private TradeRepository tradeRepository;
	
	@Autowired
	@InjectMocks
	private TradeService tradeService;
	
	private Trade trade1;
	private Trade trade2;
	List<Trade> trades;

	@BeforeEach
	public void SetUp() {
		trades = new ArrayList<>();
		trade1 = new Trade();
		trade1.setTradeId(1);
		trade1.setAccount("account");
		trade1.setType("type");
		trades.add(trade1);
		
		trade2 = new Trade();
		trade2.setTradeId(2);
		trade2.setAccount("account");
		trade2.setType("type");
		trades.add(trade2);
		
		
	}
	@AfterEach
    public void tearDown() {
    trade1 = trade2 = null;
    trades = null;
    }
	
	@Test
	void givenTradeToAddShouldReturnAddedTrade(){
	     
	     when(tradeRepository.save(any())).thenReturn(trade1);
	     tradeService.saveTrade(trade1);
	     verify(tradeRepository,times(1)).save(any());
	}
	
	@Test
	public void GivenGetAllTradesShouldReturnListOfAllTrades(){
	     tradeRepository.save(trade1);
	    
	    when(tradeRepository.findAll()).thenReturn(trades);
	    List<Trade> trades1 =tradeService.findAllTrades();
	    assertEquals(trades1,trades);
	    verify(tradeRepository,times(1)).save(trade1);
	    verify(tradeRepository,times(1)).findAll();
	}
	
	@Test
	public void GivenTradeToDeleteShouldReturnNull() {
		
	     tradeService.deleteTrade(trade1.getTradeId());
	     verify(tradeRepository,times(1)).delete(any());
	}
}



