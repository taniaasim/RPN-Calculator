package com.libertymutual.rpncalc.commands;

import java.util.*;

public class SubtractCommand extends TwoArgumentCommand {
	
	public SubtractCommand(Stack<Double> numberStack) {
		super(numberStack);
	}
	
	@Override
	protected double doMaths() {
		return getSecondPopped() - getFirstPopped(); 
	}

}
