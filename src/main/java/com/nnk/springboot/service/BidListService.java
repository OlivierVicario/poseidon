package com.nnk.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;

@Service
public class BidListService {
	@Autowired
	BidListRepository bidListRepo;

	public List<BidList> findAllBidsLists() {
		return bidListRepo.findAll();
	}
	
	public BidList saveBidList(BidList bidList) {	
		bidListRepo.save(bidList);
		return bidList;
	}
	
	public Optional<BidList> getBidsListById(Integer id) {
		return bidListRepo.findById(id);
	}
	
	public BidList updateBidList(BidList _bidList) {	
		Optional<BidList> optBidList = getBidsListById(_bidList.getBidListId());
		BidList updateBidList = optBidList.get();
		updateBidList.setAccount(_bidList.getAccount());
		updateBidList.setType(_bidList.getType());
		updateBidList.setBidQuantity(_bidList.getBidQuantity());
		bidListRepo.save(updateBidList);
		return updateBidList;
	}
	
	public BidList deleteBidList(int id) {
		BidList deleteBidList = bidListRepo.getById( id);
		bidListRepo.delete(deleteBidList);
		
		return deleteBidList;
		
	}
}
