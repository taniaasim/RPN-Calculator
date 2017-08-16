package com.libertymutual.rpncalc.commands;

import java.util.*;

public class SubtractCommand implements Undoable {
	
	private Stack<Double> numberStack;
	private double firstPopped;
	private double secondPopped;
	
	public SubtractCommand(Stack<Double> numberStack) {
		this.numberStack = numberStack;
	}
	
	public void execute() {
		firstPopped = numberStack.pop();
		secondPopped = numberStack.pop();
		Double result = secondPopped - firstPopped;
		numberStack.push(result);
	}

	public void undo() {
		numberStack.pop();
		numberStack.push(secondPopped);
		numberStack.push(firstPopped);
	}

}
