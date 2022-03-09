package com.nnk.springboot.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger LOGGER = LoggerFactory.getLogger(TradeController.class);
	// TODO: Inject Trade service
	@Autowired
	TradeService tradeService;

	@RequestMapping("/trade/list")
	public String home(Model model) {
		try {
			LOGGER.info("begin home");
			// TODO: find all Trade, add to model
			List<Trade> Trades = tradeService.findAllTrades();
			model.addAttribute("trades", Trades);
			return "trade/list";
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			LOGGER.info("end home");
		}
		return null;
	}

	@GetMapping("/trade/add")
	public String addTrade(Trade trade) {
		try {
			LOGGER.info("begin addTrade");
			return "trade/add";
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			LOGGER.info("end addTrade");
		}
		return null;
	}

	@PostMapping("/trade/validate")
	public String validate(@Valid Trade trade, BindingResult result, Model model) {
		try {
			LOGGER.info("begin validate");
			// TODO: check data valid and save to db, after saving return Trade list
			if (result.hasErrors()) {
				return "trade/add";
			} else {
				tradeService.saveTrade(trade);
			}
			return "trade/add";
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			LOGGER.info("end validate");
		}
		return null;
	}

	@GetMapping("/trade/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		try {
			LOGGER.info("begin showUpdateForm");
			// TODO: get Trade by Id and to model then show to the form
			Optional<Trade> optTrade = tradeService.getTradeById(id);
			Trade trade = optTrade.get();
			model.addAttribute("trade", trade);
			return "trade/update";
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			LOGGER.info("end showUpdateForm");
		}
		return null;
	}

	@PostMapping("/trade/update/{id}")
	public String updateTrade(@PathVariable("id") Integer id, @Valid Trade trade, BindingResult result, Model model) {
		try {
			LOGGER.info("begin updateTrade");
			// TODO: check required fields, if valid call service to update Trade and return
			// Trade list
			if (result.hasErrors()) {
				return "trade/update/{id}";
			} else {
				tradeService.updateTrade(trade);
			}
			return "redirect:/trade/list";
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			LOGGER.info("end updateTrade");
		}
		return null;
	}

	@GetMapping("/trade/delete/{id}")
	public String deleteTrade(@PathVariable("id") Integer id, Model model) {
		try {
			LOGGER.info("begin deleteTrade");
			// TODO: Find Trade by Id and delete the Trade, return to Trade list
			tradeService.deleteTrade(id);
			return "redirect:/trade/list";
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			LOGGER.info("end deleteTrade");
		}
		return null;
	}
}
