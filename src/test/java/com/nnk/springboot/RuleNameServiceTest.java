package com.nnk.springboot;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.service.RuleNameService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RuleNameServiceTest {
	@Autowired
	private RuleNameService ruleNameService;
	
	@Test
	public void ruleTest() throws Exception{
		RuleName rule = new RuleName("name","description", "json",  "template", "sqlStr","sqlPart" );

		// Save
		rule = ruleNameService.saveRuleName(rule);
		Integer id = rule.getId();
		Assertions.assertNotNull(rule.getId());
		Assertions.assertEquals(rule.getId(), id);
		
	
		// Update
		rule.setId(id);
		rule = ruleNameService.updateRuleName(rule);
		Assertions.assertEquals(rule.getId(),  id);
			
		// Find
		List<RuleName> listResult = ruleNameService.findAllRuleNames();
		Assertions.assertTrue(listResult.size() > 0);
		
		// Delete
		//Integer id = rule.getId();
		ruleNameService.deleteRuleName(id.intValue());
		Optional<RuleName> optRule = ruleNameService.getRuleNameById(id);
		Assertions.assertFalse(optRule.isPresent());

	}
}

