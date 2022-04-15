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

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.service.BidListService;

@ExtendWith(MockitoExtension.class)
public class BidListServiceTest {

	@Mock
	private BidListRepository bidListRepository;
	
	@Autowired
	@InjectMocks
	private BidListService bidListService;
	
	private BidList bidList1;
	private BidList bidList2;
	List<BidList> bidLists;

	@BeforeEach
	public void SetUp() {
		bidLists = new ArrayList<>();
		bidList1 = new BidList();
		bidList1.setBidListId(1);
		bidList1.setAccount("testAccount1");
		bidList1.setType("testType1");
		bidList1.setBidQuantity(50.0);
		bidLists.add(bidList1);
		
		bidList2 = new BidList();
		bidList2.setAccount("testAccount2");
		bidList2.setType("testType2");
		bidList2.setBidQuantity(50.0);
		bidLists.add(bidList2);
		
		
	}
	@AfterEach
    public void tearDown() {
    bidList1 = bidList2 = null;
    bidLists = null;
    }
	
	@Test
	void givenBidListToAddShouldReturnAddedBidList(){
	     
	     when(bidListRepository.save(any())).thenReturn(bidList1);
	     bidListService.saveBidList(bidList1);
	     verify(bidListRepository,times(1)).save(any());
	}
	
	@Test
	public void GivenGetAllBidListsShouldReturnListOfAllBidLists(){
	     bidListRepository.save(bidList1);
	    
	    when(bidListRepository.findAll()).thenReturn(bidLists);
	    List<BidList> bidLists1 =bidListService.findAllBidsLists();
	    assertEquals(bidLists1,bidLists);
	    verify(bidListRepository,times(1)).save(bidList1);
	    verify(bidListRepository,times(1)).findAll();
	}
	
	@Test
	public void GivenBidListToDeleteShouldReturnNull() {
		
	     bidListService.deleteBidList(bidList1.getBidListId());
	     verify(bidListRepository,times(1)).delete(any());
	}
}
