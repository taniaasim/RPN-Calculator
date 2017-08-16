package com.libertymutual.rpncalc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.libertymutual.rpncalc.commands.AddCommand;
import com.libertymutual.rpncalc.commands.ClearCommand;
import com.libertymutual.rpncalc.commands.MultiplyCommand;
import com.libertymutual.rpncalc.commands.NegateCommand;
import com.libertymutual.rpncalc.commands.PushCommand;
import com.libertymutual.rpncalc.commands.SubtractCommand;
import com.libertymutual.rpncalc.commands.Undoable;


import java.util.*;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {
	private Stack<Double> numberStack;
	private Stack<Undoable> commandHistory;
	
	public CalculatorController() {
		numberStack = new Stack<Double>();
		commandHistory = new Stack<Undoable>();
	}
	
	@PostMapping("operation/undo")
	public String undoTheLastCommand() {
		if (commandHistory.size() > 0) {
			Undoable command = commandHistory.pop();
			command.undo();
		}
		return "redirect:/calculator";
	}

	
    // Use the requestparam thing if the names are different  
	@PostMapping("/values")
	public String pushValueOntoStack(double theNumber) {
		PushCommand command = new PushCommand(numberStack, theNumber);
		command.execute();
		commandHistory.push(command);
		return "redirect:/calculator";
	} 
	
	@GetMapping("")
	public String goBackToCalculator(Model model) {
		model.addAttribute("stack", numberStack);
		model.addAttribute("canShowBinaryOperator", numberStack.size() > 1);
		model.addAttribute("canShowUnaryOperator", numberStack.size() > 0);
		model.addAttribute("undoSize", commandHistory.size());
		return "/calculator";
	}
	
	@PostMapping("/operation/clear")
	public String clearStack(Model model) {
		ClearCommand command = new ClearCommand(numberStack);
		command.execute();
		commandHistory.push(command);
		return "redirect:/calculator";
	}
	
	@PostMapping("/operation/add")
	public String addTheTwoStackNumbers() {
		AddCommand command = new AddCommand(numberStack);
		command.execute();
		commandHistory.push(command);
		return "redirect:/calculator";
	}
	
	@PostMapping("/operation/negate")
	public String negateNumber() {
		NegateCommand command = new NegateCommand(numberStack);
		command.execute();
		commandHistory.push(command);
		return "redirect:/calculator";
	}
	
	@PostMapping("/operation/subtract")
	public String subtractTheTwoStackNumbers() {
		SubtractCommand command = new SubtractCommand(numberStack);
		command.execute();
		commandHistory.push(command);
		return "redirect:/calculator";
	}
	
	@PostMapping("/operation/multiply")
	public String multiplyTheTwoStackNumber() {
		MultiplyCommand command = new MultiplyCommand(numberStack);
		command.execute();
		commandHistory.push(command);
		return "redirect:/calculator";
	}
	
	
}