package com.libertymutual.rpncalc.commands;

import java.util.*;

public class AddCommand extends TwoArgumentCommand {
	
	public AddCommand(Stack<Double> numberStack) {
		super(numberStack);
	}
	
	@Override
	protected double doMaths() {
		return getSecondPopped() + getFirstPopped();
	}

}
