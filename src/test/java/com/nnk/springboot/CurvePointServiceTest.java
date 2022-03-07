package com.nnk.springboot;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.service.CurvePointService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CurvePointServiceTest {
	@Autowired
	private CurvePointService curvePointService;
	
	@Test
	public void curvePointTest() throws Exception{
		CurvePoint curvePoint = new CurvePoint(25, 50.0, 10.0);

		// Save
		curvePoint = curvePointService.saveCurvePoint(curvePoint);
		Assertions.assertNotNull(curvePoint.getCurveId());
		Assertions.assertEquals(curvePoint.getCurveId(), 25);
		
	
		// Update
		curvePoint.setCurveId(20);
		curvePoint = curvePointService.updateCurvePoint(curvePoint);
		Assertions.assertEquals(curvePoint.getCurveId(),  20);
			
		// Find
		List<CurvePoint> listResult = curvePointService.findAllCurvePoints();
		Assertions.assertTrue(listResult.size() > 0);
		
		// Delete
		Integer id = curvePoint.getId();
		curvePointService.deleteCurvePoint(id.intValue());
		Optional<CurvePoint> optCurvePoint = curvePointService.getCurvePointById(id);
		Assertions.assertFalse(optCurvePoint.isPresent());

	}
}

