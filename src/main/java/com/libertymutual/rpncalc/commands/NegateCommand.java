package com.libertymutual.rpncalc.commands;

import java.util.*;

public class NegateCommand implements Undoable{
	
	private Stack<Double> numberStack;
	private double valuePopped;
	//private Stack<???> commandHistory;
	
	public NegateCommand(Stack<Double> numberStack) {
		this.numberStack = numberStack;
	}
	
	public void execute() {
		Double num = numberStack.pop();
		if (num != 0.0) {
			Double result = num * -1;	
			numberStack.push(result);
		} else {
			numberStack.push(num);
		}
		
	}
	
	public void undo() {
		numberStack.pop();
		numberStack.push(valuePopped);
	}

}

