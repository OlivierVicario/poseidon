package com.nnk.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.CurvePoint;

import com.nnk.springboot.repositories.CurvePointRepository;

@Service
public class CurvePointService {
	@Autowired
	CurvePointRepository curvePointRepo;

	public List<CurvePoint> findAllCurvePoints() {
		return curvePointRepo.findAll();
	}

	public CurvePoint saveCurvePoint(CurvePoint curvePoint) {
		curvePointRepo.save(curvePoint);
		return curvePoint;
	}

	public Optional<CurvePoint> getCurvePointById(Integer integer) {
		return curvePointRepo.findById(integer);
	}

	public CurvePoint updateCurvePoint(CurvePoint _curvePoint) {
		Optional<CurvePoint> optcurvePoint = getCurvePointById(_curvePoint.getId());
		CurvePoint updateCurvePoint = optcurvePoint.get();
		updateCurvePoint.setCurveId(_curvePoint.getCurveId());
		updateCurvePoint.setTerm(_curvePoint.getTerm());
		updateCurvePoint.setValue(_curvePoint.getValue());
		curvePointRepo.save(updateCurvePoint);
		return updateCurvePoint;
	}

	public CurvePoint deleteCurvePoint(int id) {
		CurvePoint deleteCurvePoint = curvePointRepo.getById((id));
		curvePointRepo.delete(deleteCurvePoint);

		return deleteCurvePoint;

	}
}
