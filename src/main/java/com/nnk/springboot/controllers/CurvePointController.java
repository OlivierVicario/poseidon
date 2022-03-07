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

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.service.CurvePointService;

@Controller
public class CurvePointController {
    // TODO: Inject Curve Point service
	@Autowired
	CurvePointService curvePointService;
    @RequestMapping("/curvePoint/list")
    public String home(Model model)
    {
        // TODO: find all Curve Point, add to model
    	List<CurvePoint> CurvePoints = curvePointService.findAllCurvePoints();
		model.addAttribute("curvePoints", CurvePoints);
        return "curvePoint/list";
    }

    @GetMapping("/curvePoint/add")
    public String addBidForm(CurvePoint bid) {
        return "curvePoint/add";
    }

    @PostMapping("/curvePoint/validate")
    public String validate(@Valid CurvePoint curvePoint, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return Curve list
    	if (result.hasErrors()) {
            return "curvePoint/add";
        } else {
        	curvePointService.saveCurvePoint(curvePoint);
        }
        return "curvePoint/add";
    }

    @GetMapping("/curvePoint/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get CurvePoint by Id and to model then show to the form
    	Optional<CurvePoint> optCurvePoint = curvePointService.getCurvePointById(id);
		CurvePoint curvePoint = optCurvePoint.get();
		model.addAttribute("curvePoint", curvePoint);
        return "curvePoint/update";
    }

    @PostMapping("/curvePoint/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid CurvePoint curvePoint,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Curve and return Curve list
		if (result.hasErrors()) {
            return "curvePoint/update/{id}";
        } else {
        	curvePointService.updateCurvePoint(curvePoint);
        }
        return "redirect:/curvePoint/list";
    }

    @GetMapping("/curvePoint/delete/{id}")
    public String deleteCurvePoint(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Curve by Id and delete the Curve, return to Curve list
    	curvePointService.deleteCurvePoint(id);
        return "redirect:/curvePoint/list";
    }
}
