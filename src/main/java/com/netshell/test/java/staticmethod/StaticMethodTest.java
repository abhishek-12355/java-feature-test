package com.netshell.test.java.staticmethod;

import com.netshell.test.java.Test;

public class StaticMethodTest implements Test {

	@Override
	public void execute() throws Exception {
		IDGenerator g = IDGenerator.defaultGenerator();
		System.out.println(g.generateId("input string"));
	}
}

@FunctionalInterface
interface IDGenerator {
	String generateId(String input);
	
	static IDGenerator defaultGenerator() {
		return new IDGenerator() {
			@Override
			public String generateId(String input) {
				return input == null ? "Null Input" : input;
			}
		};
	}
}
