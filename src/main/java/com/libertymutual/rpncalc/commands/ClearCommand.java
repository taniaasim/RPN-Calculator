package com.libertymutual.rpncalc.commands;

import java.util.*;

public class ClearCommand implements Undoable {
	
	private Stack<Double> numberStack;
	private Stack<Double> memory;
	
	
	public ClearCommand(Stack<Double> numberStack) {
		this.numberStack = numberStack;
		memory = new Stack<Double>();
	}
	
	public void execute() {
		while (!(numberStack).isEmpty()) {
			double result = numberStack.pop();
			memory.push(result);
		}
	}
	
	public void undo() {
		while (!(memory).isEmpty()) {
			double result = memory.pop();
			numberStack.push(result);
		}
	}

}
