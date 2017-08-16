package com.libertymutual.rpncalc.commands;

import java.util.Stack;

public abstract class OneArgumentCommand implements Undoable {

	private Stack<Double> numberStack;
	protected double valuePopped;
	
	
	public OneArgumentCommand(Stack<Double> numberStack) {
		this.numberStack = numberStack;
	}
	
	@Override
	public void undo() {
		numberStack.pop();
		numberStack.push(valuePopped);
	}
	
	protected abstract double doMaths();
	
	public void execute() {
		valuePopped = numberStack.pop();
		Double result = doMaths();
		numberStack.push(result);
	}

	protected double getFirstPopped() {
		return valuePopped;
	}

}
