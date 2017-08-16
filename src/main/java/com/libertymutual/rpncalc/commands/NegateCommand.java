package com.libertymutual.rpncalc.commands;

import java.util.*;

public class NegateCommand extends OneArgumentCommand{
	
	public NegateCommand(Stack<Double> numberStack) {
		super(numberStack);
	}
	
	@Override
	protected double doMaths() {
		return getFirstPopped() * -1;
	}

}

