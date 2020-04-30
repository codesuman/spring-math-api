package com.coding.assignment.math.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding.assignment.math.constants.MathOperator;
import com.coding.assignment.math.dto.MathInput;
import com.coding.assignment.math.dto.MathResult;

@RestController
@RequestMapping("/api")
public class MathController {
	@PostMapping("/add")
	public MathResult add(@RequestBody MathInput input) {
		return MathOperator.ADD.calculate(input);
	}
	
	@PostMapping("/diff")
	public MathResult diff(@RequestBody MathInput input) {
		return MathOperator.SUB.calculate(input);
	}
}
