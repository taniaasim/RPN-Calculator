package com.libertymutual.rpncalc.commands;

import java.util.*;

public class DividerCommand extends TwoArgumentCommand {
	
	public DividerCommand(Stack<Double> numberStack) {
		super(numberStack);
	}

	@Override
	protected double doMaths() {
		return getSecondPopped() / getFirstPopped();
	}

}
