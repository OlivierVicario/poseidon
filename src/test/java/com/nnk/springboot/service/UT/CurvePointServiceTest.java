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

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import com.nnk.springboot.service.CurvePointService;

@ExtendWith(MockitoExtension.class)
public class CurvePointServiceTest {

	@Mock
	private CurvePointRepository curvePointRepository;
	
	@Autowired
	@InjectMocks
	private CurvePointService curvePointService;
	
	private CurvePoint curvePoint1;
	private CurvePoint curvePoint2;
	List<CurvePoint> curvePoints;

	@BeforeEach
	public void SetUp() {
		curvePoints = new ArrayList<>();
		curvePoint1 = new CurvePoint();
		curvePoint1.setId(1);
		curvePoint1.setCurveId(2);
		curvePoint1.setTerm(50.0);
		curvePoint1.setValue(50.0);
		curvePoints.add(curvePoint1);
		
		curvePoint2 = new CurvePoint();
		curvePoint2.setCurveId(2);
		curvePoint2.setTerm(50.0);
		curvePoint2.setValue(50.0);
		curvePoints.add(curvePoint2);
		
		
	}
	@AfterEach
    public void tearDown() {
    curvePoint1 = curvePoint2 = null;
    curvePoints = null;
    }
	
	@Test
	void givenCurvePointToAddShouldReturnAddedCurvePoint(){
	     
	     when(curvePointRepository.save(any())).thenReturn(curvePoint1);
	     curvePointService.saveCurvePoint(curvePoint1);
	     verify(curvePointRepository,times(1)).save(any());
	}
	
	@Test
	public void GivenGetAllCurvePointsShouldReturnListOfAllCurvePoints(){
	     curvePointRepository.save(curvePoint1);
	    
	    when(curvePointRepository.findAll()).thenReturn(curvePoints);
	    List<CurvePoint> curvePoints1 =curvePointService.findAllCurvePoints();
	    assertEquals(curvePoints1,curvePoints);
	    verify(curvePointRepository,times(1)).save(curvePoint1);
	    verify(curvePointRepository,times(1)).findAll();
	}
	
	@Test
	public void GivenCurvePointToDeleteShouldReturnNull() {
		
	     curvePointService.deleteCurvePoint(curvePoint1.getId());
	     verify(curvePointRepository,times(1)).delete(any());
	}
}

