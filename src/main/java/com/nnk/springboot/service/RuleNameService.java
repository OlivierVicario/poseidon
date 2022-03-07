package com.nnk.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.RuleName;

import com.nnk.springboot.repositories.RuleNameRepository;

@Service
public class RuleNameService {
	@Autowired
	RuleNameRepository ruleNameRepo;

	public List<RuleName> findAllRuleNames() {
		return ruleNameRepo.findAll();
	}

	public RuleName saveRuleName(RuleName ruleName) {
		ruleNameRepo.save(ruleName);
		return ruleName;
	}

	public Optional<RuleName> getRuleNameById(Integer integer) {
		return ruleNameRepo.findById(integer);
	}

	public RuleName updateRuleName(RuleName _ruleName) {
		Optional<RuleName> optruleName = getRuleNameById(_ruleName.getId());
		RuleName updateRuleName = optruleName.get();
		updateRuleName.setName(_ruleName.getName());
		updateRuleName.setDescription(_ruleName.getDescription());
		updateRuleName.setJson(_ruleName.getJson());
		updateRuleName.setTemplate(_ruleName.getTemplate());
		updateRuleName.setSqlStr(_ruleName.getSqlStr());
		updateRuleName.setSqlPart(_ruleName.getSqlPart());
		
		ruleNameRepo.save(updateRuleName);
		return updateRuleName;
	}

	public RuleName deleteRuleName(int id) {
		RuleName deleteRuleName = ruleNameRepo.getById((id));
		ruleNameRepo.delete(deleteRuleName);

		return deleteRuleName;

	}
}
