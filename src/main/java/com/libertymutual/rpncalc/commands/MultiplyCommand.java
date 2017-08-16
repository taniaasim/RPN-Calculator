package com.libertymutual.rpncalc.commands;

import java.util.*;

public class MultiplyCommand extends TwoArgumentCommand {
	
	public MultiplyCommand(Stack<Double> numberStack) {
		super(numberStack);
	}

	@Override
	protected double doMaths() {
		return getSecondPopped() * getFirstPopped();
	}

}
