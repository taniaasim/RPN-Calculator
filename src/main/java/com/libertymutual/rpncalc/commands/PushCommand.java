package com.libertymutual.rpncalc.commands;

import java.util.*;

public class PushCommand implements Undoable {
	
	private Stack<Double> numberStack;
	private double theNumber;
	
	public PushCommand(Stack<Double> numberStack, Double theNumber) {
		this.numberStack = numberStack;
		this.theNumber = theNumber;
	}
	
	public void execute() {
		numberStack.push(theNumber);
	}
	
	public void undo() {
		numberStack.pop();
	}

}
