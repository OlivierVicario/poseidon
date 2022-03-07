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

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.service.TradeService;

@Controller
public class TradeController {
	// TODO: Inject Trade service
	@Autowired
	TradeService tradeService;

	@RequestMapping("/trade/list")
	public String home(Model model) {
		// TODO: find all Trade, add to model
		List<Trade> Trades = tradeService.findAllTrades();
		model.addAttribute("trades", Trades);
		return "trade/list";
	}

	@GetMapping("/trade/add")
	public String addUser(Trade bid) {
		return "trade/add";
	}

	@PostMapping("/trade/validate")
	public String validate(@Valid Trade trade, BindingResult result, Model model) {
		// TODO: check data valid and save to db, after saving return Trade list
		if (result.hasErrors()) {
            return "trade/add";
        } else {
        	tradeService.saveTrade(trade);
        }
		return "trade/add";
	}

	@GetMapping("/trade/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		// TODO: get Trade by Id and to model then show to the form
		Optional<Trade> optTrade = tradeService.getTradeById(id);
		Trade trade = optTrade.get();
		model.addAttribute("trade", trade);
		return "trade/update";
	}

	@PostMapping("/trade/update/{id}")
	public String updateTrade(@PathVariable("id") Integer id, @Valid Trade trade, BindingResult result, Model model) {
		// TODO: check required fields, if valid call service to update Trade and return
		// Trade list
		if (result.hasErrors()) {
            return "trade/update/{id}";
        } else {
        	tradeService.updateTrade(trade);
        }
		return "redirect:/trade/list";
	}

	@GetMapping("/trade/delete/{id}")
	public String deleteTrade(@PathVariable("id") Integer id, Model model) {
		// TODO: Find Trade by Id and delete the Trade, return to Trade list
		tradeService.deleteTrade(id);
		return "redirect:/trade/list";
	}
}
