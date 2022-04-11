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

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.service.CurvePointService;

@Controller
public class CurvePointController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CurvePointController.class);

	// TODO: Inject Curve Point service
	@Autowired
	CurvePointService curvePointService;

	@RequestMapping("/curvePoint/list")
	public String home(Model model) {
		try {
			LOGGER.info("begin home");
			
			List<CurvePoint> CurvePoints = curvePointService.findAllCurvePoints();
			model.addAttribute("curvePoints", CurvePoints);
			return "curvePoint/list";
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			LOGGER.info("end home");
		}
		return null;
	}

	@GetMapping("/curvePoint/add")
	public String addCurvePointForm(CurvePoint bid) {
		try {
			LOGGER.info("begin addCurvePointForm");

			return "curvePoint/add";
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			LOGGER.info("end addCurvePointForm");
		}
		return null;
	}

	@PostMapping("/curvePoint/validate")
	public String validate(@Valid CurvePoint curvePoint, BindingResult result, Model model) {

		try {
			LOGGER.info("begin validate");
			
			if (result.hasErrors()) {
				return "curvePoint/add";
			} else {
				curvePointService.saveCurvePoint(curvePoint);
			}
			return "curvePoint/add";
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			LOGGER.info("end validate");
		}
		return null;
	}

	@GetMapping("/curvePoint/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		try {
			LOGGER.info("begin showUpdateForm");
			
			Optional<CurvePoint> optCurvePoint = curvePointService.getCurvePointById(id);
			CurvePoint curvePoint = optCurvePoint.get();
			model.addAttribute("curvePoint", curvePoint);
			return "curvePoint/update";
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			LOGGER.info("end showUpdateForm");
		}
		return null;
	}

	@PostMapping("/curvePoint/update/{id}")
	public String updateCurvePoint(@PathVariable("id") Integer id, @Valid CurvePoint curvePoint, BindingResult result,
			Model model) {
		try {
			LOGGER.info("begin updateCurvePoint");
			
			
			if (result.hasErrors()) {
				return "curvePoint/update/{id}";
			} else {
				curvePointService.updateCurvePoint(curvePoint);
			}
			return "redirect:/curvePoint/list";
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			LOGGER.info("end updateCurvePoint");
		}
		return null;
	}

	@GetMapping("/curvePoint/delete/{id}")
	public String deleteCurvePoint(@PathVariable("id") Integer id, Model model) {
		try {
			LOGGER.info("begin deleteCurvePoint");
			
			curvePointService.deleteCurvePoint(id);
			return "redirect:/curvePoint/list";
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			LOGGER.info("end deleteCurvePoint");
		}
		return null;
	}
}
