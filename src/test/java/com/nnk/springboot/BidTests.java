package com.nnk.springboot;

import java.util.List;
import java.util.Optional;

//import org.junit.Assert;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;




//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BidTests {

	@Autowired
	private BidListRepository bidListRepository;

	
	//public void bidListTest() {
	@Test
	public void bidListTest() throws Exception{
		BidList bid = new BidList("Account Test", "Type Test", 10d);

		// Save
		bid = bidListRepository.save(bid);
		//Assert.assertNotNull(bid.getBidListId());
		Assertions.assertNotNull(bid.getBidListId());
		//Assert.assertEquals(bid.getBidQuantity(), 10d, 10d);
		Assertions.assertEquals(bid.getBidQuantity(), 10d, 10d);
		
		
		// Update
		bid.setBidQuantity(20d);
		bid = bidListRepository.save(bid);
		//Assert.assertEquals(bid.getBidQuantity(), 20d, 20d);
		Assertions.assertEquals(bid.getBidQuantity(), 20d, 20d);
		
		// Find
		List<BidList> listResult = bidListRepository.findAll();
		//Assert.assertTrue(listResult.size() > 0);
		Assertions.assertTrue(listResult.size() > 0);
		
		// Delete
		Integer id = bid.getBidListId();
		bidListRepository.delete(bid);
		Optional<BidList> bidList = bidListRepository.findById(id);
		//Assert.assertFalse(bidList.isPresent());
		Assertions.assertFalse(bidList.isPresent());
	}
}
