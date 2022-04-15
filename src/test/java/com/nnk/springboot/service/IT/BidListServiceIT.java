package com.nnk.springboot.service.IT;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.service.BidListService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BidListServiceIT {
	@Autowired
	private BidListService bidListService;
	
	@Test
	public void bidListTest() throws Exception{
		BidList bid = new BidList("Account Test", "Type Test", 10d);

		// Save
		bid = bidListService.saveBidList(bid);
		Assertions.assertNotNull(bid.getBidListId());
		Assertions.assertEquals(bid.getBidQuantity(), 10d, 10d);
		
		
		// Update
		bid.setBidQuantity(20d);
		bid = bidListService.updateBidList(bid);
		Assertions.assertEquals(bid.getBidQuantity(), 20d, 20d);
		
		// Find
		List<BidList> listResult = bidListService.findAllBidsLists();
		Assertions.assertTrue(listResult.size() > 0);
		
		// Delete
		Integer id = bid.getBidListId();
		bidListService.deleteBidList(id.intValue());
		Optional<BidList> bidList = bidListService.getBidsListById(id);
		Assertions.assertFalse(bidList.isPresent());
		
	}
}
