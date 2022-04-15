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

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import com.nnk.springboot.service.RuleNameService;

@ExtendWith(MockitoExtension.class)
public class RuleNameServiceTest {

	@Mock
	private RuleNameRepository ruleNameRepository;
	
	@Autowired
	@InjectMocks
	private RuleNameService ruleNameService;
	
	private RuleName ruleName1;
	private RuleName ruleName2;
	List<RuleName> ruleNames;

	@BeforeEach
	public void SetUp() {
		ruleNames = new ArrayList<>();
		ruleName1 = new RuleName();
		ruleName1.setId(1);
		ruleName1.setDescription("description");
		ruleName1.setJson("json");
		ruleName1.setName("name");
		ruleName1.setSqlPart("part");
		ruleName1.setSqlStr("str");
		ruleName1.setTemplate("template");
		ruleNames.add(ruleName1);
		
		ruleName2 = new RuleName();
		ruleName2.setId(2);
		ruleName2.setDescription("description");
		ruleName2.setJson("json");
		ruleName2.setName("name");
		ruleName2.setSqlPart("part");
		ruleName2.setSqlStr("str");
		ruleName2.setTemplate("template");
		ruleNames.add(ruleName2);
		
		
	}
	@AfterEach
    public void tearDown() {
    ruleName1 = ruleName2 = null;
    ruleNames = null;
    }
	
	@Test
	void givenRuleNameToAddShouldReturnAddedRuleName(){
	     
	     when(ruleNameRepository.save(any())).thenReturn(ruleName1);
	     ruleNameService.saveRuleName(ruleName1);
	     verify(ruleNameRepository,times(1)).save(any());
	}
	
	@Test
	public void GivenGetAllRuleNamesShouldReturnListOfAllRuleNames(){
	     ruleNameRepository.save(ruleName1);
	    
	    when(ruleNameRepository.findAll()).thenReturn(ruleNames);
	    List<RuleName> ruleNames1 =ruleNameService.findAllRuleNames();
	    assertEquals(ruleNames1,ruleNames);
	    verify(ruleNameRepository,times(1)).save(ruleName1);
	    verify(ruleNameRepository,times(1)).findAll();
	}
	
	@Test
	public void GivenRuleNameToDeleteShouldReturnNull() {
		
	     ruleNameService.deleteRuleName(ruleName1.getId());
	     verify(ruleNameRepository,times(1)).delete(any());
	}
}
