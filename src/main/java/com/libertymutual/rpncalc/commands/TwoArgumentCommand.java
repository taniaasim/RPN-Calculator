package com.libertymutual.rpncalc.commands;

import java.util.Stack;

public abstract class TwoArgumentCommand implements Undoable {

	private Stack<Double> numberStack;
	protected double firstPopped;
	protected double secondPopped;
	
	
	public TwoArgumentCommand(Stack<Double> numberStack) {
		this.numberStack = numberStack;
	}
	
	@Override
	public void undo() {
		numberStack.pop();
		numberStack.push(secondPopped);
		numberStack.push(firstPopped);
	}
	
	protected abstract double doMaths();
	
	public void execute() {
		firstPopped = numberStack.pop();
		secondPopped = numberStack.pop();
		Double result = doMaths();
		numberStack.push(result);
	}

	protected double getFirstPopped() {
		return firstPopped;
	}

	protected double getSecondPopped() {
		return secondPopped;
	}
	
	
}
