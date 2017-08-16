package com.libertymutual.rpncalc.commands;

import java.util.*;

public class ReciprocalCommand extends OneArgumentCommand{	
	
	public ReciprocalCommand(Stack<Double> numberStack) {
		super(numberStack);
	}
	
	@Override
	protected double doMaths() {
		return 1 / getFirstPopped();
	}

}

