package com.netshell.test.java.defaultmethod;

import com.netshell.test.java.Test;

public class DefaultMethodTest implements Test {
	@Override
	public void execute() throws Exception {
		IDGenerator g = new IDGenerator() {
			@Override
			public String generateId(String input) {
				return input == null ? "Null Input" : input;
			}
		};
		
		System.out.println(g.generateId());
	}
}

interface IDGenerator {
	String generateId(String input);
	
	default String generateId() {
		return generateId(null);
	}
}
