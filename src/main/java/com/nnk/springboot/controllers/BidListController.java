package com.nnk.springboot.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.service.BidListService;

@Controller
public class BidListController {
	
	@Autowired
	BidListService bidListService;

	@RequestMapping("/bidList/list")
	public String home(Model model) {
		
		List<BidList> bidLists = bidListService.findAllBidsLists();
		model.addAttribute("bidLists", bidLists);
		
		return "bidList/list";
	}

	@GetMapping("/bidList/add")
	public String addBidForm(BidList bid) {
		
		return "bidList/add";
	}

	@PostMapping("/bidList/validate")
	public String validate(@Valid BidList bid, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
            return "bidList/add";
        } else {
        	bidListService.saveBidList(bid);
        }
		return "redirect:/bidList/list";
	}

	@GetMapping("/bidList/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		// TODO: get Bid by Id and to model then show to the form
		Optional<BidList> optBidList = bidListService.getBidsListById(id);
		BidList bidList = optBidList.get();
		model.addAttribute("bidList", bidList);
		return "bidList/update";
	}

	@PostMapping("/bidList/update/{id}")
	public String updateBid(@PathVariable("id") Integer id, @Valid BidList bidList, BindingResult result, Model model) {
		// TODO: check required fields, if valid call service to update Bid and return
		// list Bid
		if (result.hasErrors()) {
            return "bidList/update/{id}";
        } else {
        	bidListService.updateBidList(bidList);
        }
		return "redirect:/bidList/list";
	}

	@GetMapping("/bidList/delete/{id}")
	public String deleteBid(@PathVariable("id") Integer id, Model model) {
		// TODO: Find Bid by Id and delete the bid, return to Bid list
		bidListService.deleteBidList(id);
		return "redirect:/bidList/list";
	}
}
